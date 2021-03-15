package com.model;

import com.utilities.Utils;

public class Operation {
    //private Polynomial polynomial;
    private Polynomial quotient;
    private Polynomial remainder;

    public Operation() {

    }

    public Polynomial add(Polynomial p, Polynomial q) {
        if (p.isZero() && q.isZero())
            return new Polynomial(0);

        if (!p.isZero() && q.isZero())
            return p;
        if (p.isZero() && !q.isZero())
            return q;

        int maxDegree = Math.max(p.getPolynomialDegree(), q.getPolynomialDegree());
        p.sortPolynomialByAscendingPower();
        q.sortPolynomialByAscendingPower();
        Polynomial paddedP = Utils.paddedPolynomial(p, maxDegree);
        Polynomial paddedQ = Utils.paddedPolynomial(q, maxDegree);

        Polynomial result = new Polynomial();
        for (Monomial m : paddedP.getPolynomial()) {
            Monomial sum = m.addIntegerCoeffMonomials(paddedQ.getMonomial(m.getPower()));
            result.addMonomial(sum);
        }
        result.sortPolynomialByDescendingPower();
        return result;
    }

    public Polynomial subtract(Polynomial p, Polynomial q) {
        if (p.isZero() && q.isZero())
            return new Polynomial(0);

        if (!p.isZero() && q.isZero())
            return p;
        if (p.isZero() && !q.isZero())
            return q;

        int maxDegree = Math.max(p.getPolynomialDegree(), q.getPolynomialDegree());
        p.sortPolynomialByAscendingPower();
        q.sortPolynomialByAscendingPower();
        Polynomial paddedP = Utils.paddedPolynomial(p, maxDegree);
        Polynomial paddedQ = Utils.paddedPolynomial(q, maxDegree);

        Polynomial result = new Polynomial();
        for (Monomial m : paddedP.getPolynomial()) {
            Monomial diff = m.subtractIntegerCoeffMonomials(paddedQ.getMonomial(m.getPower()));
            result.addMonomial(diff);
        }
        result.sortPolynomialByDescendingPower();
        return result;
    }

    public Polynomial multiply(Polynomial p, Polynomial q) {
        if (p.isZero() || q.isZero())
            return new Polynomial(0);

        p.sortPolynomialByDescendingPower();
        q.sortPolynomialByDescendingPower();
        Polynomial result = new Polynomial(p.getPolynomialDegree() + q.getPolynomialDegree());
        for (Monomial mp : p.getPolynomial()) {
            for (Monomial mq : q.getPolynomial()) {
                Monomial mult;
                Number finalCoeff;
                if(mp.getCoefficient() instanceof Float || mq.getCoefficient() instanceof  Float){
                    mult = mp.multiplyRealCoeff(mq);
                    finalCoeff = result.getMonomial(mult.getPower()).getRealCoefficient() + mult.getRealCoefficient();

                }
                else{
                    mult = mp.multiplyIntegerCoeff(mq);
                    finalCoeff = result.getMonomial(mult.getPower()).getIntegerCoefficient() + mult.getIntegerCoefficient();
                }
                mult.setCoefficient(finalCoeff);
                result.getPolynomial().set(mult.getPower(), mult);
            }
        }
        result.sortPolynomialByDescendingPower();
        return result;

    }

    public Polynomial derivate(Polynomial p) {
        Polynomial result = new Polynomial();
        p.sortPolynomialByDescendingPower();
        for (Monomial m : p.getPolynomial()) {
            m.derivate();
            result.addMonomial(m);
        }
        return result;
    }

    public Polynomial integrate(Polynomial p) {
        Polynomial result = new Polynomial();
        p.sortPolynomialByDescendingPower();
        for (Monomial m : p.getPolynomial()) {
            m.integrate();
            result.addMonomial(m);
        }
        return result;
    }

    public void divide(Polynomial p, Polynomial q){
        if(q.isZero() || (q.getPolynomial().size() == 1 && q.getMonomial(0).getRealCoefficient() == 0.0f))
            return;

        p.sortPolynomialByDescendingPower();
        q.sortPolynomialByDescendingPower();

        Polynomial remainder = new Polynomial(p.getPolynomial());
        Polynomial temp = new Polynomial(0);
        Polynomial quotient = new Polynomial();

        while(remainder.getPolynomial().size() != 0 &&
                (remainder.getMonomial(0).getPower() >= q.getMonomial(0).getPower())
                && !q.isZero()){
            Monomial div = remainder.getMonomial(0).divide(q.getMonomial(0));
            if(div != null) {
                temp.getPolynomial().set(0, div);
                quotient.addMonomial(div);
                Polynomial tmpMult = multiply(temp, q);
                //tmpMult.reduce();
                remainder = subtract(remainder, tmpMult);
                remainder.reduce();
            }
        }

        this.quotient = quotient;
        this.remainder = remainder;
    }

    public Polynomial getQuotient() {
        return quotient;
    }

    public Polynomial getRemainder() {
        return remainder;
    }
}
