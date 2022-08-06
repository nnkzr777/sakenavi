package store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Store;
import dao.StoreDAO;
import tool.Action;


public class StoreDeleteCheckAction extends Action{


	public String execute(
		HttpServletRequest request, HttpServletResponse response
	)throws Exception {

		//削除対象店舗のstore_idを変数に入れる
		String store_id = request.getParameter("store_id");

		if (store_id != null) {

			StoreDAO dao = new StoreDAO();
			Store store_delete = new Store();
			store_delete = dao.storeSearch(store_id);

			//セッションに削除対象の店舗beanを保存
			HttpSession session = request.getSession();
			session.setAttribute("check", store_delete);

			//確認画面に遷移
			return "store_delete_check.jsp";

		} else {

			String message = "店舗が選択されていません。";
			request.setAttribute("message", message);

			return "store_update_delete_list.jsp";
		}
	}
}
