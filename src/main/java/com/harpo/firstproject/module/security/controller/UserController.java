package com.harpo.firstproject.module.security.controller;

//import com.google.gson.GsonBuilder;

import com.harpo.firstproject.module.security.dao.repository.UserDAORepository;
import com.harpo.firstproject.module.security.model.User;
//import com.harpo.firstproject.module.security.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;
//import java.util.function.Consumer;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

	//private UserService userService;
	private UserDAORepository userDAORepository;

	@Autowired
	public UserController(UserDAORepository userDAORepository) {
		// UserService userService,
		//this.userService = userService;
		this.userDAORepository = userDAORepository;
	}

	@GetMapping(value = "/{username}/{age}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> create(@PathVariable String username, @PathVariable int age) {
		User saved = userDAORepository.insertUser(username, age);
		return ResponseEntity.ok().body(saved);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findAll() {
		final List<User> resultList = new ArrayList<>();
		final Iterable<User> all = userDAORepository.listUsers();
		all.forEach(resultList::add);
		return ResponseEntity.ok().body(resultList);
	}

}
