/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.proyectos_para_exportar;

import java.util.Scanner;


public class Proyecto {

    
    public static void main(String[] args) {
       
        Scanner entra = new Scanner(System.in);        
        System.out.println("Bienvenido al simulador de Liga Profesional de Futbol por un salchichon");
        
        
        String[]equipos = new String[10];
        
        for(int i=0 ; i<10; i++){
            System.out.println("Por favor digite el nombre del equipo que quiere competir");
            String N = entra.nextLine();
            equipos[i] = N;
        }
        
        
        puntos (equipos);
         
        
        
        
        

    }
    
    public static void puntos (String equipos[]){
        Scanner entra = new Scanner(System.in);
        System.out.println("Pasadas las 20 fechas digite los resultados de los equipos");        
       int N =20;
       
        
           for(int i=0 ; i<N ;i++){
               System.out.println("Digite los partidos ganados y perdidos");
           }
        
        
        
       
        
        
        
       
    }
    
    
}
