package org.example.calculator;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.List;
//--------------------------------------------
public class HelloController {
    @FXML
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9; //sets up calculator's user interface components
    @FXML
    private Button btnAdd, btnC, btnCE, btnDecimal, btnDivide, btnEqual, btnMultiply, btnPercent, btnSubtract;
    @FXML
    private Label lblAnswer;
    @FXML
    private TextField txtShow;
    protected List<Button> buttonList;
    private double answer;
    private String function = "empty";
    //--------------------------------------------
    public void initialize() { //performs initialization tasks to set up calculator's functionality
        answer = 0;
        buttonList = FXCollections.observableArrayList(btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAdd,btnC,btnCE,btnDecimal,
                btnDivide,btnEqual,btnMultiply,btnPercent,btnSubtract);
        updateDisplay();
        setButtons();
    }
    private void updateDisplay(){ //updates the user interface to show calculator after operations have been performed
        lblAnswer.setText(String.format("%.2f", answer));
        txtShow.clear();
    }
    private void setButtons() { //sets up button usage
        btnC.setOnAction(e -> txtShow.clear());
        btnCE.setOnAction(e -> {
            function = "empty";
            answer = 0;
            lblAnswer.setText("0.00");
        });
        btn0.setOnAction(e -> txtShow.setText(txtShow.getText() != null ? txtShow.getText() + "0" : "0")); //lambda expressions that sets an action for the corresponding numbered button
        btn1.setOnAction(e -> txtShow.setText(txtShow.getText() != null ? txtShow.getText() + "1" : "1"));
        btn2.setOnAction(e -> txtShow.setText(txtShow.getText() != null ? txtShow.getText() + "2" : "2"));
        btn3.setOnAction(e -> txtShow.setText(txtShow.getText() != null ? txtShow.getText() + "3" : "3"));
        btn4.setOnAction(e -> txtShow.setText(txtShow.getText() != null ? txtShow.getText() + "4" : "4"));
        btn5.setOnAction(e -> txtShow.setText(txtShow.getText() != null ? txtShow.getText() + "5" : "5"));
        btn6.setOnAction(e -> txtShow.setText(txtShow.getText() != null ? txtShow.getText() + "6" : "6"));
        btn7.setOnAction(e -> txtShow.setText(txtShow.getText() != null ? txtShow.getText() + "7" : "7"));
        btn8.setOnAction(e -> txtShow.setText(txtShow.getText() != null ? txtShow.getText() + "8" : "8"));
        btn9.setOnAction(e -> txtShow.setText(txtShow.getText() != null ? txtShow.getText() + "9" : "9"));
        btnDecimal.setOnAction(e -> txtShow.setText(txtShow.getText() != null ? txtShow.getText() + "." : "0."));
        btnAdd.setOnAction(e -> prepareOperation("sum"));
        btnSubtract.setOnAction(e -> prepareOperation("subtract"));
        btnMultiply.setOnAction(e -> prepareOperation("multiply"));
        btnDivide.setOnAction(e -> prepareOperation("divide"));
        btnPercent.setOnAction(e -> prepareOperation("percent"));
        btnEqual.setOnAction(e -> {
            performCalculation();
            function = "empty"; // resets after calculation
        });
    }
    private void prepareOperation(String operation) {
        if (!txtShow.getText().isEmpty()) {
            answer = Double.parseDouble(txtShow.getText());  //use the displayed value as the new base
        }
            function = operation;  //sets the current operation
            txtShow.clear();  //clears the text for new input
    }
    private void performCalculation() { //executes different arithmetic operations
        if (!txtShow.getText().isEmpty() && !function.equals("empty")) {
            switch (function) {
                case "sum":
                    answer += Double.parseDouble(txtShow.getText());
                    break;
                case "subtract":
                    answer -= Double.parseDouble(txtShow.getText());
                    break;
                case "multiply":
                    answer *= Double.parseDouble(txtShow.getText());
                    break;
                case "divide":
                    answer /= Double.parseDouble(txtShow.getText());
                    break;
                case "percent":
                    double percent = Double.parseDouble(txtShow.getText()) / 100;  //converts percentage input to a decimal
                    answer *= percent;  //multiply the current answer by the percentage decimal
                    break;
            }
            updateDisplay(); //updates the display with the new answer
            txtShow.clear();  //clears or displays new result in txtShow
        }
    }
    @Override
    public String toString() {
        return String.format("HelloController [answer=%.2f, function=%s]", answer, function);
    }
}