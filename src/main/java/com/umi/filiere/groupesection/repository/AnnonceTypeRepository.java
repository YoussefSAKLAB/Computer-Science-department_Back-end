package com.umi.filiere.groupesection.repository;

import com.umi.filiere.groupesection.entity.AnnonceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceTypeRepository extends JpaRepository<AnnonceType,Long> {
}
