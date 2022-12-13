package Controller.Customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CartItemModel;
import Models.ImagesModel;
import Models.ProductModel;
import Models.SizeModel;
import Service.ICartItemService;
import Service.IImageService;
import Service.IProductService;
import Service.ISizeService;
import Service.Impl.CartItemServiceImpl;
import Service.Impl.ImageServiceImpl;
import Service.Impl.ProductServiceImpl;
import Service.Impl.SizeServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user/product" })
public class ProductControllerCustomer extends HttpServlet {

	IProductService productService = new ProductServiceImpl();
	IImageService imageService = new ImageServiceImpl();
	ISizeService sizeService = new SizeServiceImpl();
	ICartItemService cartItemService = new CartItemServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userID = ProcessCookies.getUserIdFromCookies(req, resp);
		String role = ProcessCookies.getRoleFromCookies(req, resp);
		try {
			CartItemModel cartx = cartItemService.findCartAndCountProductID(Integer.parseInt(userID));
			req.setAttribute("cart", cartx);
			if (userID != null && Integer.parseInt(role) == 1) {

				int id = Integer.parseInt(req.getParameter("id"));
				ProductModel pro = productService.findById(id);
				req.setAttribute("pro", pro);
				List<SizeModel> sizes = sizeService.getAllProductId(id);
				req.setAttribute("sizes",sizes);
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
