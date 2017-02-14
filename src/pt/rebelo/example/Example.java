package pt.rebelo.example;

import java.util.logging.Logger;

/**
 *
 * @author joaorebelo-ar
 */
public final class Example {

    //example don't do it this way


    public static void main(String []args){

        long valueWhenToStop = ((long) (Math.random() * Integer.MAX_VALUE));

        Logger anonymousLogger = Logger.getAnonymousLogger();

        anonymousLogger.info(String.format("Value of when to stop is %d", valueWhenToStop));


    }
}
