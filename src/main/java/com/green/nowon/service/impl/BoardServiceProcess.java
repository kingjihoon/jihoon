package com.green.nowon.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.dto.BoardDTO;
import com.green.nowon.mapper.BoardMapper;
import com.green.nowon.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service 
public class BoardServiceProcess implements BoardService{
	
	private final BoardMapper mapper;

	@Override
	public void save(BoardDTO dto) {
		mapper.save(dto);
	}

	@Override
	public void findAll(Model model) {

	}

}
