package com.utilities;

import com.model.Monomial;
import com.model.Polynomial;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {



    public static Polynomial paddedPolynomial(Polynomial p, int degree){
        Polynomial paddedPolynomial = new Polynomial(degree);

        for(Monomial m: p.getPolynomial()){
            paddedPolynomial.getPolynomial().set(m.getPower(), m);

        }
        return paddedPolynomial;
    }


    private static int sign(Matcher m) {
        int sign = 1;
        try {
            if (m.group(1).equals("-"))
                sign = -1;
        } catch (NullPointerException n) {
            try {
                if (m.group(7).equals("-"))
                    sign = -1;
            } catch (NullPointerException n1) {
                sign = 1;
            }
        }
        return sign;
    }


    public static Polynomial isUserInputValid(String userStr){
        String str = userStr.replaceAll("\\s", "");
        // GROUP 1 - sign (optional for positive monomials) => ex: -2x, +2x, 2x
        // GROUP 2 - digit (optional if -1 or 1) => ex: -1x, x, +1x, x
        // GROUP 3 - term with x or X in its structure => ex: -2x, -6x^7
        // GROUP 4 - structure of degree in GROUP 3 (^power, optional if 1) => 5x^1, 5x, 6x^7
        // GROUP 5 - the exponent in GROUP 4
        // GROUP 6 - structure for constants => +5, 5, -5
        // GROUP 7 - the sign in GROUP 6
        // GROUP 8 - the digit in GROUP 6
        String polynomialRegex = "([-+]?)(\\d*)?([xX](\\^(\\d*)?)?)|(([-+]?)(\\d+))";
        Pattern pattern = Pattern.compile(polynomialRegex);
        Matcher matcher = pattern.matcher(str);
        StringBuilder errorMessage = new StringBuilder();
        ArrayList<Monomial> monomialArrayList = new ArrayList<>();
        StringBuilder parsedRegex = new StringBuilder();
        //Polynomial p = new Polynomial();

        int power;
        Integer coefficient;
        matcher.reset();
        while(matcher.find()) {
            parsedRegex.append(matcher.group(0));
            // coefficient is 1
            if (matcher.group(2) == null || matcher.group(2).isEmpty())
                coefficient = sign(matcher);
            else
                coefficient = sign(matcher) * Integer.parseInt(matcher.group(2));

            // power is 1
            if (matcher.group(4) == null)
                power = 1;
            else
                power = Integer.parseInt(matcher.group(5));

            // we have free term
            if (matcher.group(6) != null) {
                power = 0;
                coefficient = sign(matcher) * Integer.parseInt(matcher.group(8));
            }
            monomialArrayList.add(new Monomial(power, coefficient));
        }

        if (parsedRegex.toString().equals(str) && !parsedRegex.toString().equals(""))
            return new Polynomial(monomialArrayList);

        if(str.equals(""))
            return new Polynomial();

        return null;

    }

}
