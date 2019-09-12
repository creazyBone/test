package test;

class A {
    int x = 6;
    private int y = 2;

    public A(int a) {
        x = a;
    }

    int getz() {
        int z;
        z = x / y;
        return z;
    }

    void show() {
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        System.out.println("z=" + getz());
    }
}
