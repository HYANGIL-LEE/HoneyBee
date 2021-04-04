package com.honeybee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honeybee.domain.FreeReplyVO;
import com.honeybee.service.FreeReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/freply/*")
@Log4j
@AllArgsConstructor
public class FreeReplyController {
	
	private FreeReplyService service;
	
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody FreeReplyVO vo) {
		int insertCount = service.register(vo);
		
		return insertCount== 1 ? new ResponseEntity<>("success", HttpStatus.OK	) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

 }
