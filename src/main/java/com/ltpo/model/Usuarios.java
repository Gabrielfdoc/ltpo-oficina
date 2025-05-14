package com.ltpo.model;

import com.ltpo.enums.TipoUsuario;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    private String nome;
    private String telefone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private List<Automovel> automoveis;

    public Usuarios() {}

    public Usuarios(TipoUsuario tipo, String nome, String telefone, List<Automovel> automoveis) {
        this.tipo = tipo;
        this.nome = nome;
        this.telefone = telefone;
        this.automoveis = automoveis;
    }

    public Integer getId() {
        return id;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }
}
