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
}
