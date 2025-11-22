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
public class NodoOperacionUnaria extends NodoAST{
    private String operador;
    private NodoAST operando;

    public NodoOperacionUnaria(String operador, NodoAST operando) {
        this.operador = operador;
        this.operando = operando;
    }

    @Override
    public String analizar(TablaSimbolos ts) throws ExcepcionSemantica {
        String tipo = operando.analizar(ts);
        if (operador.equals("!")) {
            if (!tipo.equals("bool")) throw new ExcepcionSemantica("Operador '!' requiere bool.");
            return "bool";
        } else if (operador.equals("-")) {
            if (!tipo.equals("int")) throw new ExcepcionSemantica("Operador '-' unario requiere int.");
            return "int";
        }
        return "ERROR";
    }

    @Override
    public Object generarCodigo() { return null; }

    @Override
    public String imprimir(String indent) {
        return indent + "UNARIO (" + operador + ")\n" + operando.imprimir(indent + "  ");
    }
    
}
