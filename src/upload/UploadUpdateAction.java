package upload;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.Store;
import dao.UploadDAO;
import tool.Action;

public class UploadUpdateAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		// <input type="file" name="uploadfile">からMultipart形式のアップロードコンテンツの内容を取得
		Part part = request.getPart("uploadfile");
		String filename = null;
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			cd = cd.trim();
			if (cd.startsWith("filename")) {
				// ファイル名は=の右側以降の文字列。
				// ただし利用環境によってはだブルコーテーションが含まれているので、取り除く。
				filename = cd.substring(cd.indexOf("=") + 1).trim().replace("\"", "");
				break;
			}
		}

		// アップロードしたファイルを書き出す
		String message = null;
		UploadDAO dao=new UploadDAO();
		HttpSession session = request.getSession();
		Store store = (Store)session.getAttribute("store_update");
		String filename_before = store.getFilename();

		if (filename != null && dao.search(filename).size() == 0) {
			// アップロードされたファイル名は、OS依存のファイルパスなどを含んでいるので置換する。
			// \は/に置換し、その後ファイル名のみ抽出する。
			filename = filename.replace("\\", "/");
			int pos = filename.lastIndexOf("/");
			if (pos >= 0) {
				filename = filename.substring(pos + 1);
			}
			// 実行パスの「images」フォルダにファイルをアップロードする場合の指定
			//part.write(request.getServletContext().getRealPath("/images/") + filename);
			part.write(request.getServletContext().getRealPath("/images/") + filename);
			System.out.println(request.getServletContext().getRealPath("/images/") + filename);

			//差し替え前のファイルを削除する
			File old_file = new File(request.getServletContext().getRealPath("/images/") + filename_before);
			old_file.delete();

			// アップロードが完了した後はデータベースに登録する

			dao.replace(filename_before, filename);
			System.out.println(filename_before);

			message = "画像を[ " + filename + " ]へ差し替え完了しました。";

			request.setAttribute("message", message);
			session.setAttribute("filename_update", filename);

			return "../store/store_update.jsp";

		} else {
			message = "アップロードが失敗しました。（ファイルが選択されていないか、すでにそのファイル名は使われています）";
			request.setAttribute("message", message);

			return "upload-update.jsp";
		}
	}
}
