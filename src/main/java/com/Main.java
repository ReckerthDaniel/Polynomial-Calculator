package com;

import com.controller.Controller;
import com.view.PolynomialCalculatorGUI;

public class Main {
    public static void main(String[] args) {

        PolynomialCalculatorGUI frame = new PolynomialCalculatorGUI("Polynomial Calculator");
        Controller controller = new Controller(frame);
        frame.setVisible(true);
        frame.setResizable(false);

    }
}
