package store;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Store;
import dao.StoreDAO;
import dao.UploadDAO;
import tool.Action;


public class StoreDeleteAction extends Action{


	public String execute(
		HttpServletRequest request, HttpServletResponse response
	)throws Exception {

		HttpSession session = request.getSession();

		Store store = (Store)session.getAttribute("check");
		String message = null;

		if(store.getStore_id()!= null) {

			StoreDAO s_dao = new StoreDAO();
			s_dao.storeDelete(store.getStore_id());

			UploadDAO u_dao = new UploadDAO();
			u_dao.delete(store.getFilename());

			File file = new File(request.getServletContext().getRealPath("/images/") + store.getFilename());
			file.delete();

			session.removeAttribute("check");

			List<Store> list = s_dao.storeList();

			request.setAttribute("store_list",list);

			message = "店舗の削除を完了しました。";
			request.setAttribute("message",message);

			return "store_update_delete_list.jsp";

		} else {

			message = "店舗が選択されていません。";
			request.setAttribute("message", message);

			return "store_update_delete_list.jsp";
		}
	}
}
