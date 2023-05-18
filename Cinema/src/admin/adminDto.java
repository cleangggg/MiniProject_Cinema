package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import DBConnection.DBConnection;
import location.location_entity;

public class adminDto {
	HashMap<String, ArrayList> map = new HashMap<>();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public adminDto() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateMovie(ArrayList list) {

		String sql = "INSERT INTO MOVIE  VALUES (movie_seq.nextval, ?, ?, ?, ?, ?, ?) ";
		try {

			ps = con.prepareStatement(sql);
			ps.setObject(1, list.get(0));
			ps.setObject(2, list.get(1));
			ps.setObject(3, list.get(2));
			ps.setObject(4, list.get(3));
			ps.setObject(5, list.get(4));
			ps.setObject(6, list.get(5));
			ps.executeUpdate();
			System.out.println("업데이트완료");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int deleteMovie(String id) {
		String sql = "delete  from movie where movie_name=?";

		int result = 0;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
			System.out.println("삭제완료");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public void selectMovie_Info(String name) {
		

		String sql = "select *  from MOVIE where MOVIE_NAME = ? ";

		try {

			location_entity le = new location_entity();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			// ps.setString(2,name);

			rs = ps.executeQuery();
		
			while (rs.next()) {
				ArrayList arr = new ArrayList<>();
				arr.add(rs.getInt(1));
				arr.add(rs.getString(2));	
				arr.add(rs.getInt(3));	
				arr.add(rs.getString(4));	
				arr.add(rs.getInt(5));	
				arr.add(rs.getString(6));	
				arr.add(rs.getString(7));	
				map.put(name,arr);
				System.out.println(map);
			}			
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void modifyMovie( String modify , Object a , int num) {
		String sql =null;
		switch(modify){
		case "money":
			sql = "update movie set money = ? where num = ?";
			break;
		case "movie_time":
			sql = "update movie set movie_time = ? where num = ?";
			break;
		case "movie_seatcount":
			sql = "update movie set movie_seatcount = ? where num = ?";
			break;
		case "cinema_location":
			sql = "update movie set cinema_location = ? where num = ?";
			break;
		case "cinema_name":
			sql = "update movie set cinema_name = ? where num = ?";
			break;	
		}
		System.out.println(sql);
		try {
			ps = con.prepareStatement(sql);
			
			ps.setObject(1, a);
			ps.setInt(2, num);
			
			ps.executeUpdate();
			System.out.println("수정완료");
		} catch (Exception e) {
			
		}
	}

	public void selectMember() {
		
		String sql = "select * from membership";
		String sql2 = "select * from TICKETING_INFO";
		
		
		
		try {
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			while (rs.next()) {
				ArrayList arr = new ArrayList<>();
				arr.add(rs.getString(1));	
				arr.add(rs.getString(2));	
				arr.add(rs.getString(3));	
				arr.add(rs.getString(4));	
				System.out.println(arr);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
		
	
	

	public int deleteMember(String id) {

		String sql = "delete  from membership where member_id=?";

		int result = 0;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {

		}

		return result;
	}
	
	

}