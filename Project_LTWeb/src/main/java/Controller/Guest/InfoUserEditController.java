package Controller.Guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.InfoUserModel;
import Service.IInfoUserService;
import Service.Impl.InfoUserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/infoUser/edit" })
public class InfoUserEditController extends HttpServlet{
	IInfoUserService userService = new InfoUserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		InfoUserModel user = userService.findById(Integer.parseInt(id));
		req.setAttribute("user", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-infoUser.jsp");
		dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			InfoUserModel user = new InfoUserModel();
			user.setId(Integer.parseInt(req.getParameter("user")));
			user.setName(req.getParameter("name"));
			user.setSlug(req.getParameter("slug"));
			user.setEmail(req.getParameter("email"));
			user.setPhone(req.getParameter("phone"));
			user.setAddress(req.getParameter("address"));
			user.setAvatar(req.getParameter("avartar"));

			userService.edit(user);
			resp.sendRedirect(req.getContextPath() + "/admin/infouser/list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
