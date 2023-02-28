package web.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	private final UserServiceImpl userService;

	public HelloController(UserServiceImpl userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<User> listUsers = List.of(new User(1L,"ert","dfg","fghj"),
				new User(2L,"hjk","piu","jhkg"));
		model.addAttribute("index", listUsers);
		return "index";
	}
	
}