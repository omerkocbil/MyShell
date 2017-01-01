/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshell;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author jan
 */
public class Fabrika {

    public static void main(String[] args) {
        Makina1 makina1 = new Makina1();
        Makina2 makina2 = new Makina2();
        BirlestirmeMakinasi birlestirmeMakinasi = new BirlestirmeMakinasi();
        
        Thread makina1Thread = new Thread(makina1);
        Thread makina2Thread = new Thread(makina2);
        
        makina1Thread.start();
        makina2Thread.start();
    }
    
}

class Makina1 implements Runnable {

    private String urun = "&";
    boolean ilkDurum = true;

    public void run() {
        while (true) {
            if(BirlestirmeMakinasi.birlesmeDurumu || ilkDurum) {
                ilkDurum = false;
                System.out.println(urun + " üretilmeye başlandı.");
                BirlestirmeMakinasi.urunAdi = urun;
                
                try {
                    TimeUnit.SECONDS.sleep((long)(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                System.out.println(urun + " üretimi bitti. Birleştirme için bekleniyor.");
                BirlestirmeMakinasi.gelenUrunSayisi++;
                BirlestirmeMakinasi.birlesmeDurumu = false;
            }    
            
            BirlestirmeMakinasi.birlestir();
        }
    }
    
}

class Makina2 implements Runnable {

    private String urun = "$";
    boolean ilkDurum = true;

    public void run() {
        while (true) {
            if(BirlestirmeMakinasi.birlesmeDurumu || ilkDurum) {
                ilkDurum = false;
                System.out.println(urun + " üretilmeye başlandı.");
                BirlestirmeMakinasi.urunAdi = urun;
                
                try {
                    TimeUnit.SECONDS.sleep((long)(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                System.out.println(urun + " üretimi bitti. Birleştirme için bekleniyor.");
                BirlestirmeMakinasi.gelenUrunSayisi++;
                BirlestirmeMakinasi.birlesmeDurumu = false;
            }   
            
            BirlestirmeMakinasi.birlestir();
        }
    }
    
}

class BirlestirmeMakinasi {

    static boolean birlesmeDurumu = false;
    static int gelenUrunSayisi = 0;
    static int urunNumarasi = 0;
    static String urunAdi;
    
    synchronized static void birlestir() {
        if(gelenUrunSayisi == 2) {
            urunNumarasi++;
            
            try {
                TimeUnit.SECONDS.sleep((long)(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            if(urunAdi.equals("&")) {
                System.out.println(urunNumarasi + "_" + "$" + urunAdi);
            }
            else if(urunAdi.equals("$")) {
                System.out.println(urunNumarasi + "_" + "&" + urunAdi);
            }
            
            gelenUrunSayisi = 0;
            birlesmeDurumu = true;
        }
    }
}
