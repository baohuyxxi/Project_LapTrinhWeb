package util;

import javax.servlet.http.HttpServletRequest;

public class ShowMessage {

	public static void ShowMessageUtil(HttpServletRequest req, Boolean check, String action, String message) {
		
		if (check) {
			if(message == "") {
				if (action == "insert_success") {
					req.setAttribute("messageResponse", "Thêm thành công!!");
					req.setAttribute("alert", "success");
				} else if (action == "edit_success") {
					req.setAttribute("messageResponse", "Sửa thành công !!");
					req.setAttribute("alert", "success");
				} else if (action == "delete_success") {
					req.setAttribute("messageResponse", "Xóa thành công !!");
					req.setAttribute("alert", "success");
				} else {
					req.setAttribute("messageResponse", "Đã xãy ra lỗi. Vui lòng kiểm tra lại!!!");
					req.setAttribute("alert", "danger");
				}
			}else {
				req.setAttribute("messageResponse", message);
				req.setAttribute("alert", "success");
			}		
		}
	}
}
