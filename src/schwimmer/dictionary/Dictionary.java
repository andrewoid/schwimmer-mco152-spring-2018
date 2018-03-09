package schwimmer.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
	
	private Map<String,String> map = new HashMap<String, String>();

	public Dictionary(String filename) throws FileNotFoundException {
		
//		BufferedReader reader = new BufferedReader(
//				new FileReader(new File(filename)));
		
		Scanner scanner = new Scanner(new FileReader(new File(filename)));
		
		while(scanner.hasNext()) {
			String word = scanner.next();
			String definition = scanner.nextLine();
			map.put(word, definition);
		}
		
	}
	
	public String getDefinition(String word) {
		return map.get(word.toUpperCase());
	}
	
	public int size() {
		return map.size();
	}
	
	
}
