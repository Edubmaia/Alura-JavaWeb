package br.com.alura.screenmatch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.screenmatch.entiites.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

}
