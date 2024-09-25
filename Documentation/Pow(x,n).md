# Power Function (`myPow`)

## Problem Statement
Given a base `x` (a double) and an integer `m` (which can be positive, negative, or zero), calculate the value of \( x^m \).

## Example

**Input:**  
`x = 2.0`, `m = 10`

**Output:**  
`1024.0`  
(Since \( 2^{10} = 1024 \))

---

**Input:**  
`x = 2.0`, `m = -2`

**Output:**  
`0.25`  
(Since \( 2^{-2} = \frac{1}{2^2} = 0.25 \))

## Approach

To calculate \( x^m \), the function follows these steps:

1. **Handle Edge Cases:**
   - If `m` is zero, return `1`, since any number raised to the power of zero is `1`.
   - If `m` is negative, convert the problem into a positive exponent by inverting the base and negating the exponent.

2. **Exponentiation by Squaring:**
   - For efficiency, instead of multiplying `x` by itself `m` times, we reduce the problem size by halving the exponent in each iteration.
   - If the exponent is odd, multiply the result by `x` and continue with the squared base and halved exponent.
  
![Image](./Images/power.jpg)

### Java Code
```java
class Solution {
    public double myPow(double x, int m) {
        long n = m;                         // To handle edge case where m is Integer.MIN_VALUE
         
        if (n == 0) return 1;               // Base case: any number to the power of 0 is 1

        if (n < 0){                         //Since x^-n  =>  (1 / x)^n
            n = -n;  
            x = 1 / x;  
        }

        double res = 1;

        while (n != 0) {  
            long rem = n % 2; 
            n = n / 2;  
            if (rem == 1) {  
                res = res * x;
            }
            x = x * x; 
        }
        return res;  
    }
}
