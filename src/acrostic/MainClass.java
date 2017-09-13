/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acrostic;

import acrostic.io.GetAWordWhichStartsFrom;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println(new GetAWordWhichStartsFrom('f').random());
        while(true) {
            System.out.println("WORD: ");
            String word = new Scanner(System.in).next().toLowerCase().replace(" ", "");
            long startTime = System.currentTimeMillis();
            Acrostic a = new Acrostic(word);
            List<String> genWords = a.getGeneratedWords();
            for (Iterator<String> i = genWords.iterator(); i.hasNext();) {
                System.out.println(i.next());
            }
            long endTime = System.currentTimeMillis();
            System.out.println("TIME: " + (endTime - startTime) + " ms.");
        }
        
    }
    
}
