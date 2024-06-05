package com.umi.filiere.groupesection.service;


import com.umi.filiere.groupesection.dto.actualite.AnnonceRequestDTO;
import com.umi.filiere.groupesection.dto.actualite.AnnonceResponseDTO;
import com.umi.filiere.groupesection.entity.Annonce;

import java.util.List;

public interface AnnonceService {
    AnnonceResponseDTO createAnnonce(AnnonceResponseDTO annonceResponseDTO);
    public List<Annonce> getAllAnnonces();
    public List<Annonce> getNewestSixAnnonces();
    public List<Annonce> getSliderAnnonce();
    public Annonce getAnnonceById(Long id);
    public Annonce getAnnonceBySlug(String Slug);
    public AnnonceResponseDTO updateAnnonce(Long id, AnnonceRequestDTO annonceRequestDTO);
    public Boolean deleteAnnonce(Long id);
}
