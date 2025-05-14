package com.ltpo.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_automoveis")
public class Automovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;

    private String placa;
    private Integer ano;
    private String cor;

    public Automovel() {
    }

    public Automovel(Modelo modelo, String placa, Integer ano, String cor) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
    }

    public Integer getId() {
        return id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public Integer getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
