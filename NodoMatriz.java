package gestionvehiculos;

public class NodoMatriz {
    // Atributos de la clase NodoMatriz
    int fila; // Fila del nodo en la matriz
    int columna; // Columna del nodo en la matriz
    DatosVehiculo datosVehiculo; // Datos del vehículo almacenados en el nodo
    NodoMatriz siguienteFila; // Referencia al siguiente nodo en la misma fila
    NodoMatriz siguienteColumna; // Referencia al siguiente nodo en la misma columna

    // Constructor de la clase NodoMatriz
    public NodoMatriz(int fila, int columna, DatosVehiculo datosVehiculo) {
        this.fila = fila;
        this.columna = columna;
        this.datosVehiculo = datosVehiculo;
    }
}