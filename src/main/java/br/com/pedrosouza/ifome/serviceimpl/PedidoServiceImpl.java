package br.com.pedrosouza.ifome.serviceimpl;

import br.com.pedrosouza.ifome.domain.Pedido;
import br.com.pedrosouza.ifome.repository.PedidoRepository;
import br.com.pedrosouza.ifome.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService{

    private final PedidoRepository repository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Pedido> index() {
        return repository.findAll();
    }

    @Override
    public List<Pedido> listarPedido() {
        return repository.findAll();
    }

    @Override
    public void criarPedido(Pedido pedido) {
        repository.save(pedido);
    }


}
