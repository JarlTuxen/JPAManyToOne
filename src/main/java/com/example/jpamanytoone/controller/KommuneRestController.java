package com.example.jpamanytoone.controller;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.repository.KommuneRepository;
import com.example.jpamanytoone.service.ApiServiceGetKommuner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class KommuneRestController {

    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("/getkommuner")
    public List<Kommune> getKommuner(){
        List<Kommune> kommuneList = apiServiceGetKommuner.getKommuner();
        return kommuneList;
    }

    @DeleteMapping("/kommune/{id}")
    public ResponseEntity<String> deleteKommune(@PathVariable("id") String id){
        Optional<Kommune> optionalKommune = kommuneRepository.findById(id);
        if (optionalKommune.isPresent()){
            kommuneRepository.deleteById(id);
            return ResponseEntity.ok("Kommune deleted");
        }
        else {
            //return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kommune not found");
        }
    }
}
