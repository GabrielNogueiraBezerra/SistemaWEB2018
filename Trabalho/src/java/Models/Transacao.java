/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import interfaces.InterfaceManipulable;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author gabri
 */
public class Transacao implements InterfaceManipulable {

    private int id;
    private TipoTransacao tipoTransacao;
    private LocalDate date;
    private float valor;

    public Transacao() {
        super();
    }

    public Transacao(int id, TipoTransacao tipoTransacao, LocalDate date, float valor) {
        this.id = id;
        this.tipoTransacao = tipoTransacao;
        this.date = date;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        if (tipoTransacao != null) {
            this.tipoTransacao = tipoTransacao;
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date != null) {
            this.date = date;
        }
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        if (valor >= 0) {
            this.valor = valor;
        }
    }

    @Override
    public void save() throws SQLException, ClassNotFoundException {
        if (this.date != null && this.tipoTransacao != null && this.valor >= 0) {
            if (this.id == 0) {

            } else {
                this.update();
            }
        }
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {

        }
    }

    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        if (codigo > 0) {
            this.id = codigo;

            //
        }
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {
            // deletar
        }
    }

}
