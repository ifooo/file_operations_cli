package com.file.parsing.core;

public enum FileCommandOptions {

	HELP("h", "help", false, "helps"),

	COPY("cp", "copy", true, 2, "copying files", ' '),

	FILE("f", "file", true, 10, "specifies a file that needs to be searched in.",
			' '),

	WORD("w", "word", true, 1, "specifies a word that needs to be searched.",
			' ');
	/*
	 * COPY
	 * 
	 * SEARCH SPECIFIC WORD
	 */

	private String shortCommand;
	private String longCommand;
	private boolean hasArgs;
	private int maxArgs;
	private String description;
	private char argsDelimiter;

	FileCommandOptions(String shortCommand, String longCommand,
			boolean hasArgs, int maxArgs, String description, char argsDelimiter) {
		this.shortCommand = shortCommand;
		this.longCommand = longCommand;
		this.hasArgs = hasArgs;
		this.maxArgs = maxArgs;
		this.description = description;

	}

	private FileCommandOptions(String shortCommand, String longCommand,
			boolean hasArgs, String description) {
		this(shortCommand, longCommand, hasArgs, 0, description, ' ');
	}

	public String getShortCommand() {
		return shortCommand;
	}

	public void setShortCommand(String shortCommand) {
		this.shortCommand = shortCommand;
	}

	public String getLongCommand() {
		return longCommand;
	}

	public void setLongCommand(String longCommand) {
		this.longCommand = longCommand;
	}

	public boolean isHasArgs() {
		return hasArgs;
	}

	public void setHasArgs(boolean hasArgs) {
		this.hasArgs = hasArgs;
	}

	public int getMaxArgs() {
		return maxArgs;
	}

	public void setMaxArgs(int maxArgs) {
		this.maxArgs = maxArgs;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getArgsDelimiter() {
		return argsDelimiter;
	}

	public void setArgsDelimiter(char argsDelimiter) {
		this.argsDelimiter = argsDelimiter;
	}

}
