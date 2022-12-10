package Controller.Vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
@WebServlet(value = {"/vendor/order"})
public class VendorListOrder extends HttpServlet{
	
	IOrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//String userid = ProcessCookies.getUserIdFromCookies(req, resp);
		String storeid = ProcessCookies.getStoreIdFromCookies(req, resp);
		
		
		List<OrdersModel> orderList = orderService.getAllOfStore(Integer.parseInt(storeid));
		req.setAttribute("orderList", orderList);
		RequestDispatcher rd =  req.getRequestDispatcher("/views/vendor/order.jsp"); 
		rd.forward(req, resp);
	}

}
