package com.company;

import java.io.*;
import java.util.Arrays;

public class Main {

    private static BufferedReader getFileBufferReader(String fileName) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(fileName);
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private static int[] liczZnakiSlowa(String fileName) throws IOException {
        BufferedReader br = getFileBufferReader(fileName);
        String line;
        int liczbaZnakow = 0;
        int liczbaBialychznakow = 0;
        int liczbaSlow = 0;
        while ((line = br.readLine()) != null) {
            liczbaZnakow += liczZnaki(line);
            liczbaBialychznakow += liczBialeZnaki(line);
            liczbaSlow += liczSlowa(line);
        }
        return new int[]{liczbaZnakow, liczbaBialychznakow, liczbaSlow};
    }

    private static int liczZnaki(String zdanie) {
        return zdanie.length();
    }

    private static int liczBialeZnaki(String zdanie) {
        return zdanie.length() - zdanie.replaceAll("\s", "").length();
    }

    private static int liczSlowa(String zdanie) {
        return zdanie.split("\s").length;
    }

    public static void main(String[] args) throws IOException {
        int tab[]=liczZnakiSlowa("text.txt");
        System.out.println("Liczba znaków - "+tab[0]);
        System.out.println("Liczba białych znaków - "+tab[1]);
        System.out.println("Liczba słów - "+tab[2]);
    }
}
