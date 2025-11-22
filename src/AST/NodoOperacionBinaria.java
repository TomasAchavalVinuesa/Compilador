/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST;

import TablaSimbolos.TablaSimbolos;

/**
 *
 * @author tavto
 */
public class NodoOperacionBinaria extends NodoAST{
    private NodoAST operandoIzquierdo;
    private String operador; // "+", "-", "*", "/"
    private NodoAST operandoDerecho;

    public NodoOperacionBinaria(NodoAST opIzquierdo, String op, NodoAST opDerecho) {
        this.operandoIzquierdo = opIzquierdo;
        this.operador = op;
        this.operandoDerecho = opDerecho;
    }

    @Override
    public String analizar(TablaSimbolos ts) throws ExcepcionSemantica {
        // Si los sub-análisis fallan, lanzarán ExcepcionSemantica y este método se abortará.
        String tipoIzquierdo = this.operandoIzquierdo.analizar(ts);
        String tipoDerecho = this.operandoDerecho.analizar(ts);

        if (this.operador.matches("[+\\-*/]")) {
            if (tipoIzquierdo.equals("int") && tipoDerecho.equals("int")) {
                return "int"; 
            } else {
                // Este caso es un error de tipo (ej: True + 5)
                throw new ExcepcionSemantica("Error de Tipos: La operación '" + this.operador + "' solo está permitida entre tipos Int. Se encontró " + tipoIzquierdo + " y " + tipoDerecho + ".");
            }
        } 

        // Si la operación no es aritmética, y llega aquí (ej: comparaciones), fallará si no está implementado
        throw new ExcepcionSemantica("Error de Tipos: Operador binario '" + this.operador + "' no soportado para los tipos encontrados."); 
    }

    @Override
    public Object generarCodigo() {
        return null;
    }
    
    @Override
    public String imprimir(String indent) {
        String res = indent + "OPERACION (" + operador + ")\n";
        res += operandoIzquierdo.imprimir(indent + "  ");
        res += operandoDerecho.imprimir(indent + "  ");
        return res;
    }
}
