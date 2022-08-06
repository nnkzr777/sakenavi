package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class AdminLogoutAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();
		String message = null;

		if (session.getAttribute("admin")!=null) {
			session.removeAttribute("admin");

			message = "ログアウトしました。またのお越しをお待ちしています！";
			request.setAttribute("message", message);

			return "../store/search.jsp";
		}

		message = "すでにログアウトしています。";
		request.setAttribute("message", message);

		return "../store/search.jsp";
	}
}
