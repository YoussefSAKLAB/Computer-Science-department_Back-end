package com.umi.filiere.groupesection.service.impl;

import com.umi.filiere.groupesection.dto.actualite.AnnonceRequestDTO;
import com.umi.filiere.groupesection.dto.actualite.AnnonceResponseDTO;
import com.umi.filiere.groupesection.entity.Annonce;
import com.umi.filiere.groupesection.mapper.AnnonceMapper;
import com.umi.filiere.groupesection.repository.AnnonceRepository;
import com.umi.filiere.groupesection.service.AnnonceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class AnnonceServiceImpl implements AnnonceService {
    @Autowired
    public AnnonceRepository annonceRepository;
    @Autowired
    public AnnonceMapper annonceMapper;
    @Override
    public AnnonceResponseDTO createAnnonce(AnnonceResponseDTO annonceResponseDTO) {
        Annonce annonce=annonceMapper.mapToAnnonce(annonceResponseDTO);
        annonce.setCreated_at(LocalDateTime.now());
        annonce.setViews(0L);
        Annonce savedAnnonce=annonceRepository.save(annonce);
        return annonceMapper.mapToAnnonceDto(savedAnnonce);
    }

    @Override
    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    @Override
    public List<Annonce> getNewestSixAnnonces() {
        return annonceRepository.findNewestSixAnnonces();
    }

    @Override
    public List<Annonce> getSliderAnnonce() {
        return annonceRepository.findAllByFirstPageIsTrueOrderByCreated_atDesc();
    }

    @Override
    public Annonce getAnnonceById(Long id) {
        return annonceRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Annonce %s not found !", id)));
    }

    @Override
    public Annonce getAnnonceBySlug(String Slug) {
        return annonceRepository.findAnnonceBySlug(Slug);
    }

    @Override
    public AnnonceResponseDTO updateAnnonce(Long id, AnnonceRequestDTO annonceRequestDTO) {
        Annonce annonce=Annonce.builder()
                .id(id)
                .title(annonceRequestDTO.getTitle())
                .content(annonceRequestDTO.getContent())
                .slug(annonceRequestDTO.getSlug())
                .views(annonceRequestDTO.getViews())
                .created_at(annonceRequestDTO.getCreated_at())
                .updated_at(LocalDateTime.now())
                .featuredImage(annonceRequestDTO.getFeaturedImage())
                .firstPage(annonceRequestDTO.getFirstPage())
                .annonceType(annonceRequestDTO.getAnnonceType())
                .build();
        Annonce savedAnnonce=annonceRepository.save(annonce);
        AnnonceResponseDTO annonceResponseDTO=annonceMapper.mapToAnnonceDto(savedAnnonce);
        return annonceResponseDTO;
    }

    @Override
    public Boolean deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
        return true;
    }
}
