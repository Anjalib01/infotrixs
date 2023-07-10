package domain;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//THIS CLASS HAS BEEN USED TO WRITE LOGIC

public class Logic {
    static String filePath ="D:\\ANJI\\infotrixs\\ems.csv";

    //Method to Fetch all employee
    public void allEmp(){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                for (String value : values) {
                    System.out.print(value.trim() + "\t");
                }
                System.out.println();
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Method to fetch employee by "Id"
    public void fetchEmp(String id){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                if (values[0].trim().equals(id)) {

                    System.out.println();
                    System.out.println("ID: " + values[0]);
                    System.out.println("Name: " + values[1]);
                    System.out.println("Age: " + values[2]);
                    System.out.println("City: " + values[3]);
                    System.out.println();
                    System.out.println();
                    found = true;
                    break;
                }
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Method to add new employee
    public void addEmployee(String newRecord){

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true))) {
            printWriter.println(newRecord);
            System.out.println("New record added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Method to update an employee record
    public void updateEmployeeRecord(String id, String empId, int val){

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + ".tmp"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals(id)){
                    values[val]=empId;
                }

                writer.write(String.join(",", values));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            java.nio.file.Files.move(
                    java.nio.file.Paths.get(filePath + ".tmp"),
                    java.nio.file.Paths.get(filePath),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println("Record updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to update the CSV file.");
        }
    }

    //Method to delete employee record
    public void deleteRecord(String id) {

        List<String> updatedRecords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                if (!(values.length > 0 && values[0].equals(id))) {
                    updatedRecords.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String record : updatedRecords) {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Record deleted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to delete the record from the CSV file.");
        }
    }
}

