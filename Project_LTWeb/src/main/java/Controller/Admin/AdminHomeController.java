package Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.IEvaluateService;
import Service.IInfoUserService;
import Service.IOrderService;
import Service.IProductService;
import Service.IStoreService;
import Service.Impl.EvaluateServiceImpl;
import Service.Impl.InfoUserServiceImpl;
import Service.Impl.OrderServiceImpl;
import Service.Impl.ProductServiceImpl;
import Service.Impl.StoreServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/trang-chu" })
public class AdminHomeController extends HttpServlet {

	IEvaluateService evaluateService = new EvaluateServiceImpl();
	IProductService productService = new ProductServiceImpl();
	IOrderService orderService = new OrderServiceImpl();
	IStoreService storeService = new StoreServiceImpl();
	IInfoUserService userService = new InfoUserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String role = ProcessCookies.getRoleFromCookies(req, resp);
		if (Integer.parseInt(role) == 0) {

			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/HomeAdmin.jsp");

			int slUser = userService.CountUser();
			req.setAttribute("slUser", slUser);

			int slStore = storeService.CountStore();
			req.setAttribute("slStore", slStore);

			int slOrder = orderService.CountOrder();
			req.setAttribute("slOrder", slOrder);

			int slSold = productService.CountProductSold();
			req.setAttribute("slSold", slSold);

			int slProduct = productService.CountProduct();
			req.setAttribute("slProduct", slProduct);

			int slEvaluated = evaluateService.CountEvaluated();
			req.setAttribute("slEvaluated", slEvaluated);

			req.setAttribute("home", "active");
			req.setAttribute("evaluate", "");
			req.setAttribute("category", "");
			req.setAttribute("delivery", "");
			dispatcher.forward(req, resp);
		}
		else
		{
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

}