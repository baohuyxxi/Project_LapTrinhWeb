package Controller.Customer;

import java.io.IOException;

import javax.mail.Message;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.EvaluateModel;
import Service.IEvaluateService;
import Service.Impl.EvaluateServiceImpl;
import util.ShowMessage;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/user/contact"})
public class ContactGuestController extends HttpServlet{

	IEvaluateService evaluateService = new EvaluateServiceImpl();
	Boolean checkInsert = false;
	String action = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ShowMessage.ShowMessageUtil(req,checkInsert, action, "Cảm ơn bạn đã gửi đánh giá");
		checkInsert=false;
		RequestDispatcher rd =  req.getRequestDispatcher("/views/customer/contact.jsp"); 
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			EvaluateModel evaluate = new EvaluateModel();
			evaluate.setName(req.getParameter("name"));
			evaluate.setEmail(req.getParameter("email"));
			evaluate.setSubject(req.getParameter("subject"));
			evaluate.setContent(req.getParameter("message"));
			
			evaluateService.insert(evaluate);	
			checkInsert = true;
			action = "edit_success";
			doGet(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
