import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Task: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
        // determine if the input string is valid.
        //
        //An input string is valid if:
        //
        //Open brackets must be closed by the same type of brackets.
        //Open brackets must be closed in the correct order.
        //Every close bracket has a corresponding open bracket of the same type.

        String s = "(){}[]";
        System.out.println(isValid(s));
    }
    public static boolean isValid (String s) {
        boolean b = false;
        int openCircule = 0;
        int openFigure = 0;
        int openSquare = 0;

        for(int i = 0; i < s.length(); i++) {

            if (openCircule < 0 || openFigure < 0 || openSquare < 0){
                return false;
            }
            switch ((int)s.charAt(i)){
                case 40 : {
                    if (openSquare >0 || openFigure >0) {
                        return false;
                    }
                    openCircule++;
                    break;
                }
                case 41 : {
                    openCircule--;
                    break;
                }
                case 91 : {
                    if (openCircule >0 || openFigure >0) {
                        return false;
                    }
                    openSquare++;
                    break;
                }
                case 93 : {
                    openSquare--;
                    break;
                }
                case 123 : {
                    if (openSquare >0 || openCircule >0) {
                        return false;
                    }
                    openFigure++;
                    break;
                }
                case 125 : {
                    openFigure--;
                    break;
                }
            }
            if (!b) {
                b = openCircule > 0 || openSquare > 0 || openFigure > 0;
            }
        }
        return openCircule == 0 && openSquare == 0 && openFigure == 0 && b;
    }
}