package com.franquicias.app.repositories;

import com.franquicias.app.models.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
}
