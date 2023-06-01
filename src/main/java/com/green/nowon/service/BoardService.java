package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.dto.BoardDTO;

public interface BoardService {

	
	void save(BoardDTO dto);

	void findAll(Model model);

}
