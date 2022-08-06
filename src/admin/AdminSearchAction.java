package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.AdminDAO;
import tool.Action;

public class AdminSearchAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{

		String admin_id = request.getParameter("admin_id");

		Admin admin = new Admin();

		AdminDAO dao = new AdminDAO();

		admin = dao.adminSearch(admin_id);

		HttpSession session = request.getSession();

		session.setAttribute("admin_update", admin);

		return "admin_update.jsp";

	}
}
