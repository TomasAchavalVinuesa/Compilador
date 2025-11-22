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
public class NodoLiteral extends NodoAST{
    private String valor; // Ej: "16", "True", "False"

    public NodoLiteral(String valor) {
        this.valor = valor;
    }
    
    @Override
    public String analizar(TablaSimbolos ts) throws ExcepcionSemantica {
        // Lógica: Determinar el tipo de este valor constante
        if (valor.matches("\\d+")) {
            return "int"; 
        } else if (valor.equalsIgnoreCase("True") || valor.equalsIgnoreCase("False")) {
            return "bool";
        } else {
            // SOLUCIÓN: Si no coincide con Int o Bool, LANZAR la excepción
            throw new ExcepcionSemantica("Error Semántico: Literal '" + this.valor + "' no reconocido o de tipo no válido.");
        }
    }
    
    @Override
    public Object generarCodigo() {
        return valor;
    }
    
    @Override
    public String imprimir(String indent) {
        return indent + "LITERAL (" + valor + ")\n";
    }
}
