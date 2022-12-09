package Controller.Vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.ProductModel;
import Service.IProductService;
import Service.Impl.ProductServiceImpl;
import util.ConvertBigDecimal;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/vendor/product/add"})
public class ProductAddControllerVendor extends HttpServlet{
	IProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/add-product.jsp");
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
			
			ProductModel product = new ProductModel();
			product.setName(req.getParameter("name"));
			product.setSlug(req.getParameter("slug"));
			product.setDescription(req.getParameter("description"));
			product.setPrice(ConvertBigDecimal.createBigDecimalFromString(req.getParameter("price")));
			product.setPromotion(Integer.parseInt(req.getParameter("slug")));
			product.setQuantity(Integer.parseInt(req.getParameter("quantity")));
			product.setSold(Integer.parseInt(req.getParameter("sold")));
			product.setCategory_id(Integer.parseInt(req.getParameter("category_id")));
			product.setStoreId(Integer.parseInt(productService.findStoreIdByUserId(Integer.parseInt(id))));

			productService.insert(product);
			resp.sendRedirect(req.getContextPath() + "/vendor/product/list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
