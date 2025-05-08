package model;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Funciones {

    // 1. Crear carpeta si no existe
    public static void createFolder(String fileName) {
        File folder = new File(fileName);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    // 2. Crear archivo con contenido (añadir si existe)
    public static void createFile(String path, String fileName, String content) throws IOException {
        File file = new File(path + "/" + fileName);
        FileWriter writer = new FileWriter(file, true); // append
        writer.write(content + System.lineSeparator());
        writer.close();
    }

    // 3. Mostrar lista de archivos en una carpeta
    public static String[] showListFiles(String path) {
        File folder = new File(path);
        return folder.list();
    }

    // 4. Mostrar contenido de un archivo
    public static String showFile(String path, String fileName) throws IOException {
        File file = new File(path + "/" + fileName);
        if (!file.exists()) return null;
        return new String(Files.readAllBytes(file.toPath()));
    }

    // 5. Sobrescribir un archivo
    public static boolean overWriteFile(String path, String fileName, String newContent) throws IOException {
        File file = new File(path + "/" + fileName);
        if (!file.exists()) return false;
        FileWriter writer = new FileWriter(file, false); // overwrite
        writer.write(newContent);
        writer.close();
        return true;
    }

    // 6. Borrar un archivo
    public static void deleteFile(String path, String filename) {
        File file = new File(path + "/" + filename);
        if (file.exists()) {
            file.delete();
        }
    }

    // 7. Contar caracteres de un archivo
    public static int countChars(String path, String fileName) throws IOException {
        String content = showFile(path, fileName);
        return content != null ? content.length() : 0;
    }

    // 8. Contar palabras de un archivo
    public static int countWords(String path, String fileName) throws IOException {
        String content = showFile(path, fileName);
        return content != null ? content.trim().split("\\s+").length : 0;
    }

    // 9. Reemplazar palabras
    public static String swapWords(String path, String fileName, String oldWord, String newWord) throws IOException {
        String content = showFile(path, fileName);
        if (content == null) return null;
        String updated = content.replaceAll(oldWord, newWord);
        overWriteFile(path, fileName, updated);
        return updated;
    }
    
    // Simula la creación de un archivo PDF escribiendo el contenido de un archivo de texto
    // En un nuevo archivo con extensión .pdf (aunque no es un PDF real).
    public static void fakePDF(String path, String fileName) throws IOException {
    String content = showFile(path, fileName);
    if (content == null) return;

    FileWriter writer = new FileWriter(path + "/" + fileName + ".pdf");
    writer.write(content);
    writer.close();
    }

}
