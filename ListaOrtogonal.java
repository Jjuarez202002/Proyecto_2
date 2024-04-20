package gestionvehiculos;

import java.util.ArrayList;
import java.util.List;

public class ListaOrtogonal {
    NodoMatriz cabezaFilas; // Nodo cabeza para las filas
    NodoMatriz cabezaColumnas; // Nodo cabeza para las columnas

    // Método para insertar un nuevo nodo en la matriz ortogonal
    public void insertarEnMatriz(int fila, int columna, DatosVehiculo datosVehiculo) {
        NodoMatriz nuevoNodo = new NodoMatriz(fila, columna, datosVehiculo);
        insertarNodoEnFila(nuevoNodo);
        insertarNodoEnColumna(nuevoNodo);
    }

    // Método privado para insertar un nodo en la lista de filas
    private void insertarNodoEnFila(NodoMatriz nodo) {
        if (cabezaFilas == null) {
            cabezaFilas = nodo;
        } else {
            NodoMatriz ultimoNodo = cabezaFilas;
            while (ultimoNodo.siguienteFila != null) {
                ultimoNodo = ultimoNodo.siguienteFila;
            }
            ultimoNodo.siguienteFila = nodo;
        }
    }

    // Método privado para insertar un nodo en la lista de columnas
    private void insertarNodoEnColumna(NodoMatriz nodo) {
        if (cabezaColumnas == null) {
            cabezaColumnas = nodo;
        } else {
            NodoMatriz ultimoNodo = cabezaColumnas;
            while (ultimoNodo.siguienteColumna != null) {
                ultimoNodo = ultimoNodo.siguienteColumna;
            }
            ultimoNodo.siguienteColumna = nodo;
        }
    }

    // Método para buscar vehículos en la matriz ortogonal
    public List<NodoMatriz> buscarEnMatriz(String placa, String color, String linea, String modelo, String propietario) {
        List<NodoMatriz> resultados = new ArrayList<>();
        NodoMatriz nodoActual = cabezaFilas;
        while (nodoActual != null) {
            if (nodoActual.datosVehiculo.placa.equals(placa) &&
                    nodoActual.datosVehiculo.color.equals(color) &&
                    nodoActual.datosVehiculo.linea.equals(linea) &&
                    nodoActual.datosVehiculo.modelo.equals(modelo) &&
                    nodoActual.datosVehiculo.propietario.equals(propietario)) {
                resultados.add(nodoActual);
            }
            nodoActual = nodoActual.siguienteFila;
        }
        return resultados;
    }

    // Método para eliminar vehículos de la matriz ortogonal
    public void eliminarEnMatriz(String placa, String color, String linea, String modelo, String propietario) {
        NodoMatriz nodoActual = cabezaFilas;
        NodoMatriz nodoAnterior = null;
        while (nodoActual != null) {
            if (nodoActual.datosVehiculo.placa.equals(placa) &&
                    nodoActual.datosVehiculo.color.equals(color) &&
                    nodoActual.datosVehiculo.linea.equals(linea) &&
                    nodoActual.datosVehiculo.modelo.equals(modelo) &&
                    nodoActual.datosVehiculo.propietario.equals(propietario)) {
                if (nodoAnterior == null) {
                    cabezaFilas = nodoActual.siguienteFila;
                } else {
                    nodoAnterior.siguienteFila = nodoActual.siguienteFila;
                }
                break;
            }
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguienteFila;
        }

        nodoActual = cabezaColumnas;
        nodoAnterior = null;
        while (nodoActual != null) {
            if (nodoActual.datosVehiculo.placa.equals(placa) &&
                    nodoActual.datosVehiculo.color.equals(color) &&
                    nodoActual.datosVehiculo.linea.equals(linea) &&
                    nodoActual.datosVehiculo.modelo.equals(modelo) &&
                    nodoActual.datosVehiculo.propietario.equals(propietario)) {
                if (nodoAnterior == null) {
                    cabezaColumnas = nodoActual.siguienteColumna;
                } else {
                    nodoAnterior.siguienteColumna = nodoActual.siguienteColumna;
                }
                break;
            }
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguienteColumna;
        }
    }
}