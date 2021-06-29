/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unshareddeserializedobject;

import java.io.*;

/**
 *
 * @author dikka.aditya
 */
public class UnsharedDeserializedObject {
    rivate static void writeObject(Object o) throws Exception {
         try {
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.txt"));
             oos.writeUnshared(o);
             oos.flush();
             oos.close();
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));
         } catch (FileNotFoundException ex) {
             throw ex;
         } catch (IOException ex) {
             throw ex;
         }
     }

     private static Object readObject() throws Exception {
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));
         try {
             Object readObject = ois.readObject();
             ois.close();
             return readObject;
         } catch (ClassNotFoundException ex) {
             throw ex;
         }
     }

     public static void main(String[] args) {
         Mahasiswa m = new Mahasiswa("1817101399", "Dikka Aditya");
         try {
             writeObject(m);
             Mahasiswa readObject = (Mahasiswa) readObject();
             System.out.println("" + readObject);
         } catch (Exception ex) {
            // System.Logger.getLogger(Praktikum1.class.getName()).log(System.Logger.Level.SEVERE, null, ex);
         }
     }
}
