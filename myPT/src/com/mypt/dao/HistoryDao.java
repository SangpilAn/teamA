package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypt.connection.DBConnection;
import com.mypt.dto.HistoryDto;


public class HistoryDao {
	private DBConnection db;
	
//////////dao 싱글톤 (이)
private static HistoryDao instance = new HistoryDao();
public static HistoryDao getInstance() 
{
return instance;
}
	
	public HistoryDao() {
		db=DBConnection.getInstance();
	}
	
	public void insertHistory(HistoryDto historyBean) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=db.getConnection();
			sql= "insert history(hid,paydate,price,hcount) "
					+ "valuse(?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, historyBean.getHid());
			ps.setString(2, historyBean.getPaydate());
			ps.setInt(3, historyBean.getPrice());
			ps.setInt(4, historyBean.getHcount());
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
	}
	
	public HistoryDto getHistory(String hid) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=null;
		HistoryDto historyBean=new HistoryDto();
		
		try {
			con=db.getConnection();
			sql="select * from history where hid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, hid);
			rs=ps.executeQuery();
			if(rs.next()) {
				historyBean.setHid(rs.getString("hid"));
				historyBean.setPaydate(rs.getString("paydate"));
				historyBean.setPrice(rs.getInt("price"));
				historyBean.setHcount(rs.getInt("hcount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.closeConnection(rs, ps, con);
		}
		
		return historyBean;
	}
	
	public void updateHistory(HistoryDto historyBean) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=db.getConnection();
			sql= "update history set paydate=?,price=?,hcount=? where hid=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, historyBean.getPaydate());
			ps.setInt(2, historyBean.getPrice());
			ps.setInt(3, historyBean.getHcount());
			ps.setString(4, historyBean.getHid());
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
		
	}
	
	public void deleteHistory(String hid) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=db.getConnection();
			sql= "delete from history where hid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, hid);
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
	}
	
	
	// 그래프관련 메서드 추가
		// 월별 매출, 회원수
		public ArrayList<HistoryDto> getincome(int year,int month) {
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			String sql=null;
			HistoryDto historyBean=null;
			ArrayList<HistoryDto> arr = new ArrayList<HistoryDto>();			
					
			try {
				for(int i=1; i<=month;i++) {
					historyBean = new HistoryDto();
				
				con=db.getConnection();
				if(i<10) {
				sql="select ifnull(sum(price),0),count(distinct hid) from history where paydate like '%"+year+"-0"+i+"%';";
				}
				else {
					sql="select ifnull(sum(price),0),count(distinct hid) from history where paydate like '%"+year+"-"+i+"%';";							
				}
				System.out.println(sql);
				ps=con.prepareStatement(sql);			
				rs=ps.executeQuery();
				historyBean.setMonth(i);
				if(rs.next()) {
					System.out.println(rs.getString(1));
					historyBean.setIncome(Integer.parseInt(rs.getString(1)));
					historyBean.setUsercnt(Integer.parseInt(rs.getString(2)));
					
				}
				arr.add(historyBean);
				db.closeConnection(rs, ps, con);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return arr;
		}		
		
		
		
		// 이번 달 수입 (윤)
		public int monthIncome(int year,int month) {
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			String sql=null;				
			int income = 0;		
			
			try {		
				con=db.getConnection();
				if(month<10) {
				sql="select ifnull(sum(price),0) from history where paydate like '%"+year+"-0"+month+"%';";
				}
				else {
					sql="select ifnull(sum(price),0) from history where paydate like '%"+year+"-"+month+"%';";
				}
				System.out.println(sql);
				ps=con.prepareStatement(sql);			
				rs=ps.executeQuery();			
				if(rs.next()) {
					System.out.println(rs.getString(1));
					income = Integer.parseInt(rs.getString(1));			
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeConnection(rs, ps, con);
			}		
			return income;
		}
		
		// 현재 회원수(윤)
		public int nowUser(String now) {
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			String sql=null;				
			int usercnt = 0;		
			
			try {		
				con=db.getConnection();
				
				sql="select count(*) from user where startdate <= ? and enddate >= ?";
				
				System.out.println(sql);
				ps=con.prepareStatement(sql);
				ps.setString(1, now);
				ps.setString(2, now);
				rs=ps.executeQuery();			
				if(rs.next()) {
					System.out.println(rs.getString(1));
					usercnt = Integer.parseInt(rs.getString(1));			
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeConnection(rs, ps, con);
			}		
			return usercnt;
		}
		
		// 신규 회원수(윤)
			public int newUser(String now) {
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				String sql=null;				
				int usercnt = 0;		
				
				try {		
					con=db.getConnection();
					
					sql="select count(*) from user where signdate like '%"+now+"%';";
					
					System.out.println(sql);
					ps=con.prepareStatement(sql);
					rs=ps.executeQuery();			
					if(rs.next()) {
						System.out.println(rs.getString(1));
						usercnt = Integer.parseInt(rs.getString(1));			
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					db.closeConnection(rs, ps, con);
				}		
				return usercnt;
			}
}
