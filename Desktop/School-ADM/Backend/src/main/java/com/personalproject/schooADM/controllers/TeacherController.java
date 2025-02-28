package com.personalproject.schooADM.controllers;

import com.personalproject.schooADM.entities.Teacher;
import com.personalproject.schooADM.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @GetMapping(value = "/teacher")
    public ResponseEntity<List<Teacher>> getTeachers(){
        List<Teacher> teacherList = teacherService.getTeachers();
        return ResponseEntity.ok().body(teacherList);
    }

    @GetMapping(value = "/teacher/{id}")
    public ResponseEntity<Optional<Teacher>> getTeacherById(@PathVariable String id){
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return ResponseEntity.ok().body(teacher);
    }


}
