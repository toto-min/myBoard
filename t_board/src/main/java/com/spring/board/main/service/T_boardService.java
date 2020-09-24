package com.spring.board.main.service;

import java.util.List;

import com.spring.board.dto.T_boardDTO;

public interface T_boardService {
	public List<T_boardDTO> t_boardAll() throws Exception;
	public T_boardDTO t_boardDetail(int detail) throws Exception;
	void insertpage(T_boardDTO dto) throws Exception;
	int selectvl() throws Exception;
	void deletepage(int articleNum) throws Exception;
	void updatepage(T_boardDTO dto) throws Exception;
	String imagesel(int articleNum) throws Exception;
}
