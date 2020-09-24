package com.spring.board.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.member.dao.MemberDAO;
import com.spring.board.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO memdao;

	@Override
	public void joinMember(MemberDTO memdto) throws Exception {
		// TODO Auto-generated method stub
		memdao.joinMember(memdto);
		
	}

	@Override
	public void loginMember(MemberDTO memdto) throws Exception {
		// TODO Auto-generated method stub
		memdao.loginMember(memdto);
		
	}

}
