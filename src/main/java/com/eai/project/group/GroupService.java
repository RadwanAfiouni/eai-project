package com.eai.project.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> fetchAllGroups() {
        return groupRepository.findAll();
    }

    public Group saveGroup(Group group) {
        group.setName("Group " + group.getId());
        return groupRepository.save(group);
    }

    public Optional<Group> fetchGroupById(Long id) {
        return groupRepository.findById(id);
    }

    public boolean groupExists(Long id) {
        return groupRepository.existsById(id);
    }
}
