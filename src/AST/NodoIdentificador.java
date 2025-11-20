/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST;

import TablaSimbolos.*;

/**
 *
 * @author tavto
 */
public class NodoIdentificador extends NodoAST{
    private String nombre; // Ej: "x", "y", "n"

    public NodoIdentificador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String analizar(TablaSimbolos ts) throws ExcepcionSemantica {
        // 1. Buscar el símbolo en la Tabla de Símbolos
        Simbolo s = ts.buscar(this.nombre);
        
        if (s == null) {
            // Si la variable no está en la tabla, es un error semántico
            throw new ExcepcionSemantica("Error Semántico: La variable '" + this.nombre + "' no ha sido declarada.");
        }
        
        // 2. Devolver el tipo de la variable para el chequeo de tipos
        return s.getTipo();
    }
    
    @Override
    public Object generarCodigo() {
        return nombre;
    }
}
