/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acrostic;

import acrostic.io.GetAWordWhichStartsFrom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Master
 */
public class Acrostic {
    private String word;
    private List<Character> characters = new ArrayList<Character>();
    private List<String> generatedWords = new ArrayList<String>();
    
    public Acrostic(String word) {
        setWord(word.toLowerCase());
        setCharacters(); 
        setGeneratedWords();
    }
    
    private void setWord(String word) {
        StringBuffer wordBuffer = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) > 96 && word.charAt(i) < 123) { // checks if the char in i is only lowercase, ignores other symbols though
                wordBuffer.append(word.charAt(i));
            }
        }
        this.word = wordBuffer.toString();
    }
    
    public List<Character> getCharacters() {
        if (characters != null && !characters.isEmpty()) return new ArrayList<Character>(this.characters);
        setCharacters();
        return new ArrayList<Character>(this.characters);
    }
    private void setCharacters() {
        for (int i = 0; i < word.length(); i++) characters.add(word.charAt(i));
    }
    
    public List<String> getGeneratedWords() {
        if (generatedWords != null && !generatedWords.isEmpty()) return new ArrayList<String>(this.generatedWords);
        setGeneratedWords();
        return new ArrayList<String>(this.generatedWords);
    }
    private void setGeneratedWords() {
        for (Iterator<Character> i = characters.iterator(); i.hasNext();) {
            generatedWords.add(new GetAWordWhichStartsFrom(i.next()).random());
        }
    }
    
}
