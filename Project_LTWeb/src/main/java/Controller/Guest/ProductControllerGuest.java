package Controller.Guest;

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
import Models.SizeModel;
import Service.IImageService;
import Service.IProductService;
import Service.ISizeService;
import Service.Impl.ImageServiceImpl;
import Service.Impl.ProductServiceImpl;
import Service.Impl.SizeServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/product"})
public class ProductControllerGuest extends HttpServlet{

	IProductService productService = new ProductServiceImpl();
	IImageService imageService = new ImageServiceImpl();
	ISizeService sizeService = new SizeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ProductModel pro = productService.findById(id);
		req.setAttribute("pro",pro);
		
		List<SizeModel> sizes = sizeService.getAllProductId(id);
		req.setAttribute("sizes",sizes);

		List<ImagesModel> imag = imageService.getAllProductId(id);
		req.setAttribute("imag",imag);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/guest/product-id.jsp");
		dispatcher.forward(req, resp);
	}
}
