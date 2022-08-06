package store;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Store;
import dao.StoreDAO;
import tool.Action;

public class StoreSearchAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		)throws Exception{

		if (request.getParameter("store_id") != null) {
			String store_id = request.getParameter("store_id");
			StoreDAO dao = new StoreDAO();
			Store store = new Store();
			store = dao.storeSearch(store_id);

			HttpSession session = request.getSession();

			String area_id = store.getArea_id();
			String genre_id = store.getGenre_id();
			String checked = "checked";
			String selected = "selected";

			switch(area_id) {
				case "1":
					session.setAttribute("selected1", selected);
					break;
				case "2":
					session.setAttribute("selected2", selected);
					break;
			}

			switch(genre_id) {
				case "1":
					session.setAttribute("checked1", checked);
					break;
				case "2":
					session.setAttribute("checked2", checked);
					break;
				case "3":
					session.setAttribute("checked3", checked);
					break;
			}

			session.setAttribute("store_update", store);

			return "../upload/upload-update.jsp";

		} else {
			String area_id = request.getParameter("area_id");
			String genre_id = request.getParameter("genre_id");
			String keyword = request.getParameter("keyword");

			Store store = new Store();
			store.setArea_id(area_id);
			store.setGenre_id(genre_id);

			StoreDAO dao = new StoreDAO();
			List<Store> list = dao.storeSearch(store, keyword);
			int amount = dao.storeList().size();

			request.setAttribute("store_list", list);
			request.setAttribute("amount", amount);

			return "store_list.jsp";
		}
	}
}