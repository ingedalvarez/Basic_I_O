package com.company.I_O_Streams;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class Object_Streams {
    public static void main(String[] args) throws IOException {
        final String dataFile = "datas/invoiceObjetStreams";


try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
){
  out.writeObject(Integer.valueOf(12));
  out.writeObject(BigDecimal.valueOf(4.7));
  out.writeObject("nalgas aguadas");
  out.writeObject(new Date());

    out.writeObject(Integer.valueOf(10));
    out.writeObject(BigDecimal.valueOf(5.6));
    out.writeObject("tetas caidas");
    out.writeObject(LocalDate.of(2022, Month.JANUARY, 3));

    out.writeObject(Integer.valueOf(9));
    out.writeObject(BigDecimal.valueOf(6.8));
    out.writeObject("patas secas");
    out.writeObject(LocalDate.of(2019, Month.JULY, 15));

}catch (IOException e){
    e.printStackTrace();
}
       Object ob = new Object();
    try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))){
        while (true){
            ob = in.readObject();
            System.out.println(ob);
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }catch (EOFException e){
        System.out.println("end of the file has been reached");
    }


    }
}
