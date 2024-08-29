package org.example;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private EstadoJogador estado;
    private List<EstadoJogador> memento = new ArrayList<>();

    public EstadoJogador getEstado() {
        return estado;
    }

    public void setEstado(EstadoJogador estado) {
        this.estado = estado;
        this.memento.add(estado);
    }

    public void restauraEstado(int indice) {
        if (indice < 0 || indice >= memento.size()) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.estado = memento.get(indice);
    }

    public List<EstadoJogador> getHistoricoEstados() {
        return this.memento;
    }
}
