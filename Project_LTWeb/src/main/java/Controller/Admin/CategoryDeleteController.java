package Controller.Admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CategoryModel;
import Service.ICategoryService;
import Service.Impl.CategoryServiceImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/category/delete" })
public class CategoryDeleteController extends HttpServlet{

	
	ICategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			categoryService.delete(Integer.parseInt(req.getParameter("did")));
			resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			categoryService.delete(Integer.parseInt(req.getParameter("did")));
			resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
