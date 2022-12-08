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
import Service.IAccountService;
import Service.Impl.AccountServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/login1"})
public class LoginController extends HttpServlet{

	IAccountService accountService = new AccountServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// lấy dữ liệu từ tham số của form
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		AccountModel account= new AccountModel();
		account = accountService.checkLogin(user, pass);
		System.out.println(user);
		System.out.println(pass);
		
		if (account!=null) {
			// khởi tạo cookie
			Cookie cookie1 = new Cookie("usernameLogin", account.getUsername());
			Cookie cookie2 = new Cookie("passwordLogin", account.getPassword());
			Cookie cookie3 = new Cookie("idLogin",String.valueOf(account.getId()));
			Cookie cookie4 = new Cookie("roleLogin",String.valueOf(account.getRole()));
			// thiết lập thời gian tồn tại 30s của cookie
			cookie1.setMaxAge(30 * 60 * 60);
			cookie2.setMaxAge(30 * 60 * 60);
			cookie3.setMaxAge(30 * 60 * 60);
			cookie4.setMaxAge(30 * 60 * 60);
			// thêm cookie vào response
			resp.addCookie(cookie1);
			resp.addCookie(cookie2);
			resp.addCookie(cookie3);
			resp.addCookie(cookie4);
			 //chuyển sang trang HelloServlet
			resp.sendRedirect(req.getContextPath() + "/vendor/store/list");
		} else {
			// chuyển sang trang LoginServlet
			// resp.sendRedirect("/login");
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
	

}
