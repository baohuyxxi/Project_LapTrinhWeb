package Controller.Vendor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.StoreModel;
import Service.IStoreService;
import Service.Impl.StoreServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/vendor/store/list"})
public class StoreListControllerVendor extends HttpServlet{
	IStoreService storeService = new StoreServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<StoreModel> storeList = storeService.getAll();
		req.setAttribute("storeList", storeList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/list-store.jsp");
		dispatcher.forward(req, resp);
		
		
//		Cookie cookie = null;
//        Cookie[] cookies = null;
//        
//     // Get an array of Cookies associated with this domain
//        cookies = req.getCookies();
// 
//        // Set response content type
//        resp.setContentType("text/html");
//       
//        if (cookies != null) {
//            System.out.println("<h2> Found Cookies Name and Value</h2>");
// 
//            for (int i = 0; i < cookies.length; i++) {
//                cookie = cookies[i];
//                System.out.print("Name : " + cookie.getName() + ",  ");
//                System.out.print("Value: " + cookie.getValue() + " <br/>");
//            }
//        } else {
//        	System.out.println("<h2>No cookies founds</h2>");
//        }
	}
}
