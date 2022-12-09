package Controller.Vendor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.SizeModel;
import Service.ISizeService;
import Service.Impl.SizeServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/vendor/size/add" })
public class SizeAddControllerVendor extends HttpServlet {

	ISizeService sizeService = new SizeServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");

			SizeModel size = new SizeModel();
			size.setSize(req.getParameter("size"));
			size.setProduct_id(Integer.parseInt(req.getParameter("product_id")));
			size.setQuantity(Integer.parseInt(req.getParameter("quantity")));

			sizeService.insert(size);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resp.sendRedirect(req.getContextPath() + "/vendor/product");
		}
	}

}
