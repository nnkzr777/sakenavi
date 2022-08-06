package upload;

import java.io.File;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UploadDAO;
import tool.Action;

public class UploadDeleteAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session = request.getSession();
		String filename = (String)session.getAttribute("filename");
		String message = null;
		UploadDAO dao=new UploadDAO();

		if (filename != null) {
			File old_file = new File(request.getServletContext().getRealPath("/images/") + filename);
			old_file.delete();

			try{
				dao.delete(filename);

				message = "[ " + filename + " ]を削除しました";

				request.setAttribute("message", message);
				session.removeAttribute("filename");

				return "../upload/upload-in.jsp";

			} catch(SQLException e){
				message = "[ " + filename + " ]を削除の削除に失敗しました";

				request.setAttribute("message", message);

				return "../upload/upload-in.jsp";
			}
		} else {
			message = "削除対象画像が見つかりませんでした";

			request.setAttribute("message", message);

			return "../upload/upload-in.jsp";
		}
	}
}
