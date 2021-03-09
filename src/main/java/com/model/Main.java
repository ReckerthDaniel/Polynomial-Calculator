package com.model;

public class Main {
    public static void main(String[] args) {
//        Polynomial p = new Polynomial();
//        p.getPolynomial().add(new Monomial(4,3));
//        p.getPolynomial().add(new Monomial(3,0));
//        p.getPolynomial().add(new Monomial(2,1));
//        p.getPolynomial().add(new Monomial(1,2));
//        p.getPolynomial().add(new Monomial(0,1));
//
//        Polynomial q = new Polynomial();
//        q.getPolynomial().add(new Monomial(4,2));
//        //q.getPolynomial().add(new Monomial(3,0));
//        //q.getPolynomial().add(new Monomial(2,2));
//        //q.getPolynomial().add(new Monomial(1,0));
//        //q.getPolynomial().add(new Monomial(0,1));

        Polynomial p = Utils.createPolynomialFromString("3x^4 + 2x^3 + 2x^1 + 1x");
        Polynomial q = Utils.createPolynomialFromString("2x^1");
        Operation op = new Operation(p);
        Polynomial res = op.add(p, q);
        String resStr =  res.printPolynomial();
        System.out.println(resStr);
//        Polynomial diff = op.subtract(p, q);
//        diff.printPolynomial();

    }
}
