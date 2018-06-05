package com.harpo.firstproject.module.core.controller;

//import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//import javax.inject.Inject;
//import java.util.function.Consumer;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HomeController {

	@Autowired
	public HomeController() {
	}

	@GetMapping
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> sayHello() {
		JsonObject new_json = new JsonObject();
		new_json.addProperty("message", "Hello world!");
		return ResponseEntity.ok().body(new_json.toString());
	}
}
