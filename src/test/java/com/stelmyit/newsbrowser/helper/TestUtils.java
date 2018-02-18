package com.stelmyit.newsbrowser.helper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUtils {
	private static final Logger LOGGER = Logger.getLogger(TestUtils.class.getName());

	public static String getTextFromFile(String path) {
		String text = null;
		try {
			Scanner scanner = new Scanner(new FileReader("src/main/resources/" + path));
			StringBuilder stringBuilder = new StringBuilder();
			while (scanner.hasNext()) {
				stringBuilder.append(scanner.next());
			}
			scanner.close();
			text = stringBuilder.toString();
		} catch (FileNotFoundException exception) {
			LOGGER.log(Level.SEVERE, "Cannot find a file to read.", exception);
		}

		return text;
	}
}
