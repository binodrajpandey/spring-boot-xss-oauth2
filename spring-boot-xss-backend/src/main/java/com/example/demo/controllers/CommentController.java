package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Comment;
import com.example.demo.repositories.CommentRepository;

@RestController
public class CommentController {
	@Autowired
	private CommentRepository commentRepository;
	@PostMapping("/comments")
	public ResponseEntity<?> addComment(@RequestBody Comment comment){
		System.out.println("comment text="+comment.getText());
		commentRepository.save(comment);
		return ResponseEntity.ok(comment);
		
	}
	@GetMapping("/comments")
	public ResponseEntity<?> getComments(){
		return ResponseEntity.ok(commentRepository.findAll());
	}
	

}
