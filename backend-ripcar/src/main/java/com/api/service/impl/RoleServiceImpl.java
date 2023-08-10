package com.api.service.impl;

import com.api.model.roles.Role;
import com.api.repository.RoleRepository;
import com.api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleRepository repository;

    @Override
    public Role createRole(Role role) {
        return repository.save(role);
    }

    @Override
    public List<Role> listRole() {
        return repository.findAll();
    }
}
