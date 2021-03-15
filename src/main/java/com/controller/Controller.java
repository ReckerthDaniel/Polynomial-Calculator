package com.controller;

import com.model.Operation;
import com.model.Polynomial;
import com.utilities.Utils;
import com.view.PolynomialCalculatorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Controller implements ActionListener{
    private Polynomial p, q;
    private final PolynomialCalculatorGUI calcView;

    public Controller(PolynomialCalculatorGUI calcView) {
        this.calcView = calcView;
        calcView.addFocusListener(new TxtFieldFocus());

    }

    private void performNbButtonAction(Object src){

        if (src.equals(calcView.getNb0Button())) {
            if (calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("0");

            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("0");
        }
        if(src.equals(calcView.getNb1Button())) {
            if (calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("1");

            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("1");
        }
        if(src.equals(calcView.getNb2Button())) {
            if (calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("2");

            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("2");
        }
        if(src.equals(calcView.getNb3Button())) {
            if (calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("3");

            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("3");
        }
        if(src.equals(calcView.getNb4Button())) {
            if (calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("4");

            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("4");
        }
        if(src.equals(calcView.getNb5Button())) {
            if (calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("5");

            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("5");
        }
        if(src.equals(calcView.getNb6Button())) {
            if (calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("6");

            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("6");
        }
        if(src.equals(calcView.getNb7Button())) {
            if (calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("7");

            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("7");
        }
        if(src.equals(calcView.getNb8Button())) {
            if (calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("8");

            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("8");
        }
        if(src.equals(calcView.getNb9Button())) {
            if (calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("9");

            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("9");
        }
    }

    private void performUtilitiesButtonsAction(Object src){
        if(src.equals(calcView.getxButton())){
            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("x");
            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("x");
        }
        if(src.equals(calcView.getAddSignButton())){
            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("+");
            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("+");
        }
        if(src.equals(calcView.getSubtractSignButton())){
            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("-");
            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("-");
        }
        if(src.equals(calcView.getPowerButton())){
            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly1TxtFld()))
                calcView.setPoly1TxtFldText("^");
            if(calcView.getPrevSelectedTxtFld().equals(calcView.getPoly2TxtFld()))
                calcView.setPoly2TxtFldText("^");
        }
        if(src.equals(calcView.getClearButton())){
            calcView.getPoly1TxtFld().setText("");
            calcView.getPoly2TxtFld().setText("");
            calcView.getResultTxtArea().setText("");
        }
        if(src.equals(calcView.getEqualButton()) && !calcView.polyFldsEmpty()){
            //calcView.setResultTxtAreaText("result");
        }

    }

    private boolean validateInputs(Object src){
        String pol1String = calcView.getPoly1TxtFldText();
        String pol2String = calcView.getPoly2TxtFldText();
        if(calcView.polyFldsEmpty() && !src.equals(calcView.getClearButton())) {
            calcView.showError("Introduce polynomials!");
            //return false;
        }

        Polynomial p = Utils.validateUserInput(pol1String);

        if(p == null)
            return false;

        Polynomial q = Utils.validateUserInput(pol2String);
        if(q == null)
            return false;

        this.p = p;
        this.q = q;
        return true;


    }

    private void performOperationButtonsAction(Object src){
        Operation op = new Operation();
        if(validateInputs(src)) {
            if (src.equals(calcView.getAddButton())) {
                Polynomial sum = op.add(p, q);
                System.out.println(sum.toString());
                calcView.setResultTxtAreaText(sum.printPolynomial());
            }
            if(src.equals(calcView.getSubtractButton())) {
                Polynomial diff = op.subtract(p, q);
                calcView.setResultTxtAreaText(diff.printPolynomial());
            }
            if(src.equals(calcView.getMultiplyButton())) {
                Polynomial mult = op.multiply(p, q);
                calcView.setResultTxtAreaText(mult.printPolynomial());
            }
            if(src.equals(calcView.getDerivateButton())){
                Polynomial derivative = new Polynomial();
                if(!this.p.isZero())
                    derivative = op.derivate(p);
                else if(!this.q.isZero())
                    derivative = op.derivate(q);
                else
                    derivative = op.derivate(p);
                calcView.setResultTxtAreaText(derivative.printPolynomial());
            }
            if(src.equals(calcView.getIntegrateButton())){
                Polynomial integration;
                if(!this.p.isZero())
                    integration = op.integrate(p);
                else if(!this.q.isZero())
                    integration = op.integrate(q);
                else
                    integration = op.derivate(p);
                calcView.setResultTxtAreaText(integration.printPolynomial());
            }
            if(src.equals(calcView.getDivideButton())){
                if(!(calcView.getPoly2TxtFld().getText().equals("") || calcView.getPoly2TxtFld().getText().equals("0"))){
                    if(this.p.getPolynomialDegree() < this.q.getPolynomialDegree()){
                        calcView.showWarning("Polynomial #2 cannot be greater!");
                    }
                    else {
                        op.divide(p, q);
                        calcView.getResultTxtArea().setText("");
                        calcView.appendResultTxtArea("quotient: " + op.getQuotient().printPolynomial());
                        calcView.appendResultTxtArea("\n");
                        calcView.appendResultTxtArea("remainder: " + op.getRemainder().printPolynomial());
                    }
                }
                else{
                    calcView.showError("Cannot divide by zero!");
                }
            }
        }
        else
            calcView.showError("Invalid polynomial format!\n" +
                    "Monomial format: ax^b, with a,b integer coefficients\n" +
                    "Valid format: sum of monomials\n" +
                    "Ex: 3x^4-x^2+5x^3+25+x");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        performNbButtonAction(src);
        performUtilitiesButtonsAction(src);
        performOperationButtonsAction(src);
    }

    public class TxtFieldFocus implements FocusListener{
        @Override
        public void focusGained(FocusEvent e) {
            if(e.getSource() instanceof JTextField)
                calcView.setPrevSelectedTxtFld((JTextField) e.getSource());

        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }

    public Polynomial getPolynomial1() {
        return p;
    }

    public Polynomial getPolynomial2() {
        return q;
    }
}
