/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package l01;

import ThinhLib.MyLib;

/**
 * L01 - Create a Java console program to manage Candidates of company.
 * @author ThinhNDCE190865
 */
public class L01 {

    /**
     * main method, used to execute the program
     * 
     * @param args the command line arguments, used to retrieve data for program execution
     */
    public static void main(String[] args) {
        try {
            ManageCandidate manageCandidate = new ManageCandidate();
            byte choiceFunc = -1;

            do {
                System.out.println();
                System.out.println("   CANDIDATE MANAGEMENT SYSTEM");
                System.out.println("1. Experience");
                System.out.println("2. Fresher");
                System.out.println("3. Internship");
                System.out.println("4. Searching");
                System.out.println("5. Exit");

                do {
                    choiceFunc = MyLib.getPositiveByte("   Please choose: ");
                    if (choiceFunc > 5) {
                        System.out.println("Invalid choose. Please enter again the number between 1 and 5");
                    }
                } while (choiceFunc > 5);

                byte type;
                switch (choiceFunc) {
                    case 1:
                        type = 0;
                        manageCandidate.manageCandidates(type);
                        break;
                    case 2:
                        type = 1;
                        manageCandidate.manageCandidates(type);
                        break;
                    case 3:
                        type = 2;
                        manageCandidate.manageCandidates(type);
                        break;
                    case 4:
                        manageCandidate.searchCandidate();
                        break;
                    case 5:
                        System.out.println("Thank You");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again");
                }
            } while (choiceFunc != 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
