package Controller.Vendor;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.OrdersModel;
import Service.IOrderService;
import Service.Impl.OrderServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/vendor/order/edit-order" })
public class VendorEditOrder extends HttpServlet{

	IOrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		OrdersModel order = orderService.findById(Integer.parseInt(id));
		req.setAttribute("order", order);
		RequestDispatcher rd = req.getRequestDispatcher("/views/vendor/edit-order.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			OrdersModel order = new OrdersModel();
			order.setDeliveryId(Integer.parseInt(req.getParameter("deliveryId")));
			order.setAddress(req.getParameter("address"));
			order.setStatus(Integer.parseInt(req.getParameter("status")));
			
			
			order.setPhone(req.getParameter("phone"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
