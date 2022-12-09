package Controller.Vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.ProductModel;
import Models.SizeModel;
import Service.IProductService;
import Service.ISizeService;
import Service.Impl.ProductServiceImpl;
import Service.Impl.SizeServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/vendor/size/edit" })
public class SizeEditControllerVendor extends HttpServlet {

	ISizeService sizeService = new SizeServiceImpl();
	IProductService productService = new ProductServiceImpl();
	private static String size_name;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String product_id = req.getParameter("id");
		size_name = req.getParameter("size");
		SizeModel size = sizeService.findByIdAndSize(product_id, size_name);
		req.setAttribute("sizes", size);

		ProductModel product = productService.findById(Integer.parseInt(product_id));
		req.setAttribute("product", product);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/edit-size.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");

			SizeModel size = new SizeModel();
			size.setProduct_id(Integer.parseInt(req.getParameter("product_id")));
			size.setSize(req.getParameter("size"));
			size.setQuantity(Integer.parseInt(req.getParameter("quantity")));

			sizeService.edit(size, size_name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resp.sendRedirect(req.getContextPath() + "/vendor/product");
		}
	}
}
