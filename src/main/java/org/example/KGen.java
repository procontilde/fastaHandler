package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class KGen {

    private String path, fasta;

    public KGen(String path) {

        this.path = path;
        this.fasta = readDataFromFile(path);

    }

    private String readDataFromFile(String path) {

        BufferedReader bR;
        StringBuilder sB = new StringBuilder();

        try {

            bR = new BufferedReader(new FileReader(path));
            String line;
            boolean firstLine = true;

            while ((line = bR.readLine()) != null) {

                if (firstLine) {

                    firstLine = false;
                    continue;

                }

                sB.append(line);

            }

        } catch (IOException e) {

            System.out.println("ERROR al leer el archivo: " + e.getMessage());

        }

        return sB.toString();

    }

    public Map<String, Integer> getKgenMap(int size) {

        Map<String, Integer> kgenMap = new HashMap<>();

        if (fasta == null || fasta.length() < size) {

            System.out.println("Datos insuficientes para generar el mapa de tamaño " + size);
            return kgenMap;

        }

        int i = 0;

        while (i <= fasta.length() - size) {

            String section = fasta.substring(i, i + size);
            updateKgenMap(kgenMap, section);
            i++;

        }

        return kgenMap;
    }

    private void updateKgenMap(Map<String, Integer> kgenMap, String section) {

        if (kgenMap.containsKey(section)) kgenMap.put(section, kgenMap.get(section) + 1);
            else kgenMap.put(section, 1);

    }

    public String getFilePath() { return path; }
    public String getData() { return fasta; }

    public void setFilePath(String path) {

        this.path = path;
        this.fasta = readDataFromFile(path);

    }
    public void setData(String data) { this.fasta = data; }

}
