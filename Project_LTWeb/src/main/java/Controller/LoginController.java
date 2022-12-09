package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.AccountModel;
import Models.InfoUserModel;
import Service.IAccountService;
import Service.IInfoUserService;
import Service.Impl.AccountServiceImpl;
import Service.Impl.InfoUserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	IAccountService accountService = new AccountServiceImpl();
	IInfoUserService userService = new InfoUserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// xóa cookies
		Cookie[] cookies = null;

		// Get an array of Cookies associated with this domain
		cookies = req.getCookies();

		// Set response content type
		resp.setContentType("text/html");
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookies[i].setMaxAge(0);
				resp.addCookie(cookies[i]);
			}
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		AccountModel account = new AccountModel();
		account = accountService.checkLogin(user, pass);

		try {
		if (account != null) {
			Cookie cookieRole = new Cookie("roleLogin", String.valueOf(account.getRole()));

			resp.addCookie(cookieRole);
			if (account.getRole() == 1 || account.getRole() == 2) {
				InfoUserModel infoUser = new InfoUserModel();
				infoUser = userService.getUserName(account.getUsername());
				Cookie cookieId = new Cookie("userIdLogin", String.valueOf(infoUser.getId()));
				resp.addCookie(cookieId);
				if(account.getRole()==2)
				{
					resp.sendRedirect(req.getContextPath() + "/vendor/store");
					return;
				}
			} else if (account.getRole() == 2) {
				resp.sendRedirect(req.getContextPath() + "/login");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
