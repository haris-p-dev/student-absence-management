package gr.techpro.absence.service;


import gr.techpro.absence.dto.request.ModuleRequestDTO;
import gr.techpro.absence.dto.response.ModuleResponseDTO;
import gr.techpro.absence.entity.ModuleEntity;
import gr.techpro.absence.exception.DuplicateResourceException;
import gr.techpro.absence.repository.ModuleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                .title()


    }




}
