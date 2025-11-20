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
public class NodoDeclaracion extends NodoAST {
    
    private String tipo;
    private String identificador; 
    private NodoAST valorInicial;
    
    public NodoDeclaracion(String tipo, String identificador, NodoAST valorInicial) {
        this.tipo = tipo;
        this.identificador = identificador;
        this.valorInicial = valorInicial;
    }
    
    public String getTipo() {
        return tipo;
    }
    public String getIdentificador() {
        return identificador;
    }
    
    @Override
    public String analizar(TablaSimbolos ts) throws ExcepcionSemantica {
        // 1. Crear el nuevo símbolo
        Simbolo nuevoSimbolo = new Simbolo(this.identificador, this.tipo);
        
        // 2. Insertar en la Tabla de Símbolos y verificar duplicidad
        if (!ts.insertar(nuevoSimbolo)) {
            throw new ExcepcionSemantica("Error Semántico: La variable '" + this.identificador + "' ya ha sido declarada.");
        }

        // 3. Si hay valor inicial, verificar compatibilidad de tipos
        if (this.valorInicial != null) {
            // Obtener el tipo de la expresión a la derecha (recursivamente)
            String tipoExpresion = this.valorInicial.analizar(ts); 

            // Chequear que los tipos sean iguales
            if (!this.tipo.equals(tipoExpresion)) {
                throw new ExcepcionSemantica("Error Semántico: No se puede inicializar el tipo " + this.tipo + " con un valor de tipo " + tipoExpresion + ".");
            }
        }
        
        return "OK";
    }

    @Override
    public Object generarCodigo() {
        return null;
    }
}
