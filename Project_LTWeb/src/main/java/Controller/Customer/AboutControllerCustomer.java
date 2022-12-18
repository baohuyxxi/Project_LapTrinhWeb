package Controller.Customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CartItemModel;
import Service.ICartItemService;

// @SuppressWarnings("serial")
// @WebServlet(urlPatterns = {"/info"})

import Service.IProductService;
import Service.Impl.CartItemServiceImpl;
import Service.Impl.ProductServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user/about" })
public class AboutControllerCustomer extends HttpServlet {

	IProductService productService = new ProductServiceImpl();
	ICartItemService cartItemService = new CartItemServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// RequestDispatcher rd = req.getRequestDispatcher("/views/infoUser.jsp");
		// rd.forward(req, resp);
		
		String userID=ProcessCookies.getUserIdFromCookies(req, resp);
		CartItemModel cart = cartItemService.findCartAndCountProductID(Integer.parseInt(userID));
		req.setAttribute("cart", cart);

		
		req.setAttribute("userId", userID);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/about.jsp");
		dispatcher.forward(req, resp);
	}
}
