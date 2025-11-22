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
public class NodoWhile extends NodoAST{
    private NodoAST condicion;
    private NodoAST bloque;
    
    public NodoWhile(NodoAST condicion, NodoAST bloque) {
        this.condicion = condicion;
        this.bloque = bloque;
    }
    
    @Override
    public String analizar(TablaSimbolos ts) throws ExcepcionSemantica {
        String tipoCond = condicion.analizar(ts);
        if (!tipoCond.equals("bool")) {
            throw new ExcepcionSemantica("La condición del WHILE debe ser de tipo bool. Se encontró: " + tipoCond);
        }
        bloque.analizar(ts);
        return "OK";
    }
    
    @Override
    public Object generarCodigo() { return null; }

    @Override
    public String imprimir(String indent) {
        return indent + "WHILE\n" + condicion.imprimir(indent + "  ") + indent + "DO\n" + bloque.imprimir(indent + "  ");
    }
}
