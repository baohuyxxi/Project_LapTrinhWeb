package Controller.Vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.StoreModel;
import Service.IProductService;
import Service.IStoreService;
import Service.Impl.ProductServiceImpl;
import Service.Impl.StoreServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/vendor/store/add" })
public class StoreAddController extends HttpServlet {
	IStoreService storeService = new StoreServiceImpl();
	IProductService productService = new ProductServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = ProcessCookies.getUserIdFromCookies(req, resp);
		try {

			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");

			StoreModel store = new StoreModel();
			store.setUserId(Integer.parseInt(userid));
			store.setName(req.getParameter("name"));
			store.setSlug(req.getParameter("slug"));
			store.setAddress(req.getParameter("address"));
			storeService.insert(store);
			
			String storeId = productService.findStoreIdByUserId(Integer.parseInt(userid));
			if (storeId != null) {
				Cookie cookieStoreId = new Cookie("storeIdLogin", String.valueOf(storeId));
				resp.addCookie(cookieStoreId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resp.sendRedirect(req.getContextPath() + "/vendor/store");
		}
	}
}
