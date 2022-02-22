package com.company.I_O_Streams;

import java.io.*;

public class Data_Stream {
    public static void main(String[] args) {

        final String dataFile = "datas/invoice";
        int cant;
        double price;
        String prod;


        try(DataOutputStream out1 = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(dataFile)));){

            out1.writeInt(6);
            out1.writeDouble(5.7);
            out1.writeUTF("Culitos negros");
            out1.writeInt(12);
            out1.writeDouble(3);
            out1.writeUTF("Culitos blancos");
        }catch (UTFDataFormatException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }



        try(DataInputStream in1 = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));){
            while(true){

                cant = in1.readInt();
                price = in1.readDouble();
                prod = in1.readUTF();

                System.out.format("%2d %5.2f   %s \t %s %.3f%n" , cant, price, prod, "total: ", cant * price);

            }
        }catch (EOFException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


    }

}
/*
Data streams support binary I/O of primitive data type values
(boolean, char, byte, short, int, long, float, and double) as well as String values.
All data streams implement either the DataInput interface or the DataOutput interface.
This section focuses on the most widely-used implementations of these interfaces,
DataInputStream and DataOutputStream.
 */

/*
Then DataStreams opens an output stream. Since a DataOutputStream can only be created as a wrapper
for an existing byte stream object, DataStreams provides a buffered file output byte stream.
*/
