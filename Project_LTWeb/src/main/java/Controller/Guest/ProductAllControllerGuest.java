package Controller.Guest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.DeliveryModel;
import Models.ProductModel;
import Service.IProductService;
import Service.Impl.ProductServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/products"})
public class ProductAllControllerGuest extends HttpServlet{

	IProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> pro = productService.findProByAllId(0,"0");
		req.setAttribute("pro",pro);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/guest/productAll.jsp");
		dispatcher.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			String string = req.getParameter("question");
			List<ProductModel> pro = productService.findProByString(string);
			req.setAttribute("pro",pro);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/guest/productAll.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
