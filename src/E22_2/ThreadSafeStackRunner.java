package E22_2;

public class ThreadSafeStackRunner {
    public static void main(String[] args) {
        ThreadSafeStack stack = new ThreadSafeStack();

        // Push elements into the stack using multiple threads
        Thread pushThread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                stack.push(i);
                System.out.println("Pushed: " + i);
            }
        });

        Thread pushThread2 = new Thread(() -> {
            for (int i = 6; i <= 10; i++) {
                stack.push(i);
                System.out.println("Pushed: " + i);
            }
        });

        pushThread1.start();
        pushThread2.start();

        try {
            pushThread1.join();
            pushThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Pop elements from the stack using multiple threads
        Thread popThread1 = new Thread(() -> {
            while (!stack.isEmpty()) {
                int item = stack.pop();
                System.out.println("Popped: " + item);
            }
        });

        Thread popThread2 = new Thread(() -> {
            while (!stack.isEmpty()) {
                int item = stack.pop();
                System.out.println("Popped: " + item);
            }
        });

        popThread1.start();
        popThread2.start();

        // Check if the stack is empty
        Thread isEmptyThread = new Thread(() -> {
            boolean empty = stack.isEmpty();
            System.out.println("Is Stack Empty? " + empty);
        });

        isEmptyThread.start();
    }
}

