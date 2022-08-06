package admin;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.AdminDAO;
import tool.Action;

public class AdminInsertAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{

		//既存のセッションを取得する
		HttpSession session = request.getSession();

		//メッセージにnullを格納しておく
		String message = null;

		//セッションが取得できれば、
		if(session.getAttribute("check")!=null) {

			//管理者のbeanを生成
			Admin admin = new Admin();

			//beanにセッションの内容を詰める
			admin = (Admin)session.getAttribute("check");

			//adminInsertメソッドを使うためにAdminDAOを生成
			AdminDAO dao = new AdminDAO();

			//adminInsertを実行する
			try {
				dao.adminInsert(admin);

				session.removeAttribute("check");

				//管理者追加後の管理者一覧を改めて取得
				List<Admin> list =dao.adminList();

				//リクエスト属性に一覧を詰めて完了画面に渡す
				request.setAttribute("admin_list",list);

				//追加完了メッセージをリクエスト属性に設定
				message = "管理者の追加を完了しました";
				request.setAttribute("message", message);

				return "admin-list.jsp";

			//もし重複エラーが発生したら
			} catch(SQLIntegrityConstraintViolationException e){

				//エラーメッセージをリクエスト属性に設定
				message = "ログインIDが重複しています";
				request.setAttribute("message", message);

				return "admin_insert.jsp";
			}

		} else {

			//エラーメッセージをリクエスト属性に設定
			message = "管理者が追加できませんでした。";
			request.setAttribute("message", message);

			return "admin-insert.jsp";
		}
	}
}