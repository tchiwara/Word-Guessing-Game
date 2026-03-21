package com.tinotenda.wordGuessGame;

import java.util.Arrays;
import java.util.Scanner;

public class WordGuessingGame {
    private final String wordToGuess;
    final private char[] guessedLetters;
    private int attempts;
    Scanner scanner = new Scanner(System.in);//always declare outside here

    public WordGuessingGame(String wordToGuess, int attempts) {
        this.wordToGuess = wordToGuess;
        this.attempts = attempts;
        this.guessedLetters = new char[wordToGuess.length()];
        Arrays.fill(guessedLetters, '_');
    }

    private char getValidInput() {
        /*
        * RULE1: Never use scanner twice, always take input once and do the validation
        * I had firstly made a deadly mistake of not storing input in a variable and i had to be prompted to take it twice*/
        while(true){
                System.out.println("Enter a letter: ");
                char ch=scanner.next().toLowerCase().charAt(0);
                if(Character.isLetter(ch)) return ch;
                else System.out.println("Wrong input here...Please enter a character....");
        }

    }

    private boolean checkLetter(char enteredLetter) {
        int i = 0;
        int pos = 0;
        if (wordToGuess.indexOf(enteredLetter) == -1) {
            return false;
            //attempts--; made this mistake here of placing attempts-- after returning so this will never execute
        } else {
            while (i < wordToGuess.length()) {
                if (wordToGuess.indexOf(enteredLetter, i) != -1) {
                    pos = wordToGuess.indexOf(enteredLetter, i);
                    guessedLetters[pos] = enteredLetter;
                    i = pos + 1;
                } else i++;
            }
            return true;
        }
    }

    public boolean play() {
        while (attempts > 0) {
            char enteredLetter = getValidInput();
            boolean res = checkLetter(enteredLetter);
            if(!res){
                attempts--;
                System.out.println("Wrong...You have " + attempts + " attempts remaining....");

            }else{
                int count=0;
                for (char guessedLetter : guessedLetters) {
                    if (guessedLetter == '_'){
                        System.out.println("Good keep going... " + attempts + " attempts remaining....");
                        System.out.println(guessedLetters);
                        break;
                    }
                    count+=1;
                }
                if(count== guessedLetters.length) return true;
            }
        }
        return false;
    }
}

/*private char getValidInput() {
    while(true){
        try {
            System.out.println("Enter a letter: ");
            return scanner.next().toLowerCase().charAt(0);//no dedicated method for char input so take as string then select char
        }catch(InputMismatchException e){
            System.out.println("Invalid input...Enter a single letter");
        } catch (Exception e) {
            System.out.println("Something wrong with your input");
        }
    }   //Good catch on your own bug. scanner.next() accepts anything — numbers, symbols, everything. It never throws InputMismatchException because it reads any token as a String.

}*/
