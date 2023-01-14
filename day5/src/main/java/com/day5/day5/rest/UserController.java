package com.day5.day5.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.day5.day5.data.User;
import com.day5.day5.services.UserService;
import com.day5.day5.util.ApiResponse;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ApiResponse<User> login(
        @RequestBody User user
    ) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (userService.isValidCredentials(username, password)) {
            return new ApiResponse<User>(
                "Login successful",
                true,
                userService.getUser(username)
            );
        } else {
            return new ApiResponse<User>(
                "Invalid credentials",
                false,
                null
            );
        }
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ApiResponse<User> register(
        @RequestBody User user
    ) {
        if (userService.userExists(user.getUsername())) {
            return new ApiResponse<User>(
                "User already exists",
                false,
                null
            );
        } else {
            user.hashPassword();
            userService.saveUser(user);
            return new ApiResponse<User>(
                "User registered successfully",
                true,
                user
            );
        }
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public ApiResponse<User> logout(
        @RequestBody String username,
        @RequestBody String password
    ) {
        return new ApiResponse<User>(
            "Logout successful",
            true,
            null
        );
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<User> delete(
        @RequestBody String username,
        @RequestBody String password
    ) {
        if (userService.isValidCredentials(username, password)) {
            userService.deleteUser(username);
            return new ApiResponse<User>(
                "User deleted successfully",
                true,
                null
            );
        } else {
            return new ApiResponse<User>(
                "Invalid credentials",
                false,
                null
            );
        }
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public ApiResponse<User> getUser(
        @PathVariable String username
    ) {
        User user = userService.getUser(username);
        if (user == null) {
            return new ApiResponse<User>(
                "User not found",
                false,
                null
            );
        } else {
            return new ApiResponse<User>(
                "User found",
                true,
                user
            );
        }
    }
}
