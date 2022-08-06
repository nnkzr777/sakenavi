package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.AdminDAO;
import tool.Action;

public class AdminDeleteCheckAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		)throws Exception{

		//既存のセッションを取得する
		HttpSession session = request.getSession();

		//メッセージの初期値をNULLにする
		String message = null;

		//ログイン中のアカウント情報をadminに入れる
		Admin admin = (Admin)session.getAttribute("admin");

		//削除対象アカウントのadmin_idとadmin_nameを変数に入れる
		String admin_id = request.getParameter("admin_id");

		//もし自分のアカウントを消そうとしてるなら
		if(admin.getAdmin_id().equals(admin_id)) {

			//エラーメッセージを代入
			message = "ログイン中のアカウントは削除できません";

			//エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("message", message);

			//admin-list.jspに移動
			return "admin-list.jsp";

		//不備がなければ
		} else {

			//管理者beanを生成して、削除対象のアカウント情報を入れる
			AdminDAO dao = new AdminDAO();
			Admin admin_delete = new Admin();
			admin_delete = dao.adminSearch(admin_id);

			//セッションに削除対象の管理者beanを保存
			session.setAttribute("check", admin_delete);

			//確認画面に遷移
			return "admin_delete_check.jsp";
		}
	}
}
