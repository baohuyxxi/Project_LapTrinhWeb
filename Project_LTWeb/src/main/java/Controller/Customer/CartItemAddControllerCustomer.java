package Controller.Customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CartItemModel;
import Models.SizeModel;
import Service.ICartItemService;
import Service.ICartService;
import Service.ISizeService;
import Service.Impl.CartItemServiceImpl;
import Service.Impl.CartServiceImpl;
import Service.Impl.SizeServiceImpl;
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user/cartitem/add" })
public class CartItemAddControllerCustomer extends HttpServlet {

	ICartItemService cartItemService = new CartItemServiceImpl();
	ICartService cartService = new CartServiceImpl();
	ISizeService sizeService = new SizeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		
		String userid = ProcessCookies.getUserIdFromCookies(req, resp);
		try {
			if (userid == null) {
				resp.sendRedirect(req.getContextPath() + "/login");
			} else {
				int cartid = Integer.parseInt(cartService
						.findCartIdByUserId(Integer.parseInt(ProcessCookies.getUserIdFromCookies(req, resp))));

				String productid = req.getParameter("id");
				CartItemModel cartitem = new CartItemModel();
				cartitem.setCartId(cartid);
				cartitem.setCount(1);
				cartitem.setProductId(Integer.parseInt(productid));

				List<SizeModel> sizes = sizeService.getAllProductId(Integer.parseInt(productid));
				if (sizes.isEmpty()) {
					cartitem.setSize(null);
				} else {
					cartitem.setSize(sizes.get(0).getSize());
				}
				cartItemService.insert(cartitem);
				
				resp.sendRedirect(req.getContextPath() + "/user/products");

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
