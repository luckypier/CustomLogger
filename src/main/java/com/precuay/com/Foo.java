package com.precuay.com;

import com.precuay.com.logger.LoggerEngine;

/**
 * Run me!!!
 * @author Pierre Recuay
 */
public class Foo {

	LoggerEngine logger = LoggerEngine.getInstance();

	public static void main(String[] args) {
		Foo foo = new Foo();
		foo.execute();
	}

	public void execute() {
	    logger.message("this is a message");

		logger.error("This is an error");

		logger.warning("This is a warning");
	}
}
