package com.exampled.corporatesocialmedia.squads.controllers;

import com.exampled.corporatesocialmedia.squads.dto.CreateSquadDTO;
import com.exampled.corporatesocialmedia.squads.useCases.CreateSquadUseCase;
import com.exampled.corporatesocialmedia.squads.useCases.DeleteSquadUseCase;
import com.exampled.corporatesocialmedia.squads.useCases.ListSquadsByOfficeUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("/squads")
public class SquadController {

    private static final Logger logger = Logger.getLogger(SquadController.class.getName());
    private final CreateSquadUseCase createSquadUseCase;
    private final DeleteSquadUseCase deleteSquadUseCase;
    private final ListSquadsByOfficeUseCase listSquadsByOfficeUseCase;

    public SquadController(final CreateSquadUseCase createSquadUseCase, final DeleteSquadUseCase deleteSquadUseCase, final ListSquadsByOfficeUseCase listSquadsByOfficeUseCase){
        this.createSquadUseCase = createSquadUseCase;
        this.deleteSquadUseCase = deleteSquadUseCase;
        this.listSquadsByOfficeUseCase = listSquadsByOfficeUseCase;
    }
    @PostMapping("/create")
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    public ResponseEntity createSquad(@RequestBody CreateSquadDTO createSquadDTO){
        try{
            logger.info("Start method createSquad");
            this.createSquadUseCase.execute(createSquadDTO);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            logger.severe("Error method createSquad - Error - " + e.getMessage());
            return ResponseEntity.badRequest().body("Error inserting data");
        }
    }

    // Delete squad
    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    public ResponseEntity deleteSquad(@PathVariable UUID id){
        try{
            logger.info("Start method deleteSquad");
            this.deleteSquadUseCase.execute(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            logger.severe("Error method deleteSquad - Error - " + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // List squads from office
    @GetMapping("/listSquads/{id}")
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    public ResponseEntity listSquadsFromOffice (@PathVariable UUID id){
        try{
            logger.info("Start method deleteSquad");
            var squads = this.listSquadsByOfficeUseCase.listSquadsByOffice(id);
            return ResponseEntity.ok().body(squads);
        }catch (Exception e){
            logger.severe("Error method listSquadsFromOffice - Error - " + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Assign user to squad

}
