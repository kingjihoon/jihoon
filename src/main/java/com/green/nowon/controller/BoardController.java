package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.dto.BoardDTO;
import com.green.nowon.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
		
	private final BoardService service;//DI
	
	@GetMapping("/board")
	public String board(Model model) {
		service.findAll(model);
		return "board/list"; // classpath:/templates/
	}
	@GetMapping("/board/new")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/board")
	public String write(BoardDTO dto) {
		service.save(dto);
		return"redirect:/board";
		
	}
	


}
