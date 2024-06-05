package com.umi.filiere.groupesection.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "annonce")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title" , nullable = false)
    private String title;
    @Column(name = "content" , nullable = false)
    private String content;
    @Column(name = "slug", nullable = false,unique = true)
    private String slug;
    @Column(name = "views", nullable = false)
    private Long views;
    @Column(name = "created_at", nullable = true)
    private LocalDateTime created_at;
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updated_at;
    @Column(name = "featuredImage", nullable = true)
    private String featuredImage;
    @Column(name = "firstPage", nullable = true)
    private Boolean firstPage;
    @ManyToOne
    @JoinColumn(name = "annonceType_id")
    private AnnonceType annonceType;
}
