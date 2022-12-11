package Controller.Guest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.ProductModel;
import Models.StoreModel;
import Service.IProductService;
import Service.IStoreService;
import Service.Impl.ProductServiceImpl;
import Service.Impl.StoreServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/store"})
public class StoreControllerGuest extends HttpServlet{

	IProductService productService = new ProductServiceImpl();
	IStoreService storeService = new StoreServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int valueId = Integer.parseInt(req.getParameter("id"));
		String columnId = "storeId";
		
		StoreModel stor = storeService.findById(valueId);
		req.setAttribute("stor",stor);
		List<ProductModel> pro = productService.findProByAllId(valueId,columnId);
		req.setAttribute("pro",pro);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/guest/store-id.jsp");
		dispatcher.forward(req, resp);
	}
}
