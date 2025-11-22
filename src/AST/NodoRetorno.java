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
public class NodoRetorno extends NodoAST{
    private NodoAST expresion; // La expresión que se devuelve

    public NodoRetorno(NodoAST expresion) {
        this.expresion = expresion;
    }
    
    public NodoAST getExpresion() {
        return expresion;
    }

    @Override
    public String analizar(TablaSimbolos ts) throws ExcepcionSemantica {
        // 1. Obtener el tipo de la expresión que se intenta devolver
        String tipoExpresion = this.expresion.analizar(ts);

        if (tipoExpresion.startsWith("ERROR")) {
            throw new ExcepcionSemantica("Error Semántico dentro de la expresión de retorno: " + tipoExpresion);
        }
        
        return "OK";
    }

    @Override
    public Object generarCodigo() {
        return null;
    }
    
    @Override
    public String imprimir(String indent) {
        String res = indent + "RETORNO\n";
        res += expresion.imprimir(indent + "  ");
        return res;
    }
}
