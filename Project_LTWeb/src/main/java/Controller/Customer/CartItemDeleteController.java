package Controller.Customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ICartItemService;
import Service.Impl.CartItemServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user/cartitem/delete" })
public class CartItemDeleteController extends HttpServlet {
	ICartItemService cartItemService = new CartItemServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			cartItemService.delete(Integer.parseInt(req.getParameter("id")));
		} catch (Exception e) {
			//
		} finally {
			resp.sendRedirect(req.getContextPath() + "/user/cartitem");
		}
	}

}
