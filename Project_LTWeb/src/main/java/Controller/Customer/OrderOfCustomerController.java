package Controller.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.OrderUserModel;
import Service.IMyOrderCustomerService;
import Service.Impl.MyOrderCustomerServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user/my-order" })
public class OrderOfCustomerController extends HttpServlet {

	IMyOrderCustomerService myOrderCustomerService = new MyOrderCustomerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userid = ProcessCookies.getUserIdFromCookies(req, resp);
			String role = ProcessCookies.getRoleFromCookies(req, resp);
			if (role != null && Integer.parseInt(role) == 1) {
				List<OrderUserModel> orders = new ArrayList<OrderUserModel>();
				orders = myOrderCustomerService.myorder(Integer.parseInt(userid));
				req.setAttribute("orders", orders);
				
				RequestDispatcher rd = req.getRequestDispatcher("/views/customer/my-order.jsp");
				rd.forward(req, resp);
				
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
