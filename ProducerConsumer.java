import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer {
    private final Queue<Integer> buffer;
    private final int capacity;

    public ProducerConsumer(int capacity) {
        this.buffer = new LinkedList<>();
        this.capacity = capacity;
    }

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                // Wait if the buffer is full
                while (buffer.size() == capacity) {
                    wait();
                }

                System.out.println("Producer produced: " + value);

                // Add the value to the buffer
                buffer.add(value++);

                // Notify the consumer that new items are available
                notify();

                // Sleep for some time before producing the next item
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                // Wait if the buffer is empty
                while (buffer.isEmpty()) {
                    wait();
                }

                // Remove and retrieve the value from the buffer
                int value = buffer.poll();
                System.out.println("Consumer consumed: " + value);

                // Notify the producer that space is available in the buffer
                notify();

                // Sleep for some time before consuming the next item
                Thread.sleep(1000);
            }
        }
    }
}

 class Testing {
    public static void main(String[] args) {
        final int CAPACITY = 5;

        ProducerConsumer producerConsumer = new ProducerConsumer(CAPACITY);

        Thread producerThread = new Thread(() -> {
            try {
                producerConsumer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                producerConsumer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
