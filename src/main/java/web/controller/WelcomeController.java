package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WelcomeController {
	@GetMapping(value = "/") //стартовая страница приветствия
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Приветствую вас в Джуманджи!");
		model.addAttribute("messages", messages);
		return "index";
	}

}