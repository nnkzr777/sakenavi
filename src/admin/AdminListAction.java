package admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.AdminDAO;
import tool.Action;

public class AdminListAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		)throws Exception{

		AdminDAO dao = new AdminDAO();
		List<Admin> list = dao.adminList();

		//セッションを取得
		HttpSession session = request.getSession();

		//セッションにbeanを保存
		session.setAttribute("admin_list", list);

		return "admin-list.jsp";
	}
}
