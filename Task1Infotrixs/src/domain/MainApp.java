package domain;

import java.util.Scanner;
// THIS CLASS HAS BEEN CREATED TO WRITE USER INTERFACE
public class MainApp {

    public static void main(String[] args) {
        Logic logic=new Logic();
        Scanner sc = new Scanner(System.in);
        boolean status=true;
        while (status) {

            System.out.println("***// ENTER THE NUMBER //***\n1: Display all Employee\n2: Display Employee by Id\n3: Add an Employee\n4: Update an Employee\n5: Delete an Employee\n6: Exit");
            String choice = sc.next();

            if (choice.equals("1")){
                logic.allEmp();
            } else if (choice.equals("2")) {
                System.out.println("Enter Employee Id");
                String id=sc.next();
                logic.fetchEmp(id);
            } else if (choice.equals("3")) {
                System.out.println("Enter Details separated by details");
                String newRecord=sc.next();
                logic.addEmployee(newRecord);

            } else if (choice.equals("4")) {

                System.out.println("Enter Employee Id");
                String id=sc.next();
                while (true) {
                    System.out.println("Enter what you want to update\n1: Id\n2: Name\n3: Age\n4: Salary\n5: Exit");
                    String updateChoice = sc.next();

                    if (updateChoice.equals("1")) {
                        System.out.println("Enter updated id");
                        String updatedId=sc.next();
                        logic.updateEmployeeRecord(id,updatedId,0);
                        break;
                    } else if (updateChoice.equals("2")) {
                        System.out.println("Enter updated name");
                        String upFirstName=sc.next();
                        logic.updateEmployeeRecord(id,upFirstName,1);
                        break;
                    } else if (updateChoice.equals("3")) {
                        System.out.println("Enter updated age");
                        String upLastName=sc.next();
                        logic.updateEmployeeRecord(id,upLastName,2);
                        break;
                    } else if (updateChoice.equals("4")) {
                        System.out.println("Enter updated salary");
                        String upSalary=sc.next();
                        logic.updateEmployeeRecord(id,upSalary,3);
                        break;

                    } else if (updateChoice.equals("5")) {
                        break;
                    } else {
                        System.out.println("Enter valid choice");
                        continue;
                    }
                }
            } else if (choice.equals("5")) {
                System.out.println("Enter Employee Id");
                String id=sc.next();
                logic.deleteRecord(id);

            } else if (choice.equals("6")) {
                status=false;
            }else {
                System.out.println("////-ENTER VALID NUMBER-////");
            }
        }

    }
}



