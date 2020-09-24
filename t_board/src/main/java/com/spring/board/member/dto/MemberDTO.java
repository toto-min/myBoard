package com.spring.board.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MemberDTO {
	private int code;
	private String id;
	private String pw;
	private String pwChek;
	private String name;
}
