package Controller.Customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// @SuppressWarnings("serial")
// @WebServlet(urlPatterns = {"/info"})

import Models.ProductModel;
import Service.IProductService;
import Service.Impl.ProductServiceImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/user/about"})
public class AboutControllerGuest extends HttpServlet{

	IProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// RequestDispatcher rd =  req.getRequestDispatcher("/views/infoUser.jsp"); 
		// rd.forward(req, resp);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/about.jsp");
		dispatcher.forward(req, resp);
	}
}
