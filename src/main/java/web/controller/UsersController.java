package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	private UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping //просмотр всех юзеров
	public String index(Model model){
		model.addAttribute("users", userService.allUsers());
		return "users/users";
	}

	@GetMapping(value = "/{id}") //просмотр одного юзера по id
	public String showUser(@PathVariable("id") int id, Model model){
		model.addAttribute("user", userService.getUserByID(id));
		return "users/show";
	}

	@GetMapping(value = "/add") //создание нового юзера
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "users/add";
	}

	@PostMapping(value = "/add") //сохранение нового пользователя в списке
	public String saveUser(@ModelAttribute("user") User user) {
		userService.add(user);

		return "redirect:/users";
	}

	@GetMapping(value = "/{id}/edit")
	public String editUser (@PathVariable("id") int id, Model model) {
		model.addAttribute("user", userService.getUserByID(id));
		return "users/edit";
	}

	@PostMapping(	value = "/{id}")
	public String update (@ModelAttribute("user") User user,
						  @PathVariable("id") int id){
		userService.update(id, user);
		return "redirect:/users";
	}

	@GetMapping(value = "/{id}/delete")
	public String deleteUser (@PathVariable("id") int id) {
		this.userService.delete(id);
		return "redirect:/users";
	}
}