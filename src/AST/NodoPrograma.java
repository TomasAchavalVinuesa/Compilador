/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AST;

import java.util.List;
import TablaSimbolos.*;

/**
 *
 * @author tavto
 */
public class NodoPrograma extends NodoAST {
    
    private String tipoRetornoMain; // No usado en este análisis simple, pero es bueno tenerlo
    private List<NodoAST> listaSentencias;

    public NodoPrograma(String tipoRetornoMain, List<NodoAST> listaSentencias) {
        this.tipoRetornoMain = tipoRetornoMain;
        this.listaSentencias = listaSentencias;
    }
    
    @Override
    public String analizar(TablaSimbolos ts) throws ExcepcionSemantica {
        
        // El análisis se realiza iterando sobre todas las sentencias del cuerpo del main
        for (NodoAST sentencia : listaSentencias) {
            
            // Si una sentencia lanza ExcepcionSemantica, el bucle se detiene
            // y la excepción es atrapada en FrmPrincipal.java.
            sentencia.analizar(ts); 
        }
        
        // Si el bucle termina sin excepciones, el análisis semántico es un éxito.
        return "OK"; 
    }

    @Override
    public Object generarCodigo() {
        // Se implementará más adelante
        return null;
    }
    
    @Override
    public String imprimir(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("PROGRAMA\n");
        for (NodoAST sentencia : listaSentencias) {
            sb.append(sentencia.imprimir(indent + "  "));
        }
        return sb.toString();
    }
}
