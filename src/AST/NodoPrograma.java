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
    private String tipoRetornoMain;
    private List<NodoAST> listaSentencias;
    
    public NodoPrograma(String tipoRetornoMain, List<NodoAST> listaSentencias) {
        this.tipoRetornoMain = tipoRetornoMain;
        this.listaSentencias = listaSentencias;
    }
    
    @Override
    public String analizar(TablaSimbolos ts) throws ExcepcionSemantica {
        // Lógica: Iniciar el análisis semántico recorriendo todas las sentencias
        System.out.println("--- Iniciando Análisis Semántico ---");
        
        // El análisis se realiza iterando sobre todas las sentencias del cuerpo del main
        for (NodoAST sentencia : listaSentencias) {
            // Cada sentencia puede devolver su tipo o un indicador (ej: "OK", o una excepción si es error)
            sentencia.analizar(ts);
        }
        
        System.out.println("--- Análisis Semántico Terminado (Éxito) ---");
        return "OK"; 
    }
    
    @Override
    public Object generarCodigo() {
        // Se implementará más adelante para iniciar la generación de código.
        return null;
    }
}
