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
public enum reserved {
    IF("if"),
    ELSE("else"),
    INT("int"),
    WHILE("while"),
    RETURN("return"),
    VOID("void"),
    DOUBLE("double"),
    CHAR("char"),
    LONG("long"),
    SHORT("short"),
    FOR("for")
    ;
    public final String representation;
    private reserved(String representation){
        this.representation = representation;
    }
    @Override
    public String toString() {
        return representation + ": reserved word";
    }
    public static boolean isReserved(String s){
        for(reserved r: reserved.values()){
            if(r.representation.compareToIgnoreCase(s) == 0){
                return true;
            }
        }
        return false;
    }
    public static reserved parseReserved(String s){
        for(reserved r: reserved.values()){
            if(r.representation.compareToIgnoreCase(s) == 0){
                return r;
            }
        }
        throw new IllegalArgumentException("");
    }
}
