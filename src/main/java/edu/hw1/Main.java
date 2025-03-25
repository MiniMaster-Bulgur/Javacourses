package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    private Main() {

    }


    public static void main(final String[] ignoredArgs) {
        LOGGER.info("Hello and welcome!");

        for (int i = 0; i <= 2; i++) {
            LOGGER.info("i = {}", i);
        }
    }
}
