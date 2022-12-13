package Controller.Customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CartModel;
import Service.ICartService;
import Service.IDeliveryService;
import Service.Impl.CartServiceImpl;
import Service.Impl.DeliveryServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/user/cartitem/updateprice"})
public class UpdatePriceCartItem extends HttpServlet{

	IDeliveryService deliveryService = new DeliveryServiceImpl();
	ICartService cartService = new CartServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String deliveryid =req.getParameter("deliveryid");
		try {
			
			int cartid = Integer.parseInt(cartService
					.findCartIdByUserId(Integer.parseInt(ProcessCookies.getUserIdFromCookies(req, resp))));
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");

			CartModel cart = new CartModel();
			cart.setId(cartid);
			cart.setDeliveryId(Integer.parseInt(deliveryid));
			
			cartService.edit(cart);
			resp.sendRedirect(req.getContextPath() + "/user/cartitem");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
