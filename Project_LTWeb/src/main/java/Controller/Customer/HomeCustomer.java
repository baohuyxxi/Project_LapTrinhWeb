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
import Models.ProductModel;
import Service.ICartItemService;
import Service.IProductService;
import Service.Impl.CartItemServiceImpl;
import Service.Impl.ProductServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user/home" })
public class HomeCustomer extends HttpServlet {

	ICartItemService cartItemService = new CartItemServiceImpl();
	IProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProductModel> pro = productService.proTop3();
		req.setAttribute("pro",pro);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/guest/home.jsp");
		dispatcher.forward(req, resp);
		String userID = ProcessCookies.getUserIdFromCookies(req, resp);
		try {
			if (Integer.parseInt(ProcessCookies.getRoleFromCookies(req, resp)) == 1 && userID != null) {
				CartItemModel cart = cartItemService.findCartAndCountProductID(Integer.parseInt(userID));
				req.setAttribute("cart", cart);

				RequestDispatcher rd = req.getRequestDispatcher("/views/customer/home.jsp");
				rd.forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/login");
			}
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath() + "/login");
		}

	}

}
