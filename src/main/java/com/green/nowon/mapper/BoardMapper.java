package com.green.nowon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import com.green.nowon.dto.BoardDTO;

//@Mapper //컨피그에 @MapperScan 적용되어있으면 필요없다
public interface BoardMapper {

	void save (BoardDTO dto);
	
	List<BoardDTO> findAll();
}
