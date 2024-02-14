package com.exampled.corporatesocialmedia.squads.controllers;

import com.exampled.corporatesocialmedia.squads.dto.CreateSquadDTO;
import com.exampled.corporatesocialmedia.squads.useCases.CreateSquadUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/squads")
public class SquadController {

    private CreateSquadUseCase createSquadUseCase;

    public SquadController(final CreateSquadUseCase createSquadUseCase){
        this.createSquadUseCase = createSquadUseCase;
    }
    @PostMapping("/create")
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    public ResponseEntity createSquad(@RequestBody CreateSquadDTO createSquadDTO){
        this.createSquadUseCase.execute(createSquadDTO);
        return ResponseEntity.ok().build();
    }
}
