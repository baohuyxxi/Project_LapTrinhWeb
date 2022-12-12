package Controller.Admin;

import java.io.IOException;
import java.util.List;

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
@WebServlet(urlPatterns = {"/admin/account"})
public class ShowAccountAdminController extends HttpServlet{

	IAccountService accountService = new AccountServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<AccountModel> accountList = accountService.getAllAccount();
		req.setAttribute("accountList", accountList);
		req.setAttribute("account", "active");
		req.setAttribute("store", "");
		req.setAttribute("user", "");
		req.setAttribute("delivery", "");
		req.setAttribute("evaluate", "");
		req.setAttribute("home", "");
		req.setAttribute("category", "");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-account.jsp");
		dispatcher.forward(req, resp);
	}
}
