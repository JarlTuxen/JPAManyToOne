package com.example.jpamanytoone.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter

@Entity
public class Kommune {

    @Id
    @Column(length = 4)
    private String kode;
    private String navn;
    private String href;

    @ManyToOne
    @JoinColumn( name = "region", referencedColumnName = "kode")
    Region region;

}
