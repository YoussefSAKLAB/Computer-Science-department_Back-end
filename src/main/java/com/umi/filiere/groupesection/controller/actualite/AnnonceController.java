package com.umi.filiere.groupesection.controller.actualite;

import com.umi.filiere.groupesection.dto.actualite.AnnonceRequestDTO;
import com.umi.filiere.groupesection.dto.actualite.AnnonceResponseDTO;
import com.umi.filiere.groupesection.entity.Annonce;
import com.umi.filiere.groupesection.service.AnnonceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/annonces")
public class AnnonceController {
    private AnnonceService annonceService;
    // Get all Annonces
    @GetMapping
    public List<Annonce> getAnnonce(){
        return annonceService.getAllAnnonces();
    }
    @GetMapping("/latest")
    public List<Annonce>getNewestSixAnnonces(){
        return annonceService.getNewestSixAnnonces();
    }
    @GetMapping("/slider")
    public List<Annonce>getSliderAnnonces(){
        return annonceService.getSliderAnnonce();
    }
    @GetMapping("/slug/{slug}")
    public Annonce getAnnonceBySlug(@PathVariable String slug){
        return annonceService.getAnnonceBySlug(slug);
    }
    // Get Annonce By Id
    @GetMapping("/{id}")
    public Annonce getAnnonceById(@PathVariable Long id){
        return annonceService.getAnnonceById(id);
    }
    //Create a new Annonce
    @PostMapping
    public ResponseEntity<AnnonceResponseDTO> createAnnonce(@ModelAttribute AnnonceResponseDTO annonceResponseDTO
            ,@RequestParam("file") MultipartFile file){
        String fileName="";
        try {
            // Save the file to a specific location or process it as needed
            fileName = file.getOriginalFilename();
            File convertFile = new File("/Users/youssefsaklab/Documents/Info_Dep/UserEnd/src/assets/img/uploads/" + fileName);
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        annonceResponseDTO.setFeaturedImage(fileName);
        AnnonceResponseDTO savedAnnonce=annonceService.createAnnonce(annonceResponseDTO);
        return new ResponseEntity<>(savedAnnonce, HttpStatus.CREATED);
    }
    // Update Annonce
    @PutMapping("/{id}")
    public AnnonceResponseDTO updateAnnonce(@PathVariable Long id, @RequestBody AnnonceRequestDTO annonceRequestDTO){
        return annonceService.updateAnnonce(id,annonceRequestDTO);
    }
    // Delete Annonce
    @DeleteMapping("/{id}")
    public void deleteAnnonce(@PathVariable Long id){
        annonceService.deleteAnnonce(id);
    }
}
