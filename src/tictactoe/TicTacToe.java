/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Juego gato = new Juego();
        int x, y;
        gato.imprimirTablero();  
        do {  
            System.out.print("[JUGADOR " + (gato.obtenerJugadorActual() == 1 ? 'O' : 'X') + "] Ingrese la coordenada X: ");
            x = sc.nextInt()-1;
            sc.nextLine();
            System.out.print("[JUGADOR " + (gato.obtenerJugadorActual() == 1 ? 'O' : 'X') + "] Ingrese la coordenada Y: ");
            y = sc.nextInt()-1;
            sc.nextLine();
            if(!gato.marcarCasilla(x, y)){
                 System.out.println("[JUGADOR " + (gato.obtenerJugadorActual() == 1 ? 'O' : 'X') + "] Las coordenadas seleccionadas no se encuentran disponibles");
            }else{
                gato.imprimirTablero(); 
            }
        } while(!gato.hayGanador() && !gato.isTableroLleno());
        
        if(gato.isTableroLleno()){
            System.out.println("EMPATE");
        }else{
            System.out.println("El jugador " + (gato.obtenerJugadorActual() == 1 ? 'O' : 'X') + " gana :p");
        }
    }
}