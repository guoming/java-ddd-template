package com.example.ddd.ohs.remote.controller;

import com.example.ddd.ohs.local.appservice.UserAppService;
import com.example.ddd.ohs.local.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author guoming
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Resource
    UserAppService userAppService;

    @PutMapping
    public UserDTO create(@RequestBody UserDTO user)
    {
        return userAppService.insert(user);

    }

    @PostMapping
    public UserDTO update(@RequestBody UserDTO user)
    {

        return userAppService.update(user);
    }

    @GetMapping("{userId}")
    public UserDTO get(@PathVariable Long userId)
    {
       return userAppService.selectById(userId);

    }

    @DeleteMapping("{userId}")
    public void delete(@PathVariable Long userId)
    {

        userAppService.delete(userId);
    }

}
