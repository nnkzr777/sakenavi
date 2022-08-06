package store;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Store;
import dao.StoreDAO;
import tool.Action;

public class StoreInsertAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception {

		//既存のセッションを取得する
		HttpSession session = request.getSession();

		//メッセージにnullを格納
		String message = null;

		//セッションが取得できれば、
		if(session.getAttribute("check")!=null) {

			//店舗のbeanを生成
			Store store = new Store();

			//beanにセッションの内容を詰める
			store = (Store)session.getAttribute("check");

			//storeInsertメソッドを使うためにstoreDAOを生成
			StoreDAO dao = new StoreDAO();

			try {
				//beanを引数にしてstoreInsertを実行する。
				dao.storeInsert(store);

				session.removeAttribute("check");
				session.removeAttribute("filename");

				//店舗追加後の管理者一覧を改めて取得
				List<Store> list =dao.storeList();
				int amount = dao.storeList().size();

				//リクエスト属性に一覧を詰めて完了画面に渡す
				request.setAttribute("store_list",list);
				request.setAttribute("amount", amount);

				//追加完了メッセージをリクエスト属性に設定
				message = "店舗の追加を完了しました";
				request.setAttribute("message", message);

				return "store_list.jsp";

			} catch(SQLIntegrityConstraintViolationException e) {
				message = "店舗名か住所がすでに登録されているデータと重複しています。";
				request.setAttribute("message", message);

				return "store_insert.jsp";
			}


		} else {
			message = "店舗の追加に失敗しました。";
			request.setAttribute("message", message);

			return "store_update_delete_list.jsp";
		}
	}
}