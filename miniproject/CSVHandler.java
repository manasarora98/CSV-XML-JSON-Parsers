package com.com.miniproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CSVHandler implements MyFileHandler {

    public void read() throws Exception
    {
        try {
            FileReader fileReader = new FileReader("/Users/manasarora/Downloads/employee.csv");
            BufferedReader csvReader = new BufferedReader(fileReader);
            String line = csvReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
               // System.out.println("Employee First Name=" + data[0] + ", Last Name=" + data[1] + ", Date of Birth=" + data[2] + ", Experience=" + data[3]);
                line = csvReader.readLine();
                Employee e = new Employee();
                Date date = new SimpleDateFormat("dd/MM/yy").parse(data[2]);
                Long exp = Long.parseLong(data[3]);
                e.setDateOfBirth(date);
                e.setExperience(exp);
                e.setFirstName(data[0]);
                e.setLastName(data[1]);
                MyCollection.add(e);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void write()
    {
        ArrayList<Employee> employees = new ArrayList<>();
        for(int i = 0; i < 100; i++)
            employees.add(MyCollection.get());
        try {

            FileWriter csvWriter = new FileWriter("/Users/manasarora/Downloads/outemployee2.csv");
            for(Employee i:employees)
            {
                csvWriter.append(i.getFirstName());
                csvWriter.append(",");
                csvWriter.append(i.getLastName());
                csvWriter.append(",");
                String strDate = (new SimpleDateFormat("dd-mm-yy")).format(i.getDateOfBirth().getTime());
                csvWriter.append(strDate);
                csvWriter.append(",");
                String exp=Double.toString(i.getExperience());
                csvWriter.append(exp);
                csvWriter.append("\n");
            }
            csvWriter.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}