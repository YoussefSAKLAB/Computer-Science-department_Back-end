package com.umi.filiere.groupesection.mapper;

import com.umi.filiere.groupesection.dto.actualite.AnnonceResponseDTO;
import com.umi.filiere.groupesection.entity.Annonce;
import org.springframework.stereotype.Component;

@Component
public class AnnonceMapper {
    public static AnnonceResponseDTO mapToAnnonceDto(Annonce annonce){
        return new AnnonceResponseDTO(
                annonce.getId(),
                annonce.getTitle(),
                annonce.getContent(),
                annonce.getSlug(),
                annonce.getViews(),
                annonce.getCreated_at(),
                annonce.getUpdated_at(),
                annonce.getFeaturedImage(),
                annonce.getFirstPage(),
                annonce.getAnnonceType()
        );
    }
    public static Annonce mapToAnnonce(AnnonceResponseDTO annonceResponseDTO){
        return new Annonce(
                annonceResponseDTO.getId(),
                annonceResponseDTO.getTitle(),
                annonceResponseDTO.getContent(),
                annonceResponseDTO.getSlug(),
                annonceResponseDTO.getViews(),
                annonceResponseDTO.getCreated_at(),
                annonceResponseDTO.getUpdated_at(),
                annonceResponseDTO.getFeaturedImage(),
                annonceResponseDTO.getFirstPage(),
                annonceResponseDTO.getAnnonceType()
        );
    }
}
