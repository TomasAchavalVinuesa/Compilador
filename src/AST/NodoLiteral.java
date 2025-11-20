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
    public String analizar(TablaSimbolos ts) {
        // Lógica: Determinar el tipo de este valor constante
        if (valor.matches("\\d+")) {
            return "Int"; 
        } else if (valor.equalsIgnoreCase("True") || valor.equalsIgnoreCase("False")) {
            return "Bool";
        } else {
            return "ERROR_TIPO_LITERAL_DESCONOCIDO";
        }
    }
    
    @Override
    public Object generarCodigo() {
        return valor;
    }
}
