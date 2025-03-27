/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package daw;

/**
 *
 * @author jfervic933
 */
public record Celda(int fila, int columna) {
    
    // Para marcar esta celda como visitada
    public void visitar(int[][] matriz){
        matriz[this.fila][this.columna] = -1;
    }
    
    public boolean contieneUno(int[][] matriz){
        return matriz[this.fila][this.columna] == 1;
    }
    
    public boolean esValida(int[][] matriz){
        return fila>=0&&fila<matriz.length&&columna>=0&&columna<matriz[fila].length;
    }

}
