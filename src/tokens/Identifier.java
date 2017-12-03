/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

/**
 *
 * @author ihab
 */
public class Identifier extends token {

    private final String word;
   Identifier(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word + ": identifier";
    }

    public String getWord() {
        return word.toString();
    }
    
}
