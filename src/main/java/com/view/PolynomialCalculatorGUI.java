package com.view;

import com.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

public class PolynomialCalculatorGUI extends JFrame {
    private JPanel mainPanel;
    private JLabel polynomial1JLabel;
    private JTextField poly1TxtFld;
    private JTextField poly2TxtFld;
    //private JTextField resultTxtFld;
    private JLabel polynomial2JLabel;
    private JLabel resultJLabel;
    private JButton nb7Button;
    private JButton nb8Button;
    private JButton nb9Button;
    private JButton addSignButton;
    private JButton nb4Button;
    private JButton nb5Button;
    private JButton nb6Button;
    private JButton subtractSignButton;
    private JButton nb1Button;
    private JButton nb2Button;
    private JButton addButton;
    private JButton xButton;
    private JButton nb0Button;
    private JButton integrateButton;
    private JButton subtractButton;
    private JButton powerButton;
    private JButton divideButton;
    private JButton derivateButton;
    private JButton nb3Button;
    private JPanel numberPadPanel;
    private JButton multiplyButton;
    private JButton equalButton;
    private JButton clearButton;
    private JTextArea resultTxtArea;
    private JTextField prevSelectedTxtFld;

    Controller controller = new Controller(this) ;

    public PolynomialCalculatorGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(mainPanel);
        createUIComponents();
        this.pack();
        addActionListeners(controller);

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        integrateButton.setText("\u222B");
        resultTxtArea.setFont(resultTxtArea.getFont().deriveFont(Font.BOLD));
        resultTxtArea.setDisabledTextColor(new Color(0,0,0));
        resultTxtArea.setEnabled(false);

    }

    public JTextField getPoly1TxtFld() {
        return poly1TxtFld;
    }

    public JTextField getPoly2TxtFld() {
        return poly2TxtFld;
    }

    public JTextArea getResultTxtArea() {
        return resultTxtArea;
    }

    public JButton getNb7Button() {
        return nb7Button;
    }

    public JButton getNb8Button() {
        return nb8Button;
    }

    public JButton getNb9Button() {
        return nb9Button;
    }

    public JButton getAddSignButton() {
        return addSignButton;
    }

    public JButton getNb4Button() {
        return nb4Button;
    }

    public JButton getNb5Button() {
        return nb5Button;
    }

    public JButton getNb6Button() {
        return nb6Button;
    }

    public JButton getSubtractSignButton() {
        return subtractSignButton;
    }

    public JButton getNb1Button() {
        return nb1Button;
    }

    public JButton getNb2Button() {
        return nb2Button;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getxButton() {
        return xButton;
    }

    public JButton getNb0Button() {
        return nb0Button;
    }

    public JButton getIntegrateButton() {
        return integrateButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getPowerButton() {
        return powerButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getDerivateButton() {
        return derivateButton;
    }

    public JButton getNb3Button() {
        return nb3Button;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getEqualButton() {
        return equalButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JTextField getPrevSelectedTxtFld() {
        return prevSelectedTxtFld;
    }

    public void showError(String msg){
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showWarning(String msg){
        JOptionPane.showMessageDialog(this, msg, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public JPanel getNumberPadPanel() {
        return numberPadPanel;
    }

    public boolean polyFldsEmpty(){
        if(poly1TxtFld.getText().equals("") && poly2TxtFld.getText().equals(""))
            return true;
        return false;
    }

    public void setPrevSelectedTxtFld(JTextField txtFld) {
        this.prevSelectedTxtFld = txtFld;
    }

    public String getPoly1TxtFldText(){
        return poly1TxtFld.getText();
    }

    public String getPoly2TxtFldText(){
        return poly2TxtFld.getText();
    }

    public void setPoly1TxtFldText(String txt){
        poly1TxtFld.setText(getPoly1TxtFldText() + txt);
    }

    public void setPoly2TxtFldText(String txt){
        poly2TxtFld.setText(getPoly2TxtFldText() + txt);
    }

    public void setResultTxtAreaText(String txt){
        resultTxtArea.setText(txt);
    }

    public void appendResultTxtArea(String txt){
        resultTxtArea.append(txt);
    }

    public void addActionListeners(ActionListener e){
        this.nb0Button.addActionListener(e);
        this.nb1Button.addActionListener(e);
        this.nb2Button.addActionListener(e);
        this.nb3Button.addActionListener(e);
        this.nb4Button.addActionListener(e);
        this.nb5Button.addActionListener(e);
        this.nb6Button.addActionListener(e);
        this.nb7Button.addActionListener(e);
        this.nb8Button.addActionListener(e);
        this.nb9Button.addActionListener(e);
        this.xButton.addActionListener(e);
        this.addSignButton.addActionListener(e);
        this.subtractSignButton.addActionListener(e);
        this.equalButton.addActionListener(e);
        this.powerButton.addActionListener(e);
        this.clearButton.addActionListener(e);
        this.addButton.addActionListener(e);
        this.subtractButton.addActionListener(e);
        this.multiplyButton.addActionListener(e);
        this.derivateButton.addActionListener(e);
        this.integrateButton.addActionListener(e);
        this.divideButton.addActionListener(e);
    }

    public void addFocusListener(FocusListener f){
        this.poly1TxtFld.addFocusListener(f);
        this.poly2TxtFld.addFocusListener(f);
    }
}
