package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBConnection.DBConnection;


class DB {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public DB() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	
	






	public int delete(String id) {
		String sql = "delete from newst where id=?";
		int result =0;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return result;
	}
	
	
}