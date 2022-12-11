package Controller.Vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.IOrderItemDao;
import Models.OrderItemModel;
import Service.IOrderItemService;
import Service.Impl.OrderItemServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(value = {"/vendor/order/detail-order"})
public class ShowOrderItemVendorController extends HttpServlet{

	IOrderItemService orderItemService = new OrderItemServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (ProcessCookies.getStoreIdFromCookies(req, resp) == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		String orderId = req.getParameter("orderId");
		List<OrderItemModel> orderItemLst = orderItemService.getAll(Integer.parseInt(orderId));
		req.setAttribute("orderItemLst", orderItemLst);
		RequestDispatcher rd = req.getRequestDispatcher("/views/vendor/list-orderItem.jsp");
		rd.forward(req, resp);
	}
	
}
