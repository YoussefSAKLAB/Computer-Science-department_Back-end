package com.umi.filiere.groupesection.service;

import com.umi.filiere.groupesection.dto.groupeSection.GroupRequestDTO;
import com.umi.filiere.groupesection.dto.groupeSection.GroupResponseDTO;
import com.umi.filiere.groupesection.entity.Group;

import java.util.List;

public interface GroupService {
    GroupResponseDTO createGroup(GroupResponseDTO groupResponseDTO);
    public List<Group> getAllGroups();
    public Group getGroupById(Long id);
    public GroupResponseDTO updateGroup(Long id, GroupRequestDTO groupRequestDTO);
    public Boolean deleteGroup(Long id);
}
