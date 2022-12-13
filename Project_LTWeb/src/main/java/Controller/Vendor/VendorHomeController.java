package Controller.Vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/vendor/home"})
public class VendorHomeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String userId = ProcessCookies.getUserIdFromCookies(req, resp);
			
			req.setAttribute("userId", userId);
			RequestDispatcher rd =  req.getRequestDispatcher("/views/vendor/home.jsp"); 
			rd.forward(req, resp);
		} catch (Exception e) {
			RequestDispatcher rd =  req.getRequestDispatcher("/views/vendor/home.jsp"); 
			rd.forward(req, resp);
		}
		
		
	}

}
