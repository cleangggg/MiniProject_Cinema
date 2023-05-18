package movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBConnection.DBConnection;

public class DB {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public DB() {
		try {
			con = DBConnection.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MovieDTO> showMovie() {
		String sql = "select * from movie";
		ArrayList<MovieDTO> movie_list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MovieDTO dto = new MovieDTO();
				dto.setNum(rs.getInt("num"));
				dto.setMovie_name(rs.getString("movie_name"));
				dto.setMoney(rs.getInt("money"));
				dto.setMovie_time(rs.getString("movie_time"));
				dto.setMovie_seatcount(rs.getInt("movie_seatcount"));
				dto.setCinema_location(rs.getString("cinema_location"));
				dto.setCinema_name(rs.getString("cinema_name"));
				
				movie_list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return movie_list;
	}
	
	public int seat_check(int num) {
		String sql = "select * from movie where num = ?";
		MovieDTO dto = null;
		int movie_seatcount = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MovieDTO();
				dto.setMovie_seatcount(rs.getInt("movie_seatcount"));
				movie_seatcount = dto.getMovie_seatcount();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return movie_seatcount;
	}
	
	public MovieDTO choice_movie(int num) {
		String sql = "select * from movie where num = ?";
		MovieDTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			dto = new MovieDTO();
			if(rs.next()) {
				dto.setMovie_name(rs.getString("movie_name"));
				dto.setMovie_time(rs.getString("movie_time"));
				dto.setCinema_location(rs.getString("cinema_location"));
				dto.setCinema_name(rs.getString("cinema_name"));
				dto.setMovie_seatcount(rs.getInt("movie_seatcount"));
				MovieDTO dto1 = new MovieDTO();
				dto1.setMember_id("aaa");
				dto1.setTicketing("티켓");
				dto1.setMovie(rs.getString("movie_name"));
				dto1.setMovie_time(rs.getString("movie_time"));
				String sql1 = "insert into ticketing_info(member_id, ticketing, movie, movie_time) values(?,?,?,?)";
				try {
					ps = con.prepareStatement(sql1);
					ps.setString(1, dto1.getMember_id());
					ps.setString(2, dto1.getTicketing());
					ps.setString(3, dto1.getMovie());
					ps.setString(4, dto1.getMovie_time());
					
					ps.executeUpdate();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public MovieDTO re_view(String member_id) {
		String sql = "select * from ticketing_info where member_id = ?";
		MovieDTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MovieDTO();
				dto.setMember_id(rs.getString("member_id"));
				dto.setTicketing(rs.getString("ticketing"));
				dto.setMovie(rs.getString("movie"));
				dto.setMovie_time(rs.getString("movie_time"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int delete(String member_id) {
		int result = 0;
		String sql = "delete from ticketing_info where member_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member_id);
			
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
