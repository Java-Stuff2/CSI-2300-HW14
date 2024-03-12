import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");
        // Create UI elements
        Label titleLabel = new Label("Welcome to Metric Converter");
        ComboBox<String> conversionTypeComboBox = new ComboBox<>();
        conversionTypeComboBox.getItems().addAll(
                "Grams to Ounces",
                "Kilograms to Pounds",
                "Meters to Feet",
                "Centimeters to Inches");
        Label inputLabel = new Label("Enter value:");
        TextField inputField = new TextField();
        Button convertButton = new Button("Convert");
        Label resultLabel = new Label();

        // Set up event handler for the Convert button
        convertButton.setOnAction(e -> {
            String selectedConversionType = conversionTypeComboBox.getValue();
            String inputValue = inputField.getText();
            double convertedValue = convert(selectedConversionType, inputValue);
            resultLabel.setText("Result: " + convertedValue);
        });

        // Create layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(titleLabel, 0, 0, 2, 1);
        gridPane.add(conversionTypeComboBox, 0, 2, 2, 1);
        gridPane.add(inputLabel, 0, 1);
        gridPane.add(inputField, 1, 1);
        gridPane.add(convertButton, 0, 3, 2, 1);
        gridPane.add(resultLabel, 0, 4, 2, 1);

        // Create scene
        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private double convert(String conversionType, String input) {
        // Return the converted value
        // For simplicity, I'll just return the input value as a placeholder
        double inputValue;
        try {
            inputValue = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return 0.0;
        }
        switch (conversionType) {
            case "Grams to Ounces":
                return inputValue * 0.03527396; // 1 g = 0.03527396 oz
            case "Kilograms to Pounds":
                return inputValue * 2.20462; // 1 kg = 2.20462 lbs
            case "Meters to Feet":
                return inputValue * 3.28084; // 1 m = 3.28084 ft
            case "Centimeters to Inches":
                return inputValue * 0.393701; // 1 cm = 0.393701 in
            default:
                return inputValue; // Return input value if conversion type is unknown
        }
    }
}
