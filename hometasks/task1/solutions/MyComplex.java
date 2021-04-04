package hometasks.task1.solutions;

public class MyComplex {
    private double real = 0.0d;
    private double imag = 0.0d;
    public MyComplex(){}
    public MyComplex(double real, double imag) {
        this.imag = imag;
        this.real = real;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return '(' + ((Double)real).toString() + (imag >= 0 ? '+': "") + ((Double)imag).toString() + "i)";
    }

    public boolean isReal() {
        return (real != 0.0d);
    }

    public boolean isImaginary() {
        return (imag != 0.0d);
    }

    public boolean equals(double real, double imag) {
        return ((this.real == real) && (this.imag == imag));
    }

    public boolean equals(MyComplex another) {
        return equals(another.getReal(), another.getImag());
    }

    public double magnitude() {
        return (Math.sqrt(real * real + imag * imag));
    }

    public double argument() {
        if (real >= 0)
            return (Math.atan(imag / real));
        else return (imag >=0 ? (Math.PI + Math.atan(imag / real)) : (-Math.PI + Math.atan(imag / real)) );
    }

    public MyComplex add(MyComplex right) {
        this.real += right.getReal();
        this.imag += right.getImag();
        return this;
    }

    public MyComplex addNew(MyComplex right){
        double real = this.real + right.getReal();
        double imag = this.imag + right.getImag();
        return new MyComplex(real, imag);
    }

    public MyComplex subtract(MyComplex right){
        this.real -= right.getReal();
        this.imag -= right.getImag();
        return this;
    }

    public MyComplex subtractNew(MyComplex right){
        double real = this.real - right.getReal();
        double imag = this.imag - right.getImag();
        return new MyComplex(real, imag);
    }

    public MyComplex multiply(MyComplex right){
        this.real = real * right.getReal() - imag * right.getImag();
        this.imag = imag * right.getReal() + real * right.getImag();
        return this;
    }

    public MyComplex divide(MyComplex right){
        double denom = right.getReal() * right.getReal() - right.getImag() * right.getImag();
        this.real = (real * right.getReal() + imag * right.getImag()) / denom;
        this.imag = (imag * right.getReal() - real * right.getImag()) / denom;
        return this;
    }

    public MyComplex conjugate(){
        return new MyComplex(this.real, -this.imag);
    }
}
