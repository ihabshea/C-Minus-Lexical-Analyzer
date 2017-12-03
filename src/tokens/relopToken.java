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
public class relopToken extends token {

    public final String Relop;

    relopToken(String Relop) {
        this.Relop = Relop;
    }

    @Override
    public String toString() {
        return Relop + ": relational operator";
    }

}
