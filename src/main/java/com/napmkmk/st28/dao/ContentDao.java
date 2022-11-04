package com.napmkmk.st28.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.napmkmk.st28.dto.ContentDto;

public class ContentDao implements IDao {  //4 implements IDao 써줌 에러 나면 add implements 첫번째꺼 누름.
	JdbcTemplate template; //1번. JdbcTemplate 선언

	@Autowired // 3번 오터 와이어드 템플릿을 받기 위해 컨테이너 찾음.
	public void setTemplate(JdbcTemplate template) { //2 번 셋터 만들기 template컨테이너에서 가져옴.
		this.template = template;
	}

	@Override
	public void deleteDao(final String mid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM board WHERE mid=?";
		
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
			
	  			 pstmt.setString(1, mid);
			}
		});

	}

	@Override
	public void writeDao(final String mwriter, final String mcontent) {
		// TODO Auto-generated method stub
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				
				String sql = "INSERT INTO board(mid, mwriter, mcontent) VALUES (board_seq.nextval,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mwriter);
				pstmt.setString(2, mcontent);
			
				
				return pstmt;
			}
		}) ;
		
		
	}

	@Override
	public ArrayList<ContentDto> listDao() {
		// TODO Auto-generated method stub
		 String sql = "SELECT * FROM board ORDER BY mid DESC"; //게시판 번호로 내림 차순
		
		 ArrayList<ContentDto> dtos =  (ArrayList<ContentDto>) template.query(sql,new BeanPropertyRowMapper(ContentDto.class)); 

		return dtos;
	}

	
	
	
}
