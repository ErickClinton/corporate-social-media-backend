package com.exampled.corporatesocialmedia.squads.useCases;

import com.exampled.corporatesocialmedia.squads.dto.GetSquadDTO;
import com.exampled.corporatesocialmedia.squads.repositories.SquadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class ListSquadsByOfficeUseCase {
    private static final Logger logger = Logger.getLogger(ListSquadsByOfficeUseCase.class.getName());
    private final SquadRepository squadRepository;
    public ListSquadsByOfficeUseCase(final SquadRepository squadRepository){
        this.squadRepository = squadRepository;
    }

    public List<GetSquadDTO> listSquadsByOffice(UUID id){
        logger.info("Start useCase listSquadsByOffice - Request - " + id);
        var squads = this.squadRepository.findByIdOffice(id);
        logger.info(("End useCase listSquadsByOffice"));
        return squads.stream().map(GetSquadDTO::new).toList();
    }
}
