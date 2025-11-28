package com.diario.projetodiario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diario.projetodiario.model.Dorama;
import com.diario.projetodiario.model.User;

public interface DoramaRepository extends JpaRepository<Dorama, Long> {

    List<Dorama> findByUserAndStatus(User user, String status);

}
