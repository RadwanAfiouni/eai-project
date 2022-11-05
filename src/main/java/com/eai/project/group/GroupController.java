package com.eai.project.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/group")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Group>> getAllGroups() {
        return new ResponseEntity<>(groupService.fetchAllGroups(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Group>> getGroupById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(groupService.fetchGroupById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Group> saveGroup(Group group) {
        return new ResponseEntity<>(groupService.saveGroup(group), HttpStatus.OK);
    }

}
