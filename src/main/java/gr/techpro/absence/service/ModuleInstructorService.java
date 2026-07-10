package gr.techpro.absence.service;


import gr.techpro.absence.dto.response.ModuleInstructorResponseDTO;
import gr.techpro.absence.entity.InstructorEntity;
import gr.techpro.absence.entity.ModuleEntity;
import gr.techpro.absence.entity.ModuleInstructorEntity;
import gr.techpro.absence.enums.InstructorRole;
import gr.techpro.absence.exception.DuplicateResourceException;
import gr.techpro.absence.exception.ResourceNotFoundException;
import gr.techpro.absence.repository.InstructorRepository;
import gr.techpro.absence.repository.ModuleInstructorRepository;
import gr.techpro.absence.repository.ModuleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ModuleInstructorService {

    private final ModuleInstructorRepository moduleInstructorRepo;
    private final InstructorRepository instructorRepo;
    private final ModuleRepository moduleRepo;


    public ModuleInstructorResponseDTO assignInstructorToModule(Long instructorId, Long moduleId, InstructorRole role){


        InstructorEntity instructor = instructorRepo.findById(instructorId)
                .orElseThrow(()->new ResourceNotFoundException("Instructor with id '"+instructorId+"' cannot be found"));

        ModuleEntity module= moduleRepo.findById(moduleId)
                .orElseThrow(()->new ResourceNotFoundException("Module with id '"+moduleId+"' cannot be found"));


        if(moduleInstructorRepo.combinationExists(moduleId,instructorId)) {
            throw new DuplicateResourceException("Instructor "+instructor.getFirstName()+" is already registered in this module "+module.getTitle());
        };

        ModuleInstructorEntity completedEntry = new ModuleInstructorEntity();

        completedEntry.setModule(module);
        completedEntry.setInstructor(instructor);
        completedEntry.setRole(role);

        ModuleInstructorEntity saved = moduleInstructorRepo.save(completedEntry);

        return ModuleInstructorResponseDTO.from(saved);

    }


    public String removeRelationship(Long instructorId, Long moduleId){

        InstructorEntity instructor = instructorRepo.findById(instructorId)
                .orElseThrow(()->new ResourceNotFoundException("Instructor with id '"+instructorId+"' cannot be found"));

        ModuleEntity module= moduleRepo.findById(moduleId)
                .orElseThrow(()->new ResourceNotFoundException("Module with id '"+moduleId+"' cannot be found"));

        if(!moduleInstructorRepo.combinationExists(moduleId,instructorId)) {
                 throw new DuplicateResourceException("Instructor "+instructor.getFirstName()+" is NOT registered in this module "+module.getTitle());
        };

        ModuleInstructorEntity relation = moduleInstructorRepo
                .findByInstructorIdAndModuleId(instructorId,moduleId)
                .orElseThrow(() ->new ResourceNotFoundException("Instructor is not assigned in this module")
                        );


        moduleInstructorRepo.delete(relation);

        return "Instructor "+instructor.getFirstName()+" has been removed from "+module.getTitle();
    }


    public List<ModuleInstructorResponseDTO> getModulesOfInstructor(Long instructorId){

       instructorRepo.findById(instructorId)
                .orElseThrow(()->new ResourceNotFoundException("Instructor with id '"+instructorId+"' cannot be found"));

        List <ModuleInstructorEntity> relationships = moduleInstructorRepo.findByInstructorId(instructorId);

        if(relationships.isEmpty()){
            throw new ResourceNotFoundException(
                    "Instructor does NOT teach any module at the moment." );
        }

        return relationships.stream()
                .map(entity -> ModuleInstructorResponseDTO.from(entity))
                .toList();
    }


    public List<ModuleInstructorResponseDTO> getInstructorsOfSameModule(Long moduleId){
        moduleRepo.findById(moduleId)
                .orElseThrow(()->new ResourceNotFoundException("Module with id '"+moduleId+"' cannot be found"));

        List<ModuleInstructorEntity> relationships =
                moduleInstructorRepo.findByModuleId(moduleId);

        if(relationships.isEmpty()){
            throw new ResourceNotFoundException(
                    "This module has no teachers attached yet." );
        }
        return relationships.stream()
                .map(entity -> ModuleInstructorResponseDTO.from(entity))
                .toList();

    }


}
