package com.app.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CorsController {
    @GetMapping("/cors")
    public String cors() {
        return "cors";
    }
}
