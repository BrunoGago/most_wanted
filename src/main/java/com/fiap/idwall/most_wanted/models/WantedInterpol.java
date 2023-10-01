package com.fiap.idwall.most_wanted.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "wanted_interpol")
@Table(name = "TB_WANTED_INTERPOL")
@Data
public class WantedInterpol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 9, nullable = false, unique = true)
    private Long id;

    @Column(name = "FULL_NAME", length = 100)
    private String fullName;

    @Column(name = "AGE", length = 100)
    private String age;

    @Column(name = "NATIONALITY", length = 100)
    private String nationality;

    @Column(name = "IMAGE_URL", length = 300)
    private String imageUrl;

    public WantedInterpol() {
    }

    public WantedInterpol(String fullName, String age, String nationality, String imageUrl) {
        this.fullName = fullName;
        this.age = age;
        this.nationality = nationality;
        this.imageUrl = imageUrl;
    }
}
