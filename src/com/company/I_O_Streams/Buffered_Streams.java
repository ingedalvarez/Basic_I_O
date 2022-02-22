package com.company.I_O_Streams;


import java.io.*;

public class Buffered_Streams {
    public static void main(String[] args) throws IOException {
        int c;


        try(BufferedReader in = new BufferedReader(new FileReader("xanadu.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("datas/character_output_bufferedReader.txt"));) {
            while((c=in.read())!=-1){
                out.write(c);
                System.out.format("%d ", c);

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
