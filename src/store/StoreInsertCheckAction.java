package store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Store;
import tool.Action;

public class StoreInsertCheckAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		)throws Exception{

		//既存のセッションを取得する
		HttpSession session = request.getSession();

		//店舗を登録する管理者のidを得るためにセッションの情報を管理者beanに詰める
		Admin admin = (Admin)session.getAttribute("admin");

		//店舗beanの各項目にパラメータをうつす
		String store_name = request.getParameter("store_name");
		String store_description = request.getParameter("store_description");
		String business_hours =request.getParameter("business_hours");
		String store_address = request.getParameter("store_address");
		String area_id = request.getParameter("area_id");
		String genre_id = request.getParameter("genre_id");
		String admin_id = admin.getAdmin_id();
		String filename = (String)session.getAttribute("filename");

		//メッセージにnullを格納しておく
		String message = null;

		//もし入力必須項目が１つでも埋まっていなければ
		if(store_name == "" | store_description == "" | business_hours == "" | store_address == "" | area_id == null | genre_id == null) {

			//エラーメッセージを代入
			message = "全て入力必須項目です";

			//エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("message", message);

			//store_insert.jspに移動
			return "store_insert.jsp";

		} else {
			//不備がなければ店舗情報をbeanに詰める
			Store store = new Store();
			store.setStore_name(store_name);
			store.setStore_description(store_description);
			store.setBusiness_hours(business_hours);
			store.setStore_address(store_address);
			store.setArea_id(area_id);
			store.setGenre_id(genre_id);
			store.setAdmin_id(admin_id);
			store.setFilename(filename);

			//セッションにbeanを保存
			session.setAttribute("check", store);

			//確認画面に遷移
			return "store_insert_check.jsp";
		}
	}
}