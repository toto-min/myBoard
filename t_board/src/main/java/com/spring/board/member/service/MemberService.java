package com.spring.board.member.service;

import com.spring.board.member.dto.MemberDTO;

public interface MemberService {
	public void joinMember(MemberDTO memdto) throws Exception;
	public void loginMember(MemberDTO memdto) throws Exception;
}
