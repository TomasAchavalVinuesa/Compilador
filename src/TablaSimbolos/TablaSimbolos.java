/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TablaSimbolos;

import java.util.HashMap;

/**
 *
 * @author tavto
 */
public class TablaSimbolos {
    private HashMap<String, Simbolo> tabla;
    
    public TablaSimbolos() {
        this.tabla = new HashMap<>();
    }

    public boolean insertar(Simbolo s) {
        if (tabla.containsKey(s.getNombre())) {
            return false;
        }
        tabla.put(s.getNombre(), s);
        return true;
    }

    public Simbolo buscar(String nombre) {
        return tabla.get(nombre);
    }
    
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append("NOMBRE\t\tTIPO\n");
        sb.append("------\t\t----\n");
        
        // Recorremos todos los valores del mapa
        for (Simbolo s : tabla.values()) {
            sb.append(s.getNombre())
              .append("\t\t")
              .append(s.getTipo())
              .append("\n");
        }
        return sb.toString();
    }
}
