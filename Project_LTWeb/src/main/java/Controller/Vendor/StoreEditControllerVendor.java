package Controller.Vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.StoreModel;
import Service.IInfoUserService;
import Service.IProductService;
import Service.IStoreService;
import Service.Impl.InfoUserServiceImpl;
import Service.Impl.ProductServiceImpl;
import Service.Impl.StoreServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/vendor/store/edit" })
public class StoreEditControllerVendor extends HttpServlet {

	IStoreService storeService = new StoreServiceImpl();
	IInfoUserService infoUserService = new InfoUserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		// tìm userID từ cookies
		String userid = ProcessCookies.getUserIdFromCookies(req, resp);

		if (userid == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		} else {
			if (ProcessCookies.getStoreIdFromCookies(req, resp) == null) {
				resp.sendRedirect(req.getContextPath() + "/login");
				return;
			}

			String id = req.getParameter("id");

			String checkStoreId = infoUserService.findUserIdByStoreId(Integer.parseInt(id));
			if (userid.equals(checkStoreId)) {//kiem tra id cửa hàng có phải của user không
				StoreModel store = storeService.findById(Integer.parseInt(id));
				req.setAttribute("store", store);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/edit-store.jsp");
				dispatcher.forward(req, resp);
			}
			else
			{
				resp.sendRedirect(req.getContextPath() + "/vendor/store");
			}
		}
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
			resp.sendRedirect(req.getContextPath() + "/vendor/store");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
