package ru.geekbrains.ntr_0304;

public class Main {

    public static void main(String[] args)  {

        ConsoleHelper.setSequence("ABC");

        Thread threadA = new Thread(new CharPrinter('A'));
        Thread threadB = new Thread(new CharPrinter('B'));
        Thread threadC = new Thread(new CharPrinter('C'));

        threadA.start();
        threadB.start();
        threadC.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinished!");
    }

}
