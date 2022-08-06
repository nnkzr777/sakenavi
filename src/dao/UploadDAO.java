package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Upload;

public class UploadDAO extends DAO {

	public List<Upload> search(String filename) throws Exception {
		List<Upload> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select * from upload where filename like ?");
		st.setString(1, "%"+filename+"%");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Upload p=new Upload();
			p.setId(rs.getInt("id"));
			p.setFilename(rs.getString("filename"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}

	//画像追加メソッド
	public int insert(String filename) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"insert into upload values(null, ?)");
		st.setString(1, filename);
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}

	//画像差し替えメソッド
		public int replace(String filename_before, String filename_after) throws Exception {
			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
					"update upload set filename = ? where filename = ?");
			st.setString(1, filename_after);
			st.setString(2, filename_before);
			st.executeUpdate();
			int line = st.executeUpdate();

			st = con.prepareStatement(
					"update store set filename = ? where filename = ?");
			st.setString(1, filename_after);
			st.setString(2, filename_before);
			st.executeUpdate();
			line++;

			st.close();
			con.close();
			return line;
		}

	//画像の削除メソッド
	public int delete(String filename) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"delete from upload where filename = ?");
		st.setString(1, filename);
		int line=st.executeUpdate();
		st.close();
		con.close();

		return line;
	}
}
