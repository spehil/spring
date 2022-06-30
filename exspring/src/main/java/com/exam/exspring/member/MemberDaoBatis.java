package com.exam.exspring.member;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



//@Repository//Dao역할이니까 Repository로 한다.
public class MemberDaoBatis implements MemberDao {
    @Autowired
//	private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
	
	
	
	

	@Override
	public List<MemberVo> selectMemberList() {
		
		
		
		return session.selectList("com.exam.member.MemberDao.selectMemberList");
		}
		


	@Override
	public MemberVo selectMember(String memId) {
		
		return session.selectOne("com.exam.member.MemberDao.selectMember", memId);
		}
		

	
	
	
	@Override
	public int insertMember(MemberVo vo) {
		
		return session.insert("com.exam.member.MemberDao.insertMember",vo);
		
	}

	@Override
	public int delMember(String memId) {
		
		
		return session.delete("com.exam.member.MemberDao.delMember",memId);
		
	}


	@Override
	public int updateMember(MemberVo vo) {
		
		return session.update("com.exam.member.MemberDao.updateMember",vo);
		
		
	
	}


	@Override
	public MemberVo selectLoginMember(MemberVo vo) {
		
		return session.selectOne("com.exam.member.MemberDao.selectLoginMember", vo);
		
	}

}
