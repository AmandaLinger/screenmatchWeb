package br.com.estudos.screenmatchWeb.domain.filme;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> { //facilita realizar o CRUD
}
