package com.KrzzybStudios.bowsmasscalculator;

public class Bows_weight_formula_1 {
    public static double getWeight(double alpha, double beta, double draw){
        //double alpha = 7.6, beta = 7, draw = 35,
        double weight = 0;
        weight = draw * 0.453592 * Math.sin(Math.toRadians(beta)) * Math.cos(Math.toRadians(alpha));
        weight = weight / Math.cos(Math.toRadians(beta));
        //double weightDouble = String.format("%.2f", weight);
        System.out.print(weight);
        return weight;
    }
}  