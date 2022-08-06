package store;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Store;
import dao.StoreDAO;
import tool.Action;

public class StoreListAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		)throws Exception{

		StoreDAO dao = new StoreDAO();
		List<Store> list = dao.storeList();

		int amount = dao.storeList().size();

		request.setAttribute("store_list", list);
		request.setAttribute("amount", amount);

		return "store_list.jsp";
	}
}
