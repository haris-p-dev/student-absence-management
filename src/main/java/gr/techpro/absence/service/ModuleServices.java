package gr.techpro.absence.service;


import gr.techpro.absence.dto.request.ModuleRequestDTO;
import gr.techpro.absence.dto.response.ModuleResponseDTO;
import gr.techpro.absence.entity.ModuleEntity;
import gr.techpro.absence.exception.DuplicateResourceException;
import gr.techpro.absence.exception.ResourceNotFoundException;
import gr.techpro.absence.repository.ModuleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ModuleServices {

    private final ModuleRepository moduleRepo;

    //create module if not exists
    public ModuleResponseDTO createModule(ModuleRequestDTO request){

        if(moduleRepo.existsByCode(request.getCode())) {
            throw new DuplicateResourceException(
                    "You cannot add a module with code '" +request.getCode()+ "' as it belongs to another module");
        }

        ModuleEntity module = ModuleEntity.builder()
                .code(request.getCode())
                .title(request.getTitle())
                .semester(request.getSemester())
                .acadYear(request.getAcademicYear())
                .build();

        ModuleEntity savedModule = moduleRepo.save(module);

        return ModuleResponseDTO.builder()
                .id(savedModule.getId())
                .code(savedModule.getCode())
                .title(savedModule.getTitle())
                .credits(savedModule.getCredits())
                .semester(savedModule.getSemester())
                .academicYear(savedModule.getAcadYear())
                .build();
    }

    //return all modules to a List
    public List<ModuleResponseDTO> getAllModules(){

        return moduleRepo.findAll()
                .stream().map(moduleEntity -> ModuleResponseDTO.builder()
                                .id(moduleEntity.getId())
                        .code(moduleEntity.getCode())
                        .title(moduleEntity.getTitle())
                        .credits(moduleEntity.getCredits())
                        .semester(moduleEntity.getSemester())
                        .academicYear(moduleEntity.getAcadYear())
                        .createdAt(moduleEntity.getCreatedDate())
                        .build())
                .toList();

    }

    public ModuleResponseDTO getModuleById(Long id){

        ModuleEntity module= moduleRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Module id '"+id+"' not found"));

        return ModuleResponseDTO.builder()
                .id(module.getId())
                .code(module.getCode())
                .title(module.getTitle())
                .credits(module.getCredits())
                .semester(module.getSemester())
                .academicYear(module.getAcadYear())
                .build();

    }

    public ModuleResponseDTO updateModule(Long id, ModuleRequestDTO request){

        ModuleEntity module= moduleRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Module with id '"+id+"' cannot be found."));

        if(moduleRepo.existsByCodeAndIdNot(id,request.getCode())){
            throw new DuplicateResourceException("This module module-code belongs to another module");
        }

        return ModuleResponseDTO.builder()
                .id(module.getId())
                .code(module.getCode())
                .title(module.getTitle())
                .credits(module.getCredits())
                .semester(module.getSemester())
                .academicYear(module.getAcadYear())
                .createdAt(module.getCreatedDate())
                .build();
    }

    public void deleteModule(Long id){
        ModuleEntity module= moduleRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Module with id '"+id+"' cannot be found."));

        moduleRepo.delete(module);
    }



}
