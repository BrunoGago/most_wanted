package com.fiap.idwall.most_wanted.models;

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

@Data
@Entity(name = "crime")
@Table(name = "TB_CRIME")
public class Crime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CRIME", length = 9, nullable = false, unique = true)
    private Long id;

    @Column(name = "DESCRIPTION", length = 55, nullable = false)
    private String description;

    @OneToMany(mappedBy = "crime", cascade = CascadeType.ALL)
    private List<Wanted_Crime> wantedCrimes;

}
