package gr.techpro.absence.controller;

import gr.techpro.absence.dto.response.AbsenceResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class AbsenceController {




    @GetMapping("/{id}")
    public AbsenceResponseDTO getAbsence(@PathVariable Long id){}
}
