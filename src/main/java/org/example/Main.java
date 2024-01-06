package org.example;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.example.kafka.record.Rent;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Rent rent = Rent.newBuilder()
                .setId(1)
                .setClientId(42)
                .setCourtId(2)
                .setRentalName("Super rental")
                .setStartTime(sdf.format(new Date()))
                .setEndTime(null)
                .build();

        DatumWriter<Rent> rentDatumWriter = new SpecificDatumWriter<Rent>(Rent.class);

        try (DataFileWriter<Rent> dataFileWriter = new DataFileWriter<Rent>(rentDatumWriter)) {
            dataFileWriter.create(rent.getSchema(), new File("xd.avro"));
            dataFileWriter.append(rent);
        }

        System.out.println("Good");

        DatumReader<Rent> rentDatumReader = new SpecificDatumReader<Rent>(Rent.class);

        try (DataFileReader<Rent> dataFileReader = new DataFileReader<Rent>(new File("xd.avro") ,rentDatumReader)) {
            if (dataFileReader.hasNext()) {
                Rent next = dataFileReader.next();
                System.out.println(next);
            }
        }

        while (true);
    }
}