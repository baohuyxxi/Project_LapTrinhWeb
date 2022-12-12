package Controller.Admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.DeliveryModel;
import Service.IDeliveryService;
import Service.Impl.DeliveryServiceImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/delivery/add"})
public class DeliveryAddController extends HttpServlet{

	
	
	IDeliveryService deliveryService = new DeliveryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-delivery.jsp");
		dispatcher.forward(req, resp);
	}

	private static BigDecimal createBigDecimalFromString(String string) {
	    BigDecimal value = null;
	    try {
	        Number number = NumberFormat.getNumberInstance(new Locale("pt", "BR")).parse(string);
	        value = new BigDecimal(Integer.parseInt(number.toString()));
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return value;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			
			DeliveryModel delivery = new DeliveryModel();
			delivery.setName(req.getParameter("name"));
			delivery.setPhone(req.getParameter("phone"));
			delivery.setPrice(createBigDecimalFromString(req.getParameter("price")));
			delivery.setStatus(Integer.parseInt(req.getParameter("status")));
			
			deliveryService.insert(delivery);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			resp.sendRedirect(req.getContextPath() + "/admin/delivery");
		}
	}


}
