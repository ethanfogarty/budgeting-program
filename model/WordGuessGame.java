package model;
import java.util.Random;

public class WordGuessGame{

    // private String word;
    private String word;
    private int healthLevel = 5;

    public WordGuessGame(){
        // getting random word
        Random r = new Random();
        word = WordGuessBank.WORD_BANK.get(r.nextInt(WordGuessBank.WORD_BANK.size()));
    }

    public int[] findLetter(char c){
        int count = 0;

        for (int i = 0; i < word.length(); i++){            
            if (c == word.charAt(i)){
                count++;
            }
        }
        int[] indexArray = new int[count];
        count = 0;
        for (int i = 0; i < word.length(); i++){            
            if (c == word.charAt(i)){
                indexArray[count] = i;
                count++;
            }
        }
        return indexArray;
    }

    public String getWord() {
        return word;
    }

    public int getHealthLevel(){
        return healthLevel;
    }

    public void setHealthLevel(int health){
        this.healthLevel = health;
    }
}