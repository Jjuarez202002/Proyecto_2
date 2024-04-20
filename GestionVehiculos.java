package gestionvehiculos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GestionVehiculos {
    private static ListaOrtogonal listaOrtogonal = new ListaOrtogonal();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestor de Vehiculos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 1));

        JButton insertButton = new JButton("Insertar Vehiculo");
        JButton searchButton = new JButton("Buscar Vehiculo");
        JButton deleteButton = new JButton("Eliminar Vehiculo");

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertVehicle();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchVehicle();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteVehicle();
            }
        });

        frame.add(insertButton);
        frame.add(searchButton);
        frame.add(deleteButton);

        frame.setVisible(true);
    }

    private static void insertVehicle() {
        JFrame insertFrame = new JFrame("Insertar Vehiculo");
        insertFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        insertFrame.setSize(300, 200);
        insertFrame.setLayout(new GridLayout(6, 2));

        JTextField placaField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField lineaField = new JTextField();
        JTextField modeloField = new JTextField();
        JTextField propietarioField = new JTextField();

        insertFrame.add(new JLabel("Placa: "));
        insertFrame.add(placaField);
        insertFrame.add(new JLabel("Color: "));
        insertFrame.add(colorField);
        insertFrame.add(new JLabel("Linea: "));
        insertFrame.add(lineaField);
        insertFrame.add(new JLabel("Modelo: "));
        insertFrame.add(modeloField);
        insertFrame.add(new JLabel("Propietario: "));
        insertFrame.add(propietarioField);

        JButton insertButton = new JButton("Insertar");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = placaField.getText();
                String color = colorField.getText();
                String linea = lineaField.getText();
                String modelo = modeloField.getText();
                String propietario = propietarioField.getText();
                listaOrtogonal.insertarEnMatriz(1, 1, new DatosVehiculo(placa, color, linea, modelo, propietario));
                JOptionPane.showMessageDialog(insertFrame, "Vehiculo insertado correctamente.");
                insertFrame.dispose();
            }
        });

        insertFrame.add(insertButton);
        insertFrame.setVisible(true);
    }

    private static void searchVehicle() {
        JFrame searchFrame = new JFrame("Buscar Vehiculo");
        searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchFrame.setSize(300, 150);
        searchFrame.setLayout(new GridLayout(3, 2));

        JTextField placaField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField lineaField = new JTextField();
        JTextField modeloField = new JTextField();
        JTextField propietarioField = new JTextField();

        searchFrame.add(new JLabel("Placa: "));
        searchFrame.add(placaField);
        searchFrame.add(new JLabel("Color: "));
        searchFrame.add(colorField);
        searchFrame.add(new JLabel("Linea: "));
        searchFrame.add(lineaField);
        searchFrame.add(new JLabel("Modelo: "));
        searchFrame.add(modeloField);
        searchFrame.add(new JLabel("Propietario: "));
        searchFrame.add(propietarioField);

        JButton searchButton = new JButton("Buscar");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = placaField.getText();
                String color = colorField.getText();
                String linea = lineaField.getText();
                String modelo = modeloField.getText();
                String propietario = propietarioField.getText();

                List<NodoMatriz> resultados = listaOrtogonal.buscarEnMatriz(placa, color, linea, modelo, propietario);
                if (resultados.isEmpty()) {
                    JOptionPane.showMessageDialog(searchFrame, "No se encontraron vehiculos con los criterios especificados.");
                } else {
                    StringBuilder message = new StringBuilder();
                    for (NodoMatriz nodo : resultados) {
                        DatosVehiculo vehiculo = nodo.datosVehiculo;
                        message.append("Placa: ").append(vehiculo.placa).append(", Color: ").append(vehiculo.color)
                                .append(", Linea: ").append(vehiculo.linea).append(", Modelo: ").append(vehiculo.modelo)
                                .append(", Propietario: ").append(vehiculo.propietario).append("\n");
                    }
                    JOptionPane.showMessageDialog(searchFrame, message.toString(), "Vehiculo(s) encontrado(s)", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        searchFrame.add(searchButton);
        searchFrame.setVisible(true);
    }

    private static void deleteVehicle() {
        JFrame deleteFrame = new JFrame("Eliminar Vehiculo");
        deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteFrame.setSize(300, 150);
        deleteFrame.setLayout(new GridLayout(2, 2));

        JTextField placaField = new JTextField();
        JTextField propietarioField = new JTextField();

        deleteFrame.add(new JLabel("Placa: "));
        deleteFrame.add(placaField);
        deleteFrame.add(new JLabel("Propietario: "));
        deleteFrame.add(propietarioField);

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = placaField.getText();
                String propietario = propietarioField.getText();

                listaOrtogonal.eliminarEnMatriz(placa, "", "", "", propietario);
                JOptionPane.showMessageDialog(deleteFrame, "El Vehiculo ha sido eliminado correctamente.");
                deleteFrame.dispose();
            }
        });

        deleteFrame.add(deleteButton);
        deleteFrame.setVisible(true);
    }
}