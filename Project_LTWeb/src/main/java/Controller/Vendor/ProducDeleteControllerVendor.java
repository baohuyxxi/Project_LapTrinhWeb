package Controller.Vendor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.IProductService;
import Service.Impl.ProductServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/vendor/product/delete" })
public class ProducDeleteControllerVendor extends HttpServlet{

	IProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		productService.delete(Integer.parseInt(req.getParameter("id")));
		}
		catch (Exception e) {
			//
		}
		finally {
			resp.sendRedirect(req.getContextPath() + "/vendor/product");
		}
	}
}
