package br.com.pedrosouza.ifome.controller;

import br.com.pedrosouza.ifome.domain.Produto;
import br.com.pedrosouza.ifome.repository.ProdutoRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  private final ProdutoRepository repository;

  @Autowired
  public ProdutoController(ProdutoRepository repository) {
    this.repository = repository;
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Produto> index() {
    return repository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id){
    Produto produto = repository.findOne(id);
    if(produto.getPedidos() != null && !produto.getPedidos().isEmpty()){
      throw new RuntimeException("Não foi possível remover o produto!\nProduto associado a um pedido!");
    } else {
      repository.delete(produto);
    }
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  public void create(@RequestBody Produto produto){
    repository.save(produto);
  }

  @RequestMapping(value = "{id}/editar" , method = RequestMethod.PUT)
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void update(@PathVariable("id") Long id, Produto produto){
    if(produto.getPedidos() != null && !produto.getPedidos().isEmpty()){
      throw new RuntimeException("Não é possível atualizar o produto!\nProduto associado a um pedido!");
    } else {
      repository.save(produto);
    }
  }
}
