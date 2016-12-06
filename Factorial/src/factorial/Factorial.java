/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

/**
 *
 * @author jan
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        calculateFactorial(Integer.parseInt(args[0]));
    }
    
    public static void calculateFactorial(int sayi) {
        long sonuc = 1;
        
        for (int i = 2; i <= sayi; i++) {
            sonuc = sonuc * i;
        }
        
        System.out.print(String.valueOf(sayi) + "!" + " = " + String.valueOf(sonuc));
    }
    
}
