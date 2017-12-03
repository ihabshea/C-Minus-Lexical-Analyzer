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
public class commentToken extends token {
    String comment;
    commentToken(String comment){
        this.comment = comment;
    }
    public String toString(){
        return comment + ": comment";
    }
}
