package com.company.I_O_Streams;

import java.io.*;

public class Character_Streams {
    public static void main(String[] args) {
     int c;
     try(FileReader in = new FileReader("xanadu.txt");
         FileWriter out = new FileWriter("datas/character-output.txt");){

         while ((c = in.read())!= -1){
             out.write(c);
             System.out.format("%d ", c);
         }
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }

    }
}
