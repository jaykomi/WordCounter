package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import application.WordCounter;

public class WordCounterTest {

    @Test
    public void testCountWords() {
    	
        // Test de countWords-methode met verschillende invoerteksten
        String text1 = "Dit is een test.";
        int wordCount1 = WordCounter.countWords(text1);

        // Verwacht aantal woorden in de tekst1 is 4
        Assertions.assertEquals(4, wordCount1);

        String text2 = " Hello,  world! ";
        int wordCount2 = WordCounter.countWords(text2);

        // Verwacht aantal woorden in de tekst2 is 2 -- leading & ending spaties i.c.m. karakters. 
        Assertions.assertEquals(2, wordCount2);

        String text3 = "";
        int wordCount3 = WordCounter.countWords(text3);

        // Verwacht aantal woorden in de tekst3 is 0 (lege tekst)
        Assertions.assertEquals(0, wordCount3);
        
        String text4 = "123";
        int wordCount4 = WordCounter.countWords(text4);

        // Verwacht aantal woorden in de tekst4 is 0 (cijfers)
        Assertions.assertEquals(0, wordCount4);
    }
}