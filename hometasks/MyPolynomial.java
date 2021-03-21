package hometasks;


public class MyPolynomial {
    private double[] coeffs;
    public MyPolynomial() {
        this.coeffs = new double[10];
    }
    public MyPolynomial(double... coeffs) {
        this.coeffs = new double[coeffs.length + 5];
        int i = 0;
        for (double inpCoeff : coeffs) {
            this.coeffs[i++] = inpCoeff;
        }
    }
    public int getDegree() {
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (coeffs[i] != 0.0d) {
                return i;
            }
        }
        return 0;
    }
    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < coeffs.length; i++) {
            if (coeffs[i] > 0.0d)
                out = "+" + ((Double)coeffs[i]).toString() + "x^" + ((Integer) i).toString() + out;
            else if (coeffs[i] < 0.0d)
                out = ((Double) coeffs[i]).toString() + "x^" + ((Integer) i).toString() + out;
        }
        return out;
    }
    public double evaluate(double x) {
        double out = 0.0d;
        for (int i = 0; i < coeffs.length; i++) {
            if (coeffs[i] != 0.0d)
                out = out + coeffs[i] * Math.pow(x, i);
        }
        return out;
    }

    public boolean equals(MyPolynomial right) {
        if (getDegree() != right.getDegree()) {
            return false;
        }
        for (int i = 0; i <= getDegree(); i++) {
            if (coeffs[i] != right.coeffs[i]) {
                return false;
            }
        }
        return true;
    }

    public MyPolynomial add(MyPolynomial right) {
        double[] sumCoeffs = new double[Math.max(getDegree(), right.getDegree()) + 1];
        int i = 0;
        while ( (i <= getDegree()) && (i <= right.getDegree()) ) {
            sumCoeffs[i] = right.coeffs[i] + coeffs[i];
            i++;
        }
        while (i <= getDegree()) {
            sumCoeffs[i] = coeffs[i];
            i++;
        }
        while (i <= right.getDegree()) {
            sumCoeffs[i] = right.coeffs[i];
            i++;
        }
        return new MyPolynomial(sumCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        MyPolynomial multiplyPolinomial = new MyPolynomial();
        for (int i = 0; i <= getDegree(); i++) {
            if (coeffs[i] != 0) {
                double[] soloMulti = new double[i + right.getDegree() + 1];
                for (int j = 0; j <= right.getDegree(); j++) {
                    soloMulti[i + j] = coeffs[i] * right.coeffs[j];
                }
                multiplyPolinomial = multiplyPolinomial.add(new MyPolynomial(soloMulti));
            }
        }
        return multiplyPolinomial;
    }
}
