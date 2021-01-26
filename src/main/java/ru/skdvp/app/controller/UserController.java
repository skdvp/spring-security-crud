package ru.skdvp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.skdvp.app.model.User;
import ru.skdvp.app.service.UserService;

@Controller
@RequestMapping("")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getUserPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("key", user);
        return "user";
    }

    /*==========================CRUD=================================*/


    @GetMapping("/admin")
    public String showAllUsers(Model model) {
        // GET /user_list всех людей из DAO и передаём на отображение в представление
        model.addAttribute("key", userService.showAllUsers());

        return "user_list";
    }

    @GetMapping("/user_list/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        // GET /user_list/:id получим одного человека по id из DAO и передаём на отображение в представление
        model.addAttribute("key", userService.showUser(id));
        return "show_user";
    }

    @GetMapping("/user_list/new")
    public String newUser(@ModelAttribute("key") User user) {
        // GET /user_list/new запрос HTML формы для создания записи
        return "new_user";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("key") User user) {
        // POST /user_list создаём новую запись
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/user_list/{id}/edit")
    // GET /user_list/:id/edit HTML форма редактирование записи
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("keyEdit", userService.showUser(id));
        return "edit";
    }

    @PatchMapping("/user_list/{id}")
    // PATCH /user_list/:id HTML форма обновления записи
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("keyEdit") User updateUser) {
        userService.updateUser(id, updateUser);
        return "redirect:/admin";
    }

    @DeleteMapping("/user_list/{id}")
    // DELETE user_list/:id HTML форма удаления записи
    public String delete(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return "redirect:/admin";
    }


}
