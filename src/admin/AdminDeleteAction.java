package admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.AdminDAO;
import tool.Action;


public class AdminDeleteAction extends Action{


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

			//adminDeleteメソッドを使うためにAdminDAOを生成
			AdminDAO dao = new AdminDAO();

			//beanのadmin_idを引数にしてadminDeleteを実行する。
			dao.adminDelete(admin.getAdmin_id());

			session.removeAttribute("check");

			//管理者追加後の管理者一覧を改めて取得
			List<Admin> list =dao.adminList();

			//管理者一覧にリクエスト属性を設定
			request.setAttribute("admin_list",list);

			//追加完了メッセージをリクエスト属性に設定
			message = "管理者の削除を完了しました";
			request.setAttribute("message", message);

			return "admin-list.jsp";

		} else {

			message = "管理者が選択されていません。";
			request.setAttribute("message", message);

			return "admin-list.jsp";
		}
	}
}
