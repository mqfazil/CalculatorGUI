package org.example.calculator;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ButtonColorChange extends HelloController {
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
            button.setStyle(style + "#5e5959;"); //gray
        } else if ("btnDivide".equals(id) || "btnMultiply".equals(id) || "btnSubtract".equals(id) || "btnAdd".equals(id) || "btnEqual".equals(id)) {
            button.setStyle(style + "#b77529;"); //dark orange
        } else {
            button.setStyle(style + "#989190;"); //light gray for all numbers
        }
    }
    private void revertButtonColor(Button button) { //reverts all buttons back to original color
        String originalStyle = "-fx-background-color: ";
        String id = button.getId();
        if ("btnC".equals(id) || "btnCE".equals(id) || "btnPercent".equals(id)) {
            button.setStyle(originalStyle + "#3b393a;"); //dark gray
        } else if ("btnDivide".equals(id) || "btnMultiply".equals(id) || "btnSubtract".equals(id) || "btnAdd".equals(id) || "btnEqual".equals(id)) {
            button.setStyle(originalStyle + "#f2a33c;"); //orange
        } else {
            button.setStyle(originalStyle + "#5e5959;"); //gray for all numbers
        }
    }
}
