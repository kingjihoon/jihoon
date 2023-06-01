package com.green.nowon.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class BoardDTO {
	private long bno;
	private String title;
	private String content; 
	private LocalDateTime createdDate; 
}