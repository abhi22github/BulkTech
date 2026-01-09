package com.Website.BulkTech.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class loginController {

    @GetMapping(value = "/login/{role}")
    public String viewRole(@PathVariable String role){
       if(role.equals("Admin"))return "admin-dashboard";
       return "trainer-dashboard";

    }
}
