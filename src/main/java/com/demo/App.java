package com.demo;

public class App {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        System.out.println("Application Started");

        System.out.println("Addition: "
                + calculator.add(10, 20));

        System.out.println("Subtraction: "
                + calculator.subtract(20, 5));

        System.out.println("Multiplication: "
                + calculator.multiply(5, 6));

        System.out.println("Application Completed");
    }
}
