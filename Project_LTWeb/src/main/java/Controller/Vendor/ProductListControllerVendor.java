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

import Models.CategoryModel;
import Models.ProductModel;
import Models.SizeModel;
import Service.ICategoryService;
import Service.IProductService;
import Service.ISizeService;
import Service.IStoreService;
import Service.Impl.CategoryServiceImpl;
import Service.Impl.ProductServiceImpl;
import Service.Impl.SizeServiceImpl;
import Service.Impl.StoreServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/vendor/product" })
public class ProductListControllerVendor extends HttpServlet {
	IProductService productService = new ProductServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	IStoreService storeService = new StoreServiceImpl();
	ISizeService sizeService = new SizeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userid = null;

		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = req.getCookies();
		resp.setContentType("text/html");
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if (cookie.getName().equals("userIdLogin"))
					userid = cookie.getValue();
			}
		} else {
			//
		}
		
		if (userid == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		} else {
			//lấy product
			String storeId = productService.findStoreIdByUserId(Integer.parseInt(userid));
			List<ProductModel> productList = productService.getAllByStoreId(Integer.parseInt(storeId));
			
			
			for (ProductModel product : productList) {
				//lấy size
				List<SizeModel> sizes = sizeService.getAllProductId(product.getId());
				product.setSizemd(sizes);
			}
			
			req.setAttribute("productList", productList);
			//lấy category
			List<CategoryModel> categoryList = categoryService.getAll();
			req.setAttribute("categoryList", categoryList);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/list-product.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
