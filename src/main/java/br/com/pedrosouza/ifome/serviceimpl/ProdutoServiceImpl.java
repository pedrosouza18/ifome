package br.com.pedrosouza.ifome.serviceimpl;

import br.com.pedrosouza.ifome.domain.Produto;
import br.com.pedrosouza.ifome.repository.ProdutoRepository;
import br.com.pedrosouza.ifome.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    private final ProdutoRepository repository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.repository = produtoRepository;
    }


    @Override
    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    @Override
    public void deletarProduto(Long id) {
        Produto produto = repository.findOne(id);
        if(produto.getPedidos() != null && !produto.getPedidos().isEmpty()){
            throw new RuntimeException("Não foi possível remover o produto!\nProduto associado a um pedido!");
        } else {
            repository.delete(produto);
        }
    }

    @Override
    public void criarProduto(Produto produto) {
        repository.save(produto);
    }

    @Override
    public void atualizarProduto(Long id, Produto produto) {
        repository.save(produto);
    }

    @Override
    public Produto buscarProduto(Long id) {
        return repository.findOne(id);
    }
}
