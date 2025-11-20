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
        // 1. Obtener los tipos de los operandos recursivamente
        String tipoIzquierdo = this.operandoIzquierdo.analizar(ts);
        String tipoDerecho = this.operandoDerecho.analizar(ts);

        if (tipoIzquierdo.equals("ERROR") || tipoDerecho.equals("ERROR")) {
            return "ERROR"; // Propagar errores desde abajo
        }

        // 2. Definir reglas de compatibilidad para operaciones aritméticas
        if (this.operador.matches("[+\\-*/]")) {
            // Operaciones aritméticas solo permiten Int
            if (tipoIzquierdo.equals("Int") && tipoDerecho.equals("Int")) {
                return "Int"; // El resultado es Int
            } else {
                throw new ExcepcionSemantica("Error de Tipos: La operación '" + this.operador + "' solo está permitida entre tipos Int. Se encontró " + tipoIzquierdo + " y " + tipoDerecho + ".");
            }
        } 
        // Se pueden añadir aquí otras operaciones (ej: comparaciones "==" o "&&" que devuelven "Bool")

        return "ERROR_OPERADOR_NO_SOPORTADO"; // En caso de operador desconocido o no manejado
    }

    @Override
    public Object generarCodigo() {
        return null;
    }
}
