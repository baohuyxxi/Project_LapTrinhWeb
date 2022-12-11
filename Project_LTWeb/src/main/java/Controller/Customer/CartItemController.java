package Controller.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CartItemModel;
import Models.CartModel;
import Models.ImagesModel;
import Models.ProductModel;
import Models.SizeModel;
import Service.ICartItemService;
import Service.ICartService;
import Service.IImageService;
import Service.IProductService;
import Service.ISizeService;
import Service.Impl.CartItemServiceImpl;
import Service.Impl.CartServiceImpl;
import Service.Impl.ImageServiceImpl;
import Service.Impl.ProductServiceImpl;
import Service.Impl.SizeServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user/cartitem" })
public class CartItemController extends HttpServlet {

	IProductService productService = new ProductServiceImpl();
	ICartService cartService = new CartServiceImpl();
	ISizeService sizeService = new SizeServiceImpl();
	IImageService imageService = new ImageServiceImpl();
	ICartItemService cartItemService = new CartItemServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role = ProcessCookies.getRoleFromCookies(req, resp);
		if (Integer.parseInt(role) == 1) {
			//lấy products
			int cartid = Integer.parseInt(cartService.findCartIdByUserId(Integer.parseInt(ProcessCookies.getUserIdFromCookies(req, resp))));
			List<ProductModel> products = productService.findProductByCardId(cartid);
			req.setAttribute("products", products);
			
			//lấy size theo product
			for (ProductModel product : products) {
				// lấy size
				List<SizeModel> sizes = sizeService.getAllProductId(product.getId());
				product.setSizemd(sizes);

				ProductModel images = productService.findById(cartid);
				if(images != null)
				{
					product.setImg(images.getImg());
				}
			}
			
			List<CartItemModel> cartitems = cartItemService.getAll();
			for (CartItemModel cartitem : cartitems) {
				ProductModel product = productService.findByProductId(cartitem.getProductId());
				product.setSizemd(sizeService.getAllProductId(product.getId()));
				product.setImg(productService.findById(cartid));
					cartitem.setProduct(product);
			}

			RequestDispatcher rd = req.getRequestDispatcher("/views/customer/list-cart-items.jsp");
			rd.forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
