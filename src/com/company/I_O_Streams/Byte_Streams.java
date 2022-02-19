package com.company.I_O_Streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Programs use byte streams to perform input and output of 8-bit bytes. All byte stream classes
are descended from InputStream and OutputStream.

There are many byte stream classes. To demonstrate how byte streams work,
we'll focus on the file I/O byte streams, FileInputStream and FileOutputStream.
Other kinds of byte streams are used in much the same way; they differ mainly in
the way they are constructed.
 */
public class Byte_Streams {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
                System.out.print(c + " ");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }

        }

        //Byte Stream with try-with-resources
        System.out.println();
        int c1;


        try (FileInputStream in1 = new FileInputStream("xanadu.txt"); FileOutputStream out1 = new FileOutputStream("outagain2.txt")) {

            while ((c1 = in1.read()) != -1) {
                out1.write(c1);
                System.out.print(c1 + "-");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}



