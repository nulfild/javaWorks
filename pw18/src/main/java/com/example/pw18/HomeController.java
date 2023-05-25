package com.example.pw18;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
@Slf4j
public class HomeController {
	@GetMapping
	public ModelAndView render() {
		log.info("Render hello.html");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello.html");
		return modelAndView;
	}
}
