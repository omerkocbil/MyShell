/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minustwo;

/**
 *
 * @author jan
 */
public class MinusTwo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        minusTwo(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }
 
    public static void minusTwo(int i1, int i2) {
        System.out.print(String.valueOf(i1) + " - " + String.valueOf(i2) + " = " + String.valueOf(i1 - i2));
    }
    
}
