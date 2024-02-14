package com.exampled.corporatesocialmedia.squads.useCases;

import com.exampled.corporatesocialmedia.squads.dto.CreateSquadDTO;
import com.exampled.corporatesocialmedia.squads.entities.SquadsEntity;
import com.exampled.corporatesocialmedia.squads.repositories.SquadRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateSquadUseCase {
    private SquadRepository squadRepository;

    public CreateSquadUseCase(final SquadRepository squadRepository){
        this.squadRepository = squadRepository;
    }
    public void execute(CreateSquadDTO squad){
        var newSquad = SquadsEntity.builder()
                .value(squad.value())
                .id_office(squad.id_office())
                .id_manager(squad.id_manager())
                .build();
        this.squadRepository.save(newSquad);
    }
}
