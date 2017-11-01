import java.util.Random;

public class Driver {

    public static void main(String... args) {

        Barber[] barbers = new Barber[]{
                new Barber("A", 0),
                new Barber("B", 0),
                new Barber("C", 0),
                new Barber("D", 0),
                new Barber("E", 0)
        };

        int numCustomers = 17;

        try {
            numCustomers = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Error: Could not parse number of customers argument, using default value of 17");
        }

        int numCompleteRounds = numCustomers / 5;
        int numIncompleteRound = numCustomers % 5;

        System.out.println("Number of customers: " + numCustomers);
        System.out.println("Initial order and totals: ");
        printBarbers(barbers);

        //main loop
        //complete rounds
        int i;
        for (i = 0; i < numCompleteRounds; i++) {
            System.out.println("*********");
            System.out.println("Round " + (i + 1) + ":");
            addMonies(barbers);
            System.out.println("New totals:");
            printBarbers(barbers);
            updateOrder(barbers);
            System.out.println("New order:");
            printBarbers(barbers);
        }

        //remaining customers
        if (numIncompleteRound > 0) {
            System.out.println("*********");
            System.out.println("Round " + (i + 1) + ":");
            addMonies(barbers, numIncompleteRound);
            System.out.println("New totals:");
            printBarbers(barbers);
            updateOrder(barbers);
            System.out.println("New order:");
            printBarbers(barbers);
        }

        System.out.println("*********");
        System.out.println("Final order and totals: ");
        printBarbers(barbers);
    }

    public static void updateOrder(Barber[] barbers) {
        for(int i  = 0; i < barbers.length; i ++) {
            fairSort(barbers, i);
        }
    }

    public static void fairSort(Barber[] barbers, int index) {
        Barber indexBarber = barbers[index];
        for(int i = index; i > 0; i--) {
            if(barbers[i - 1].getTotal() - indexBarber.getTotal() >= 20) {
                swapAndPush(barbers, i - 1, index);
                index = i - 1;
            }
        }
    }
    public static void swapAndPush(Barber[] barbers, int targetIndex, int sourceIndex) {
        Barber sourceBarber = barbers[sourceIndex];
        for (int j = sourceIndex; j > targetIndex; j--) {
            barbers[j] = barbers[j - 1];
        }
        barbers[targetIndex] = sourceBarber;
    }

    public static void addMonies(Barber[] barbers) {
        Random rand = new Random();
        for(Barber barber: barbers) {
            int n = (rand.nextInt(4) + 1) * 10;
            barber.setTotal(barber.getTotal() + n);
        }
    }

    public static void addMonies(Barber[] barbers, int remainingCustomers) {
        Random rand = new Random();
        for (int i = 0; i < remainingCustomers; i++) {
            int n = (rand.nextInt(4) + 1) * 10;
            barbers[i].setTotal(barbers[i].getTotal() + n);
        }
    }

    public static void printBarbers(Barber[] barbers) {
        for(Barber barber: barbers) {
            System.out.println(barber.getName() + ": " + barber.getTotal());
        }
    }
}
