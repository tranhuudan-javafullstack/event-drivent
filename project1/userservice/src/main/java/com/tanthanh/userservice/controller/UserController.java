package com.tanthanh.userservice.controller;

import com.tanthanh.userservice.data.Role;
import com.tanthanh.userservice.data.User;
import com.tanthanh.userservice.model.AddRoleToUser;
import com.tanthanh.userservice.model.UserDTO;
import com.tanthanh.userservice.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @GetMapping("/listUser")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/listRole")
    public List<Role> getAllRole() {
        return userService.getAllRole();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/addRoleToUser")
    public void addRoleToUser(@RequestBody AddRoleToUser model) {
        userService.addRole(model.getUsername(), model.getRolename());
    }

    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role role) {
        return userService.saveRole(role);
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody UserDTO dto) {
        return userService.login(dto.getUsername(), dto.getPassword());
    }

    @PostMapping("/validateToken")
    public UserDTO validateToken(@RequestBody UserDTO dto) {
        return userService.validateToken(dto.getToken());
    }


    @GetMapping
    public String homePage() {
        return "Day la trang chu";
    }
}
