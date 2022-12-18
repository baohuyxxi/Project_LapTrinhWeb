package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.InfoUserModel;
import Service.IInfoUserService;
import Service.Impl.InfoUserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/infouser/change"})
public class ChangeStatusUserController extends HttpServlet{

	IInfoUserService infoUserService = new InfoUserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			InfoUserModel user = new InfoUserModel();
			user.setId(Integer.parseInt(req.getParameter("id")));
			user.setStatus(Boolean.parseBoolean(req.getParameter("status")));
			
			infoUserService.editStatusByAdmin(user);
			resp.sendRedirect(req.getContextPath()+ "/admin/infouser");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
