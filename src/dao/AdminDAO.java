package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Admin;

public class AdminDAO extends DAO {

	/*/
	 * 登録ユーザー検索メソッド(ログイン用)
	 */
	public Admin adminSearch(String login_id, String password) throws Exception{

		Connection con = getConnection();
		Admin admin = null;
		PreparedStatement st = con.prepareStatement(
				"select * from admin where login_id = ?"
				+ " and password = ?");

		st.setString(1, login_id);
		st.setString(2, password);

		ResultSet rs = st.executeQuery();

		if(rs.next()) {
			admin = new Admin();
			admin.setAdmin_id(rs.getString("admin_id"));
			admin.setAdmin_name(rs.getString("admin_name"));
			admin.setLogin_id(rs.getString("login_id"));
			admin.setPassword(rs.getString("password"));
			admin.setEmail(rs.getString("email"));
			admin.setTime(rs.getString("time"));
		}

		st.close();
		con.close();

		return admin;
	}

	/*/
	 * 管理者を1人だけ検索するメソッド(更新用)
	 */
	public Admin adminSearch(String admin_id) throws Exception{

		Connection con = getConnection();
		Admin admin = null;
		PreparedStatement st = con.prepareStatement(
				"select * from admin where admin_id = ?");

		st.setString(1, admin_id);

		ResultSet rs = st.executeQuery();

		if(rs.next()) {
			admin = new Admin();
			admin.setAdmin_id(rs.getString("admin_id"));
			admin.setAdmin_name(rs.getString("admin_name"));
			admin.setLogin_id(rs.getString("login_id"));
			admin.setPassword(rs.getString("password"));
			admin.setEmail(rs.getString("email"));
			admin.setTime(rs.getString("time"));
		}

		st.close();
		con.close();

		return admin;
	}

	/*/
	 * 管理者を全て表示するメソッド
	 */
	public List<Admin> adminList() throws Exception{
		List<Admin> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from admin");

		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			Admin admin = new Admin();
			admin.setAdmin_id(rs.getString("admin_id"));
			admin.setAdmin_name(rs.getString("admin_name"));
			admin.setLogin_id(rs.getString("login_id"));
			admin.setPassword(rs.getString("password"));
			admin.setEmail(rs.getString("email"));
			admin.setTime(rs.getString("time"));
			list.add(admin);
		}

		st.close();
		con.close();

		return list;
	}

	/*/
	 * 管理者の追加メソッド
	 */
	public int adminInsert(Admin admin) throws Exception {

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
			"insert into admin values(null, ?, ?, ?, NULL, cast( now() as datetime))");

		st.setString(1, admin.getAdmin_name());
		st.setString(2, admin.getLogin_id());
		st.setString(3, admin.getPassword());

		int line=st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	/*
	 * 管理者の更新メソッド
	 */
	public int adminUpdate(Admin admin) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
				"update admin set"
				+ " admin_name = ?,"
				+ " login_id = ?,"
				+ " password = ?"
				+ " where admin_id = ?");

		st.setString(1, admin.getAdmin_name());
		st.setString(2, admin.getLogin_id());
		st.setString(3, admin.getPassword());
		st.setString(4, admin.getAdmin_id());

		int line=st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	/*
	 * 管理者の削除メソッド
	 */
	public int adminDelete(String admin_id) throws Exception {

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
			"delete from admin where admin_id = ?");

		st.setString(1, admin_id);

		int line=st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
}
