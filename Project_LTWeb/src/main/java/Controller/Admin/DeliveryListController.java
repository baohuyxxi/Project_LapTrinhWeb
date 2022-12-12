package Controller.Admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
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
@WebServlet(urlPatterns = {"/admin/delivery"})
public class DeliveryListController extends HttpServlet{

	IDeliveryService deliveryService = new DeliveryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DeliveryModel> deliveryList = deliveryService.getAll();
		req.setAttribute("deliveryList",deliveryList);
		req.setAttribute("delivery", "active");
		req.setAttribute("evaluate", "");
		req.setAttribute("home", "");
		req.setAttribute("category", "");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-delivery.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}
