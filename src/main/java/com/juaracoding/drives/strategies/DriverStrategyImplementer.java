package com.juaracoding.drivers.strategies;

public class DriverStrategyImplementer {
    public static DriverStrategy chooseStrategy(String strategy){
        switch (strategy){
            case "chrome":
                return new Chrome();
            case "firefox":
                return new com.juaracoding.drivers.strategies.Firefox();
            default:
                return null;
        }
    }
}
