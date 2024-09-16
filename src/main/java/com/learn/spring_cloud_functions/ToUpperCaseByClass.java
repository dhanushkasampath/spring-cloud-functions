package com.learn.spring_cloud_functions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

//	Method 2 of implementing serverless functions

public class ToUpperCaseByClass implements Function<String, String> {

    Logger logger = LoggerFactory.getLogger(ToUpperCaseByClass.class);
    /**
     * This serverless function can be called as follows.
     * curl -H "Content-Type:text/plain" localhost:8083/toUpperCaseByClass -d "boooom"
     * @param o
     * @return. in the cmd we can see the uppercase string of the provided string.
     */
    @Override
    public String apply(String o) {
        logger.info("apply method called. String received: {}", o);
        return String.valueOf(o).toUpperCase();
    }
}

// Also we need to add a property to application.properties file saying this is the package we are creating serverless functions.
