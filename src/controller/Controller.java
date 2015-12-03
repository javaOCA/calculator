package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Model;

public class Controller {
    @FXML
    private Text text;
    private Model model = new Model();
    private boolean start = true;
    private double operand1;
    private double operand2;
    private String operator;
    private boolean one = false;
    
    @FXML
    private void closeForm() {
        Platform.exit();
    }
    
    @FXML
    private void getClear(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (value.equals("C")) {
            text.setText("0");
            operator = "";
            operand1 = 0;
            operand2 = 0;
            start = true;
        }
    }
    
    @FXML
    private void getNumber(ActionEvent event) {
        if (start) {
            text.setText("");
            start = false;
        }
        if (one) {
            text.setText("");
            one = false;
        }
        String value = ((Button) event.getSource()).getText();
        text.setText(text.getText() + value);
    }
    
    @FXML
    private void getOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!value.equals("=")) {
            if (checkOperand(text.getText())) {
                operand1 = Double.parseDouble(text.getText());
                operator = value;
                one = true;
            } else {
                text.setText("Wrong operand1");
                start = true;
            }
        } else {
            if (checkOperand(text.getText())) {
                operand2 = Double.parseDouble(text.getText());
                text.setText(model.calculation(operand1, operand2, operator));
            } else
                text.setText("Wrong operand2");
            operator = "";
            start = true;
        }
    }
    
    private boolean checkOperand(String operand) {
        Pattern p = Pattern.compile("^[-+]?[0-9]*\\.?[0-9]+$");
        Matcher m = p.matcher(operand);
        return m.find();
    }
}
