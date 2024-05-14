
import java.util.Scanner;

// Label class
class Label {
    private String text;

    Label(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

// Button class
class Button {
    private String text;

    Button(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// Panel class
class Panel {
    private Button[] buttons;
    private Label label;

    Panel(int buttonCount, String[] buttonTexts, String labelText) {
        buttons = new Button[buttonCount];
        for (int i = 0; i < buttonCount; i++) {
            buttons[i] = new Button(buttonTexts[i]);
        }
        label = new Label(labelText);
    }

    public void displayButtons() {
        System.out.println("Buttons that are available to press:");
        for (int i = 0; i < buttons.length; i++) {
            System.out.println(buttons[i].getText());
        }
    }

    public void handleClick(int buttonIndex) {
        if (buttonIndex >= 0 && buttonIndex < buttons.length) {
            String buttonText = buttons[buttonIndex].getText();
            label.setText("Button '" + buttonText + "' clicked");
            System.out.println("New Label: " + label.getText());
        } else {
            System.out.println("Invalid button index");
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Graphic for Panel");

        Panel panel = new Panel(2, new String[] { "Button 1", "Button 2" }, "Label");

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Display buttons");
            System.out.println("2. Click a button");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    panel.displayButtons();
                    break;
                case 2:
                    System.out.print("Enter index of button you wish to press: ");
                    int buttonIndex = scanner.nextInt() - 1;
                    panel.handleClick(buttonIndex);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Quiting");
    }
}
