package com.green.nowon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	void save (BoardDTO dto);
	
	List<BoardDTO> findAll();
}
