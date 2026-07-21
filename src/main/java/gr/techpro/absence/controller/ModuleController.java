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
    @GetMapping("/modules/{moduleId}")
    public ModuleResponseDTO getModule(@PathVariable Long moduleId){
        return moduleServices.getModuleById(moduleId);
    }

    //update a module
    @PutMapping("/modules/{moduleId}")
    public ModuleResponseDTO update(@PathVariable Long moduleId,@Valid @RequestBody ModuleRequestDTO request){
        return moduleServices.updateModule(moduleId,request);
    }

    //delete a module
    @DeleteMapping("/modules/{moduleId}")
    public void deleteModule(@PathVariable Long moduleId){
         moduleServices.deleteModule(moduleId);
    }


}
