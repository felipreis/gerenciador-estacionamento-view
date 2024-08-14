package com.client.estacionamento.view;

import com.app.estacionamento.controller.CarrroController;
import com.app.estacionamento.controller.EntradaController;
import com.app.estacionamento.entity.Carro;
import com.app.estacionamento.entity.Entrada;
import com.app.estacionamento.entity.form.CarroForm;
import com.app.estacionamento.entity.form.EntradaForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EntradaVeiculo extends JFrame{

    private JTextField marca;
    private JTextField placa;
    private JButton entradaButton;

    private final CarrroController carroController;
    private final EntradaController entradaController;


    public EntradaVeiculo(CarrroController carroController, EntradaController entradaController) {
        this.carroController = carroController;
        this.entradaController = entradaController;

        // Configuração dos componentes da interface gráfica
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
                handleEntrada();
            }
        });

        setTitle("Entrada de Veículo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void handleEntrada() {
        CarroForm carroForm = new CarroForm();
        EntradaForm entradaForm = new EntradaForm();

        carroForm.setMarca(marca.getText());
        carroForm.setPlaca(placa.getText());

        Carro carro = carroController.create(carroForm);


        entradaForm.setCarroId(carro.getId());

        Entrada entrada = entradaController.create(entradaForm);

        System.out.println("Entrada do veículo realizada");
    }

    // Método para inicializar e mostrar a janela
    public void showWindow() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }


}
