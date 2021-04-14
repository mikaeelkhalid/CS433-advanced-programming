package a02;

class even extends Thread {

    @Override
    public void run() {

        int count = 0;

        for (int i = 0; i < 10000; i++) {

            if (i % 2 == 0) {

                count += 1;
            }
        }

        System.out.println("total even numbers in range 0 to 10000: " + count);
        System.out.println("using thread: " + Thread.currentThread().getName());
    }
}

class prime extends Thread {

    @Override
    public void run() {

        int num = 0;
        int primeNums = 0;

        for (int i = 0; i < 10000; i++) {

            int count = 0;

            for (num = i; num >= 1; num--) {

                if (i % num == 0) {

                    count += 1;
                }

                if (count > 2) {

                    break;
                }
            }

            if (count == 2) {

                primeNums += 1;
            }
        }

        System.out.println("total prime numbers in range 10000: " + primeNums);
        System.out.println("using thread: " + Thread.currentThread().getName());
    }
}

class Process {
    public static void main(String[] args) throws InterruptedException {

        even thread1 = new even();
        prime thread2 = new prime();

        long startTime = System.nanoTime();
        thread1.start();
        thread2.start();
        long stopTime = System.nanoTime();
        thread2.join();

        System.out.print("time in nanoseconds: ");
        System.out.println(stopTime - startTime);

        startTime = System.nanoTime();
        thread1.run();
        thread2.run();
        stopTime = System.nanoTime();

        System.out.print("time in nanoseconds: ");
        System.out.println(stopTime - startTime);
    }
}