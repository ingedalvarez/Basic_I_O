package com.company.I_O_Streams;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;


public class Object_StreamsII {
    final static String dataFile = "datas/object_StreamsII";
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2022, Month.JANUARY, 15);
        LocalDate date2 = LocalDate.of(2022, Month.FEBRUARY, 7);
        LocalDate date3 = LocalDate.of(2022, Month.JANUARY, 25);

        Invoice invoice1 = new Invoice("Culos blancos", 2, BigDecimal.valueOf(12.6), date1);
        Invoice invoice2 = new Invoice("Culos negros", 3, BigDecimal.valueOf(11.2), date2);
        Invoice invoice3 = new Invoice("Tetas caidas", 4, BigDecimal.valueOf(5.0), date3);

        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
        out.writeObject(invoice1);
        out.writeObject(invoice2);
        out.writeObject(invoice3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;


        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            while(true){
                Object obj = in.readObject();
                System.out.println(obj);
            }

        } catch (EOFException e) {
            System.out.println("end of the file has been reached");
        }
        catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }
}

class Invoice implements Serializable{
    protected String prod;
    protected Integer cant;
    protected BigDecimal price;
    protected BigDecimal total;
    protected LocalDate date;

    public Invoice(String prod, Integer cant, BigDecimal price, LocalDate date) {
        this.prod = prod;
        this.cant = cant;
        this.price = price;
        this.date = date;
        this.total = price.multiply(BigDecimal.valueOf(cant));

    }

    public String getProd() {
        return prod;
    }

    public Integer getCant() {
        return cant;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Invoice{ " +
                "prod= '" + prod + '\'' +
                ", cant= " + cant +
                ", price= " + price +
                ", total= " + total +
                ", date= " + date +
                '}';
    }
}
