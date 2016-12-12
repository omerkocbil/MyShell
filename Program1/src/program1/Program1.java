/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jan
 */
public class Program1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createAndWriteFile(args[0], args[1]);
    }
    
    public static void createAndWriteFile(String fileName, String content) {
        String workingDir = System.getProperty("user.home");
        File f = new File(workingDir + "/" + fileName + ".txt");
        FileWriter fw;
        try {
            fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            System.out.print("Dosya oluşturma ve yazma işlemi başarılı");
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Program1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
