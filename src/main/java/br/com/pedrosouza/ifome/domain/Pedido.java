package br.com.pedrosouza.ifome.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Pedido implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToMany
  private List<Produto> itens;

  public List<Produto> getItens() {
    return itens;
  }

  public void setItens(List<Produto> itens) {
    this.itens = itens;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pedido pedido = (Pedido) o;

    if (itens != null ? !itens.equals(pedido.itens) : pedido.itens != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return itens != null ? itens.hashCode() : 0;
  }
}
