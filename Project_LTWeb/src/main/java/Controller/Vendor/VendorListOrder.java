package Controller.Vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.OrdersModel;
import Service.IOrderService;
import Service.IProductService;
import Service.Impl.OrderServiceImpl;
import Service.Impl.ProductServiceImpl;

@SuppressWarnings("serial")
@WebServlet(value = {"/vendor/order"})
public class VendorListOrder extends HttpServlet{
	
	IOrderService orderService = new OrderServiceImpl();
	IProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid = null;
		
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = req.getCookies();
		resp.setContentType("text/html");
		if (cookies != null) {
          for (int i = 0; i < cookies.length; i++) {
              cookie = cookies[i];
              if(cookie.getName().equals("userIdLogin"))
            	  userid=cookie.getValue();
          }
      } else {
    	  //
      }
		
		
		List<OrdersModel> orderList = orderService.getAllOfStore(Integer.parseInt(productService.findStoreIdByUserId(Integer.parseInt(userid))));
		req.setAttribute("orderList", orderList);
		RequestDispatcher rd =  req.getRequestDispatcher("/views/vendor/order.jsp"); 
		rd.forward(req, resp);
	}

}
