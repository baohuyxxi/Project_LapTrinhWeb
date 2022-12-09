package Controller.Vendor;

import java.io.IOException;

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
@WebServlet(urlPatterns = { "/vendor/store/edit" })
public class StoreEditControllerVendor extends HttpServlet{

	IStoreService storeService = new StoreServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		StoreModel store = storeService.findById(Integer.parseInt(id));
		req.setAttribute("store", store);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/edit-store.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			StoreModel store = new StoreModel();
			store.setId(Integer.parseInt(req.getParameter("id")));
			store.setName(req.getParameter("name"));
			store.setSlug(req.getParameter("slug"));
			store.setAddress(req.getParameter("address"));
			
			storeService.edit(store);
			resp.sendRedirect(req.getContextPath() + "/vendor/store/my");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
