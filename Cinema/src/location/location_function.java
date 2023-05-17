package location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import DBConnection.DBConnection;

public class location_function {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	location_entity le = new location_entity();
	ArrayList arr = new ArrayList<>();
	HashMap<String, ArrayList> map = new HashMap<>();

	public location_function() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectMovie_INFO(String loc, String name) {

		String sql = "select MOVIE_NAME, MOVIE_TIME , MOVIE_SEATCOUNT, CINEMA_NAME, CINEMA_LOCATION from MOVIE where CINEMA_LOCATION = ? ";

		try {

			location_entity le = new location_entity();
			ps = con.prepareStatement(sql);
			ps.setString(1, loc);
			// ps.setString(2,name);

			rs = ps.executeQuery();
		
			while (rs.next()) {
				if (rs.getString(4).equals(name)){
				ArrayList arr = new ArrayList<>();
				arr.add(rs.getString(1));	
				arr.add(rs.getString(2));	
				arr.add(rs.getString(3));	
				arr.add(rs.getString(4));	
				map.put(name,arr);
				System.out.println(map);
			}
			}
		System.out.println(map.size());	
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}