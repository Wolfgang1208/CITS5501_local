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
        long l = 65535;
        int i = l;
        System.out.print(i);
    }

    public static void main(String[] args) {
        outer();
    }
}