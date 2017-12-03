/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ihab
 */
public abstract class token {

    public static Collection<token> tokenize(String expression) {
        ArrayList<token> tokens = new ArrayList<>();
        StringCharacterIterator itr = new StringCharacterIterator(expression);
        Pattern ident = Pattern.compile("[A-Za-z][A-Za-z_0-9]*");
        Pattern k = Pattern.compile("[A-Za-z_0-9]");

        for (char c = itr.first(); c != StringCharacterIterator.DONE; c = itr.next()) {
            if (Character.isWhitespace(c)) {
                continue;
            }
            if (c == '(') {
                tokens.add(new lParen());
                continue;
            }
            if (c == ')') {
                tokens.add(new rParen());
                continue;
            }
//            if (c == 'i') {
//                char d = itr.next();
//                if (d == 'f') {
//                    d = itr.next();
//                    if (Character.isWhitespace(c) || c == '(') {
//                        reserved Reserved = reserved.parseReserved("if");
//                        tokens.add(new reservedTokens(Reserved));
//                        itr.previous();
//                    }
//
//                } else {
//                    itr.previous();
//                }
//                continue;
//            }
            if (c == '=') {
                char d = itr.next();
                if (d != '=') {

                    operator Operator = operator.parseOperator(c);
                    tokens.add(new OperatorToken(Operator));
                    continue;
                }
            }
            if (c == '[') {
                tokens.add(new lBracket());
            }
            if (c == ']') {
                tokens.add(new rBracket());
            }
            if (c == '>') {
                char d = itr.next();
                if (d == '=') {
                    tokens.add(new relopToken(">="));
                } else if (Character.isDigit(d) | Character.isAlphabetic(d) | Character.isWhitespace(d)) {
                    tokens.add(new relopToken(">"));
                }
            }
            if (c == '<') {
                char d = itr.next();
                if (d == '=') {
                    tokens.add(new relopToken("<="));
                } else if (Character.isDigit(d) | Character.isAlphabetic(d) | Character.isWhitespace(d)) {
                    tokens.add(new relopToken(">"));
                }
            }
            if (c == '{') {
                tokens.add(new lCurly());
            }
            if (c == '}') {
                tokens.add(new rCurly());
            }
            if (c == ';') {
                tokens.add(new semicolon());
            }
            if (c == '/') {
                char d = itr.next();
                String comment = "/";
                boolean isComment = false;
                if (d == '*') {
                    comment += d;
                    for (char ch = itr.next(); ch != StringCharacterIterator.DONE; ch = itr.next()) {
                        comment += ch;
                        if (ch == '*') {
                            char ds = itr.next();
                            if (ds == '/') {
                                comment += ds;
                                isComment = true;
                                break;
                            }
                        }
                    }
                    if (isComment) {
                        tokens.add(new commentToken(comment));
                        continue;
                    } else {

                    }

                }
            }
            if (Character.isAlphabetic(c)) {
                String identifier = "";
                for (char h = itr.current(); h != StringCharacterIterator.DONE; h = itr.next()) {
                    identifier += h;
                    //  System.out.println(identifier.trim());
                    if (h == '(' | h == ')' | h == '[' | h == ']' | h == '<' | h == '=' | h == '>' | h == ';' | operator.isOperator(h) | Character.isWhitespace(h)) {
                        itr.previous();
                        break;
                    }
                    if (reserved.isReserved(identifier)) {
                        reserved Reserved = reserved.parseReserved(identifier);
                        tokens.add(new reservedTokens(Reserved));
                        break;
                    }
                }
                if (!reserved.isReserved(identifier)) {
                    tokens.add(new Identifier(identifier));
                    continue;
                }
            }

            if (Character.isDigit(c)) {
                int number;
                number = parseNumber(itr);
                tokens.add(new NumericToken(number));
                continue;
            }
            if (operator.isOperator(c)) {
                operator Operator = operator.parseOperator(c);
                tokens.add(new OperatorToken(Operator));
            }
        }
        return tokens;
    }

    private static int parseNumber(StringCharacterIterator itr) {
        int accumulator = 0;

        for (char c = itr.current(); c != StringCharacterIterator.DONE; c = itr.next()) {
            // Stop once we reach a non-numeric character.
            // We have to rewind the iterator since we went too far.
            if (!Character.isDigit(c)) {
                itr.previous();
                return accumulator;
            }

            accumulator *= 10;
            accumulator += Character.getNumericValue(c);
        }

        return accumulator;
    }
}
