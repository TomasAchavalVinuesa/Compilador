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
public class NodoAsignacion extends NodoAST {
    private String identificador;
    private NodoAST expresion; 

    public NodoAsignacion(String identificador, NodoAST expresion) {
        this.identificador = identificador;
        this.expresion = expresion;
    }

    @Override
    public String analizar(TablaSimbolos ts) throws ExcepcionSemantica {
        // 1. Buscar el identificador en la Tabla de Símbolos (verificar que exista)
        Simbolo simboloVariable = ts.buscar(this.identificador);
        
        if (simboloVariable == null) {
            throw new ExcepcionSemantica("Error Semántico: La variable '" + this.identificador + "' no ha sido declarada.");
        }
        
        // 2. Obtener el tipo de la variable destino
        String tipoDestino = simboloVariable.getTipo();
        
        // 3. Obtener el tipo de la expresión a asignar
        String tipoExpresion = this.expresion.analizar(ts);
        
        // 4. Verificar compatibilidad de tipos
        if (!tipoDestino.equals(tipoExpresion)) {
            throw new ExcepcionSemantica("Error Semántico: No se puede asignar el valor de tipo " + tipoExpresion + " a la variable de tipo " + tipoDestino + ".");
        }

        return "OK";
    }

    @Override
    public Object generarCodigo() {
        return null;
    }
    
    @Override
    public String imprimir(String indent) {
        String res = indent + "ASIGNACION (" + identificador + ")\n";
        res += indent + "  =\n";
        res += expresion.imprimir(indent + "    ");
        return res;
    }
}
