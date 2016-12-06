/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshell;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jan
 */
public class MyShell {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            System.out.print("myshell>> ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            
            if (input.equals("exit")) {
                break;
            } else if (input.equals("clear")) {
                callClear();
            } else {
                executeCommands(input);
            }
        }
        
        Runtime.getRuntime().exit(1);
    }
    
    public static void executeCommands(String input) {
        if (input.contains("&")) {
            String[] boslukluKomutlar = input.split("&");
            String[] komutlar = {boslukluKomutlar[0].substring(0, boslukluKomutlar[0].length() - 1), boslukluKomutlar[1].substring(1, boslukluKomutlar[1].length())};
            
            for (int i = 0; i < 2; i++) {
                if (komutlar[i].split(" ").length == 2) {
                    if (komutlar[i].split(" ")[0].equals("factorial")) {
                        callFactorial(Integer.parseInt(komutlar[i].split(" ")[1]));
                    } 
                    else {
                        System.out.println("Hatalı komut girdiniz!");
                    }
                } 
                else if (komutlar[i].split(" ").length == 3) {
                    if (komutlar[i].split(" ")[0].equals("plustwo")) {
                        callPlusTwo(Integer.parseInt(komutlar[i].split(" ")[1]), Integer.parseInt(komutlar[i].split(" ")[2]));
                    } 
                    else if (komutlar[i].split(" ")[0].equals("minustwo")) {
                        callMinusTwo(Integer.parseInt(komutlar[i].split(" ")[1]), Integer.parseInt(komutlar[i].split(" ")[2]));
                    } 
                    else {
                        System.out.println("Hatalı komut girdiniz!");
                    }
                }
            }
        } 
        else if (input.split(" ").length == 2) {
            if (input.split(" ")[0].equals("factorial")) {
                callFactorial(Integer.parseInt(input.split(" ")[1]));
            } 
            else if (input.split(" ")[0].equals("cat")) {
                callCat(input.split(" ")[1]);
            } 
            else {
                System.out.println("Hatalı komut girdiniz!");
            }
        } 
        else if (input.split(" ").length == 3) {
            if (input.split(" ")[0].equals("plustwo")) {
                callPlusTwo(Integer.parseInt(input.split(" ")[1]), Integer.parseInt(input.split(" ")[2]));
            } 
            else if (input.split(" ")[0].equals("minustwo")) {
                callMinusTwo(Integer.parseInt(input.split(" ")[1]), Integer.parseInt(input.split(" ")[2]));
            } 
            else {
                System.out.println("Hatalı komut girdiniz!");
            }
        } 
        else {
            System.out.println("Hatalı komut girdiniz!");
        }
    }    
    
    public static void callPlusTwo(int sayi1, int sayi2) {
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "PlusTwo.jar", String.valueOf(sayi1), String.valueOf(sayi2));
        
        String workingDir = System.getProperty("user.dir");
        
        pb.directory(new File(workingDir));
        try {
            Process proc = pb.start();
            proc.waitFor();
            
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();
            
            byte b[] = new byte[in.available()];
            in.read(b, 0, b.length);
            
            System.out.println(new String(b));
        } catch (IOException ex) {
            System.out.println("Çağırma işlemi başarısızlıkla sonuçlandı.");
        } catch (InterruptedException ex) {
            System.out.println("Çağırma işlemi başarısızlıkla sonuçlandı.");
        }
    }
    
    public static void callMinusTwo(int sayi1, int sayi2) {
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "MinusTwo.jar", String.valueOf(sayi1), String.valueOf(sayi2));
        
        String workingDir = System.getProperty("user.dir");
        
        pb.directory(new File(workingDir));
        try {
            Process proc = pb.start();
            proc.waitFor();
            
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();
            
            byte b[] = new byte[in.available()];
            in.read(b, 0, b.length);
            
            System.out.println(new String(b));
        } catch (IOException ex) {
            System.out.println("Çağırma işlemi başarısızlıkla sonuçlandı.");
        } catch (InterruptedException ex) {
            System.out.println("Çağırma işlemi başarısızlıkla sonuçlandı.");
        }
    }
    
    public static void callFactorial(int sayi1) {
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "Factorial.jar", String.valueOf(sayi1));
        
        String workingDir = System.getProperty("user.dir");
        
        pb.directory(new File(workingDir));
        try {
            Process proc = pb.start();
            proc.waitFor();
            
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();
            
            byte b[] = new byte[in.available()];
            in.read(b, 0, b.length);
            
            System.out.println(new String(b));
        } catch (IOException ex) {
            System.out.println("Çağırma işlemi başarısızlıkla sonuçlandı.");
        } catch (InterruptedException ex) {
            Logger.getLogger(MyShell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void callClear() {
        ProcessBuilder pb = new ProcessBuilder("clear");
        pb.directory(new File("/usr/bin"));
        try {
            Process proc = pb.start();
            proc.waitFor();
            
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();
            
            byte b[] = new byte[in.available()];
            in.read(b, 0, b.length);
            
            System.out.print(new String(b));
        } catch (IOException ex) {
            System.out.println("Çağırma işlemi başarısızlıkla sonuçlandı.");
        } catch (InterruptedException ex) {
            Logger.getLogger(MyShell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void callCat(String filePath) {
        if (!filePath.startsWith("/") || !filePath.contains(".")) {
            System.out.println("Böyle bir dosya bulunamadı.");
        } else {
            ProcessBuilder pb = new ProcessBuilder("cat", filePath);
            pb.directory(new File("/usr/bin"));
            try {
                Process proc = pb.start();
                proc.waitFor();
                
                InputStream in = proc.getInputStream();
                InputStream err = proc.getErrorStream();
                
                byte b[] = new byte[in.available()];
                in.read(b, 0, b.length);
                
                System.out.print(new String(b));
            } catch (IOException ex) {
                System.out.println("Çağırma işlemi başarısızlıkla sonuçlandı.");
            } catch (InterruptedException ex) {
                Logger.getLogger(MyShell.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
