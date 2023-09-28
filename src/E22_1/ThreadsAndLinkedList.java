package E22_1;

import java.util.LinkedList;

class AddElementRunnable implements Runnable {
    private LinkedList<Integer> list;

    public AddElementRunnable(LinkedList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            list.add(i);
            System.out.println("Adding: " + i);
        }
    }
}

class RemoveElementsRunnable implements Runnable {
    private LinkedList<Integer> list;

    public RemoveElementsRunnable(LinkedList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 50; i++) {
            if (!list.isEmpty()) {
                int removed = list.remove();
                System.out.println("Removed: " + removed);
            }
        }
    }
}

public class ThreadsAndLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        AddElementRunnable r1 = new AddElementRunnable(list);
        RemoveElementsRunnable r2 = new RemoveElementsRunnable(list);

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        thread1.start();
        thread2.start();

    }
}

/*
When we try to run the program, the elements can be removed from an empty list (Though I give delay in Removing elements),
or the list might not contain all the elements that were added. This demonstrates that the list is being corrupted.
 */