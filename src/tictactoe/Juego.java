/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
/**
 *
 * @author Miguel
 */
public class Juego {
    char[][] tablero;
    int jugadorActual = 1;

    public Juego(){
        tablero = new char[3][3];
        iniciarTablero();
    }
    
    public void iniciarTablero(){
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                tablero[x][y] = '-';
            }
        }
    }
    public void imprimirTablero(){
        for (int x = 0; x < 3; x++) {
            System.out.println("_______");
            System.out.print("|");
            for (int y = 0; y < 3; y++) {
                System.out.print(tablero[x][y]);
                System.out.print("|");
               
            }
             System.out.println("");
            
        }
        System.out.println("_______");
    }    
    public boolean marcarCasilla(int x, int y){
        if(tablero[x][y] == '-'){
            tablero[x][y] = (jugadorActual == 1 ? 'O' : 'X');
            if(!hayGanador()){
                jugadorActual = (jugadorActual == 1 ? 2 : 1);
            }
            return true;
        }
        return false;
    }
    
    public boolean isTableroLleno(){
        boolean lleno = true;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if(tablero[x][y] == '-'){
                    lleno = false;
                }
            }
        }
        return lleno;
    }
    
    public int obtenerJugadorActual(){
        return jugadorActual;
    }
    public boolean revisarFilas(){
       return (tablero[0][0] != '-' && (tablero[0][0] == tablero[0][1] && tablero[0][1] == tablero[0][2])) ||
               (tablero[1][0] != '-' && (tablero[1][0] == tablero[1][1] && tablero[1][1] == tablero[1][2])) ||
               (tablero[2][0] != '-' && (tablero[2][0] == tablero[2][1] && tablero[2][1] == tablero[2][2])) ;
    }
    public boolean revisarDiagonales(){
        return (tablero[0][0] != '-' && (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2])) ||
                (tablero[2][0] != '-' && (tablero[2][0] == tablero[1][1] && tablero[1][1] == tablero[0][0]));
    }
    public boolean revisarColumnas(){
        return (tablero[0][0] != '-' && (tablero[0][0] == tablero[1][0] && tablero[1][0] == tablero[2][0])) ||
                (tablero[0][1] != '-' && (tablero[0][1] == tablero[1][1] && tablero[1][1] == tablero[2][1])) ||
                (tablero[0][2] != '-' && (tablero[0][2] == tablero[1][2] && tablero[1][2] == tablero[2][2]));
    }
    public boolean hayGanador(){
        return  revisarFilas() || revisarDiagonales() || revisarColumnas();
    }
}