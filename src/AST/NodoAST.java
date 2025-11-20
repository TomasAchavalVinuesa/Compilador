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
public abstract class NodoAST {
    public abstract String analizar(TablaSimbolos ts) throws ExcepcionSemantica; 
    public abstract Object generarCodigo();
}
