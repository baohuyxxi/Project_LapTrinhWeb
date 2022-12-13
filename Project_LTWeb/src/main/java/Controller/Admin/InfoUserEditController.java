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
@WebServlet(urlPatterns = { "/admin/infoUser/edit" })
public class InfoUserEditController extends HttpServlet{
	IInfoUserService userService = new InfoUserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String storeId = ProcessCookies.getStoreIdFromCookies(req, resp);
			
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			InfoUserModel user = new InfoUserModel();
			user.setId(Integer.parseInt(req.getParameter("id")));
			user.setName(req.getParameter("name"));
			user.setSlug(req.getParameter("slug"));
			user.setEmail(req.getParameter("email"));
			user.setPhone(req.getParameter("phone"));
			user.setAddress(req.getParameter("address"));
			user.setAvatar(req.getParameter("avatar"));
			if(req.getParameter("status").equals("Ngừng hoạt động")) {
				user.setStatus(false);
			}else if(req.getParameter("status").equals("Đang hoạt động")) {
				user.setStatus(true);
			}
			userService.edit(user);
			
			if (storeId != "") {
				resp.sendRedirect(req.getContextPath() + "/vendor/home");
			}else {
				resp.sendRedirect(req.getContextPath() + "/admin/infouser");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
