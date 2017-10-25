package br.com.pedrosouza.ifome.controller;

import br.com.pedrosouza.ifome.domain.Produto;
import br.com.pedrosouza.ifome.service.ProdutoService;
import br.com.pedrosouza.ifome.serviceimpl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  private final ProdutoService produtoService;

  @Autowired
  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Produto> index() {
    return produtoService.listarProdutos();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id){
    produtoService.deletarProduto(id);
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  public void create(@RequestBody Produto produto){
    produtoService.criarProduto(produto);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  public Produto buscarProduto(@PathVariable("id") Long id){
    return produtoService.buscarProduto(id);
  }

  @RequestMapping(value = "{id}/editar" , method = RequestMethod.PUT)
  public void update(@PathVariable("id") Long id, @RequestBody Produto produto){
      produtoService.atualizarProduto(id, produto);
  }
}
