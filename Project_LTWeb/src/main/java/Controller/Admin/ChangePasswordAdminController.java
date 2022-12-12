package Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.AccountModel;
import Service.IAccountService;
import Service.Impl.AccountServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/account/change"})
public class ChangePasswordAdminController extends HttpServlet{

	IAccountService accountService = new AccountServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		AccountModel account = accountService.findById(Integer.parseInt(id));
		req.setAttribute("account", account);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-password.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			AccountModel account = new AccountModel();
			account.setId(Integer.parseInt(req.getParameter("id")));
			account.setPassword(req.getParameter("password"));
			
			accountService.edit(account);
			resp.sendRedirect(req.getContextPath() + "/admin/account");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
