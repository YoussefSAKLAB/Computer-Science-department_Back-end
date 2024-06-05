package com.umi.filiere.groupesection.controller.actualite;

import com.umi.filiere.groupesection.dto.actualite.AnnonceRequestDTO;
import com.umi.filiere.groupesection.dto.actualite.AnnonceResponseDTO;
import com.umi.filiere.groupesection.dto.actualite.AnnonceTypeRequestDTO;
import com.umi.filiere.groupesection.dto.actualite.AnnonceTypeResponseDTO;
import com.umi.filiere.groupesection.entity.AnnonceType;
import com.umi.filiere.groupesection.service.AnnonceTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/annonceTypes")
public class AnnonceTypeController {
    private AnnonceTypeService annonceTypeService;
    // Get all Annonces
    @GetMapping
    public List<AnnonceType> getAnnonceType(){
        return annonceTypeService.getAllAnnoncesType();
    }
    // Get AnnonceType By Id
    @GetMapping("/{id}")
    public AnnonceType getAnnonceTypeById(@PathVariable Long id){
        return annonceTypeService.getAnnonceTypeById(id);
    }
    //Create a new AnnonceType
    @PostMapping
    public ResponseEntity<AnnonceTypeResponseDTO> createAnnonceType(@RequestBody AnnonceTypeResponseDTO annonceTypeResponseDTO){
        AnnonceTypeResponseDTO savedAnnonceType=annonceTypeService.createAnnonceType(annonceTypeResponseDTO);
        return new ResponseEntity<>(savedAnnonceType, HttpStatus.CREATED);
    }
    // Update AnnonceType
    @PutMapping("/{id}")
    public AnnonceTypeResponseDTO updateAnnonceType(@PathVariable Long id, @RequestBody AnnonceTypeRequestDTO annonceTypeRequestDTO){
        return annonceTypeService.updateAnnonceType(id,annonceTypeRequestDTO);
    }
    // Delete AnnonceType
    @DeleteMapping("/{id}")
    public void deleteAnnonceType(@PathVariable Long id){
        annonceTypeService.deleteAnnonceType(id);
    }
}
