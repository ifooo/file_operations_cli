package com.file.parsing.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOperations implements Runnable {

	private FileOperationsPattern fileOperationsPattern;

	Path pathToFile;

	public FileOperations(FileOperationsPattern operationsPattern,
			Path pathToFile) {
		this.fileOperationsPattern = operationsPattern;
		this.pathToFile = pathToFile;
	}

	void readFile() {
		// System.out.println("Started reading the file at " + new Date());
		String line;
		Charset charset = StandardCharsets.UTF_8;
		try (BufferedReader bufferedReader = Files.newBufferedReader(
				pathToFile, charset)) {
			while ((line = bufferedReader.readLine()) != null) {
				fileOperationsPattern.searchForSpecificWord(line);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start. File = "
				+ pathToFile);
		readFile();
		System.out.println(Thread.currentThread().getName() + " End.");

	}
}
