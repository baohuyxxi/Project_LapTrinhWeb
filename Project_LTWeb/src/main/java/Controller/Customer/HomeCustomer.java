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
import Service.Impl.CartItemServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/user/home"})
public class HomeCustomer extends HttpServlet{
	
	ICartItemService cartItemService = new CartItemServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userID = ProcessCookies.getUserIdFromCookies(req, resp);
		try {
		if(Integer.parseInt(ProcessCookies.getRoleFromCookies(req, resp))==1)
		{
			CartItemModel cart = cartItemService.findCartAndCountProductID(Integer.parseInt(userID));
			req.setAttribute("cart", cart);
			
			RequestDispatcher rd =  req.getRequestDispatcher("/views/customer/home.jsp"); 
			rd.forward(req, resp);
		}
		else
		{
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		}catch (Exception e) {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		
	}
	
}
