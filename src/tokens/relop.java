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
public enum relop {
    GT(">"),
    LT("<"),
    LEQ("<="),
    GEQ(">="),
    EQ("=="),
    NEQ("!=");
    public final String representation;
    private relop(String representation){
        this.representation = representation;
    }
    @Override
    public String toString() {
        return representation + ": relational operator";
    }
    public static boolean isRelop(String s){
        for(reserved r: reserved.values()){
            if(r.representation.compareToIgnoreCase(s) == 0){
                return true;
            }
        }
        return false;
    }

}
