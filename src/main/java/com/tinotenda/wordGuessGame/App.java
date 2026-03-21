package com.tinotenda.wordGuessGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App{
    static Scanner scanner=new Scanner(System.in);

    private static String randomWordPicking(String[] arr){
        Random random=new Random();
        int index= random.nextInt(arr.length);
        return arr[index];
    }

    private static void welcomeMessage(){
        System.out.println("""
                Welcome to my Word Guessing Game!!!!
                Please select the difficulty you wanna play...
                1.Easy(10 attempts)
                2.Medium(5 attempts)
                3.Hard(3 attempts)
                Enter your choice:
                """);
    }

    private static void display(){
        System.out.println("Do you want to continue playing????");
        System.out.println("""
                1.Yes
                2.No
                """);
    }

    private static int getValidInput(int min, int max){//used 2 params to ensure flexibility  of inputs
        int num;
        while(true) {
            try {
                num= scanner.nextInt();
                if(num>=min&&num<=max) return num;
                else System.out.println("Out of range...Try again!!!");

            }catch (InputMismatchException e){
                System.out.println("Please enter the correct number!!!");
                scanner.nextLine();//write something here about why you keep on forgetting to add this
            }catch (Exception e){
                System.out.println("Something wrong with your input!!!");
                scanner.nextLine();
            }
        }
    }

    private static Difficulty selectDifficulty(int mode){
        return Difficulty.values()[mode-1];
    }

    private static boolean startGame(Difficulty chosenMode){
        String wordToGuess = randomWordPicking(chosenMode.getWordDifficulty());
        WordGuessingGame startGuessing = new WordGuessingGame(wordToGuess,chosenMode.getAttempts());
        return startGuessing.play();
    }

    public static void main(String[] args){


       int choice=1;
       int mode;
       boolean result;
       Difficulty chosenMode;
        do {
            welcomeMessage();
            mode=getValidInput(1,3);
            chosenMode=selectDifficulty(mode);
            if (startGame(chosenMode)) System.out.println("You won!!!!");
            else System.out.println("You lost");
            display();
            choice=getValidInput(1,2);

        }while(choice==1);


    }
}
