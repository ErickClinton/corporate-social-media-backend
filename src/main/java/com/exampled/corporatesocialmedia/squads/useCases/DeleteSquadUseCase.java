package com.exampled.corporatesocialmedia.squads.useCases;

import com.exampled.corporatesocialmedia.squads.repositories.SquadRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class DeleteSquadUseCase {
    private static final Logger logger = Logger.getLogger(DeleteSquadUseCase.class.getName());
    private final SquadRepository squadRepository;
    public DeleteSquadUseCase(final SquadRepository squadRepository){
        this.squadRepository = squadRepository;
    }
    public void execute(UUID id) throws Exception{
        logger.info("Start useCase DeleteSquad - Request -" + id);
        var users = this.squadRepository.findIfSquadHasMember(id);
        System.out.println(users);
        if(!users.isEmpty()){
            logger.severe("Error useCase DeleteSquad - Error - Squad still has members");
            throw new Exception("Squad still has members");
        };
        this.squadRepository.deleteById(id);
        logger.info("End useCase DeleteSquad");
    }
}
