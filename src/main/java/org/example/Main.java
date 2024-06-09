package org.example;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner miScan = new Scanner(System.in);

    public static void main(String[] args) {

        KGen kgen = null;
        char option;

        do {

            System.out.println("Seleccione una de las siguientes opciones:\na. Abrir fichero FASTA\nb. Calcular y mostrar mapa de palabras de tamaño...\nc. Salir");
            option = miScan.nextLine().charAt(0);

            switch (option) {

                case 'a':

                    System.out.print("Introduzca el nombre (o el path) del fichero FASTA: ");
                    String fileName = miScan.nextLine();

                    try {

                        kgen = new KGen(fileName);
                        System.out.println("Archivo leído correctamente.");

                    } catch (IOException e) {

                        System.out.println("ERROR al leer el archivo: " + e.getMessage());

                    }

                    break;

                case 'b':

                    if (kgen == null) {

                        System.out.println("Debe abrir un fichero FASTA.");

                    } else {

                        System.out.print("Introduzca el tamaño de la palabra: ");
                        int size = Integer.parseInt(miScan.nextLine());
                        Map<String, Integer> kgenMap = kgen.getKgenMap(size);

                        for (Map.Entry<String, Integer> entry : kgenMap.entrySet()) System.out.println(entry.getKey() + ": " + entry.getValue());

                    }

                    break;

                case 'c':

                    System.out.println("Hasta pronto");
                    break;

                default:

                    System.out.println("Introduzca una opción válida.");

            }

        }while(option != 'c');

    }

}