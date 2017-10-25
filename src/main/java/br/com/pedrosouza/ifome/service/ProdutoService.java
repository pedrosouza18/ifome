package br.com.pedrosouza.ifome.service;

import br.com.pedrosouza.ifome.domain.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> listarProdutos();

    void deletarProduto(Long id);

    void criarProduto(Produto produto);

    void atualizarProduto(Long id, Produto produto);

    Produto buscarProduto(Long id);
}
