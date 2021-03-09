package com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Polynomial {
    private ArrayList<Monomial> polynomial = new ArrayList<Monomial>();

    public Polynomial(int power){
        for(int i = 0; i <= power; i++)
            this.polynomial.add(new Monomial(i,0));
    }

    public Polynomial() {

    }

    public Polynomial(ArrayList<Monomial> polynomial) {
        this.polynomial = polynomial;
    }

    public ArrayList<Monomial> getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(ArrayList<Monomial> polynomial) {
        this.polynomial = polynomial;
    }

    public void addMonomial(Monomial m){
        this.getPolynomial().add(m);
    }

    public Monomial getMonomial(int index){
        return this.getPolynomial().get(index);
    }


    public void copyPolynomial(Polynomial p) {
        for (Monomial m: p.getPolynomial())
            this.getPolynomial().add(m);
    }

    public boolean isZero() {
        return this.getPolynomial().size() == 0;
    }

    public void sortPolynomialByDescendingPower() {
        this.polynomial.sort(Collections.reverseOrder(Comparator.comparingInt(Monomial::getPower)));
    }

    public void sortPolynomialByAscendingPower() {
        this.polynomial.sort(Comparator.comparingInt(Monomial::getPower));
    }

    public int getPolynomialDegree() {
        this.sortPolynomialByDescendingPower();
        return this.getPolynomial().get(0).getPower();
    }

    public String printPolynomial(){
        StringBuilder str = new StringBuilder();
        for (Monomial m: this.getPolynomial()){
            str.append(m.getCoefficient() + "x^" + m.getPower() + "+");
        }
        return str.toString();
    }


}