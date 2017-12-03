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
public class reservedTokens extends token {
    private final reserved word;
    reservedTokens(reserved word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word.toString();
    }

    public String getWord() {
        return word.toString();
    }
}
