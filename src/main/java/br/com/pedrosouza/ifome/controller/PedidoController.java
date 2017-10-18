package br.com.pedrosouza.ifome.controller;

import br.com.pedrosouza.ifome.domain.Pedido;
import br.com.pedrosouza.ifome.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
  private final PedidoRepository repository;

  @Autowired
  public PedidoController(PedidoRepository repository) {
    this.repository = repository;
  }


  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Pedido> index() {
    return repository.findAll();
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  public void create(@RequestBody Pedido pedido) {
    repository.save(pedido);
  }

}
