/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioDatos;

import contactosui.Contactos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Files {
    
   /* public static void rellenarContactos(){
      File f = new File("contactos.dat");
        FileOutputStream fo;
          ObjectOutputStream oo;
          
          
            if (!f.exists()) {
          try {
              f.createNewFile();
          } catch (IOException ex) {
              System.out.println("Error al crear el archivo");
          }
        }
            
            
            
        
         if (f.exists()) {    
            
          
        try {
            fo = new FileOutputStream(f);
            oo = new ObjectOutputStream(fo);
            ArrayList<Contactos> v = new ArrayList<>();
            v.add(new Contactos("marcos", "Omella", "Pellicer", "Soltero", "Masculino", "20"));
               oo.writeObject(v);
        oo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
              Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
          }
      
      }
        
       
        
        
    }*/
    
    
        
    public static ArrayList<Contactos> cargarContactos(){
       
        ArrayList<Contactos> vContactos = new ArrayList();
        File f = new File("contactos.dat");
        FileInputStream fi = null;        
        ObjectInputStream oi= null;
        
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error al crear el archivo");
            }
        }
        
        if (f.exists()) {
            try {
               fi = new FileInputStream(f);
               oi = new ObjectInputStream(fi);
               
               while(true){
                   Contactos c = (Contactos) oi.readObject();
                   vContactos.add(c);
               }
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.out.println("Fin de lectrua");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                try {
                    if (oi!=null)
                        oi.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el archivo");
                }
            }
 
        }
     
      
        
        return  vContactos;
    }
    
   

    public static void guardarContactos(ArrayList<Contactos> vContactos) {
      File f = new File("contactos.dat");
      FileOutputStream fo = null;
      ObjectOutputStream oo = null;
      
        if (!f.exists()) {
          try {
              f.createNewFile();
          } catch (IOException ex) {
              System.out.println("Error al crear el archivo");
          }
        } 
            if (f.exists()) {
                
              try {
                  fo= new FileOutputStream(f);
                  oo = new ObjectOutputStream(fo);
                  
                  for (Contactos vContacto : vContactos) {
                      oo.writeObject(vContacto);
                  }
              } catch (FileNotFoundException ex) {
                  System.out.println("Error al escribir en el archivo");
   
              } catch (IOException ex) {
                  Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
              }finally{
                  try {
                      oo.close();
                  } catch (IOException ex) {
                      System.out.println("Error al cerrar el archivo");
                  }
              }
                
                
            }
        
      
    }
}
