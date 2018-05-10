package com.ericardo.login_reg.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ericardo.login_reg.models.User;
import com.ericardo.login_reg.repositories.RoleRepository;
import com.ericardo.login_reg.repositories.UserRepository;


@Service
public class UserService {
    private UserRepository _uR;
    private RoleRepository _rR;
    private BCryptPasswordEncoder _brcypt;
    
    public UserService(UserRepository _uR, RoleRepository _rR, BCryptPasswordEncoder _brcypt)     {
        this._uR = _uR;
        this._rR = _rR;
        this._brcypt = _brcypt;
    }
    
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(_brcypt.encode(user.getPassword()));
        user.setRoles(_rR.findByName("ROLE_USER"));
        _uR.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(_brcypt.encode(user.getPassword()));
        user.setRoles(_rR.findByName("ROLE_ADMIN"));
        _uR.save(user);
    }    
    
    // Find by username
    public User findByUsername(String username) {
        return _uR.findByUsername(username);
    }
    
    // Find by email
    public User findByEmail(String email) {
    		return _uR.findByEmail(email);
    }
    
}