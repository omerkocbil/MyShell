/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program2;

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
public class Program2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        changeFile(args[0], args[1]);
    }
    
    public static void changeFile(String fileName, String character) {
        String workingDir = System.getProperty("user.home");
        File f = new File(workingDir + "/" + fileName + ".txt");
        FileWriter fw;
        FileReader fr;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String s = "", line;
            while((line = br.readLine()) != null) {
                 s = s + line;
            }
            
            br.close();
            fr.close();
            
            fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            
            s = s.replaceAll(" ", character);
            bw.write(s);
            
            bw.close();
            fw.close();
            
            File newFile = new File(System.getProperty("user.home") + "/" + fileName + "_" + character + ".txt");
            if(f.renameTo(newFile)){
                System.out.print("Dosya değiştirme işlemi başarılı");
            }
            else {
                System.out.print("Dosya değiştirme işlemi başarısız");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Program2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
