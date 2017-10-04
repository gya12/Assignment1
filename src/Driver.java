import java.util.Random;

public class Driver {

    public static void main(String[] args) {

        Barber[] barbers = new Barber[]{
                new Barber("A", 0),
                new Barber("B", 0),
                new Barber("C", 0),
                new Barber("D", 0),
                new Barber("E", 0)
        };


        Barber[] b1 = new Barber[]{
                new Barber("A", 100),
                new Barber("B", 100),
                new Barber("C", 90),
                new Barber("D", 90),
                new Barber("E", 80)
        };

        Barber[] b2 = new Barber[]{
                new Barber("E", 190),
                new Barber("A", 190),
                new Barber("B", 200),
                new Barber("C", 200),
                new Barber("D", 180)
        };


        printBarbers(b1);
        updateOrder(b1);
        printBarbers(b1);
        System.out.println("*****************");
        printBarbers(b2);
        updateOrder(b2);
        printBarbers(b2);

        //printBarbers(b2);
        //updateOrder(b2);
        //printBarbers(b2);

        //swapAndPush test
        //printBarbers(b1);
        //swapAndPush(b1, 1, 4);
        //printBarbers(b1);
        //swapAndPush(b1, 0,1);
        //printBarbers(b1);

        //printBarbers(barbers);
        //addMonies(barbers);
        //printBarbers(barbers);
/*
        //main loop
        //complete rounds for now
        for (int i = 0; i < 1; i++) {
            addMonies(barbers);
            //sort(barbers);

        }
*/

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

                //indexBarber = barbers[index];
                //keep the indexBarber
                //update index
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

    public static void printBarbers(Barber[] barbers) {
        System.out.println("******");
        for(Barber barber: barbers) {
            System.out.println(barber.getName() + ": " + barber.getTotal());
        }
        System.out.println("***");
    }
}
