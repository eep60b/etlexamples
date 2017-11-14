package com.etlsolutions.examples.weather;

/**
 *
 * @author zc
 */
public final class MetWeatherCommandLineRunner {

    public static void main(String[] args) throws Throwable {
        
        try{
            ApplicationParametersFactory factory = ApplicationParametersFactory.getInstance();
            ApplicationParameters parameters = factory.loadApplicationParameters(args);
            if(parameters.isRunMultiple()) {
                new MultipleProcessor().process(parameters);
            } else {
                new SingleProcessor().process(parameters);
            }
            
            factory.saveParameters(parameters);
            
        } catch (Throwable th) {
            throw th;
        }
    }
}
