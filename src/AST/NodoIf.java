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
public class NodoIf extends NodoAST{
    private NodoAST condicion;
    private NodoAST bloqueThen;
    private NodoAST bloqueElse;
    
    public NodoIf(NodoAST condicion, NodoAST bloqueThen, NodoAST bloqueElse) {
        this.condicion = condicion;
        this.bloqueThen = bloqueThen;
        this.bloqueElse = bloqueElse;
    }
    
    @Override
    public String analizar(TablaSimbolos ts) throws ExcepcionSemantica {
        String tipoCond = condicion.analizar(ts);
        if (!tipoCond.equals("bool")) {
            throw new ExcepcionSemantica("La condición del IF debe ser de tipo bool. Se encontró: " + tipoCond);
        }
        bloqueThen.analizar(ts);
        if (bloqueElse != null) {
            bloqueElse.analizar(ts);
        }
        return "OK";
    }
    
    @Override
    public Object generarCodigo() { return null; }
    
    @Override
    public String imprimir(String indent) {
        String res = indent + "IF\n" + condicion.imprimir(indent + "  ") + indent + "THEN\n" + bloqueThen.imprimir(indent + "  ");
        if (bloqueElse != null) {
            res += indent + "ELSE\n" + bloqueElse.imprimir(indent + "  ");
        }
        return res;
    }
}
