package org.example.calculator;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.List;
import javafx.scene.input.MouseEvent;
//--------------------------------------------
public class HelloController {
    @FXML
    private Button btn0;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnC;
    @FXML
    private Button btnCE;
    @FXML
    private Button btnDecimal;
    @FXML
    private Button btnDivide;
    @FXML
    private Button btnEqual;
    @FXML
    private Button btnMultiply;
    @FXML
    private Button btnPercent;
    @FXML
    private Button btnSubtract;
    @FXML
    private Label lblAnswer;
    @FXML
    private TextField txtShow;
    private List<Button> buttonList;
    private double answer;
    private String function = "empty";
    //--------------------------------------------
    public void initialize() {
        answer = 0;
        buttonList = FXCollections.observableArrayList(btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAdd,btnC,btnCE,btnDecimal,
                btnDivide,btnEqual,btnMultiply,btnPercent,btnSubtract);
        setAnswer();
        functions();
    }
    private void setAnswer(){
        lblAnswer.setText(String.format("%.2f", answer));
        txtShow.clear();
    }
    private void functions() { //sets up button usage
        btnC.setOnAction(actionEvent -> {
            txtShow.clear();
        });
        btnCE.setOnAction(actionEvent -> {
            function = "empty";
            answer = 0;
            lblAnswer.setText("0.00");
        });
        btn0.setOnAction(actionEvent -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"0":"0");
        });
        btn1.setOnAction(actionEvent -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"1":"1");
        });
        btn2.setOnAction(actionEvent -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"2":"2");
        });
        btn3.setOnAction(actionEvent -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"3":"3");
        });
        btn4.setOnAction(actionEvent -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"4":"4");
        });
        btn5.setOnAction(actionEvent -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"5":"5");
        });
        btn6.setOnAction(actionEvent -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"6":"6");
        });
        btn7.setOnAction(actionEvent -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"7":"7");
        });
        btn8.setOnAction(actionEvent -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"8":"8");
        });
        btn9.setOnAction(actionEvent -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"9":"9");
        });
        btnDecimal.setOnAction(actionEvent -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+".":"0.");
        });
        btnAdd.setOnAction(actionEvent -> {
            prepareOperation("sum");
        });
        btnSubtract.setOnAction(actionEvent -> {
            prepareOperation("subtract");
        });
        btnMultiply.setOnAction(actionEvent -> {
            prepareOperation("multiply");
        });
        btnDivide.setOnAction(actionEvent -> {
            prepareOperation("divide");
        });
        btnPercent.setOnAction(actionEvent -> {
            prepareOperation("percent");
        });
        btnEqual.setOnAction(actionEvent -> {
            performCalculation();
            function = "empty";  //resets after calculation
        });
    }
    private void prepareOperation(String operation) {
        if (!txtShow.getText().isEmpty()) {
            answer = Double.parseDouble(txtShow.getText());  //stores current value
            function = operation;  //sets the current operation
            txtShow.clear();  //clears the text for new input
        }
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
            setAnswer(); //updates the display with the new answer
            txtShow.clear();  //clears or displays new result in txtShow
        }
    }
    private void action() { //handles different calculator operations
        switch (function){
            case "empty": Double.parseDouble(txtShow.getText());
                setAnswer();
                break;
            case "sum": answer += Double.parseDouble(txtShow.getText());
                setAnswer();
                break;
            case "subtract": answer -= Double.parseDouble(txtShow.getText());
                setAnswer();
                break;
            case "multiply": answer *= Double.parseDouble(txtShow.getText());
                setAnswer();
                break;
            case "divide": answer /= Double.parseDouble(txtShow.getText());
                setAnswer();
                break;
            case "equal":
                setAnswer();
                break;
        }
    }
    public void handleButtonPress(MouseEvent event) {
        Button button = (Button) event.getSource();
        changeButtonColor(button); //applies new color based on button ID
    }
    public void handleButtonRelease(MouseEvent event) {
        Button button = (Button) event.getSource();
        revertButtonColor(button); //reverts to original color
    }
    private void changeButtonColor(Button button) { //changes button colors when pressed
        String style = "-fx-background-color: ";
        String id = button.getId();
        if ("btnC".equals(id) || "btnCE".equals(id) || "btnPercent".equals(id)) {
            button.setStyle(style + "#5e5959;"); // gray
        } else if ("btnDivide".equals(id) || "btnMultiply".equals(id) || "btnSubtract".equals(id) || "btnAdd".equals(id) || "btnEqual".equals(id)) {
            button.setStyle(style + "#b77529;"); // dark orange
        } else {
            button.setStyle(style + "#989190;"); // light gray for all numbers
        }
    }
    private void revertButtonColor(Button button) { //reverts all buttons back to original color
        String originalStyle = "-fx-background-color: ";
        String id = button.getId();
        if ("btnC".equals(id) || "btnCE".equals(id) || "btnPercent".equals(id)) {
            button.setStyle(originalStyle + "#3b393a;"); // gray
        } else if ("btnDivide".equals(id) || "btnMultiply".equals(id) || "btnSubtract".equals(id) || "btnAdd".equals(id) || "btnEqual".equals(id)) {
            button.setStyle(originalStyle + "#f2a33c;"); // dark orange
        } else {
            button.setStyle(originalStyle + "#5e5959;"); // light gray for all numbers
        }
    }
    @Override
    public String toString() {
        return "HelloController [answer=" + answer + ", function=" + function + "]";
    }
}
