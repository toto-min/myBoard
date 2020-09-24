package com.spring.board.main.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.board.dto.T_boardDTO;

public interface T_boardDAO {
	public List<T_boardDTO> t_boardAll() throws DataAccessException;
	public T_boardDTO t_boardDetail(int detail) throws DataAccessException;
	void insert(T_boardDTO dto) throws DataAccessException;
	int selectvl() throws DataAccessException;
	void delete(int articleNum) throws DataAccessException;
	void update(T_boardDTO dto) throws DataAccessException;
	String selimage(int articleNum) throws DataAccessException;
}
