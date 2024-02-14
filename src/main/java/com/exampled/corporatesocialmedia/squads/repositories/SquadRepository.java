package com.exampled.corporatesocialmedia.squads.repositories;

import com.exampled.corporatesocialmedia.squads.entities.SquadsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface SquadRepository extends JpaRepository<SquadsEntity, UUID> {

}
