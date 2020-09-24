package com.spring.board.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.board.dto.T_boardDTO;

@Repository
public class T_boardDAOImpl implements T_boardDAO{

	@Autowired
	SqlSession sess;
	
	@Override
	public List<T_boardDTO> t_boardAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return sess.selectList("mybatis.mappers.T_board_mapper.t_boardAll");
	}

	@Override
	public T_boardDTO t_boardDetail(int detail) throws DataAccessException {
		// TODO Auto-generated method stub
		return sess.selectOne("mybatis.mappers.T_board_mapper.t_boardDetail",detail);
	}
	
	@Override
	public void insert(T_boardDTO dto) throws DataAccessException {
		// TODO Auto-generated method stub
		sess.insert("mybatis.mappers.T_board_mapper.t_boardinsert", dto);
	}

	@Override
	public int selectvl() throws DataAccessException {
		// TODO Auto-generated method stub
		return sess.selectOne("mybatis.mappers.T_board_mapper.insertNum");
	}

	@Override
	public void delete(int articleNum) throws DataAccessException {
		// TODO Auto-generated method stub
		sess.delete("mybatis.mappers.T_board_mapper.t_boarddel",articleNum);
	}

	@Override
	public void update(T_boardDTO dto) throws DataAccessException {
		// TODO Auto-generated method stub
		sess.update("mybatis.mappers.T_board_mapper.t_boardupdate", dto);
		
	}

	@Override
	public String selimage(int articleNum) throws DataAccessException {
		// TODO Auto-generated method stub
		return sess.selectOne("mybatis.mappers.T_board_mapper.t_boardimgsel", articleNum);
	}

}
