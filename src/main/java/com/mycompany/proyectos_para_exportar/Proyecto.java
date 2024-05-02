
package com.mycompany.proyectos_para_exportar;

import java.util.Scanner;
import java.util.Random;

public class Proyecto {

    public static void main(String[] args) {
        Scanner entra = new Scanner(System.in);
        System.out.println("Bienvenido al simulador de Liga Profesional de Futbol por un salchichon");

        String[] equipos = new String[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Por favor digite el nombre del equipo que quiere competir");
            String N = entra.nextLine();
            equipos[i] = N;
            System.out.print("\033c"); // Limpiar consola puede no funcionar en todos los terminales
        }

        int[][] resultados = partidos(equipos);
        int[] puntos = calcularPuntos(resultados);
        tabla(equipos, puntos);
        estadisticas(equipos, resultados);
    }

    public static int[][] partidos(String[] equipos) {
        int[][] resultados = new int[equipos.length][3]; // [][0]: ganados, [][1]: perdidos, [][2]: empatados
        Random random = new Random();

        // Simulando todos los partidos
        for (int i = 0; i < equipos.length; i++) {
            for (int j = i + 1; j < equipos.length; j++) {
                int resultado = random.nextInt(3); // 0 = gana i, 1 = gana j, 2 = empate
                if (resultado == 0) {
                    resultados[i][0]++; // i gana
                    resultados[j][1]++; // j pierde
                } else if (resultado == 1) {
                    resultados[j][0]++; // j gana
                    resultados[i][1]++; // i pierde
                } else {
                    resultados[i][2]++; // Empate
                    resultados[j][2]++;
                }
            }
        }
        return resultados;
    }

    public static int[] calcularPuntos(int[][] resultados) {
        int[] puntos = new int[resultados.length];
        for (int i = 0; i < resultados.length; i++) {
            puntos[i] = resultados[i][0] * 3 + resultados[i][2]; // 3 puntos por victoria, 1 punto por empate
        }
        return puntos;
    }

    public static void tabla(String[] equipos, int[] puntos) {
        // Ordenar equipos y puntos de mayor a menor
        for (int i = 0; i < puntos.length; i++) {
            for (int j = i + 1; j < puntos.length; j++) {
                if (puntos[i] < puntos[j]) {
                    int temp = puntos[i];
                    puntos[i] = puntos[j];
                    puntos[j] = temp;
                    
                    String tempNombre = equipos[i];
                    equipos[i] = equipos[j];
                    equipos[j] = tempNombre;
                }
            }
        }

        System.out.println("Tabla de resultados de la liga:");
        for (int i = 0; i < equipos.length; i++) {
            System.out.printf("%-20s %d puntos\n", equipos[i], puntos[i]);
        }
    }

    public static void estadisticas(String[] equipos, int[][] resultados) {
        System.out.println("Estadísticas de partidos (Ganados, Perdidos, Empatados):");
        for (int i = 0; i < equipos.length; i++) {
            System.out.printf("%-20s %d Ganados, %d Perdidos, %d Empatados\n", equipos[i], resultados[i][0], resultados[i][1], resultados[i][2]);
        }
    }
}