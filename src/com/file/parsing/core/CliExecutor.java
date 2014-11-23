package com.file.parsing.core;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CliExecutor {

	Options options = new Options();

	void createOptions() {
		options.addOption("opt", false, "options");
		options.addOption("help", false, "help");
		options.addOption("f", true, "file");
		Option opt = new Option("f", "file");
		opt.setArgs(15);
		options.addOption(opt);
	}

	void parse() throws ParseException {
		String[] arg = { "-help" };
		HelpFormatter formatter = new HelpFormatter();
		CommandLineParser parser = new GnuParser();
		CommandLine cmd = parser.parse(options, arg);

		if (cmd.hasOption("opt")) {
			System.out.println("jeeej");
		}

		if (cmd.hasOption("help")) {
			formatter.printHelp("help", options);
		}

	}

	void createHelp() {

	}

	public void execute(String[] args) throws ParseException {
		CommandLineParser commandLineParser = new GnuParser();
		HelpFormatter formatter = new HelpFormatter();
		FileCommandOptionsCreator fileCommandOptionsCreator = new FileCommandOptionsCreator();
		CommandLine cmd = commandLineParser.parse(fileCommandOptionsCreator,
				args);

		if (cmd.hasOption("help")) {
			formatter.printHelp("help", fileCommandOptionsCreator);
		}

		if (cmd.hasOption("word")) {
			if (cmd.hasOption("file")) {
				String wordOptionValue = cmd.getOptionValue("word");
				String[] fileOptionValues = cmd.getOptionValues("file");
				Path[] asa = new Path[fileOptionValues.length];
				for (int i = 0; i < fileOptionValues.length; i++) {
					asa[i] = Paths.get(fileOptionValues[i]);
				}
				new PoolThread().execute(asa, new FileOperationsPattern(
						wordOptionValue));
			}
		}
	}

	public static void main(String[] args) throws ParseException {
		new CliExecutor().execute(args);

	}

}
