package view.console;

import model.Funciones;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        String path, fileName, content;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear Carpeta");
            System.out.println("2. Crear Archivo");
            System.out.println("3. Listar Archivos");
            System.out.println("4. Mostrar Archivo");
            System.out.println("5. Sobrescribir Archivo");
            System.out.println("6. Borrar Archivo");
            System.out.println("7. Contar Caracteres");
            System.out.println("8. Contar Palabras");
            System.out.println("9. Reemplazar Palabras");
            System.out.println("10. Exportar PDF");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de la carpeta: ");
                        Funciones.createFolder(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Nombre de archivo: ");
                        fileName = sc.nextLine();
                        System.out.print("Contenido: ");
                        content = sc.nextLine();
                        Funciones.createFile(path, fileName, content);
                        break;
                    case 3:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        String[] files = Funciones.showListFiles(path);
                        if (files != null) {
                            for (String f : files) System.out.println(f);
                        } else {
                            System.out.println("No hay archivos o ruta inválida.");
                        }
                        break;
                    case 4:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        System.out.println(Funciones.showFile(path, fileName));
                        break;
                    case 5:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        System.out.print("Nuevo contenido: ");
                        content = sc.nextLine();
                        boolean success = Funciones.overWriteFile(path, fileName, content);
                        System.out.println(success ? "Archivo modificado." : "Archivo no existe.");
                        break;
                    case 6:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        Funciones.deleteFile(path, fileName);
                        break;
                    case 7:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        System.out.println("Caracteres: " + Funciones.countChars(path, fileName));
                        break;
                    case 8:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        System.out.println("Palabras: " + Funciones.countWords(path, fileName));
                        break;
                    case 9:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        System.out.print("Palabra antigua: ");
                        String oldWord = sc.nextLine();
                        System.out.print("Palabra nueva: ");
                        String newWord = sc.nextLine();
                        System.out.println(Funciones.swapWords(path, fileName, oldWord, newWord));
                        break;
                    case 10:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo (sin .pdf): ");
                        fileName = sc.nextLine();
                        Funciones.fakePDF(path, fileName);
                        System.out.println("Archivo .pdf simulado creado correctamente.");
                        break;

                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);

        sc.close();
    }
}
