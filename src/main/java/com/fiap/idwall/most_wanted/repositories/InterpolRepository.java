package com.fiap.idwall.most_wanted.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.idwall.most_wanted.models.WantedInterpol;

@Repository
public interface InterpolRepository extends JpaRepository<WantedInterpol, Long> {

}
