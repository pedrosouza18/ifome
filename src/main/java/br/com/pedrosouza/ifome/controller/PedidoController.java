package br.com.pedrosouza.ifome.controller;

import br.com.pedrosouza.ifome.domain.Pedido;
import br.com.pedrosouza.ifome.service.PedidoService;
import br.com.pedrosouza.ifome.serviceimpl.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

  private final PedidoService pedidoService;

  @Autowired
  public PedidoController(PedidoService pedidoService) {
    this.pedidoService = pedidoService;
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Pedido> index() {
    return pedidoService.listarPedido();
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  public void create(@RequestBody Pedido pedido) {
    pedidoService.criarPedido(pedido);
  }

}
