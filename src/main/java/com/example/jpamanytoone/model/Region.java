package com.example.jpamanytoone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
public class Region {

    @Id
    @Column(length = 4)
    private String kode;
    private String navn;
    private String href;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "region")
    @JsonBackReference
    private Set<Kommune> kommuner = new HashSet<>();

}
