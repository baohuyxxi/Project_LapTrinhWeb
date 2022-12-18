package Controller.Customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CartItemModel;
import Models.CartModel;
import Models.DeliveryModel;
import Models.InfoUserModel;
import Models.ProductModel;
import Service.ICartItemService;
import Service.ICartService;
import Service.IDeliveryService;
import Service.IImageService;
import Service.IInfoUserService;
import Service.IProductService;
import Service.ISizeService;
import Service.IStoreService;
import Service.Impl.CartItemServiceImpl;
import Service.Impl.CartServiceImpl;
import Service.Impl.DeliveryServiceImpl;
import Service.Impl.ImageServiceImpl;
import Service.Impl.InfoUserServiceImpl;
import Service.Impl.ProductServiceImpl;
import Service.Impl.SizeServiceImpl;
import Service.Impl.StoreServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user/cartitem" })
public class CartItemController extends HttpServlet {

	IProductService productService = new ProductServiceImpl();
	ICartService cartService = new CartServiceImpl();
	ISizeService sizeService = new SizeServiceImpl();
	IImageService imageService = new ImageServiceImpl();
	ICartItemService cartItemService = new CartItemServiceImpl();
	IDeliveryService deliveryService = new DeliveryServiceImpl();
	IInfoUserService infoUserService = new InfoUserServiceImpl();
	IStoreService storeService = new StoreServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = ProcessCookies.getUserIdFromCookies(req, resp);
		String role = ProcessCookies.getRoleFromCookies(req, resp);
		try {
			if (userID != null && Integer.parseInt(role) == 1) {
				try {
					if (role != null) {
						CartItemModel cartx = cartItemService.findCartAndCountProductID(Integer.parseInt(userID));
						req.setAttribute("cart", cartx);
						
						String userId = ProcessCookies.getUserIdFromCookies(req, resp);
						req.setAttribute("userId", userId);
						// lấy products
						int cartid = Integer.parseInt(cartService
								.findCartIdByUserId(Integer.parseInt(ProcessCookies.getUserIdFromCookies(req, resp))));
						//List<String> productid = productService.findProductIdByCardId(cartid);
						List<CartItemModel> cartitems = cartItemService.getAllByCartId(cartid);
						for (CartItemModel cartitem : cartitems) {
							ProductModel product = productService.findByProductId(cartitem.getProductId());
							product.setSizemd(sizeService.getAllProductId(product.getId()));
							product.setImg(productService.findById(product.getId()).getImg());
							cartitem.setProduct(product);
						}

						req.setAttribute("cartitems", cartitems);
						
						//lấy đơn vị vận chuyển
						List<DeliveryModel> deliverys = deliveryService.getAll();
						
						InfoUserModel infoUser = infoUserService.findById(Integer.parseInt(userID));
						//lay deliveryid từ cartid
						CartModel cart = cartService.findById(cartid);
						DeliveryModel deliveryfromcartid = deliveryService.findById(cart.getDeliveryId());
						
						//String storeid = productService.findStoreIdByProductId(productid);
						
						
						double total_promotion = total_Promotion(cartitems);
						double delivery_price = Double.parseDouble(deliveryfromcartid.getPrice().toString());
						double total_price = total_Price(cartitems, total_promotion, delivery_price);
						
						req.setAttribute("deliverys", deliverys);
						req.setAttribute("deliveryfromcartid", deliveryfromcartid);
						req.setAttribute("infoUser", infoUser);
						req.setAttribute("total_promotion", total_promotion);
						req.setAttribute("total_price", total_price);
						

						RequestDispatcher rd = req.getRequestDispatcher("/views/customer/list-cart-items.jsp");
						rd.forward(req, resp);
					} else {
						resp.sendRedirect(req.getContextPath() + "/login");
					}
				} catch (Exception e) {
					e.printStackTrace();// null
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/login");
			}
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath() + "/login");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	private double total_Promotion(List<CartItemModel> cartitems)
	{
		double total = 0;
		for (CartItemModel cartitem : cartitems) {
			total = total +Double.parseDouble(cartitem.getProduct().getPrice().toString()) *
					cartitem.getCount() *(cartitem.getProduct().getPromotion())/100;			
				
		}		
		return total;
	}
	
	private double total_Price(List<CartItemModel> cartitems, double total_promotion, double delivery_price)
	{
		double total = 0;
		for (CartItemModel cartitem : cartitems) {
			total =  total + Double.parseDouble(cartitem.getProduct().getPrice().toString())*cartitem.getCount();
		}		
		return total - total_promotion + delivery_price;
	}

}
