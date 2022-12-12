package Controller.Customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.ImagesModel;
import Models.ProductModel;
import Service.IImageService;
import Service.IProductService;
import Service.Impl.ImageServiceImpl;
import Service.Impl.ProductServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user/product" })
public class ProductControllerCustomer extends HttpServlet {

	IProductService productService = new ProductServiceImpl();
	IImageService imageService = new ImageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userID = ProcessCookies.getUserIdFromCookies(req, resp);
		String role = ProcessCookies.getRoleFromCookies(req, resp);
		try {
			if (userID != null && Integer.parseInt(role) == 1) {

				int id = Integer.parseInt(req.getParameter("id"));
				ProductModel pro = productService.findById(id);
				req.setAttribute("pro", pro);
				List<ImagesModel> imag = imageService.getAllProductId(id);
				req.setAttribute("imag", imag);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/views/customer/product-id.jsp");
				dispatcher.forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/login");
			}
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}
