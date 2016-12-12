/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jan
 */
public class Program3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        readAndDeleteFile(args[0]);
    }
    
    public static void readAndDeleteFile(String fileName) {
        String workingDir = System.getProperty("user.home");
        File f = new File(workingDir + "/" + fileName + ".txt");
        FileReader fr;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String s = "", line;
            while((line = br.readLine()) != null) {
                 s = s + line;
            }
            
            System.out.println("Dosyanın içeriği: " + s);
            
            br.close();
            fr.close();
            
            if(f.delete()) {
                System.out.print("Dosya silme işlemi başarılı");
            }
            else {
                System.out.print("Dosya silme işlemi başarısız");
            }
               
        } catch (IOException ex) {
            Logger.getLogger(Program3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
