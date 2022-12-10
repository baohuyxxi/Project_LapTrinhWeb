package Controller.Vendor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
@WebServlet(urlPatterns = { "/vendor/store" })
public class MyStoreControllerVendor extends HttpServlet {
	IStoreService storeService = new StoreServiceImpl();
	IProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userid = ProcessCookies.getUserIdFromCookies(req, resp);

		if (userid == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		} else {
			try {

				List<StoreModel> myStorelist = new ArrayList<StoreModel>();

				StoreModel myStore = storeService
						.findById(Integer.parseInt(productService.findStoreIdByUserId(Integer.parseInt(userid))));
				myStorelist.add(myStore);
				req.setAttribute("myStorelist", myStorelist);
			} catch (Exception e) {
				// chưa có cửa hàng
			} finally {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/my-store.jsp");
				dispatcher.forward(req, resp);
			}
		}

	}
}
