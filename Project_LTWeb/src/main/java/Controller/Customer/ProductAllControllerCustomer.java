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
@WebServlet(urlPatterns = {"/user/products"})
public class ProductAllControllerCustomer extends HttpServlet{

	IProductService productService = new ProductServiceImpl();
	ICartItemService cartItemService = new CartItemServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = ProcessCookies.getUserIdFromCookies(req, resp);
		List<ProductModel> pro = productService.findProByAllId(0,"0");
		req.setAttribute("pro",pro);

		CartItemModel cart = cartItemService.findCartAndCountProductID(Integer.parseInt(userID));
		req.setAttribute("cart", cart);
		req.setAttribute("userId", userID);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/customer/productAll.jsp");
		dispatcher.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = ProcessCookies.getUserIdFromCookies(req, resp);
		String role = ProcessCookies.getRoleFromCookies(req, resp);
		
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			

			String string = req.getParameter("question");
			List<ProductModel> pro = productService.findProByString(string);
			req.setAttribute("pro",pro);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/customer/productAll.jsp");
			dispatcher.forward(req, resp);
			if (userID != null && Integer.parseInt(role) == 1) {
				
				pro = productService.findProByAllId(0, "0");
				req.setAttribute("pro", pro);
				req.setAttribute("userId", userID);
				dispatcher = req.getRequestDispatcher("/views/customer/productAll.jsp");
				dispatcher.forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
