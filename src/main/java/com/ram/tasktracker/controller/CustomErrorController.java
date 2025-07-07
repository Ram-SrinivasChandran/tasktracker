package com.ram.tasktracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class CustomErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    public String handleError() {
        return "Custom error message: Page not found!";
    }
}
