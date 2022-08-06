package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import tool.Action;

public class AdminInsertCheckAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		)throws Exception{

		//パラメータを取得
		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");
		String password_check =request.getParameter("password_check");
		String admin_name = request.getParameter("admin_name");

		String message = null;

		if(!login_id.matches("[a-zA-Z_0-9]{5,16}") | !password.matches("[a-zA-Z_0-9]{5,16}") | !admin_name.matches(".{1,12}")) {
			message = "入力データが条件を満たしていません";
			request.setAttribute("message", message);
			return "admin_insert.jsp";

		//もしパスワードと確認用パスワードが不一致なら
		} else if(password != "" && password_check != "" && !(password.equals(password_check))) {

			//変数にエラーメッセージを代入
			message = "パスワードと確認用パスワードが一致しません";

			//エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("message", message);

			//admin-insert.jspに遷移
			return "admin_insert.jsp";

		//入力必須項目が１つでも埋まっていなければ
		} else if(login_id == "" | password == "" | password_check == "" | admin_name == "") {

			//変数にエラーメッセージを代入
			message = "全て入力必須項目です";

			//エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("message", message);

			//admin-insert.jspに遷移
			return "admin_insert.jsp";

		} else {
			//不備がなければ管理者情報をbeanに詰める
			Admin admin = new Admin();
			admin.setLogin_id(login_id);
			admin.setPassword(password);
			admin.setAdmin_name(admin_name);

			//セッションを取得
			HttpSession session = request.getSession();

			//セッションにbeanを保存
			session.setAttribute("check", admin);

			//確認画面に遷移
			return "admin_insert_check.jsp";
		}
	}
}
