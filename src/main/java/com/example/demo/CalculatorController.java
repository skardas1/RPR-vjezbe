package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField displej;
    private boolean novi_unos=true;
    private double operand1=0;
    private String operator="";

    public CalculatorController(TextField displej) {
        this.displej = displej;
        this.operand1=Double.parseDouble(displej.getText());
        this.operator="";
    }

    public CalculatorController() {
        novi_unos=true;
       // operand1=Double.parseDouble(this.displej.getText());
        operator="";
    }

    public void handleDigitButtonClick(ActionEvent broj) {
        Button dugmeklik=(Button) broj.getSource();
        String dugmetekst=dugmeklik.getText();
        if(novi_unos)
        {
            displej.clear(); //brie sve sa displeja tj cisti ga
            novi_unos=false;
        }
        if(!dugmetekst.equals(".") || !displej. getText().contains("."))
            displej.appendText(dugmetekst);

    }


    public void handleOperatorButtonClick(ActionEvent operacija) {
        Button dugmeklik=(Button) operacija.getSource();
        String dugmeop=dugmeklik.getText();
        operand1=Double.parseDouble(displej.getText());

        if(!dugmeop.isEmpty())
        {
            izvrsi();
        }
        operator=dugmeop;
      // operand1=Double.parseDouble(displej.getText());
        novi_unos=true;
    }


    public void handleEqualsButtonClick() {
        izvrsi();
        operator="";
    }
    private void izvrsi()
    {
        if(!operator.isEmpty())
        {
            double operand2=Double.parseDouble(displej.getText());
            switch(operator)
            {
                case "+":
                    operand1+=operand2;
                    break;
                case "-":
                    operand1-=operand2;
                    break;
                case "/":
                    if(operand2<=0)
                    {
                        displej.setText("Error, dijeljeno sa 0.");
                        novi_unos=true;
                        return;
                    }
                    else operand1/=operand2;
                    break;
                case "x":
                    operand1*=operand2;
                    break;
                case "%":
                    operand1/=100;
            }
        }
        displej.setText(String.valueOf(operand1));
        novi_unos=true;
    }
}