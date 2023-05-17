package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBConnection.DBConnection;

public class account_DAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public account_DAO() {

		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean mapping_member(String id) {

		String sql = "select * from membership where member_id = ?";
		try {

			account_entity ae = new account_entity();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				ae.setNum(rs.getInt(1));
				ae.setMember_id(rs.getString(2));
				ae.setMember_pwd(rs.getString(3));
				ae.setNick(rs.getString(4));
				ae.setPhone(rs.getString(5));
				ae.setBirth(rs.getDate(6));

			}
			if (id.equals(ae.getMember_id())) {
				System.out.println("로그인 성공");
				return true;
			} else {
				System.out.println("로그인 실패");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
