package com.exampled.corporatesocialmedia.squads.useCases;

import com.exampled.corporatesocialmedia.squads.repositories.SquadRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class DeleteSquadUseCase {
    private final SquadRepository squadRepository;
    public DeleteSquadUseCase(final SquadRepository squadRepository){
        this.squadRepository = squadRepository;
    }
    public void execute(UUID id) throws Exception{
        var users = this.squadRepository.findIfSquadHasMember(id);
        System.out.println(users);
        if(!users.isEmpty()) throw new Exception("Squad still has members");
        this.squadRepository.deleteById(id);
    }
}
