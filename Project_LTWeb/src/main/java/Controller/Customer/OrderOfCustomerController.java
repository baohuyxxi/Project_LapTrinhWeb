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

import Models.CartItemModel;
import Models.OrderUserModel;
import Service.ICartItemService;
import Service.IMyOrderCustomerService;
import Service.Impl.CartItemServiceImpl;
import Service.Impl.MyOrderCustomerServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user/my-order" })
public class OrderOfCustomerController extends HttpServlet {

	IMyOrderCustomerService myOrderCustomerService = new MyOrderCustomerServiceImpl();
	ICartItemService cartItemService = new CartItemServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userid = ProcessCookies.getUserIdFromCookies(req, resp);
			String role = ProcessCookies.getRoleFromCookies(req, resp);
			CartItemModel cartx = cartItemService.findCartAndCountProductID(Integer.parseInt(userid));
			req.setAttribute("cart", cartx);
			
			if (role != null && Integer.parseInt(role) == 1) {
				List<OrderUserModel> orders0 = new ArrayList<OrderUserModel>();
				List<OrderUserModel> orders1 = new ArrayList<OrderUserModel>();
				List<OrderUserModel> orders2 = new ArrayList<OrderUserModel>();
				List<OrderUserModel> orders3 = new ArrayList<OrderUserModel>();
				
				
				orders0 = myOrderCustomerService.myorder(Integer.parseInt(userid), 0);
				req.setAttribute("orders0", orders0);
				orders1 = myOrderCustomerService.myorder(Integer.parseInt(userid), 1);
				req.setAttribute("orders1", orders1);
				orders2 = myOrderCustomerService.myorder(Integer.parseInt(userid), 2);
				req.setAttribute("orders2", orders2);
				orders3 = myOrderCustomerService.myorder(Integer.parseInt(userid), 3);
				req.setAttribute("orders3", orders3);
				
				req.setAttribute("userId", userid);
				RequestDispatcher rd = req.getRequestDispatcher("/views/customer/my-order.jsp");
				rd.forward(req, resp);
				
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
