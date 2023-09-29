package com.fiap.idwall.most_wanted.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "wanted")
@Table(name = "TB_WANTED")
@Data
public class Wanted {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_WANTED", length = 9, nullable = false, unique = true)
    private Long id;

    @Column(name = "FULL_NAME", length = 55, nullable = false)
    private String fullName;

    @Column(name = "BIRTH_DATE", nullable = false)
    private Date birthDate;

    @Column(name = "GENDER", length = 1, nullable = false)
    private char gender;

    @OneToMany(mappedBy = "wanted", cascade = CascadeType.ALL)
    private List<Wanted_Crime> wantedCrimes;
    
}
