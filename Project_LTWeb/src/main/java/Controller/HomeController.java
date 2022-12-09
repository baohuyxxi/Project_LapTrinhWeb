package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		RequestDispatcher rd =  req.getRequestDispatcher("/views/home.jsp"); 
=======
		RequestDispatcher rd =  req.getRequestDispatcher("/views/login.jsp"); 
>>>>>>> a83c682ef8e61e89f9a7bf350ce1dc7f97e93ddf
		rd.forward(req, resp);
	}

}
