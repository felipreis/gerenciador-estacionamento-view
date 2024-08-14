package com.client.estacionamento;

import com.client.estacionamento.view.EntradaVeiculo;

import javax.swing.*;

public class SwingApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EntradaVeiculo entradaCarro = new EntradaVeiculo();
            entradaCarro.setVisible(true);
        });
    }
}
