package com.exam.exspring.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoJdbc implements MemberDao {

	String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 서버 주소
	String user = "web"; //데이터베이스 사용자 아이디
	String password = "web01"; //데이터베이스 사용자 비밀번호
	
	@Override
	public List<MemberVo> selectMemberList() {
		// 데이터베이스 member 테이블의 정보를 select하여 출력
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		String selectSql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
		try (
			Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속(연결)
			PreparedStatement pstmt = conn.prepareStatement(selectSql);
			ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) { //다음 레코드가 있는 동안 반복
				MemberVo vo = new MemberVo();
				vo.setMemId( rs.getString("mem_id") );
				vo.setMemPass( rs.getString("mem_pass") );
				vo.setMemName( rs.getString("mem_name") );
				vo.setMemPoint( rs.getInt("mem_point") );
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertMember(MemberVo vo) {
		int num = 0;
		String insertSql = "INSERT INTO member "
				+ "(mem_id, mem_pass, mem_name, mem_point) "
				+ "VALUES (?, ?, ?, ?)";
		try (
			Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속(연결)
			PreparedStatement pstmt = conn.prepareStatement(insertSql);
		) {
			pstmt.setString(1, vo.getMemId() ); //pstmt에 담긴 SQL문의 1번째 ?에 id 값을 주입
			pstmt.setString(2, vo.getMemPass() ); //pstmt에 담긴 SQL문의 2번째 ?에 pass 값을 주입
			pstmt.setString(3, vo.getMemName() ); //pstmt에 담긴 SQL문의 3번째 ?에 name 값을 주입
			pstmt.setInt(4, vo.getMemPoint() ); //pstmt에 담긴 SQL문의 4번째 ?에 point 값을 주입
			num = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int delMember(String memId) {
		int num = 0;
		String delSql = "DELETE FROM member WHERE mem_id = ?";
		try (
			Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속(연결)
			PreparedStatement pstmt = conn.prepareStatement(delSql);
		) {
			pstmt.setString(1, memId); //pstmt에 담긴 SQL문의 1번째 ?에 id 값을 주입
			num = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
}
