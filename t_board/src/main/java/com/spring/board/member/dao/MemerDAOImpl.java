package com.spring.board.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.board.member.dto.MemberDTO;

@Repository
public class MemerDAOImpl implements MemberDAO{
	
	@Autowired
	SqlSession memsess;

	@Override
	public void joinMember(MemberDTO memdto) throws DataAccessException {
		// TODO Auto-generated method stub
		memsess.selectOne("mybatis.mappers.Member_mapper.memberjoin", memdto);
		
	}

	@Override
	public void loginMember(MemberDTO memdto) throws DataAccessException {
		// TODO Auto-generated method stub
		memsess.selectList("mybatis.mappers.Member_mapper.login", memdto);
		
	}

}
