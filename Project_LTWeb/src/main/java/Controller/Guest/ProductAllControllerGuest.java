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
		
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			String link ="./products?";
			
			String string= "";
			
			if(req.getParameter("question") != null )
			{
				string = req.getParameter("question");
				link = link +"question=" + string;
			}
			
			String pageIdCheck = req.getParameter("page");
			int pageid =1;
			if(pageIdCheck != null )
				pageid= Integer.parseInt(pageIdCheck);
			
			req.setAttribute("link",link);
			
			ProductModel amountPage = productService.PagePro(string);
			req.setAttribute("amountPage",amountPage);
			
			List<ProductModel> pro = productService.findProByString(string, pageid);
			req.setAttribute("pro",pro);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/guest/productAll.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
