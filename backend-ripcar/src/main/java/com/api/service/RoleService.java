package com.api.service;

import com.api.model.roles.Role;
import com.api.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RoleService {

    public Role createRole(Role role);

    public List<Role> listRole();


}
