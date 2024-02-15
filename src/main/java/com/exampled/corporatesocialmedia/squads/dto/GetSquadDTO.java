package com.exampled.corporatesocialmedia.squads.dto;

import com.exampled.corporatesocialmedia.squads.entities.SquadsEntity;
import com.exampled.corporatesocialmedia.user.dto.GetUserDTO;

import java.util.UUID;

public record GetSquadDTO(
        UUID id,
        String value,
        UUID id_office,
        UUID id_manager
) {
    public GetSquadDTO(SquadsEntity squad){
        this(squad.getId(), squad.getValue(), squad.getId_office(), squad.getId_manager());
    }
}
