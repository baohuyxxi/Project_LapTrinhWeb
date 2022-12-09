package Controller.Guest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.ProductModel;
import Service.IProductService;
import Service.Impl.ProductServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/zay/product"})
public class ProductControllerGuest extends HttpServlet{

	IProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ProductModel pro = productService.findById(id);
		req.setAttribute("pro",pro);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/guest/product-id.jsp");
		dispatcher.forward(req, resp);
	}
}
