import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Main extends Application {

    /**
     * The Start method creates and initializes the graphical user interface components for the solar energy system application and executes the calculations based on the user's input values.
     * @param stage is the main application window used for displaying the GUI.
     */

    @Override
    public void start(Stage stage) {

        VBox container = new VBox(10);
        container.setPadding(new Insets(20));
        container.setAlignment(Pos.CENTER);

        Label title = new Label("Solar Energy System");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;-fx-font-family: 'Segoe UI';");
        container.getChildren().add(title);

        Label introductionText = new Label("This system estimates whether the current solar panel setup is sufficient enough to cover a house's yearly energy consumption.");
        introductionText.setStyle("-fx-text-fill: gray;");
        introductionText.setWrapText(true);
        introductionText.setMaxWidth(350);
        container.getChildren().add(introductionText);

        Label spacing1 = new Label("");
        spacing1.setMinHeight(20);
        container.getChildren().add(spacing1);

        Label consumptionTitle = new Label("Yearly House Consumption");
        consumptionTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-font-family: 'Segoe UI';");
        container.getChildren().add(consumptionTitle);

        Label consumptionDescription = new Label("Enter yearly house consumption in kWh. An average household in Denmark with 2-4 people consumes between 4000-6000 kWh of electricity annually.");
        consumptionDescription.setStyle("-fx-text-fill: gray;");
        consumptionDescription.setWrapText(true);
        consumptionDescription.setMaxWidth(350);
        container.getChildren().add(consumptionDescription);

        TextField yearlyConsumptionField = new TextField();
        container.getChildren().add(yearlyConsumptionField);
        yearlyConsumptionField.setPromptText("Enter the yearly house consumption");
        yearlyConsumptionField.setMaxWidth(250);

        Label spacing2 = new Label("");
        spacing2.setMinHeight(1);
        container.getChildren().add(spacing2);

        Label productionTitle = new Label("Expected Yearly Production of a Single Solar Panel in kWh");
        productionTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-font-family: 'Segoe UI';");
        container.getChildren().add(productionTitle);

        Label productionDescription = new Label("Enter yearly solar panel production in kWh. A single average solar panel in Denmark produces around 250-350 kWh of electricity annually.");
        productionDescription.setStyle("-fx-text-fill: gray;");
        productionDescription.setWrapText(true);
        productionDescription.setMaxWidth(350);
        container.getChildren().add(productionDescription);

        TextField yearlyProductionField = new TextField();
        container.getChildren().add(yearlyProductionField);
        yearlyProductionField.setPromptText("Enter the yearly solar panel production");
        yearlyProductionField.setMaxWidth(250);

        Label spacing3 = new Label("");
        spacing3.setMinHeight(1);
        container.getChildren().add(spacing3);

        Label panelCountTitle = new Label("Number of Solar Panels");
        panelCountTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-font-family: 'Segoe UI';");
        container.getChildren().add(panelCountTitle);

        Label panelCountDescription = new Label("Enter the number of solar panels.");
        panelCountDescription.setStyle("-fx-text-fill: gray;");
        container.getChildren().add(panelCountDescription);

        TextField panelCountField = new TextField();
        container.getChildren().add(panelCountField);

        panelCountField.setPromptText("Enter the number of solar panels");
        panelCountField.setMaxWidth(250);

        Label spacing4 = new Label("");
        spacing4.setMinHeight(1);
        container.getChildren().add(spacing4);

        Label result = new Label("The result will be displayed here.");
        result.setStyle("-fx-text-fill: gray;");
        container.getChildren().add(result);

        Button calculateButton = new Button("Calculate");
        calculateButton.setStyle(
                "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;"
        );
        container.getChildren().add(calculateButton);

        calculateButton.setOnAction(event -> {
            try {
                String userConsumptionInput = yearlyConsumptionField.getText();
                double yearlyHouseConsumption = Double.parseDouble(userConsumptionInput);

                String userProductionInput = yearlyProductionField.getText();
                double yearlyProduction = Double.parseDouble(userProductionInput);

                String userPanelCountInput = panelCountField.getText();

                int panelCount = Integer.parseInt(userPanelCountInput);

                House house = new House(yearlyHouseConsumption);

                EnergySystem energySystem = new EnergySystem(house);

                for (int i = 0; i < panelCount; i++) {
                    SolarPanel solarPanel = new SolarPanel(yearlyProduction);
                    energySystem.addSolarPanel(solarPanel);

                }

                boolean sufficient =
                        energySystem.compareProductionAndConsumption();

                int additionalPanelsNeeded =
                        energySystem.calculateAdditionalPanelsNeeded(yearlyProduction);

                double totalProduction =
                        energySystem.calculateSolarProduction();

                if (sufficient) {
                    result.setText(
                            "Solar production is sufficient." + "\nTotal solar panel production: " + totalProduction + " kWh."
                    );
                    result.setStyle("-fx-text-fill: green;");
                }
                else {
                    result.setText(
                            "More solar panels are needed." + "\nAdditional panels needed: " + additionalPanelsNeeded
                    );
                    result.setStyle("-fx-text-fill: red;");
                }

            }
            catch (NumberFormatException e) {

                result.setText("Please enter valid numeric values.");
                result.setStyle("-fx-text-fill: red;");
            }
        });

        Scene scene = new Scene(container, 650, 650);

        stage.setTitle("Solar Energy System");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method that launches and starts the JavaFX application.
     * @param args is the parameter for command-line arguments when the application is executed.
     */

    public static void main(String[] args) {
        launch();
    }
}