package Water;

import java.util.concurrent.Semaphore;

class Water {

    private final Semaphore hydrogen;
    private final Semaphore oxygen;
    Runnable releaseHydrogen = ()-> System.out.print("H");
    Runnable releaseOxygen = ()-> System.out.print("O");
    int moleculs;

    public Water(int moleculs) {
        hydrogen = new Semaphore(2, true);
        oxygen = new Semaphore(0, true);
        this.moleculs = moleculs;
    }

    private void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire(1);
        releaseHydrogen.run();
        oxygen.release(1);
    }

    private void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire(2);
        releaseOxygen.run();
        hydrogen.release(2);
    }

    public void build(){
        String input = CreateMoleculs.buildChain(moleculs);
        System.out.println("Input: " + input);

        System.out.println("Output: ");

        for(int i = 0; i < input.length(); i++ ){

            switch (input.charAt(i)) {
                case 'O' -> new Thread(() -> {
                    try {
                        oxygen(releaseOxygen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
                case 'H' -> new Thread(() -> {
                    try {
                        hydrogen(releaseHydrogen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ).start();
            }
        }
    }
}