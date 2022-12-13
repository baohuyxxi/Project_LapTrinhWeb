package Controller.Customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.StoreModel;
import Service.IProductService;
import Service.IStoreService;
import Service.Impl.ProductServiceImpl;
import Service.Impl.StoreServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/user/shops"})
public class StoreListControllerCustomer extends HttpServlet{

	IProductService productService = new ProductServiceImpl();
	IStoreService storeService = new StoreServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<StoreModel> stor = storeService.getAllInfo();
		req.setAttribute("stor",stor);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/customer/store-list.jsp");
		dispatcher.forward(req, resp);
	}
	
}
