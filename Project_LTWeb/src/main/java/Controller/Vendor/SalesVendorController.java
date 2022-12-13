package Controller.Vendor;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.ProductModel;
import Service.IOrderService;
import Service.IProductService;
import Service.Impl.OrderServiceImpl;
import Service.Impl.ProductServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(value = { "/vendor/sale" })
public class SalesVendorController extends HttpServlet {

	IProductService productService = new ProductServiceImpl();
	IOrderService orderService = new OrderServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String storeid = ProcessCookies.getStoreIdFromCookies(req, resp);
			if (storeid == null) {
				resp.sendRedirect(req.getContextPath() + "/login");
				return;
			}
			String userId = ProcessCookies.getUserIdFromCookies(req, resp);
			
			req.setAttribute("userId", userId);
			// Sản phẩm bán nhiều nhất
			ProductModel top1Product = productService.findTop1Product(Integer.parseInt(storeid));
			req.setAttribute("product", top1Product);

			// sản phẩm bán ít nhất
			ProductModel minSoldProductModel = productService.findMinSoldProduct(Integer.parseInt(storeid));
			req.setAttribute("productMinSold", minSoldProductModel);

			// Tổng doanh thu của cửa hàng
			BigDecimal totalSales = orderService.totalSales(Integer.parseInt(storeid));
			req.setAttribute("totalSales", totalSales);

			RequestDispatcher rd = req.getRequestDispatcher("/views/vendor/Sales.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/vendor/Sales.jsp");
			rd.forward(req, resp);
		}
	}

}
