package Controller.Vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.OrdersModel;
import Service.IOrderService;
import Service.IProductService;
import Service.Impl.OrderServiceImpl;
import Service.Impl.ProductServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(value = { "/vendor/order" })
public class VendorListOrder extends HttpServlet {

	IOrderService orderService = new OrderServiceImpl();
	IProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String storeid = ProcessCookies.getStoreIdFromCookies(req, resp);
			String userId = ProcessCookies.getUserIdFromCookies(req, resp);
			
			req.setAttribute("userId", userId);
			List<OrdersModel> orderList = orderService.getAllOfStore(Integer.parseInt(storeid));
			req.setAttribute("orderList", orderList);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			RequestDispatcher rd = req.getRequestDispatcher("/views/vendor/order.jsp");
			rd.forward(req, resp);
		}

	}

}
