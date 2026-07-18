package gr.techpro.absence.controller;

import gr.techpro.absence.dto.request.ModuleRequestDTO;
import gr.techpro.absence.dto.response.ModuleResponseDTO;
import gr.techpro.absence.service.ModuleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService moduleServices;

    //create a module
    @PostMapping("/modules")
    public ModuleResponseDTO createModule(@Valid @RequestBody ModuleRequestDTO request){
        return moduleServices.createModule(request);

    }
    //return all modules

    @GetMapping("/modules")
    public List<ModuleResponseDTO> getAllModules(){
        return moduleServices.getAllModules();
    }

    //get modules by id
    @GetMapping("/modules/{id}")
    public ModuleResponseDTO getModule(@PathVariable Long id){
        return moduleServices.getModuleById(id);
    }

    //update a module
    @PutMapping("/modules/{id}")
    public ModuleResponseDTO update(@PathVariable Long id,@Valid @RequestBody ModuleRequestDTO request){
        return moduleServices.updateModule(id,request);
    }

    //delete a module
    @DeleteMapping("/modules/{id}")
    public void deleteModule(@PathVariable Long id){
         moduleServices.deleteModule(id);
    }


}
