package com.file.parsing.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileOperationsPattern {
//	private static final String REGEXP = "[a-zA-Z]{3,}ia";

	private String specificWord;

	public FileOperationsPattern(String specificWord) {
		this.specificWord = specificWord;

	}

	void searchForSpecificWord(String line) {
		Pattern pattern = Pattern.compile(specificWord);

		Matcher matcher = pattern.matcher(line);

		while (matcher.find()) {
			System.out.println(Thread.currentThread().getName() + "found: "
					+ matcher.group() + " start(): " + matcher.start()
					+ ", end(): " + matcher.end());
		}
	}
}
