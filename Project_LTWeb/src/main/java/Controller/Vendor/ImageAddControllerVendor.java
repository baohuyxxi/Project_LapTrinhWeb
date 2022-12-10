package Controller.Vendor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.ImagesModel;
import Models.SizeModel;
import Service.IImageService;
import Service.ISizeService;
import Service.Impl.ImageServiceImpl;
import Service.Impl.SizeServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/vendor/image/add" })
public class ImageAddControllerVendor extends HttpServlet {

	IImageService imageService = new ImageServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");

			ImagesModel img = new ImagesModel();
			img.setImage_id(Integer.parseInt(req.getParameter("image_id")));
			img.setImg(req.getParameter("img"));
			img.setProduct_id(Integer.parseInt(req.getParameter("product_id")));

			imageService.insert(img);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resp.sendRedirect(req.getContextPath() + "/vendor/product");
		}
	}

}
