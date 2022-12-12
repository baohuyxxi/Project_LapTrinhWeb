package Controller.Admin;

import java.io.IOException;
import java.util.List;

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
@WebServlet(urlPatterns = {"/admin/infouser"})
public class InfoUserListController extends HttpServlet{

	IInfoUserService userService = new InfoUserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<InfoUserModel> userList = userService.getAll();
		req.setAttribute("userList", userList);
		req.setAttribute("user", "active");
		req.setAttribute("delivery", "");
		req.setAttribute("evaluate", "");
		req.setAttribute("home", "");
		req.setAttribute("category", "");
		req.setAttribute("store", "");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-infoUser.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}
