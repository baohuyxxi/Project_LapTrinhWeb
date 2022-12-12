package Controller.Customer;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CartItemModel;
import Models.ProductModel;
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
@WebServlet(urlPatterns = { "/user/cartitem/edit" })
public class CartItemEditController extends HttpServlet {

	ICartItemService cartItemService = new CartItemServiceImpl();
	IProductService productService = new ProductServiceImpl();
	ICartService cartService = new CartServiceImpl();
	ISizeService sizeService = new SizeServiceImpl();
	IImageService imageService = new ImageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userID = ProcessCookies.getUserIdFromCookies(req, resp);
		String role = ProcessCookies.getRoleFromCookies(req, resp);
		try {
			if (userID != null && Integer.parseInt(role) == 1) {
				try {
					CartItemModel cartitem = new CartItemModel();
					int cartitemid = Integer.parseInt(req.getParameter("id"));

					int productid = Integer.parseInt(productService.findProductIdByCardId(cartitemid));
					cartitem = cartItemService.findById(cartitemid);

					ProductModel product = productService.findByProductId(cartitem.getProductId());
					product.setSizemd(sizeService.getAllProductId(product.getId()));
					product.setImg(productService.findById(productid).getImg());
					cartitem.setProduct(product);

					req.setAttribute("cartitem", cartitem);

					RequestDispatcher rd = req.getRequestDispatcher("/views/customer/edit-cart-item.jsp");
					rd.forward(req, resp);

				} catch (Exception e) {
					e.printStackTrace();
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
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");

			CartItemModel cartitem = new CartItemModel();
			cartitem.setId(Integer.parseInt(req.getParameter("id")));
			cartitem.setCount(Integer.parseInt(req.getParameter("count")));
			cartitem.setSize(req.getParameter("size"));

			cartItemService.edit(cartitem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath() + "/user/cartitem");
	}

}
