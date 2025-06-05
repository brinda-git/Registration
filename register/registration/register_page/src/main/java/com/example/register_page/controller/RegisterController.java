package com.example.register_page.controller;

import com.example.register_page.model.Register;
import com.example.register_page.repository.RegisterRepository;
import com.example.register_page.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired
    //created
    RegisterService registerService;
    public RegisterController(RegisterService registerService)

    {
        this.registerService = registerService;
    }

    @Autowired
    private RegisterRepository registerRepository;



//    private static final List<Register> users = new ArrayList<>();
//
//    static {
//        // Adding some dummy data to the list
//        users.add(new Register("user1", "a", "a@a", "a1", "a1"));
//        users.add(new Register("user2", "b", "b@b", "b@b", "b1"));
//        users.add(new Register("user3", "c", "c@c", "c@c", "c1"));
//        users.add(new Register("user4", "d", "d@d", "d@d", "d1"));
//        users.add(new Register("user5", "e", "e@e", "e@e", "e1"));
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Register> getRegisterDetails(@PathVariable String id) {
//        Optional<Register> user = users.stream()
//                .filter(register -> register.getId().equals(id))
//                .findFirst();
//
//        if (user.isPresent()) {
//            return ResponseEntity.ok(user.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

//    @PostMapping
//    public ResponseEntity<String> createRegister1(@RequestBody Register register) {
//        // Check if user with same ID already exists
//        boolean exists = users.stream()
//                .anyMatch(existing -> existing.getId().equals(register.getId()));
//
//        if (exists) {
//            return ResponseEntity.status(HttpStatus.CONFLICT)
//                    .body("User with ID " + register.getId() + " already exists");
//        }
//
//        users.add(register);
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body("Registration successful for ID: " + register.getId());
//    }


//    @GetMapping
//    public List<Register> getAllRegisters() {
//        return new ArrayList<>(users);
//
//
//    }
@CrossOrigin(origins = "*")
@PostMapping("/register")
    public ResponseEntity<String> createRegister(@RequestBody Register register) {

        // Check if user with same ID exists
        if (registerRepository.existsById(register.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("User with ID " + register.getId() + " already exists");
        }

        // Password match check
        if (!register.getPassword().equals(register.getConfirmpassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Password and Confirm Password do not match");
        }

        // Save user
        registerRepository.save(register);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Registration successful for ID: " + register.getId());
    }
}


