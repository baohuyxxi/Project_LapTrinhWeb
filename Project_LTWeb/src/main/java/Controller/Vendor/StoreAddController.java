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
import Service.IStoreService;
import Service.Impl.StoreServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/vendor/store/add" })
public class StoreAddController extends HttpServlet {
	IStoreService storeService = new StoreServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/add-my-store.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = null;

		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = req.getCookies();
		resp.setContentType("text/html");
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if (cookie.getName().equals("userIdLogin"))
					id = cookie.getValue();
			}
		} else {
			//
		}
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");

			StoreModel store = new StoreModel();
			store.setUserId(Integer.parseInt(id));
			store.setName(req.getParameter("name"));
			store.setSlug(req.getParameter("slug"));
			store.setAddress(req.getParameter("address"));

			storeService.insert(store);
			resp.sendRedirect(req.getContextPath() + "/vendor/store/my");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
