package ru.geekbrains.ntr_0304;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class ConsoleHelper {

    private static Queue<Character> charQueue = new ConcurrentLinkedQueue<>();

    public static void setSequence(String sequence) {
        charQueue.clear();
        charQueue.addAll(sequence.chars().mapToObj(e -> (char) e).collect(Collectors.toList()));
    }

    public static void reset() {
        charQueue.clear();
    }

    public static synchronized void print(char symbol) {

        if (charQueue.isEmpty()) return;
        if (!charQueue.contains(symbol)) return;

        while (symbol != charQueue.peek()) {
            try {
                ConsoleHelper.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(symbol);
        charQueue.add(charQueue.poll());
        ConsoleHelper.class.notifyAll();
    }
}


