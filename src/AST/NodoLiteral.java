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
        if (valor.matches("\\d+")) {
            try {
                // Intentar parsear como Long para verificar si entra en Int
                long val = Long.parseLong(valor);
                if (val > 2147483647L) {
                    // Nota: 2147483648 es válido solo si tiene un '-' delante en el parser,
                    // pero como literal positivo individual, es un desbordamiento.
                    // Simplificación: marcamos error si el literal per se es muy grande.
                    throw new ExcepcionSemantica("El entero " + valor + " excede el límite de 32 bits.");
                }
                return "int";
            } catch (NumberFormatException e) {
                throw new ExcepcionSemantica("Número inválido: " + valor);
            }
        } else if (valor.equalsIgnoreCase("True") || valor.equalsIgnoreCase("False")) {
            return "bool";
        }
        throw new ExcepcionSemantica("Literal desconocido: " + valor);
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
