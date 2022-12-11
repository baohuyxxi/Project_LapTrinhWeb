package Controller.Vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CategoryModel;
import Models.ProductModel;
import Service.ICategoryService;
import Service.IInfoUserService;
import Service.IProductService;
import Service.Impl.CategoryServiceImpl;
import Service.Impl.InfoUserServiceImpl;
import Service.Impl.ProductServiceImpl;
import util.ConvertBigDecimal;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/vendor/product/edit" })
public class ProductEditControllerVendor extends HttpServlet {

	IProductService productService = new ProductServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	IInfoUserService infoUserService = new InfoUserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

			String productid = req.getParameter("id");
			String storeid = productService.findStoreIdByProductId(Integer.parseInt(productid));
			String checkStoreId = ProcessCookies.getStoreIdFromCookies(req, resp);
			if (storeid.equals(checkStoreId)) {// kiem tra id cửa hàng có phải của user không
				ProductModel product = productService.findByProductId(Integer.parseInt(productid));
				req.setAttribute("product", product);

				List<CategoryModel> categoryList = categoryService.getAll();
				req.setAttribute("categoryList", categoryList);

				RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/edit-product.jsp");
				dispatcher.forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/vendor/store");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");

			ProductModel product = new ProductModel();
			product.setId(Integer.parseInt(req.getParameter("id")));
			product.setName(req.getParameter("name"));
			product.setSlug(req.getParameter("slug"));
			product.setDescription(req.getParameter("description"));
			product.setPrice(ConvertBigDecimal.createBigDecimalFromString(req.getParameter("price")));
			product.setPromotion(Integer.parseInt(req.getParameter("promotion")));
			product.setCategory_id(Integer.parseInt(req.getParameter("category_id")));

			productService.edit(product);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resp.sendRedirect(req.getContextPath() + "/vendor/product");
		}
	}

}
