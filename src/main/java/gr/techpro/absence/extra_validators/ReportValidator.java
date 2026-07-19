package gr.techpro.absence.extra_validators;

import gr.techpro.absence.exception.ResourceNotFoundException;
import gr.techpro.absence.repository.ModuleRepository;
import gr.techpro.absence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ReportValidator {

   private final ModuleRepository moduleRepo;
   private final StudentRepository studentRepo;


   public void validateStudentExists(Long studentId) {

       studentRepo.findById(studentId)
               .orElseThrow(() -> new ResourceNotFoundException(
                       "Student not found with id: " + studentId));
   }


    public void validateModuleExists(Long moduleId) {

        moduleRepo.findById(moduleId)
                .orElseThrow(() ->new ResourceNotFoundException(
                        "Module not found with id: " + moduleId));

    }

}
