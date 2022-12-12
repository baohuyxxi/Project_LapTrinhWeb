package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.StoreModel;
import Service.IStoreService;
import Service.Impl.StoreServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/store/edit"})
public class StoreEditStatusAdminController extends HttpServlet{

	IStoreService storeService = new StoreServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			StoreModel store = new StoreModel();
			store.setId(Integer.parseInt(req.getParameter("id")));
			store.setStatus(Boolean.parseBoolean(req.getParameter("status")));

		
			storeService.editByAdmin(store);
			resp.sendRedirect(req.getContextPath()+ "/admin/store");

		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath()+ "/admin/store");
			e.printStackTrace();
		}
	}
	
}
