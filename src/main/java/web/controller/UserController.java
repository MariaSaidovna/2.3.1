package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Model.User;
import web.service.UserService;

@Controller
//@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/add_user")
    public String newUser (Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }
    @PostMapping("/add_user")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User user){
        userService.change(user, id);
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.findUserById(id));
        return "/update";
    }

}

