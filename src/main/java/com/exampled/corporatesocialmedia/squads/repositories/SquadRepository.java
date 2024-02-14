package com.exampled.corporatesocialmedia.squads.repositories;

import com.exampled.corporatesocialmedia.squads.entities.SquadsEntity;
import com.exampled.corporatesocialmedia.user.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SquadRepository extends JpaRepository<SquadsEntity, UUID> {
    @Query("SELECT u FROM users u WHERE u.id_squad = :squadId")
    List<UsersEntity> findIfSquadHasMember(UUID squadId);
}
