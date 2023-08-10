package com.api.controller;

import com.api.model.roles.Role;
import com.api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService service;

    @PostMapping
    public Role create(@RequestBody Role role){
        return service.createRole(role);
    }

    @GetMapping
    public List<Role> listRoles(){
        return service.listRole();
    }
}
