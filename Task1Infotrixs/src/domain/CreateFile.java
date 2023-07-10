package domain;
import java.io.FileWriter;
import java.io.IOException;

//THIS CLASS HAS BEEN USED TO CREATE "CSV" FILE IN SYSTEM
public class CreateFile {
    public static void main(String[] args) {
        String filePath = "D:\\ANJI\\infotrixs\\ems.csv";
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.append("Id, Name, Age, Salary\n");
            fileWriter.append("1, Renuka, 24, 40000\n");
            fileWriter.append("2, Teena, 25, 50000\n");
            fileWriter.append("3, Rada, 22, 30000\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
