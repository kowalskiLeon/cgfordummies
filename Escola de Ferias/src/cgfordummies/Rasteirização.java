/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgfordummies;

import java.util.Scanner;
import cgfordummies.SalvarMatriz;

/**
 *
 * @author Guilherme Moura
 */
public class Rasteirização {
    
    
    public static void fazerDDA(int tamanho, int x1, int y1, int x2, int y2){
        
        int matriz[][] = new int[tamanho][tamanho];
        
        float x = x1;   // x que será incrementado
        float y = y1;  //  y que será incrementado
        int dx = x2 - x1; //distancia entre xs
        int dy = y2 - y1; //distancia entre ys
        int passos; //quantidade de passos
        
        //comparação entre as distancias de x e y
        if(Math.abs(dx) > Math.abs(dy)){ passos = Math.abs(dx);}
        else {passos = Math.abs(dy);}
        
        double xincr = dx/(double) passos; //incremento de x
        double yincr = dy/(double) passos; //incremento de y
        
        matriz[Math.round(x)][Math.round(y)] = 1; // adicionando a primeira posição a matriz
        
        for(int k = 1; k <= passos; k++){
            x+= xincr; y += yincr; //incrementos
            matriz[Math.round(x)][Math.round(y)] = 1;
            
        }
        
        SalvarMatriz sv = new SalvarMatriz();
        sv.salvar(matriz, tamanho, "resultadoDDA.txt");
        
    }   

    public int[][] fazerBresenham(int tamanho, int x1, int y1, int x2, int y2){
        
        int matriz[][] = new int[tamanho][tamanho];
        
        int dx = x2 - x1; //diferença entre os xs
        int dy = y2 - y1; //diferença entre os ys
        int x = x1; //repassamos o ponto inicial para cada das variaveis que serão trabalhadas
        int y = y1;
        int incrx, incry, const1, const2, p;
        
        if(dx >= 0) incrx = 1;
        else{
            incrx = -1;
            dx = -dx;
        }
        
        if(dy >= 0) incry = 1;
        else{
            incry = -1;
            dy = -dy;
        }
        
        matriz[Math.round(x)][Math.round(y)] = 1; //adicionamos o ponto inicial
        
        if(dy < dx){
            p = 2*dy - dx;
            const1 = 2*dy;
            const2 = 2*(dy-dx);
            for(int i = 0; i < dx; i++){
                x += incrx;
                if(p < 0) p+= const1;
                else{
                    y += incry;
                    p += const2;
                }
                matriz[Math.round(x)][Math.round(y)] = 1;
                
            }
        }
        else{
            p = 2*dx - dy;
            const1 = 2*dx;
            const2 = 2*(dx - dy);
            
            for(int i = 0; i < dy; i++){
                y += incry;
                if(p < 0) p += const1;
                else{
                    x += incrx;
                    p+= const2;
                }
                matriz[Math.round(x)][Math.round(y)] = 1;
            }
        }
        
        return  matriz;
        
    }
    
    public int[][] fazerOctante(int tamanho, int xc, int yc, int r){
        
        int matriz[][] = new int[tamanho][tamanho];
        
        int x, y, p;
        
        x = 0; y = r; p = 3 - 2*r;
        matriz = plotarPontos(matriz, xc, x, yc, y);
        
        while(x < y){
            
            if(p < 0){
                p = p + 4*x + 6;
            }else{
                p = p + 4*(x - y) + 10;
                y = y -1;
            }
            x= x + 1;
            matriz = plotarPontos(matriz, xc, x, yc, y);
        } 
        
        
        return matriz;
    }
    
    
     public int[][] plotarPontos(int matriz[][], int xc, int x, int yc, int y){
        
        matriz[xc + x][yc + y] = 1;
        matriz[xc - x][yc + y] = 1;
        matriz[xc + x][yc - y] = 1;
        matriz[xc - x][yc - y] = 1;
        matriz[xc + y][yc + x] = 1;
        matriz[xc - y][yc + x] = 1;
        matriz[xc + y][yc - x] = 1;
        matriz[xc - y][yc - x] = 1;
        
        
        return matriz;
    }
    
    
    
    public Rasteirização() {
        
    }
    
     
       

}
