package br.com.emersonmorgado.aluraflix.aluraflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

}
