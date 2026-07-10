package gr.techpro.absence.service;


import gr.techpro.absence.dto.request.InstructorRequestDTO;
import gr.techpro.absence.dto.response.InstructorResponseDTO;
import gr.techpro.absence.entity.InstructorEntity;
import gr.techpro.absence.exception.DuplicateResourceException;
import gr.techpro.absence.exception.ResourceNotFoundException;
import gr.techpro.absence.repository.InstructorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InstructorServices {

    private final InstructorRepository instructorRepo;
    
//    createInstructor()

    public InstructorResponseDTO createInstructor(InstructorRequestDTO request) {
//throws exception if email already exists
        if (instructorRepo.existsByEmail(request.getEmail())) {
            throw new ResourceNotFoundException("An Instructor with email '" + request.getEmail() + "' already exists");
        }

//map dto to the relevant Entity
        InstructorEntity instructor = InstructorEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

//saving the new entity via Repository
        InstructorEntity updated = instructorRepo.save(instructor);

        return InstructorResponseDTO.from(updated);

}

//    getInstructorById()

    public InstructorResponseDTO getInstructorById(Long id) {

        InstructorEntity instructorEntity = instructorRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Instructor with id " + id + " was not found."));

        return  InstructorResponseDTO.from(instructorEntity);

    }

//    getAllInstructors()

    public List<InstructorResponseDTO> getAllInstructors() {

        return instructorRepo.findAll()
                .stream()
                .map(instructor -> InstructorResponseDTO.from(instructor))
                .toList();
    }
//    updateInstructor()

    public InstructorResponseDTO updateInstructor(Long id,InstructorRequestDTO request){

        InstructorEntity instructorEntity = instructorRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Instructor with id " + id + " cannot be found."));


        if(instructorRepo.existsByEmailAndIdNot(id,request.getEmail())){
            throw new DuplicateResourceException("This email is belongs to another instructor");
        }

        instructorEntity.setFirstName(request.getFirstName());
        instructorEntity.setLastName(request.getLastName());
        instructorEntity.setEmail(request.getEmail());
        InstructorEntity updated = instructorRepo.save(instructorEntity);

        return  InstructorResponseDTO.from(updated);
    }

//    deleteInstructor()
public void deleteInstructor(Long id){
    InstructorEntity instructorEntity = instructorRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor with id " + id + " cannot be found."));
    instructorRepo.delete(instructorEntity);
}

}
