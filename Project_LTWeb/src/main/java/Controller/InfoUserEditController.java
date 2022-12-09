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
import Service.IInfoUserService;
import Service.Impl.InfoUserServiceImpl;
import util.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/infoUser/edit" })
public class InfoUserEditController extends HttpServlet{
	IInfoUserService userService = new InfoUserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		InfoUserModel user = userService.findById(Integer.parseInt(id));
		req.setAttribute("user", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/edit-infoUser.jsp");
		dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InfoUserModel user = new InfoUserModel();
		
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("id")) {
					user.setId(Integer.parseInt(item.getString("UTF-8")));
				} 
				else if (item.getFieldName().equals("name")) {
					user.setName(item.getString("UTF-8"));
				} 
				else if(item.getFieldName().equals("slug")){
					user.setSlug(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("email")){
					user.setEmail(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("phone")){
					user.setPhone(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("address")){
					user.setAddress(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("createdAt")){
					user.setAddress(item.getString("UTF-8"));
				}
				else{
					if (item.getSize() > 0) {// neu co file d
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/user/" + fileName);
					item.write(file);
					user.setAvatar(fileName);
					} else {
						user.setAvatar(null);
					}
				}
			}
			userService.edit(user);
			
			resp.sendRedirect(req.getContextPath() + "/admin/infouser/list");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
