package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String allUsersPage (ModelMap model) {
		model.addAttribute("users", userService.listUsers());
		return "users";
	}

	@GetMapping(value = "/new")
	public String newUserPage (ModelMap model) {
		model.addAttribute("user", new User());
		return "newUser";
	}

	@PostMapping("/new")
	public String newUserAdd (@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}

	@GetMapping(value = "/edit")
	public String editUserPage (@RequestParam(value = "id") Long id, ModelMap model) {
		model.addAttribute("user", userService.getUser(id));
		return "editUser";
	}

	@PostMapping("/edit")
	public String editUser (@ModelAttribute("user") User user) {
		userService.updateUser(user);
		return "redirect:/users";
	}

	@PostMapping("/delete")
	public String deleteUser (@RequestParam(value = "id") Long id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
}