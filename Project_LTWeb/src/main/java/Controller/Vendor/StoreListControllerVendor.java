package Controller.Vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.StoreModel;
import Service.IStoreService;
import Service.Impl.StoreServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/vendor/store/list"})
public class StoreListControllerVendor extends HttpServlet{
	IStoreService storeService = new StoreServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<StoreModel> storeList = storeService.getAll();
		req.setAttribute("storeList", storeList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/guest/list-store.jsp");
		dispatcher.forward(req, resp);
	}
}
