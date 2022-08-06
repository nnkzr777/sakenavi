package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bean.Store;

public class StoreDAO extends DAO {

	/*
	 * 店舗条件検索メソッド
	 */
	public List<Store> storeSearch(Store store, String keyword) throws Exception{

		String area_id = store.getArea_id();
		String genre_id = store.getGenre_id();
		String sql = null;

		Connection con = getConnection();
		PreparedStatement st = null;

		if (area_id == null & genre_id == null) {
			sql = "select * from store where"
					+ " store_name like ?"
					+ " or store_description like ?";

			st = con.prepareStatement(sql);

			st.setString(1, "%" + keyword + "%");
			st.setString(2, "%" + keyword + "%");

		} else if (area_id != null & genre_id == null) {
			sql = "select * from store where"
					+ " area_id = ?"
					+ " and (store_name like ?"
					+ " or store_description like ?)";

			st = con.prepareStatement(sql);

			st.setString(1, area_id);
			st.setString(2, "%" + keyword + "%");
			st.setString(3, "%" + keyword + "%");

		} else if(area_id == null & genre_id != null){
			sql = "select * from store where"
					+ " genre_id = ?"
					+ " and (store_name like ?"
					+ " or store_description like ?)";

			st = con.prepareStatement(sql);

			st.setString(1, genre_id);
			st.setString(2, "%" + keyword + "%");
			st.setString(3, "%" + keyword + "%");

		} else {
			sql = "select * from store where"
					+ " area_id = ?"
					+ " and genre_id = ?"
					+ " and (store_name like ?"
					+ " or store_description like ?)";

			st = con.prepareStatement(sql);

			st.setString(1, area_id);
			st.setString(2, genre_id);
			st.setString(3, "%" + keyword + "%");
			st.setString(4, "%" + keyword + "%");
		}

		ResultSet rs = st.executeQuery();
		List<Store> list = new ArrayList<>();

		while (rs.next()) {
			Store s = new Store();
			s.setStore_id(rs.getString("store_id"));
			s.setStore_name(rs.getString("store_name"));
			s.setStore_description(rs.getString("store_description"));
			s.setBusiness_hours(rs.getString("business_hours"));
			s.setStore_address(rs.getString("store_address"));
			s.setFilename(rs.getString("filename"));
			s.setGenre_id(rs.getString("genre_id"));
			s.setArea_id(rs.getString("area_id"));
			s.setAdmin_id(rs.getString("admin_id"));
			list.add(s);
		}

		Collections.reverse(list);

		st.close();
		con.close();
		return list;
	}

	/*
	 * 店舗IDから1件だけ検索するメソッド
	 */
	public Store storeSearch(String store_id) throws Exception {

		Connection con = getConnection();
		Store store = null;
		PreparedStatement st = con.prepareStatement(
				"select * from store where store_id = ?");

		st.setString(1, store_id);

		ResultSet rs = st.executeQuery();

		if(rs.next()) {
			store = new Store();
			store.setStore_id(rs.getString("store_id"));
			store.setStore_name(rs.getString("store_name"));
			store.setStore_description(rs.getString("store_description"));
			store.setBusiness_hours(rs.getString("business_hours"));
			store.setStore_address(rs.getString("store_address"));
			store.setFilename(rs.getString("filename"));
			store.setGenre_id(rs.getString("genre_id"));
			store.setArea_id(rs.getString("area_id"));
			store.setAdmin_id(rs.getString("admin_id"));
		}

		st.close();
		con.close();

		return store;
	}

	/*
	 * 全件取得メソッド
	 */
	public List<Store> storeList() throws Exception{
		List<Store> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from store");

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Store s = new Store();
			s.setStore_id(rs.getString("store_id"));
			s.setStore_name(rs.getString("store_name"));
			s.setStore_description(rs.getString("store_description"));
			s.setBusiness_hours(rs.getString("business_hours"));
			s.setStore_address(rs.getString("store_address"));
			s.setFilename(rs.getString("filename"));
			s.setGenre_id(rs.getString("genre_id"));
			s.setArea_id(rs.getString("area_id"));
			s.setAdmin_id(rs.getString("admin_id"));
			list.add(s);
		}

		Collections.reverse(list);

		st.close();
		con.close();
		return list;
	}

	/*
	 * 店舗の追加メソッド
	 */
	public int storeInsert(Store store) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"insert into store values(null, ?, ?, ?, ?, ?, ?, ?, ?)");
		st.setString(1, store.getStore_name());
		st.setString(2, store.getStore_description());
		st.setString(3, store.getBusiness_hours());
		st.setString(4, store.getStore_address());
		st.setString(5, store.getFilename());
		st.setString(6, store.getGenre_id());
		st.setString(7, store.getArea_id());
		st.setString(8, store.getAdmin_id());

		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}

	/*
	 * 店舗データの更新メソッド
	 */
	public int storeUpdate(Store store) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
				"update store set store_name = ?,"
				+ " store_description = ?,"
				+ " business_hours = ?,"
				+ " store_address = ?,"
				+ " filename = ?,"
				+ " area_id = ?,"
				+ " genre_id = ?,"
				+ " admin_id = ?"
				+ " where store_id = ?");

		st.setString(1, store.getStore_name());
		st.setString(2, store.getStore_description());
		st.setString(3, store.getBusiness_hours());
		st.setString(4, store.getStore_address());
		st.setString(5, store.getFilename());
		st.setString(6, store.getArea_id());
		st.setString(7, store.getGenre_id());
		st.setString(8, store.getAdmin_id());
		st.setString(9, store.getStore_id());

		int line=st.executeUpdate();
		st.close();
		con.close();

		return line;
	}

	/*
	 * 店舗削除メソッド
	 */
	public int storeDelete(String store_id) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
				"delete from store where store_id = ?");

		st.setString(1, store_id);

		int line=st.executeUpdate();
		st.close();
		con.close();

		return line;
	}
}