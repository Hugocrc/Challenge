package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Interface MovieRepository que permite executar operações relacionadas ao banco de dados para a entidade Movie
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Método personalizado do repositório para encontrar o ID máximo
    @Query(value = "SELECT max(id) FROM Movie")
    Long findMaxId();
}
