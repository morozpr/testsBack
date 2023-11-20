package com.example.testsBack.services;

import com.example.testsBack.entities.StudentsGroup;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.RoleRepository;
import com.example.testsBack.repositories.StudentsGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsGroupService {
    private final StudentsGroupRepository studentsGroupRepository;
    public StudentsGroupService(StudentsGroupRepository studentsGroupRepository) {
        this.studentsGroupRepository = studentsGroupRepository;
    }
    public StudentsGroup postObject(StudentsGroup studentsGroup) throws BadRequest {
        List<StudentsGroup> check = studentsGroupRepository.findByStudentsGroupName(studentsGroup.getStudentsGroupName());
        if (check == null) {
            throw new BadRequest("Bad Request.");
        }
        return studentsGroupRepository.save(studentsGroup); /*  С большой буквы это тип данных, а с маленькой переменная */
    }

    public StudentsGroup getObject(Long id) throws BadRequest {
        if (studentsGroupRepository.findById(id) == null) {
            throw new BadRequest("Object not found.");
        }
        return studentsGroupRepository.findById(id).get();
    }

    public Iterable<StudentsGroup> getAllObjects() {
        return studentsGroupRepository.findAll();
    }

    public StudentsGroup editObject(StudentsGroup studentsGroup, Long id) throws BadRequest {
        if (studentsGroupRepository.findById(id) == null) {
            throw new BadRequest("Object not found.");
        }
        studentsGroupRepository.updateStudentsGroupNameById(studentsGroup.getStudentsGroupName(), id);
        return studentsGroupRepository.findById(id).get();
    }

    public void deleteObject(Long id) throws BadRequest {
        if (studentsGroupRepository.findById(id) == null) {
            throw new BadRequest("Object not found.");
        }
        studentsGroupRepository.deleteById(id);
    }
}
