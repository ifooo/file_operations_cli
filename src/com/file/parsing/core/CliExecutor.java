package com.file.parsing.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

public class CliExecutor {

	public void execute(String[] args) throws ParseException, IOException {
		CommandLineParser commandLineParser = new GnuParser();
		HelpFormatter formatter = new HelpFormatter();
		FileCommandOptionsCreator fileCommandOptionsCreator = new FileCommandOptionsCreator();
		CommandLine cmd = commandLineParser.parse(fileCommandOptionsCreator,
				args);

		if (cmd.hasOption("help")) {
			formatter.printHelp("help", fileCommandOptionsCreator);
		} else if (cmd.hasOption("word") && cmd.hasOption("file")) {
			String wordOptionValue = cmd.getOptionValue("word");
			String[] fileOptionValues = cmd.getOptionValues("file");
			Path[] pathToFile = new Path[fileOptionValues.length];
			for (int i = 0; i < fileOptionValues.length; i++) {
				pathToFile[i] = Paths.get(fileOptionValues[i]);
			}
			new PoolThread().execute(pathToFile, new FileOperationsPattern(
					wordOptionValue));
		} else if (cmd.hasOption("copy")) {
			String[] files = cmd.getOptionValues("copy");
			Path source = Paths.get(files[0]);
			Path target = Paths.get(files[1]);
			Files.copy(source, target);
		} else {
			System.out.println("No valid command");
		}
	}

	public static void main(String[] args) throws ParseException, IOException {
		new CliExecutor().execute(args);

	}

}
