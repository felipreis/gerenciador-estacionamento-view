package com.client.estacionamento.view;



import com.client.estacionamento.model.Carro;
import com.client.estacionamento.service.CarroService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class EntradaVeiculo extends JFrame{

    private JTextField marca;
    private JTextField placa;
    private JButton entradaButton;

    public EntradaVeiculo() {

        initUI();
    }

    private void initUI() {
        marca = new JTextField(20);
        placa = new JTextField(20);
        entradaButton = new JButton("Entrada");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Marca:"));
        add(marca);
        add(new JLabel("Placa:"));
        add(placa);
        add(entradaButton);

        entradaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    handleEntrada();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        setTitle("Entrada de Veículo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void handleEntrada() throws IOException, InterruptedException {
        CarroService carroService = new CarroService();
        Carro carro = new Carro();
        carro.setPalca(placa.getText());
        carro.setMarca(marca.getText());
        carroService.createCarro(carro);
        System.out.println("Carro registrado com sucesso");




        System.out.println("Entrada do veículo realizada");
    }

    // Método para inicializar e mostrar a janela
    public void showWindow() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }


}
