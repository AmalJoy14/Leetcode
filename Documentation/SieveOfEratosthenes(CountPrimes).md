# Sieve of Eratosthenes

## Overview
The Sieve of Eratosthenes is an efficient algorithm used to find all prime numbers up to a given limit. It is particularly useful for generating prime numbers in a specified range with a time complexity of  *O(n log n)*.

## Steps of the Algorithm
1. **Initialize an Array**: Create a boolean array `isPrime[]` of size `n` (where `n` is the limit till which we need to find primes) and initialize all elements as `true`.
2. **Mark Non-Primes**:
   - Start with the first prime number, which is `2`.
   - Mark all multiples of `2` (except `2` itself) as `false` in the array.
   - Move to the next number in the array and repeat the process for numbers that are still marked as `true`.
3. **Collect Prime Numbers**: After marking, the indices of the array `isPrime[]` that are still `true` represent prime numbers.

## Code
```java
class Solution {
    public int countPrimes(int n) {
        
        //Sieve Of Eratosthenes.
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes , true);    //Default : true
        int count = 0;

        for (int i = 2 ; i < n ; i++){
            if (isPrimes[i]){
                count++;
                for (int j = i * 2 ; j < n ; j += i){
                   isPrimes[j] = false; 
                }
            }
        }

        return count;
    }
}
