package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessCookies{
	public static void addCookieForCookies(HttpServletRequest req, HttpServletResponse resp, String name, String value)
	{
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(10*60);
		resp.addCookie(cookie);
	}
	
	public static String getUserIdFromCookies(HttpServletRequest req, HttpServletResponse resp)
	{
		String userId = null;
		
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = req.getCookies();
		resp.setContentType("text/html");
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if (cookie.getName().equals("userIdLogin"))
					userId = cookie.getValue();
			}
		} else {
			//
		} 
		return userId;
	}
	public static String getRoleFromCookies(HttpServletRequest req, HttpServletResponse resp)
	{
		String role = null;
		
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = req.getCookies();
		resp.setContentType("text/html");
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if (cookie.getName().equals("roleLogin"))
					role = cookie.getValue();
			}
		} else {
			//
		} 
		return role;
	}
	public static String getStoreIdFromCookies(HttpServletRequest req, HttpServletResponse resp)
	{
		String storeId = null;
		
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = req.getCookies();
		resp.setContentType("text/html");
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if (cookie.getName().equals("storeIdLogin"))
					storeId = cookie.getValue();
			}
		} else {
			//
		} 
		return storeId;
	}
}
