package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import Models.AccountModel;
import Models.InfoUserModel;
import Service.IAccountService;
import Service.IInfoUserService;
import Service.Impl.AccountServiceImpl;
import Service.Impl.InfoUserServiceImpl;
import util.Constant;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/register/add"})
public class ResgisterController extends HttpServlet{

	IInfoUserService userService = new InfoUserServiceImpl();
	IAccountService accountService = new AccountServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InfoUserModel user = new InfoUserModel();
		AccountModel account = new AccountModel();
		
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					user.setName(item.getString("UTF-8"));
				} 
				else if(item.getFieldName().equals("slug")){
					user.setSlug(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("email")){
					user.setEmail(item.getString("UTF-8"));
					account.setUsername(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("phone")){
					user.setPhone(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("address")){
					user.setAddress(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("password")){
					account.setPassword(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("role")){
					account.setRole(Integer.parseInt(item.getString("UTF-8")));
				}
				else{
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/user/" + fileName);
					item.write(file);
					user.setAvatar(fileName.toString());
				}
			}
			userService.insert(user);
			accountService.insert(account);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();//dang ki khong thanh cong
		}
		finally {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}


}
