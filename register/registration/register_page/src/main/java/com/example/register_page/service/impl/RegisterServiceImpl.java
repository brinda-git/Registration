package com.example.register_page.service.impl;

import com.example.register_page.model.Register;
import com.example.register_page.service.RegisterService;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Override
    public String createRegister(Register register) {
        // Placeholder logic – replace with your real registration logic
        return "User " + register.getName() + " registered successfully!";
    }




}
