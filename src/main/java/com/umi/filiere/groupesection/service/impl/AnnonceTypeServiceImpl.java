package com.umi.filiere.groupesection.service.impl;

import com.umi.filiere.groupesection.dto.actualite.AnnonceTypeRequestDTO;
import com.umi.filiere.groupesection.dto.actualite.AnnonceTypeResponseDTO;
import com.umi.filiere.groupesection.entity.AnnonceType;
import com.umi.filiere.groupesection.mapper.AnnonceTypeMapper;
import com.umi.filiere.groupesection.repository.AnnonceTypeRepository;
import com.umi.filiere.groupesection.service.AnnonceTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class AnnonceTypeServiceImpl implements AnnonceTypeService {
    @Autowired
    AnnonceTypeRepository annonceTypeRepository;
    @Autowired
    AnnonceTypeMapper annonceTypeMapper;
    @Override
    public AnnonceTypeResponseDTO createAnnonceType(AnnonceTypeResponseDTO annonceTypeResponseDTO) {
        AnnonceType annonceType=annonceTypeMapper.mapToAnnonceType(annonceTypeResponseDTO);
        annonceType.setCreated_at(LocalDateTime.now());
        AnnonceType savedAnnonceType=annonceTypeRepository.save(annonceType);
        return annonceTypeMapper.mapToAnnonceTypeDto(savedAnnonceType);
    }

    @Override
    public List<AnnonceType> getAllAnnoncesType() {
        return annonceTypeRepository.findAll();
    }

    @Override
    public AnnonceType getAnnonceTypeById(Long id) {
        return annonceTypeRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Annonce_Type %s not found !", id)));
    }
    @Override
    public AnnonceTypeResponseDTO updateAnnonceType(Long id, AnnonceTypeRequestDTO annonceTypeRequestDTO) {
        AnnonceType annonceType=AnnonceType.builder()
                .id(id)
                .name(annonceTypeRequestDTO.getName())
                .description(annonceTypeRequestDTO.getDescription())
                .slug(annonceTypeRequestDTO.getSlug())
                .created_at(annonceTypeRequestDTO.getCreated_at())
                .updated_at(LocalDateTime.now())
                .build();
        AnnonceType savedAnnonceType=annonceTypeRepository.save(annonceType);
        AnnonceTypeResponseDTO annonceTypeResponseDTO=annonceTypeMapper.mapToAnnonceTypeDto(savedAnnonceType);
        return annonceTypeResponseDTO;
    }

    @Override
    public Boolean deleteAnnonceType(Long id) {
        annonceTypeRepository.deleteById(id);
        return true;
    }
}
