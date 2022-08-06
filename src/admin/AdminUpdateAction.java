package admin;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.AdminDAO;
import tool.Action;

public class AdminUpdateAction extends Action{

	public String execute(
		HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		//既存のセッションを取得する
		HttpSession session = request.getSession();

		//メッセージの初期値をNULLにする
		String message = null;

		//セッションが取得できれば、
		if(session.getAttribute("check")!=null) {

			//管理者のbeanを生成
			Admin admin = new Admin();

			//beanにセッションの内容を詰める
			admin = (Admin)session.getAttribute("check");

			//adminUpdateメソッドを使うためにAdminDAOを生成
			AdminDAO dao = new AdminDAO();

			try {
			dao.adminUpdate(admin);

			//管理者更新後の管理者一覧を改めて取得
			List<Admin> list =dao.adminList();

			//管理者一覧にリクエスト属性を設定
			request.setAttribute("admin_list",list);

			//追加完了メッセージをリクエスト属性に設定
			message = "管理者の更新を完了しました";
			request.setAttribute("message", message);

			return "admin-list.jsp";

			} catch(SQLIntegrityConstraintViolationException e) {

				//エラーメッセージをリクエスト属性に設定
				message = "ログインIDが重複しています";
				request.setAttribute("message", message);

				return "admin_update.jsp";
			}

		} else {

			message = "管理者情報が取得できませんでした";
			request.setAttribute("message", message);

			return "admin-list.jsp";
		}
	}
}
