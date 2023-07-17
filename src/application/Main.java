package application;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class Main extends Application {
    private ListView<String> wordListView;
    private Label wordCountLabel;
    
    // https://www.wikihow.com/Install-Spring-Boot-in-Eclipse -- voor springboot uitleg voor REST API. 
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            TextArea textArea = new TextArea(); // TextArea voor user input
            Button calculateButton = new Button("Calculate"); // Button om berekening te triggeren
            wordListView = new ListView<>(); // ListView voor de meest frequente woorden
            wordCountLabel = new Label(); // Label to display word count

            // functies aan de hand van button press. 
            calculateButton.setOnAction(e -> {
                String inputText = textArea.getText();

                // initialiseer de wordcount functie op de input text en vul de label met de return value van WordCounter
                int wordCount = WordCounter.countWords(inputText);
                wordCountLabel.setText("The total word count is: " + wordCount);

                // initialiseer de frequentie functie met de naam analyzer 
                WordFrequencyAnalyzer analyzer = new WordFrequencyAnalyzer();
                
                // haal de top 5 meest gebruikte woorden uit de ingevoerde tekst
                List<WordFrequency> mostFrequentWords = analyzer.calculateMostFrequentNWords(inputText, 5);

                // maak een woordlijst voor het opslaan van de frequentie + woord. 
                // for loop om door de mostFrequentWords lijst heen te gaan. getWord en getFrequency koppelen woord + frequentie aan observerable list       
                ObservableList<String> wordList = FXCollections.observableArrayList();
                for (WordFrequency wordFrequency : mostFrequentWords) {
                    wordList.add(wordFrequency.getWord() + " : " + wordFrequency.getFrequency());
                }

                wordListView.setItems(wordList);
            });
            
            calculateButton.disableProperty().bind(Bindings.isEmpty(textArea.textProperty()));

            // javaFX boxes offset/spacing parameters 
            HBox countHBox = new HBox(10);
            countHBox.setPadding(new Insets(10));
            countHBox.getChildren().addAll(calculateButton, wordCountLabel);

            VBox vBox = new VBox(10);
            vBox.setPadding(new Insets(10));
            vBox.getChildren().addAll(textArea, countHBox, wordListView);

            root.setCenter(vBox);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
