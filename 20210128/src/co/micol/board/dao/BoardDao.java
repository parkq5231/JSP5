package co.micol.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.board.common.DAO;
import co.micol.board.vo.BoardVo;

public class BoardDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	public ArrayList<BoardVo> selectList() {
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		BoardVo vo;
		String sql = "SELECT * FROM BOARD ORDER BY BID DESC";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVo();// 한개씩 읽어서 vo객체에 담아줌
				vo.setbId(rs.getInt("bid"));
				vo.setbName(rs.getString("bname"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				vo.setbGroup(rs.getInt("bgroup"));
				vo.setbStep(rs.getInt("bstep"));
				vo.setbIndent(rs.getInt("bindent"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}// end of recordset

	public BoardVo select(BoardVo vo) {
		String sql = "SELECT * FROM BOARD WHERE BID=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setbId(rs.getInt("bid"));
				vo.setbName(rs.getString("bname"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				vo.setbGroup(rs.getInt("bgroup"));
				vo.setbStep(rs.getInt("bstep"));
				vo.setbIndent(rs.getInt("bindent"));
				hitCount(vo.getbId()); // 다 읽고 나서 한행의 hitcount 증가 밑의 메소드 참조
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public int insert(BoardVo vo) {// vo 객체를 받는다
		int n = 0;
		String sql = "INSERT INTO BOARD VALUES(BIDSEQ.NEXTVAL,?,?,?,?,0,0,0,0)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbName());
			psmt.setString(2, vo.getbTitle());
			psmt.setString(3, vo.getbContent());
			psmt.setDate(4, vo.getbDate());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 추가.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int delete(BoardVo vo) {// vo 객체를 받는다
		int n = 0;
		String sql = "DELETE FROM BOARD WHERE BID=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 삭제.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int update(BoardVo vo) {// vo 객체를 받는다
		int n = 0;
		// content만 업데이트 해보기
		String sql = "UPDATE BOARD SET BCONTENT=? WHERE BID=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbContent());
			psmt.setInt(2, vo.getbId());
			n = psmt.executeUpdate();
			System.out.println(n + "건 업데이트.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	private void close() {// connection을 닫아주는거
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end of close

	private void hitCount(int hit) { // 조회수 증가 method // DB type=number
		String sql = "UPDATE BOARD SET BHIT = BHIT+1 WHERE BID=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hit);
			int n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end of hitCount
}
