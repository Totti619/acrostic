/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acrostic.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Master
 */
public class GetAWordWhichStartsFrom {
    private char letter;
    
    private String url;
    
    private InputStream is;
    private BufferedReader br;
    private StringBuffer jsonBuffer;
    private String jsonString;
    
    private List<String> words;
    
    public GetAWordWhichStartsFrom(char letter) {
        this.letter = letter;
        url = "http://api.wordnik.com:80/v4/words.json/search/" + letter + "?caseSensitive=true&minCorpusCount=5&maxCorpusCount=30&minDictionaryCount=2&maxDictionaryCount=30&minLength=2&maxLength=30&skip=0&limit=50&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";

        obtainJSONContent();
        obtain();
        
    }
    
    public List<String> getWords() {
        return words;
    }
    
    public String random() {
        if (!words.isEmpty()) return words.get(new Random().nextInt((words.size() - 1) + 1));
        return "";
    }
    
    private void obtainJSONContent() {
        int character;
        jsonBuffer = new StringBuffer();
        try {
            is = new URL(url.trim()).openStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((character = br.read()) != -1) jsonBuffer.append((char)character);
            jsonString = jsonBuffer.toString();
            is.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GetAWordWhichStartsFrom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GetAWordWhichStartsFrom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GetAWordWhichStartsFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void obtain() {
        StringBuffer key, value;
        
        String[] wordsSplit = jsonString.split("[:,\"\\s]");
        List<String> someWords = new ArrayList<String>();
        for (int i = 0; i < wordsSplit.length; i++) {
           if (!wordsSplit[i].equals("")) someWords.add(wordsSplit[i]);
        }
        
        List<String> words = new ArrayList<String>();
        for (Iterator<String> i = someWords.iterator(); i.hasNext();) {
            if (i.next().contains("word")) words.add(i.next());
        }
        //for (Iterator<String> i = words.iterator(); i.hasNext();) System.out.println(i.next());
        
        this.words = words;
    }
}
