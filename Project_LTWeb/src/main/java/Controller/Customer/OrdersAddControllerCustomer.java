package Controller.Customer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CartItemModel;
import Models.DeliveryModel;
import Models.OrderItemModel;
import Models.OrdersModel;
import Models.ProductModel;
import Models.StoreId_ProductId;
import Service.ICartItemService;
import Service.ICartService;
import Service.IDeliveryService;
import Service.IOrderService;
import Service.IProductService;
import Service.Impl.CartItemServiceImpl;
import Service.Impl.CartServiceImpl;
import Service.Impl.DeliveryServiceImpl;
import Service.Impl.OrderServiceImpl;
import Service.Impl.ProductServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user/order" })
public class OrdersAddControllerCustomer extends HttpServlet {

	IProductService productService = new ProductServiceImpl();
	ICartItemService cartItemService = new CartItemServiceImpl();
	ICartService cartService = new CartServiceImpl();
	IDeliveryService deliveryService = new DeliveryServiceImpl();
	IOrderService orderService = new OrderServiceImpl();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = ProcessCookies.getUserIdFromCookies(req, resp);
		String deliveryId = req.getParameter("deliveryid");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");

		try {
			if (userid == null) {
				resp.sendRedirect(req.getContextPath() + "/login");
			}
			int cartid = Integer.parseInt(
					cartService.findCartIdByUserId(Integer.parseInt(ProcessCookies.getUserIdFromCookies(req, resp))));
			// int productid =
			// Integer.parseInt(productService.findProductIdByCardId(cartid));
			List<CartItemModel> cartitems = cartItemService.getAllByCartId(cartid);
			for (CartItemModel cartitem : cartitems) {
				ProductModel product = productService.findByProductId(cartitem.getProductId());
				cartitem.setProduct(product);
			}

			List<String> storeids = new ArrayList<String>();

			for (CartItemModel cartitem : cartitems) {
				if (storeids.isEmpty()) {
					String storeidx = productService.findStoreIdByProductId(cartitem.getProduct().getId());
					storeids.add(storeidx);
				} else {
					for (String storeid : storeids) {
						// tim storeid
						String storeidx = productService.findStoreIdByProductId(cartitem.getProduct().getId());
						if (!storeid.equals(storeidx)) {
							storeids.add(storeidx);
							break;
						}
					}
				}

			}
			
			List<StoreId_ProductId> listStore = new ArrayList<StoreId_ProductId>();
			
			for (String store : storeids) {
				if (listStore.isEmpty()) {
					StoreId_ProductId s = new StoreId_ProductId();
					s.set_storeid(store);
					listStore.add(s);
				} else {
					for (StoreId_ProductId storex : listStore) {
						if (!storex.get_storeid().equals(store)) {
							StoreId_ProductId s = new StoreId_ProductId();
							s.set_storeid(store);
							listStore.add(s);
							break;
						}
					}
				}
				
			}
			
			for (CartItemModel cartitem : cartitems) {
				for (StoreId_ProductId store : listStore) {
					String storeidx = productService.findStoreIdByProductId(cartitem.getProduct().getId());
					if (store.get_storeid().equals(storeidx)) {
						List<String> list = store.get_productid();
						if(list == null)
							list = new ArrayList<String>();
						list.add(String.valueOf(cartitem.getProduct().getId()));
						store.set_productid(list);
					}
				}

			}
			
			
			
			

			List<OrdersModel> orders = new ArrayList<OrdersModel>();

			for (String storeid : storeids) {
				for (CartItemModel cartitem : cartitems) {
					String storeidx = productService.findStoreIdByProductId(cartitem.getProduct().getId());
					if (storeid.equals(storeidx)) {
						if (orders.isEmpty()) {
							OrdersModel order = new OrdersModel();
							order.setUserId(Integer.parseInt(userid));
							order.setStoreId(Integer.parseInt(storeid));
							order.setDeliveryId(Integer.parseInt(deliveryId));
							order.setAddress(address);
							order.setPhone(phone);

							// tinh tien cua dơn vi van chuyen
							DeliveryModel delivery = deliveryService.findById(Integer.parseInt(deliveryId));
							BigDecimal delivery_price =  BigDecimal.valueOf(delivery.getPrice().doubleValue());
							BigDecimal total_product = BigDecimal.valueOf(total_price_a_product(cartitem));
							BigDecimal total = total_product.subtract(delivery_price);
							
							order.setTotal_price(total);
							orders.add(order);
						} else {
							for (OrdersModel ordercount : orders) {
								if (ordercount.getStoreId() != Integer.parseInt(storeid)) {
									OrdersModel order = new OrdersModel();
									order.setUserId(Integer.parseInt(userid));
									order.setStoreId(Integer.parseInt(storeid));
									order.setDeliveryId(Integer.parseInt(deliveryId));
									order.setAddress(address);
									order.setPhone(phone);

									// tinh tien cua dơn vi van chuyen
									DeliveryModel delivery = deliveryService.findById(Integer.parseInt(deliveryId));
									BigDecimal delivery_price =  BigDecimal.valueOf(delivery.getPrice().doubleValue());
									BigDecimal total_product = BigDecimal.valueOf(total_price_a_product(cartitem));
									BigDecimal total = total_product.subtract(delivery_price);
									
									order.setTotal_price(total);
									orders.add(order);
									break;
								} else if (ordercount.getStoreId() == Integer.parseInt(storeid)) {
									BigDecimal total_product = BigDecimal.valueOf(total_price_a_product(cartitem));
									BigDecimal orderold = ordercount.getTotal_price();
									BigDecimal total = total_product.add(orderold);
									
									ordercount.setTotal_price(total);
								}
							}
						}
					}

				}
			}
			
			for (OrdersModel order : orders) {
//				orderService.insert(order);
//				
//				OrderItemModel orderitem
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private double total_price_a_product(CartItemModel cartitem) {
		double total = 0;
		double promotion = total + Double.parseDouble(cartitem.getProduct().getPrice().toString()) * cartitem.getCount()
				* (cartitem.getProduct().getPromotion()) / 100;

		total = total + Double.parseDouble(cartitem.getProduct().getPrice().toString()) * cartitem.getCount();
		return total - promotion;
	}

}
