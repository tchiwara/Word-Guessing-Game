# Word Guessing Game (Hangman-style)

A CLI word guessing game built in Java as part of my
structured backend engineering roadmap.

## How to Run
1. Clone the repository
2. Open in IntelliJ or any Java IDE
3. Run `App.java`

## How to Play
- Select a difficulty level (Easy / Medium / Hard)
- Guess one letter at a time
- You win by revealing the full word before attempts run out
- You lose when attempts reach zero

## Features
- Three difficulty levels with different word lists and attempt limits
- Input validation — letters only, no numbers or special characters
- Case insensitive — uppercase and lowercase treated the same
- Handles recurring letters in a word correctly
- Play again option after each game

## Concepts Practiced
- OOP — encapsulation, instance variables, constructors
- Enums with fields and constructors
- char[] array manipulation
- String methods — indexOf(), charAt(), toLowerCase()
- Exception handling with try-catch
- Guard clauses and early return pattern
- Single Responsibility Principle

## What I Learned
- The difference between local and instance variable scope
- Why this keyword exists and when it's necessary
- How indexOf() with fromIndex handles recurring characters
- Why pseudocode and dry runs on paper matter before coding
- How to make use of parameters instead of having duplicate methods with same logic and different ranges

