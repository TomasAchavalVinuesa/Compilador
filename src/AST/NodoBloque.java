/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST;
import TablaSimbolos.TablaSimbolos;
import java.util.List;

/**
 *
 * @author tavto
 */
public class NodoBloque extends NodoAST{
    private List<NodoAST> sentencias;

    public NodoBloque(List<NodoAST> sentencias) {
        this.sentencias = sentencias;
    }
    
    @Override
    public String analizar(TablaSimbolos ts) throws ExcepcionSemantica {
        // Nota: Aquí se podría crear un nuevo ámbito (scope) si la TS lo soporta.
        // Por ahora, usamos la misma tabla.
        for (NodoAST s : sentencias) {
            s.analizar(ts);
        }
        return "OK";
    }

    @Override
    public Object generarCodigo() { return null; }

    @Override
    public String imprimir(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("BLOQUE {\n");
        for (NodoAST s : sentencias) {
            sb.append(s.imprimir(indent + "  "));
        }
        sb.append(indent).append("}\n");
        return sb.toString();
    }
}
