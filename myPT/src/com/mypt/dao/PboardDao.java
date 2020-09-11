package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypt.dto.PboardDto;

public class PboardDao extends AbstractBoardDao<PboardDto> {

	private static PboardDao instance = new PboardDao();

	public static PboardDao getInstance() {
		return instance;
	}

	private PboardDao() {
	}

	public void insert(PboardDto dto) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into pboard(pb_title, pb_writer, pb_head, pb_content, hit, like, pb_photo) values(?,?,?,?,?,?,?)";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getWriter());
			ps.setString(3, dto.getHead());
			ps.setString(4, dto.getContent());
			ps.setInt(5, 0);
			ps.setInt(6, 0);
			ps.setString(7, dto.getPhoto());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
	}

	@Override
	public void update(PboardDto dto) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "update pboard set pb_title=?, pb_head=?, pb_content=?, pb_photo=? where num=?";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getHead());
			ps.setString(3, dto.getContent());
			ps.setString(4, dto.getPhoto());
			ps.setInt(5, dto.getNum());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
	}

	public ArrayList<PboardDto> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<PboardDto> arr = new ArrayList<PboardDto>();

		String sql = "select * from pboard order by pb_num desc";

		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				PboardDto dto = new PboardDto();

				dto.setNum(rs.getInt("pb_num"));
				dto.setTitle(rs.getString("pb_title"));
				dto.setWriter(rs.getString("pb_writer"));
				String date = rs.getTimestamp("pb_date").toString();
				dto.setDate(date.substring(0, 10));
				dto.setPhoto(rs.getString("pb_photo"));
				dto.setContent(rs.getString("pb_content"));
				dto.setLike(rs.getInt("pb_like"));
				dto.setHit(rs.getInt("pb_hit"));

				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}

		return arr;
	}

	public PboardDto detailView(int num) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		PboardDto dto = null;

		String sql = "select pb_title, pb_writer, pb_date, hit, pb_content, like from pboard where num=?";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);

			rs = ps.executeQuery();

			if (rs.next()) {
				dto = new PboardDto();

				dto.setTitle(rs.getString(1));
				dto.setWriter(rs.getString(2));
				dto.setDate(rs.getTimestamp(3).toString());
				dto.setHit(rs.getInt(4) + 1);
				dto.setContent(rs.getString(5));
				dto.setLike(rs.getInt(6));

				updateHit(num, "pboard");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}

		return dto;

	}

///		좋아요 리스트 확인요함
	public ArrayList<PboardDto> myLikeList(ArrayList<Integer> nums) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<PboardDto> arr = new ArrayList<PboardDto>();

		String sql = "select * from pboard where num=?";

		try {
			con = db.getConnection();

			for (int num : nums) {
				ps = con.prepareStatement(sql);
				ps.setInt(1, num);

				rs = ps.executeQuery();

				if (rs.next()) {
					PboardDto dto = new PboardDto();

					dto.setTitle(rs.getString("pb_title"));
					dto.setWriter(rs.getString("pb_writer"));
					dto.setDate(rs.getTimestamp("pb_date").toString());
					dto.setPhoto(rs.getString("pb_photo"));
					dto.setLike(rs.getInt("pb_like"));
					dto.setHit(rs.getInt("pb_hit"));

					arr.add(dto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}

		return arr;
	}

	// 댓글 수 확인
	public int commentNum(int pb_num) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		String sql = "SELECT count(*) FROM pcomment where pb_num=" + pb_num;

		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			} else {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}

		return result;
	}

	// 포토 게시판 좋아요 눌렀는지 확인
	public String photoLikeCheck(int pbl_num, String nick) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = "";

		String sql = "SELECT * FROM pblike where pbl_num=? and pbl_nick=?";

		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pbl_num);
			ps.setString(2, nick);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = "checked=\"checked\"";
			} else {
				result = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}

		return result;
	}

	// 총 게시물 수
	public int getTotalCount() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int totalCount = 0;
		try {
			con = db.getConnection();
			sql = "select count(*) from pboard";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next())
				totalCount = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}
		return totalCount;
	}

	// Board Total Count : 검색 시 총 게시물수
	public int getTotalCount(String keyField, String keyWord) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int totalCount = 0;
		try {
			con = db.getConnection();
			// 검색이 아닌경우
			if (keyWord.trim().equals("") || keyWord == null) {
				sql = "select count(*) from pboard";

				ps = con.prepareStatement(sql);
			} else {
				// 검색인 경우
				sql = "select count(*) from pboard where " + keyField + " like '%" + keyWord + "%'";

				System.out.println(sql);
				ps = con.prepareStatement(sql);
			}
			rs = ps.executeQuery();
			if (rs.next())
				totalCount = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}
		return totalCount;
	}
	
	// 정해진 레코드 수 만큼 리스트 받아옴
	public ArrayList<PboardDto> getList(int startPage,int numPerPage) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<PboardDto> arr = new ArrayList<PboardDto>();

		String sql = "select * from pboard order by pb_num desc limit ?,?";

		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, startPage);
			ps.setInt(2, numPerPage);
			rs = ps.executeQuery();

			while (rs.next()) {
				PboardDto dto = new PboardDto();

				dto.setNum(rs.getInt("pb_num"));
				dto.setTitle(rs.getString("pb_title"));
				dto.setWriter(rs.getString("pb_writer"));
				String date = rs.getTimestamp("pb_date").toString();
				dto.setDate(date.substring(0, 10));
				dto.setPhoto(rs.getString("pb_photo"));
				dto.setContent(rs.getString("pb_content"));
				dto.setLike(rs.getInt("pb_like"));
				dto.setHit(rs.getInt("pb_hit"));

				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}

		return arr;
	}

}
