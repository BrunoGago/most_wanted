package com.fiap.idwall.most_wanted.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "wanted_crime")
@Table(name = "TB_WANTED_CRIME")
public class Wanted_Crime {

    @Column(name = "ID_WANTED", length = 9, nullable = false, unique = true)
    private Long wantedId;

    @Column(name = "ID_CRIME", length = 9, nullable = false, unique = true)
    private Long crimesId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_WANTED", nullable = false)
    private Wanted wanted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CRIME", nullable = false)
    private Crime crime;
}
