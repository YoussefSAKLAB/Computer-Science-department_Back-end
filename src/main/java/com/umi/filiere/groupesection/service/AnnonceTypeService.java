package com.umi.filiere.groupesection.service;


import com.umi.filiere.groupesection.dto.actualite.AnnonceTypeRequestDTO;
import com.umi.filiere.groupesection.dto.actualite.AnnonceTypeResponseDTO;
import com.umi.filiere.groupesection.entity.AnnonceType;

import java.util.List;

public interface AnnonceTypeService {
    AnnonceTypeResponseDTO createAnnonceType(AnnonceTypeResponseDTO annonceTypeResponseDTO);
    public List<AnnonceType> getAllAnnoncesType();
    public AnnonceType getAnnonceTypeById(Long id);
    public AnnonceTypeResponseDTO updateAnnonceType(Long id, AnnonceTypeRequestDTO annonceTypeRequestDTO);
    public Boolean deleteAnnonceType(Long id);
}
