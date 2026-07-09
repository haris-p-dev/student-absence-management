package gr.techpro.absence.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class ModuleController {

    @PostMapping("/modules")


    //return all modules
    @GetMapping("/modules")

    //get modules by id
    @GetMapping("/modules")

    //update a module
    @PostMapping("/modules/{id}")
}
