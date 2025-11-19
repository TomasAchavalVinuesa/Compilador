/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorLexico;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author tavto
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta1 = "D:/AAA RECIBIRME/Compiladores/Compilador2025/AnalizadorLexico/src/AnalizadorLexico/Lexer.flex";
        String ruta2 = "D:/AAA RECIBIRME/Compiladores/Compilador2025/AnalizadorLexico/src/AnalizadorLexico/LexerCup.flex";
        String[] rutaS ={"-parser", "Sintax", "D:/AAA RECIBIRME/Compiladores/Compilador2025/AnalizadorLexico/src/AnalizadorLexico/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivoLexer = new File("D:/AAA RECIBIRME/Compiladores/Compilador2025/AnalizadorLexico/src/AnalizadorLexico/Lexer.java");
        if (archivoLexer.exists()) {
            archivoLexer.delete(); // Elimina el archivo si ya existe
        }
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("D:/AAA RECIBIRME/Compiladores/Compilador2025/AnalizadorLexico/src/AnalizadorLexico/sym.java");
        if(Files.exists (rutaSym)){
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("D:/AAA RECIBIRME/Compiladores/Compilador2025/AnalizadorLexico/sym.java"), 
                Paths.get("D:/AAA RECIBIRME/Compiladores/Compilador2025/AnalizadorLexico/src/AnalizadorLexico/sym.java")
        );
        
        Path rutaSintax = Paths.get("D:/AAA RECIBIRME/Compiladores/Compilador2025/AnalizadorLexico/src/AnalizadorLexico/Sintax.java");
        if(Files.exists (rutaSintax)){
            Files.delete(rutaSintax);
        }
        
        Files.move(
                Paths.get("D:/AAA RECIBIRME/Compiladores/Compilador2025/AnalizadorLexico/Sintax.java"), 
                Paths.get("D:/AAA RECIBIRME/Compiladores/Compilador2025/AnalizadorLexico/src/AnalizadorLexico/Sintax.java")
        );
    }
}
