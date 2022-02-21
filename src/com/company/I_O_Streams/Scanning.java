package com.company.I_O_Streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Scanning {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner s = null;
        try{
            s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));

            while (s.hasNext()){
                System.out.format("%s%n",s.next());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        finally {
            if(s != null){
                s.close();
            }
        }
    }
}

/*
Objects of type Scanner are useful for breaking down formatted input into tokens
and translating individual tokens according to their data type.
y default, a scanner uses white space to separate tokens. (White space characters
include blanks, tabs, and line terminators. For the full list, refer to the
documentation for Character.isWhitespace.)
 */