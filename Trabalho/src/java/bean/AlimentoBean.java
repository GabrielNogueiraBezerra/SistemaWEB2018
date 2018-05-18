/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import Models.CategoriaAlimento;

/**
 *
 * @author Marcelo
 */
public class AlimentoBean {
    private int id;
    private String nome;
    private CategoriaAlimento categoriaAlimento;
    private float quantidadeFibras;
    private float quantidadeCalorias;
    private float quantidadeCarboidratos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaAlimento getCategoriaAlimento() {
        return categoriaAlimento;
    }

    public void setCategoriaAlimento(CategoriaAlimento categoriaAlimento) {
        this.categoriaAlimento = categoriaAlimento;
    }

    public float getQuantidadeFibras() {
        return quantidadeFibras;
    }

    public void setQuantidadeFibras(float quantidadeFibras) {
        this.quantidadeFibras = quantidadeFibras;
    }

    public float getQuantidadeCalorias() {
        return quantidadeCalorias;
    }

    public void setQuantidadeCalorias(float quantidadeCalorias) {
        this.quantidadeCalorias = quantidadeCalorias;
    }

    public float getQuantidadeCarboidratos() {
        return quantidadeCarboidratos;
    }

    public void setQuantidadeCarboidratos(float quantidadeCarboidratos) {
        this.quantidadeCarboidratos = quantidadeCarboidratos;
    }
    
    
}
