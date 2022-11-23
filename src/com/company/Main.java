package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int sales[][][] = new int[5][4][2];

    public static String getString(String prompt) {
        Scanner input = new Scanner(System.in);
        String strInput = "";
        try {
            System.out.println(prompt);
            strInput = input.next();
        } catch (Exception e) {
            System.out.println("incorrect input");
            System.out.println(e);
        }
        return (strInput);
    }

    public static int getInt(String prompt) {
        Scanner input = new Scanner(System.in);
        int intInput = 0;
        while (intInput < 1) {
            System.out.println(prompt);
            intInput = input.nextInt();
        }
        return (intInput);
    }

    public static void inputYear(){
        int yearInput = getInt("which year would you like to fill in?");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                int salesInput = getInt("what were the sales for quarter" + i + "department" + j);
                (sales[yearInput-1][i][j]) = salesInput;
            }
        }
        updateSave();
    }

    public static void outputYear(){
        int yearInput = getInt("which year would you like to display?");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(sales[yearInput-1][i][j]);
            }
        }
    }

    public static void outputAllYears(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.println(sales[i][j][k]);
                }
            }
        }
    }

    public static void updateSave() {
        try {
            FileWriter myWriter = new FileWriter("sales.txt", false);
            //myWriter.write( + "\n"); // writes to file
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 2; k++) {
                        myWriter.write( sales[i][j][k] + ",");
                    }
                }
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public static void loadSave(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                List<String> splitLine = Arrays.asList(line.split(","));
                for (int j = 0; j < 4; j++) { //just need to change 200 and map in play for tutorial map version
                    for (int k = 0; k < 2; k++) {
                        sales[i][j][k] = Integer.parseInt(splitLine.get(k));
                    }
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e);
        }
    }



    public static void menu() {
        boolean menu = true;
        while (menu == true) {
            String action = getString("what would you like to (enter number of action): \n (1)-input year-  \n (2)-output year- \n (3)-output all years-");
            if (action.equals("1")) {
                inputYear();
            }
            if (action.equals("2")) {
                outputYear();
            }
            if (action.equals("2")) {
                outputAllYears();
            }
            String menuAgain = getString("would you like to perform another action Y or N?");
            if (menuAgain.equals("N")) {
                menu = false;
            }
        }
    }




    public static void main(String[] args) {
        loadSave("sales.txt");
        menu();
    }
}
