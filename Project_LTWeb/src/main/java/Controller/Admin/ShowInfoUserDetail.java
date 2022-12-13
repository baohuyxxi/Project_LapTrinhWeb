package Controller.Admin;

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
import util.ProcessCookies;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/infoUser" })
public class ShowInfoUserDetail extends HttpServlet{

	IInfoUserService userService = new InfoUserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		InfoUserModel user = userService.findById(Integer.parseInt(id));
		req.setAttribute("user", user);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/infoUser.jsp");
		dispatcher.forward(req, resp);
	}
}
