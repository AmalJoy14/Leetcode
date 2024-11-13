# Leap Year Checker

## Introduction
The conditions for a year to be a leap year are:
1. It should be divisible by 4.
2. However, if it is divisible by 100, it must also be divisible by 400 to be a leap year.

## Logic
To determine if a year is a leap year:
- A year is a leap year if:
  - It is divisible by 4 **and** not divisible by 100.
  - **Or**, it is divisible by 400.
  
## Code

```java

        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
