package com.fiap.idwall.most_wanted.models;

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
<<<<<<< HEAD:src/main/java/com/fiap/idwall/most_wanted/models/WantedFBI.java
public class WantedFBI {
=======
public class Wanted {
    
>>>>>>> 85963ef00ccf0e96ebfa20cc00fdfbe21f7a3282:src/main/java/com/fiap/idwall/most_wanted/models/Wanted.java
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
