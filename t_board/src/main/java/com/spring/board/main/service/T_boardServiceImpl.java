package com.spring.board.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dto.T_boardDTO;
import com.spring.board.main.dao.T_boardDAO;

@Service
public class T_boardServiceImpl implements T_boardService{

	@Autowired
	T_boardDAO dao;
	
	@Override
	public List<T_boardDTO> t_boardAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.t_boardAll();
	}

	@Override
	public T_boardDTO t_boardDetail(int detail) throws Exception {
		// TODO Auto-generated method stub
		return dao.t_boardDetail(detail);
	}
	
	@Override
	public void insertpage(T_boardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(dto);
	}


	@Override
	public int selectvl() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectvl();
	}

	@Override
	public void deletepage(int articleNum) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(articleNum);
	}

	@Override
	public void updatepage(T_boardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		dao.update(dto);
	}

	@Override
	public String imagesel(int articleNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.selimage(articleNum);
	}

}
