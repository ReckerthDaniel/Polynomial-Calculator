package com.model;

public class Monomial {
    private int power;
    private Number coefficient;

    /**
     * Empty constructor. Default value for power.
     */
    public Monomial() {
    }

    /**
     * Constructor with given power.
     * @param power
     */
    public Monomial(int power, Integer coefficient) {
        this.power = power;
        this.coefficient = coefficient;
    }

    public Monomial(int power, Float coefficient) {
        this.power = power;
        this.coefficient = coefficient;
    }

    public Monomial(int power, Number coefficient) {
        this.power = power;
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Number getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Number coefficient) {
        this.coefficient = coefficient;
    }

    private boolean hasEqualPower(Monomial m) {
        return this.getPower() == m.getPower();
    }

    private boolean isEmpty(){
        return this.getPower() == 0 || this.getCoefficient().equals(0);
    }

    public Monomial addIntegerCoeffMonomials(Monomial m){
        Monomial sum = new Monomial();
        if(this.hasEqualPower(m)){
            sum.setPower(m.getPower());
            sum.setCoefficient(this.getCoefficient().intValue() + m.getCoefficient().intValue());
        }
        else{
            sum.setPower(this.power);
            sum.setCoefficient(this.getCoefficient().intValue());
        }
        return sum;
    }

    public Monomial subtractIntegerCoeffMonomials(Monomial m){
        Monomial diff = new Monomial();
        if(this.hasEqualPower(m)){
            diff.setPower(m.getPower());
            diff.setCoefficient(this.getCoefficient().intValue() - m.getCoefficient().intValue());
        }
        return diff;
    }

    public String printMonomial(){
        return this.getCoefficient() + "x^" + this.getPower();
    }
}
