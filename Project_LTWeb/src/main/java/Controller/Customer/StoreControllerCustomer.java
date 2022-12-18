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
import Models.ProductModel;
import Models.StoreModel;
import Service.ICartItemService;
import Service.IProductService;
import Service.IStoreService;
import Service.Impl.CartItemServiceImpl;
import Service.Impl.ProductServiceImpl;
import Service.Impl.StoreServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/user/store"})
public class StoreControllerCustomer extends HttpServlet{

	IProductService productService = new ProductServiceImpl();
	IStoreService storeService = new StoreServiceImpl();
	ICartItemService cartItemService = new CartItemServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int valueId = Integer.parseInt(req.getParameter("id"));
		String userId = ProcessCookies.getUserIdFromCookies(req, resp);
		
		CartItemModel cart = cartItemService.findCartAndCountProductID(Integer.parseInt(userId));
		req.setAttribute("cart", cart);
		
		req.setAttribute("userId", userId);
		List<StoreModel> stor = storeService.getAllInfo(valueId,"Store.id");
		req.setAttribute("stor",stor);
		List<ProductModel> pro = productService.findProByAllId(valueId,"storeId");
		req.setAttribute("pro",pro);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/guest/store-id.jsp");
		dispatcher.forward(req, resp);
	}
}
