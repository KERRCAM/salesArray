package com.company;

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
        menu();
    }
}
