package com.exampled.corporatesocialmedia.squads.useCases;

import com.exampled.corporatesocialmedia.squads.dto.CreateSquadDTO;
import com.exampled.corporatesocialmedia.squads.entities.SquadsEntity;
import com.exampled.corporatesocialmedia.squads.repositories.SquadRepository;
import com.exampled.corporatesocialmedia.user.useCase.CreateUserUseCase;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CreateSquadUseCase {
    private static final Logger logger = Logger.getLogger(CreateUserUseCase.class.getName());
    private final SquadRepository squadRepository;

    public CreateSquadUseCase(final SquadRepository squadRepository){
        this.squadRepository = squadRepository;
    }
    public void execute(CreateSquadDTO squad){
        logger.info("Start useCase CreateSquad - Request - " + squad);
        var newSquad = SquadsEntity.builder()
                .value(squad.value())
                .id_office(squad.id_office())
                .id_manager(squad.id_manager())
                .build();
        var result = this.squadRepository.save(newSquad);
        logger.info("End useCase CreateSquad - Response - " + result);
    }
}
