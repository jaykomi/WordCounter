package interfaces;

import java.util.List;

import application.WordFrequency;

//interface -- geen implementatie alleen declaratie
public interface IWordFrequencyAnalyzer {
	
	int calculateHighestFrequency(String text);
	int calculateFrequencyForWord (String text, String word);
	List<WordFrequency> calculateMostFrequentNWords (String text, int n);
	
}