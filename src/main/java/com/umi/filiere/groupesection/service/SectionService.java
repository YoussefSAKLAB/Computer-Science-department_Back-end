package com.umi.filiere.groupesection.service;

import com.umi.filiere.groupesection.dto.groupeSection.SectionRequestDTO;
import com.umi.filiere.groupesection.dto.groupeSection.SectionResponseDTO;
import com.umi.filiere.groupesection.entity.Section;

import java.util.List;

public interface SectionService {
    SectionResponseDTO createSection(SectionResponseDTO sectionResponseDTO);
    public List<Section> getAllSections();
    public Section getSectionById(Long id);
    public SectionResponseDTO updateSection(Long id, SectionRequestDTO sectionRequestDTO);
    public Boolean deleteSection(Long id);
}
