package com.spring.board.member.dao;

import org.springframework.dao.DataAccessException;

import com.spring.board.member.dto.MemberDTO;

public interface MemberDAO {
	public void joinMember(MemberDTO memdto) throws DataAccessException;
	public void loginMember(MemberDTO memdto) throws DataAccessException;
}
