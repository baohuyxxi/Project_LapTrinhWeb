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
import Service.IProductService;
import Service.Impl.CategoryServiceImpl;
import Service.Impl.ProductServiceImpl;
import util.ConvertBigDecimal;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/vendor/product/edit" })
public class ProductEditControllerVendor extends HttpServlet{

	IProductService productService = new ProductServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		ProductModel product = productService.findById(Integer.parseInt(id));
		req.setAttribute("product", product);
		
		List<CategoryModel> categoryList = categoryService.getAll();
		req.setAttribute("categoryList", categoryList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/edit-product.jsp");
		dispatcher.forward(req, resp);
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
			product.setQuantity(Integer.parseInt(req.getParameter("quantity")));
			product.setCategory_id(Integer.parseInt(req.getParameter("category_id")));

			productService.edit(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			resp.sendRedirect(req.getContextPath() + "/vendor/product");
		}
	}

}
