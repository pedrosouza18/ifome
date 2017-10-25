package br.com.pedrosouza.ifome.service;

import br.com.pedrosouza.ifome.domain.Pedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> listarPedido();

    void criarPedido(Pedido pedido);

}
