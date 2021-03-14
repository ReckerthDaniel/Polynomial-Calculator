package com.model;

import com.utilities.Utils;

public class Operation {
    //private Polynomial polynomial;

    public Operation() {

    }

    public Polynomial add(Polynomial p, Polynomial q) {
        if(p.isZero() && q.isZero())
            return new Polynomial(0);

        if(!p.isZero() && q.isZero())
            return p;
        if(p.isZero() && !q.isZero())
            return q;

        int maxDegree = Math.max(p.getPolynomialDegree(), q.getPolynomialDegree());
        p.sortPolynomialByAscendingPower();
        q.sortPolynomialByAscendingPower();
        Polynomial paddedP = Utils.paddedPolynomial(p, maxDegree);
        Polynomial paddedQ = Utils.paddedPolynomial(q, maxDegree);

        Polynomial result = new Polynomial();
        for(Monomial m: paddedP.getPolynomial()){
            Monomial sum = m.addIntegerCoeffMonomials(paddedQ.getMonomial(m.getPower()));
            result.addMonomial(sum);
        }
        result.sortPolynomialByDescendingPower();
        return result;
    }

    public Polynomial subtract(Polynomial p, Polynomial q) {
        if(p.isZero() && q.isZero())
            return new Polynomial();

        p.sortPolynomialByAscendingPower();
        q.sortPolynomialByAscendingPower();

        if(!p.isZero() && q.isZero())
            return p;
        if(p.isZero() && !q.isZero())
            return q;

        Polynomial result = new Polynomial();
        for(Monomial m: p.getPolynomial()){
            Monomial diff = m.subtractIntegerCoeffMonomials(q.getMonomial(m.getPower()));
            result.addMonomial(diff);
        }

        result.sortPolynomialByDescendingPower();
        return result;
    }
}
