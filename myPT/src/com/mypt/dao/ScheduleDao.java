package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import com.mypt.connection.DBConnection;
import com.mypt.dto.ScheduleDto;

public class ScheduleDao {
	private DBConnection db;

//////////dao 싱글톤 (이)
	private static ScheduleDao instance = new ScheduleDao();

	public static ScheduleDao getInstance() {
		return instance;
	}

	private ScheduleDao() {
		db = DBConnection.getInstance();
	}

	public void scheduleInsert(ScheduleDto sd) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			String sql = "insert into schedule values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, sd.getS_id());
			ps.setString(2, sd.getS_date());
			ps.setString(3, sd.getS_time());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
	}

	public ScheduleDto scheduleSelect(String s_id, String s_date) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ScheduleDto sd = new ScheduleDto();
		try {
			con = db.getConnection();
			String sql = "select * from schedule where s_id=? and s_date=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, s_id);
			ps.setString(2, s_date);
			rs = ps.executeQuery();
			if (rs.next()) {
				sd.setS_id(s_id);
				sd.setS_date(s_date);
				sd.setS_time(rs.getString(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}
		return sd;
	}

	public void ScheduleUpdate(ScheduleDto sd) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			String sql = "update schedule set s_time=? where s_id=? and s_date=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, sd.getS_time());
			ps.setString(2, sd.getS_id());
			ps.setString(3, sd.getS_date());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
	}

	public void ScheduleDelete(String s_id, String s_date) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			String sql = "delete from schedule where s_id=? and s_date=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, s_id);
			ps.setString(2, s_date);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
	}
	
	public int isScheduleExist(String s_id, String s_date) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int flag=0;
		try {
			con = db.getConnection();
			String sql = "select * from schedule where s_id=? and s_date=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, s_id);
			ps.setString(2, s_date);
			rs = ps.executeQuery();
			if (rs.next()) {
				flag=1;
			}else {
				flag=0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}
		return flag;
	}
	
	
	//오늘의 피티회원
	public ArrayList<ScheduleDto> todayPTList(String tid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH)+1;
		int day = cal.get(cal.DATE);
		String today = year+"-"+month+"-"+day;
		
		ArrayList<ScheduleDto> arr = new ArrayList<ScheduleDto>();			
		
		try {
			con = db.getConnection();
			String sql = "select * from schedule s left outer join user u on s.s_id=u.id where tid=? and s_date=?";			
			ps = con.prepareStatement(sql);
			ps.setString(1, tid);
			ps.setString(2, today);
			rs = ps.executeQuery();
			while (rs.next()) {
				ScheduleDto sd = new ScheduleDto();				
				sd.setS_id(rs.getString("id"));
				sd.setS_date(rs.getString("s_date"));
				sd.setS_time(rs.getString("s_time"));				
				arr.add(sd);	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}
		return arr;
	}
	
}
