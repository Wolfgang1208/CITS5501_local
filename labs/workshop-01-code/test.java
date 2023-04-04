class test {
    static boolean inner() {
        System.out.print("inner");
        return false;
    }

    static void outer() {
        if (true | inner()) {
            System.out.print("outer");
        }
    }

    public void myMethod() {
        long l = 12;
        int i = (int) l;
        System.out.print(i);
    }

    public static void arrayMethod() {
        int[] myArray = { 80 };
        int[] arr = myArray;
        arr[0] -= 1;
        System.out.println(myArray[0]);
    }

    private static void printNum() {
        long a = 9223372036854775807L;
        System.out.println(a + 100000000);
    }

    public static void main(String[] args) {
        arrayMethod();
        printNum();
    }

}