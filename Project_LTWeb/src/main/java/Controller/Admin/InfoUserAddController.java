package Controller.Admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.DeliveryModel;
import Models.InfoUserModel;
import Service.IInfoUserService;
import Service.Impl.InfoUserServiceImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/infouser/add"})
public class InfoUserAddController extends HttpServlet{

	IInfoUserService userService = new InfoUserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-infoUser.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			InfoUserModel user = new InfoUserModel();
			user.setName(req.getParameter("name"));
			user.setSlug(req.getParameter("slug"));
			user.setEmail(req.getParameter("email"));
			user.setPhone(req.getParameter("phone"));
			user.setAddress(req.getParameter("address"));
			user.setAvatar(req.getParameter("avartar"));

			userService.insert(user);
			resp.sendRedirect(req.getContextPath() + "/admin/infouser/list");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
