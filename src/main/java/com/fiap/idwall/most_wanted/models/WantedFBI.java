package com.fiap.idwall.most_wanted.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "wanted_fbi")
@Table(name = "TB_WANTED_FBI")
@Data
public class WantedFBI implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 9, nullable = false, unique = true)
    private Long id;

    @Column(name = "CRIME", length = 55, nullable = false)
    private String crime;

    @Column(name = "FULL_NAME", length = 55, nullable = false)
    private String fullName;

    @Column(name = "DETAILS_URL", length = 100, nullable = false)
    private String detailsUrl;

    @Column(name = "IMAGE_URL", length = 100, nullable = false)
    private String imageUrl;

    public WantedFBI(String crime, String name, String detailsUrl, String imageUrl) {
        this.crime = crime;
        this.fullName = name;
        this.detailsUrl = detailsUrl;
        this.imageUrl = imageUrl;
    }
}
