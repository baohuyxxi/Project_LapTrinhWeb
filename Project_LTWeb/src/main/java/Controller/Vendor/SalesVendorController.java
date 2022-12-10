package Controller.Vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.ProductModel;
import Service.IProductService;
import Service.Impl.ProductServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(value = {"/vendor/sale"})
public class SalesVendorController extends HttpServlet{

	IProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String storeid = ProcessCookies.getStoreIdFromCookies(req, resp);
		ProductModel top1Product = productService.findTop1Product(Integer.parseInt(storeid));
		req.setAttribute("product", top1Product);
		RequestDispatcher rd =  req.getRequestDispatcher("/views/vendor/Sales.jsp"); 
		rd.forward(req, resp);
	}
	
}
