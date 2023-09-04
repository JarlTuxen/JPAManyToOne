package com.example.jpamanytoone.controller;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.model.Region;
import com.example.jpamanytoone.repository.KommuneRepository;
import com.example.jpamanytoone.repository.RegionRepository;
import com.example.jpamanytoone.service.ApiServiceGetRegioner;
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
public class RegionRestController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("/getregioner")
    public List<Region> getRegioner(){
        List<Region> lstRegioner = apiServiceGetRegioner.getRegioner();
        return lstRegioner;
    }


    @DeleteMapping("/region/{id}")
    public ResponseEntity<String> deleteRegion(@PathVariable("id") String id){
        Optional<Region> optionalRegion = regionRepository.findById(id);
        if (optionalRegion.isPresent()){
            regionRepository.deleteById(id);
            return ResponseEntity.ok("Region deleted");
        }
        else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Region not found");
        }
    }



/*
    @DeleteMapping("/region/{id}")
    public ResponseEntity<String> deleteRegion(@PathVariable("id") String id) {
        Optional<Region> optionalRegion = regionRepository.findById(id);
        if (optionalRegion.isPresent()) {
            Region region = optionalRegion.get();

            // Remove references from Kommune entities
            for (Kommune kommune : region.getKommuner()) {
                kommune.setRegion(null);
                kommuneRepository.save(kommune); // Update Kommune entities
                kommuneRepository.deleteById(kommune.getKode());
            }

            regionRepository.deleteById(id);
            return ResponseEntity.ok("Region deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Region not found");
        }
    }
*/

}
