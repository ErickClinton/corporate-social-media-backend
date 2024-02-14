package com.exampled.corporatesocialmedia.squads.controllers;

import com.exampled.corporatesocialmedia.squads.dto.CreateSquadDTO;
import com.exampled.corporatesocialmedia.squads.useCases.CreateSquadUseCase;
import com.exampled.corporatesocialmedia.squads.useCases.DeleteSquadUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/squads")
public class SquadController {

    private final CreateSquadUseCase createSquadUseCase;
    private final DeleteSquadUseCase deleteSquadUseCase;

    public SquadController(final CreateSquadUseCase createSquadUseCase, final DeleteSquadUseCase deleteSquadUseCase){
        this.createSquadUseCase = createSquadUseCase;
        this.deleteSquadUseCase = deleteSquadUseCase;
    }
    @PostMapping("/create")
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    public ResponseEntity createSquad(@RequestBody CreateSquadDTO createSquadDTO){
        this.createSquadUseCase.execute(createSquadDTO);
        return ResponseEntity.ok().build();
    }

    // Delete squad
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSquad(@PathVariable UUID id){
        try{
            this.deleteSquadUseCase.execute(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // List squads from office

    // Assign user to squad

}
