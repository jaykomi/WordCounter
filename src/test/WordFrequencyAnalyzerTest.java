package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.WordFrequency;
import application.WordFrequencyAnalyzer;

import java.util.List;

public class WordFrequencyAnalyzerTest {

    private WordFrequencyAnalyzer wordFrequencyAnalyzer;

    @BeforeEach
    // BeforeEach = execute method before each new test 
    public void setup() {
        wordFrequencyAnalyzer = new WordFrequencyAnalyzer();
    }

    @Test
    public void testHighestFrequency() {
    	
        // Test de calculateHighestFrequency
        String exampleText = "Dit dit is een test. Dit is een test.";
        int highestFrequency = wordFrequencyAnalyzer.calculateHighestFrequency(exampleText);

        // Frequentie van het meesvoorkomende woord "dit" is 2
        Assertions.assertEquals(3, highestFrequency);
    }

    @Test
    public void testFrequencyForWord() {
    	
        // Test de calculateFrequencyForWord-methode met een voorbeeldtekst en een specifiek woord
        String exampleText = "Dit is een test. Dit is slechts een Test.";
        String exampleWord = "test";
        int frequency = wordFrequencyAnalyzer.calculateFrequencyForWord(exampleText, exampleWord);

        // Verwachte frequentie van het woord "test" is 2 (hoofdlettergevoeligheid testen)
        Assertions.assertEquals(2, frequency);
    }

    @Test
    public void testMostFrequentNWords() {
        // Test de calculateMostFrequentNWords-methode met een voorbeeldtekst en 'n' gelijk aan 3
        String exampleText = "Dit is een test. Dit is een Test.";
        int n = 3;
        List<WordFrequency> mostFrequentWords = wordFrequencyAnalyzer.calculateMostFrequentNWords(exampleText, n);

        // Verwachte lijst van de 3 meest voorkomende woorden met hun frequenties:
        // "dit" (2), "een" (2), "is" (2) -- Alfabetische volgorde. 
        Assertions.assertEquals(3, mostFrequentWords.size());
        Assertions.assertEquals("dit", mostFrequentWords.get(0).getWord());
        Assertions.assertEquals(2, mostFrequentWords.get(0).getFrequency());
        Assertions.assertEquals("een", mostFrequentWords.get(1).getWord());
        Assertions.assertEquals(2, mostFrequentWords.get(1).getFrequency());
        Assertions.assertEquals("is", mostFrequentWords.get(2).getWord());
        Assertions.assertEquals(2, mostFrequentWords.get(2).getFrequency());
    }
}
