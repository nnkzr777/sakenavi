package upload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.UploadDAO;
import tool.Action;

public class UploadAction extends Action {
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
		HttpSession session = request.getSession();
		UploadDAO dao=new UploadDAO();
		String message = null;

		if (filename != null && dao.search(filename).size() == 0) {
			// アップロードされたファイル名は、OS依存のファイルパスなどを含んでいるので置換する。
			// \は/に置換し、その後ファイル名のみ抽出する。
			filename = filename.replace("\\", "/");
			int pos = filename.lastIndexOf("/");
			if (pos >= 0) {
				filename = filename.substring(pos + 1);
			}
			// 実行パスの「images」フォルダにファイルをアップロードする場合の指定
			part.write(request.getServletContext().getRealPath("/images/") + filename);
			System.out.println(request.getServletContext().getRealPath("/images/") + filename);

			// アップロードが完了した後はデータベースに登録する
			dao.insert(filename);

			message = "[ " + filename + " ]のアップロードが完了しました。";

			request.setAttribute("message", message);
			session.setAttribute("filename", filename);

			return "../store/store_insert.jsp";

		} else {

			message = "アップロードが失敗しました。（ファイルが選択されていないか、すでにそのファイル名は使われています）";
			request.setAttribute("message", message);

			return "upload-in.jsp";
		}
	}
}
