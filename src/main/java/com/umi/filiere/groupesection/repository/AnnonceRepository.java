package com.umi.filiere.groupesection.repository;

import com.umi.filiere.groupesection.entity.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
    Annonce findAnnonceBySlug(String Slug);
    @Query("SELECT a from Annonce a WHERE a.firstPage=true ORDER BY a.created_at DESC")
    List<Annonce> findAllByFirstPageIsTrueOrderByCreated_atDesc();
    @Query("SELECT a FROM Annonce a ORDER BY a.created_at DESC")
    List<Annonce> findNewestSixAnnonces();

}
