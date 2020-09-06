package org.as.techzone;

public class Main {
    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Hello World 1"); // <-Uses a lambda

        // Uses an anonymous class
        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("Hello World 2");
            }
        };
        process(r1); // Hello World 1
        process(r2); // Hello World 2

        // with a lambda passed directly
        process(() -> System.out.println("Hello World 3")); // Hello World 3
    }
    public static void process(Runnable r) {
        r.run();
    }

}
