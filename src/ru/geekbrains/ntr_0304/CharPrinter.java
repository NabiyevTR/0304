package ru.geekbrains.ntr_0304;


public class CharPrinter implements Runnable {
    private char symbol;

    private static final int NUMBER_OF_SYMBOLS = 5;

    public CharPrinter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUMBER_OF_SYMBOLS; i++) {
            ConsoleHelper.print(symbol);
        }
    }
}
