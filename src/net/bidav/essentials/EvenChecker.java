package net.bidav.essentials;

// Yunus

public class EvenChecker {


    public static boolean isInt(double n){
        int counter = 0;
        while(counter <= n) {
            if (counter == n)
                return true;
            counter++;
        }
        return false;
    }

    //Gamma function code I found online
    static double gamma(double x) {
        double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
        double ser = 1.0 + 76.18009173    / (x + 0)   - 86.50532033    / (x + 1)
                + 24.01409822    / (x + 2)   -  1.231739516   / (x + 3)
                +  0.00120858003 / (x + 4)   -  0.00000536382 / (x + 5);
        return Math.exp(tmp + Math.log(ser * Math.sqrt(2 * Math.PI)));
    }

    public static boolean is2(double n){
        double gammaN = n-gamma(n+1);
        if( gammaN < .000000001 && gammaN > 0)  //Approximation because computers suck, checks to see if n = gamma(n+1)
            if(n == n*n)
                return false;
            else
                return true;
        else
            return false;
    }

    public static boolean isPrime(double n){
    int count = 0;
    int divCount = 0;

    while(!(count == 2))
        count++;

    while(count < n)
    {
        if(isInt(n/count))
            divCount++;
        count++;
    }

    if (divCount >= 1)
        return false;
    else
        return true;
    }


    //Most Important Prat
    public static boolean isEven(double n){

        if(is2(n))
            return true;
        if(isPrime(n))
            return false;
        int count = 1;
        while (!(isPrime(count + n) || isPrime(count - 1) )){
        count++;
        }
        if(isInt((count*count)/2))
            return true;
        else
            return false;

    }


    public static void main(String[] args) {

        double inputNumber = 112; //Only works for numbers greater then 1

        System.out.println(isEven(inputNumber));

    }



}
