/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola.de.ferias;

import cgfordummies.Amostragem;
import cgfordummies.Rasteirização;
import cgfordummies.SalvarMatriz;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author guile
 */
public class EscolaDeFerias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rasteirização dda = new Rasteirização();
        
        try {
            /*Scanner entrada = new Scanner(System.in);
            
            int n = entrada.nextInt();
            int xc = entrada.nextInt();
            int yc = entrada.nextInt();
            int r = entrada.nextInt();
            
            int matriz [][] = dda.fazerOctante(n, xc, yc, r);
            SalvarMatriz sv = new SalvarMatriz();
            sv.salvar(matriz, n, "Teste.txt");*/
            
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EscolaDeFerias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(EscolaDeFerias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EscolaDeFerias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(EscolaDeFerias.class.getName()).log(Level.SEVERE, null, ex);
        }
        Amostragem a = new Amostragem();
        a.setVisible(true);
        
        
    }
    
}
