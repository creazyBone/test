package test;



class B extends A {
    int x = 3, y = 5, z;

    public B(int a) {
        super(a);
    }

    int getz() {
        z = x + y;
        return z;
    }
}