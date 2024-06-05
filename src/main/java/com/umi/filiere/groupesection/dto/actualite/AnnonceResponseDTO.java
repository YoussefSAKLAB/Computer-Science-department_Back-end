package com.umi.filiere.groupesection.dto.actualite;

import com.umi.filiere.groupesection.entity.AnnonceType;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AnnonceResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String slug;
    private Long views;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String featuredImage;
    private Boolean firstPage;
    private AnnonceType annonceType;
}
