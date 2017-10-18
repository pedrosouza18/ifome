package br.com.pedrosouza.ifome.repository;

import br.com.pedrosouza.ifome.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
