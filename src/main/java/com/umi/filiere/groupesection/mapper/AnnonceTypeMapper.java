package com.umi.filiere.groupesection.mapper;

import com.umi.filiere.groupesection.dto.actualite.AnnonceTypeResponseDTO;
import com.umi.filiere.groupesection.entity.AnnonceType;
import org.springframework.stereotype.Component;

@Component
public class AnnonceTypeMapper {
    public static AnnonceTypeResponseDTO mapToAnnonceTypeDto(AnnonceType annonceType){
        return new AnnonceTypeResponseDTO(
                annonceType.getId(),
                annonceType.getName(),
                annonceType.getDescription(),
                annonceType.getSlug(),
                annonceType.getCreated_at(),
                annonceType.getUpdated_at()
        );
    }
    public static AnnonceType mapToAnnonceType(AnnonceTypeResponseDTO annonceTypeResponseDTO){
        return new AnnonceType(
                annonceTypeResponseDTO.getId(),
                annonceTypeResponseDTO.getName(),
                annonceTypeResponseDTO.getDescription(),
                annonceTypeResponseDTO.getSlug(),
                annonceTypeResponseDTO.getCreated_at(),
                annonceTypeResponseDTO.getUpdated_at()
        );
    }
}
