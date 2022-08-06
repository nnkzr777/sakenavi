package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.AdminDAO;
import tool.Action;

public class AdminLoginAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String login_id=request.getParameter("login_id");
		String password=request.getParameter("password");

		String message = null;

		if(login_id.equals("") || password.equals("")) {
			//ログインIDかパスワードどちらか、もしくは双方未入力なら
			message = "ログインIDとパスワードは入力必須です。";

			//エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("message", message);

			//login-in.jspに処理を転送
			return "login-in.jsp";

		} else {
			//ログイン認証を行い、ユーザー情報を取得
			AdminDAO dao=new AdminDAO();
			Admin admin=dao.adminSearch(login_id, password);

			if(admin != null) {
				//ユーザー情報を取得できたらセッションにbeanを保存
				session.setAttribute("admin", admin);

				return "admin-menu.jsp";

			} else {
				//ユーザー情報を取得できなければ

				message = "ログインIDとパスワードが一致しません";
				request.setAttribute("message", message);

				return "login-in.jsp";
			}
		}
	}
}
