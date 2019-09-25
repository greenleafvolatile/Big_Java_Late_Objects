import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * "Implement the sieve of Eratosthenes: a method for computing prime numbers, known to the ancient Greeks.
 * This method will compute all prime numbers up to n. Choose an n. First insert all number from 2 to n into a set.
 * Then erase all multiples of 2 (except 2); that is 4, 6, 8, 10, 12....Erase all multiples of 3; that is 6, 9, 12, 15..
 * Go up to square root of n. Then print the set."
 */

public class Programming_Exercise_15_8 {

    public static void computePrime(int n){
        Set<Integer> result = new HashSet<>();
        for(int i=2;i<n;i++){
            result.add(i);
        }
        Iterator<Integer> iterator=result.iterator();
        while(iterator.hasNext()){

            Integer number=iterator.next();
            for(int i=2;i<Math.sqrt(n);i++){
                if (number != i && number % i == 0 ) {
                    iterator.remove();
                    break;
                }
            }
        }
        for(Integer number : result){
            System.out.print(number + " ");
        }

    }
    public static void main(String[] args){
        computePrime(11);
    }
}
