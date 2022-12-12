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
@WebServlet(urlPatterns = {"/admin/category/edit"})
public class CategoryEditController extends HttpServlet {
	ICategoryService CategoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CategoryModel category = CategoryService.findById(Integer.parseInt(id));
		req.setAttribute("category", category);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-category.jsp");
		dispatcher.forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");

			CategoryModel category = new CategoryModel();
			category.setId(Integer.parseInt(req.getParameter("id")));
			category.setName(req.getParameter("name"));
			category.setSlug(req.getParameter("slug"));

			
			CategoryService.edit(category);
			resp.sendRedirect(req.getContextPath() + "/admin/category");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
