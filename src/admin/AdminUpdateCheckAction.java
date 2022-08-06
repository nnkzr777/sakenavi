package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import tool.Action;

public class AdminUpdateCheckAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		)throws Exception{

		//既存のセッションを取得
		HttpSession session = request.getSession();

		Admin admin = (Admin)session.getAttribute("admin_update");

		//パラメータを取得
		String admin_id = admin.getAdmin_id();
		String admin_name = request.getParameter("admin_name");
		String login_id = request.getParameter("login_id");
		String password = admin.getPassword();
		String password_check = request.getParameter("password_check");
		String new_password = request.getParameter("new_password");
		String new_password_check =request.getParameter("new_password_check");

		String message = null;

		//入力必須項目が１つでも埋まっていなければ
		if(admin_name == "" | login_id == "" | password_check == "" | new_password =="" | new_password_check == "") {

			//変数にエラーメッセージを代入
			message = "全て入力必須項目です";

			//エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("message", message);

			return "admin_update.jsp";

		//もし現在のパスワードが一致していなかったら
		} else if(!(password.equals(password_check))){

			//変数にエラーメッセージを代入
			message = "現在のパスワードが違います";

			//エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("message", message);

			return "admin_update.jsp";

		//新パスワードと新パスワード確認が一致していなかったら
		} else if(!(new_password.equals(new_password_check))) {

			//変数にエラーメッセージを代入
			message = "新パスワード と 新パスワード確認 が一致していません";

			//エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("message", message);

			return "admin_update.jsp";

		} else {
			//不備がなければ管理者情報をbeanに詰める
			Admin admin_update = new Admin();
			admin_update.setAdmin_id(admin_id);
			admin_update.setAdmin_name(admin_name);
			admin_update.setLogin_id(login_id);
			admin_update.setPassword(new_password);

			//セッションにbeanを保存
			session.setAttribute("check", admin_update);

			System.out.println(admin_update.getLogin_id());
			System.out.println(admin_update.getPassword());
			System.out.println(admin_update.getAdmin_name());

			//確認画面に遷移
			return "admin_update_check.jsp";
		}
	}
}
