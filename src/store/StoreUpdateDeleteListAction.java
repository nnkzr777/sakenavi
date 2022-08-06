package store;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Store;
import dao.StoreDAO;
import tool.Action;

public class StoreUpdateDeleteListAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		)throws Exception{

		StoreDAO dao = new StoreDAO();
		List<Store> list = dao.storeList();

		HttpSession session = request.getSession();

		session.setAttribute("store_list", list);

		return "store_update_delete_list.jsp";
	}
}
