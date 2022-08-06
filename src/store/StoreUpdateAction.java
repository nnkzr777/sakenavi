package store;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Store;
import dao.StoreDAO;
import tool.Action;

public class StoreUpdateAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception {

		HttpSession session = request.getSession();

		String message = null;

		if(session.getAttribute("check")!=null) {

			Store store = (Store)session.getAttribute("check");
			StoreDAO dao = new StoreDAO();

			try {
				dao.storeUpdate(store);

				session.removeAttribute("check");
				session.removeAttribute("filename_update");
				session.removeAttribute("store_update");

				List<Store> list =dao.storeList();
				int amount = dao.storeList().size();

				request.setAttribute("store_list",list);
				request.setAttribute("amount", amount);

				message = "店舗の更新を完了しました";
				request.setAttribute("message", message);

				return "store_list.jsp";

			} catch (SQLIntegrityConstraintViolationException e) {
				message = "店舗名か住所がすでに登録されているデータと重複しています。";
				request.setAttribute("message", message);

				return "store_update.jsp";
			}

		} else {
			message = "店舗情報を取得できませんでした";
			request.setAttribute("message", message);

			return "store_update_check.jsp";
		}
	}
}