package com.spring.board.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class T_boardDTO {
	private int articleNum;
	private int parentNum;
	private Date writeDate;
	private String title;
	private String contents;
	private String imagefileName;
	private int hit;
	private String writer;
}
