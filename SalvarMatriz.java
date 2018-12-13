/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgfordummies;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guile
 */
public class SalvarMatriz {
    
    
    public void salvar(int matriz[][], int n, String pathname){
        
        String texto = n + "\n";
       
        try {
             File out = new File(pathname);
             FileWriter fw = new FileWriter(out);
             
             
             
             for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                
                    texto += matriz[i][j] + " ";
                    
                }
                texto += "\n";
            }
            fw.write(texto);
            fw.close();
            
             
        } catch (IOException ex) {
            Logger.getLogger(SalvarMatriz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
}
