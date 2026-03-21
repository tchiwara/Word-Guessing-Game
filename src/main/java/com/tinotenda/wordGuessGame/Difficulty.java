package com.tinotenda.wordGuessGame;

enum Difficulty{

    Easy(10,new String[]{"cat", "dog", "run", "jump", "code"}),
    Medium(5,new String[]{"python", "syntax", "method", "interface", "boolean"}),
    Hard(3,new String[]{"inheritance", "polymorphism", "abstraction", "encapsulation","recursion"});

    final private int attempts;
    final private String[] wordDifficulty;

    private Difficulty(int attempts,String[] wordDifficulty){
        this.attempts=attempts;
        this.wordDifficulty=wordDifficulty;
    }

    public int getAttempts(){
        return this.attempts;//why is the keyword unnecessary here?..because there is no naming conflict
    }

    public String[] getWordDifficulty(){
        return this.wordDifficulty;
    }

}