package schwimmer.dictionary;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class DictionaryTest {

	@Test
	public void testConstructor() throws FileNotFoundException {
		
		Dictionary dictionary = new Dictionary("src/schwimmer/dictionary/dictionary.txt");
		assertEquals(167964, dictionary.size());
	}

}
