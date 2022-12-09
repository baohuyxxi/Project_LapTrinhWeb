package Controller.Admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
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
@WebServlet(urlPatterns = {"/admin/category/list"})
public class CategoryListController extends HttpServlet{

	ICategoryService CategoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> categoryList = CategoryService.getAll();
		req.setAttribute("categoryList",categoryList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-category.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}
