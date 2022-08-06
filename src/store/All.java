package store;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/store/all"})
public class All extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();//イニシャルコンテキスト取得インスタンス生成命名ic
			DataSource ds=(DataSource)ic.lookup(//icのルックアップメソッド
				"java:/comp/env/jdbc/sakenavi");
			Connection con=ds.getConnection();

			PreparedStatement st=con.prepareStatement(
			"select * from store");
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				out.println(rs.getInt("store_id"));
				out.println("：");
				out.println(rs.getString("store_name"));
				out.println("：");
				out.println(rs.getString("store_description"));
				out.println("：");
				out.println(rs.getString("business_hours"));
				out.println("：");
				out.println(rs.getString("store_address"));
				out.println("：");
				out.println(rs.getString("images_name"));
				out.println("：");
				out.println(rs.getInt("genre_id"));
				out.println("：");
				out.println(rs.getInt("area_id"));
				out.println("：");
				out.println(rs.getInt("admin_id"));
			}


			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
