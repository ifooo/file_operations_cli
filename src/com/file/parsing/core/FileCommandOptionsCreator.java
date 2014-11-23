package com.file.parsing.core;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class FileCommandOptionsCreator extends Options{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileCommandOptionsCreator() {

		for (FileCommandOptions commandOption : FileCommandOptions.values()) {
			Option option = new Option(commandOption.getShortCommand(),
					commandOption.getLongCommand(), commandOption.isHasArgs(),
					commandOption.getDescription());
			option.setArgs(commandOption.getMaxArgs());
			option.setValueSeparator(commandOption.getArgsDelimiter());
			addOption(option);
		}
	}

}
