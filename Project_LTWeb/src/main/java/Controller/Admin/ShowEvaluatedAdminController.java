package Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.EvaluateModel;
import Service.IEvaluateService;
import Service.Impl.EvaluateServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/evaluated"})
public class ShowEvaluatedAdminController extends HttpServlet{

	IEvaluateService evaluateService = new EvaluateServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<EvaluateModel> evaluateList = evaluateService.getAll();
		req.setAttribute("evaluateList", evaluateList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/review.jsp");
		req.setAttribute("home", "");
		req.setAttribute("evaluate", "active");
		dispatcher.forward(req, resp);
	}
	
}
