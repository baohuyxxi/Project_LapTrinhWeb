package Controller.Customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.ProductModel;
import Service.ICartService;
import Service.IProductService;
import Service.Impl.CartServiceImpl;
import Service.Impl.ProductServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user/cartitem" })
public class CartItemController extends HttpServlet {

	IProductService productService = new ProductServiceImpl();
	ICartService cartService = new CartServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = ProcessCookies.getRoleFromCookies(req, resp);
		if (Integer.parseInt(userid) == 1) {
			int cartid = Integer.parseInt(cartService.findCartIdByUserId(Integer.parseInt(userid)));
			List<ProductModel> products = productService.findProductByCardId(cartid);
			req.setAttribute("products", products);

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
