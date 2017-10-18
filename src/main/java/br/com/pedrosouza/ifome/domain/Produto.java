package br.com.pedrosouza.ifome.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Produto implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String loja;
  private Double preco;
  private String nome;

  @ManyToMany(mappedBy = "itens", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Pedido> pedidos;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLoja() {
    return loja;
  }

  public void setLoja(String loja) {
    this.loja = loja;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Pedido> getPedidos() {
    return pedidos;
  }

  public void setPedidos(List<Pedido> pedidos) {
    this.pedidos = pedidos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Produto produto = (Produto) o;

    if (id != null ? !id.equals(produto.id) : produto.id != null) return false;
    if (loja != null ? !loja.equals(produto.loja) : produto.loja != null) return false;
    if (preco != null ? !preco.equals(produto.preco) : produto.preco != null) return false;
    if (nome != null ? !nome.equals(produto.nome) : produto.nome != null) return false;
    if (pedidos != null ? !pedidos.equals(produto.pedidos) : produto.pedidos != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (loja != null ? loja.hashCode() : 0);
    result = 31 * result + (preco != null ? preco.hashCode() : 0);
    result = 31 * result + (nome != null ? nome.hashCode() : 0);
    result = 31 * result + (pedidos != null ? pedidos.hashCode() : 0);
    return result;
  }
}
