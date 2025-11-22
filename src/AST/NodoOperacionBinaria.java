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
        String t1 = operandoIzquierdo.analizar(ts);
        String t2 = operandoDerecho.analizar(ts);

        // Operaciones Aritméticas
        if (operador.matches("[+\\-*/%]")) {
            if (t1.equals("int") && t2.equals("int")) return "int";
            throw new ExcepcionSemantica("Operación aritmética " + operador + " requiere enteros.");
        }

        // Operaciones Relacionales
        if (operador.matches("[><]|==")) {
            // Asumimos que se pueden comparar int con int. (Opcional: bool con bool para ==)
            if (t1.equals(t2)) return "bool"; 
            throw new ExcepcionSemantica("Comparación requiere tipos iguales.");
        }

        // Operaciones Lógicas
        if (operador.equals("&&") || operador.equals("||")) {
            if (t1.equals("bool") && t2.equals("bool")) return "bool";
            throw new ExcepcionSemantica("Operación lógica " + operador + " requiere booleanos.");
        }

        return "ERROR";
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
