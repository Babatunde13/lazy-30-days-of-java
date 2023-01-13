
class App implements Cloneable {
    public static void main(String[] args) {
        String example1 = String.format(">%d<", 35);
        System.out.println(example1);

        String example2 = String.format(">%7d<", 35);
        System.out.println(example2);        

        String example3 = String.format(">%07d<", 35);
        System.out.println(example3);

        String example4 = String.format(">%-7d<", 35);
        System.out.println(example4);

        String example5 = String.format(">%7.3f<",35.0);
        System.out.println(example5);

        String example7 = String.format("%010.5f", 32.12);
        System.out.println(example7);

    }
}
