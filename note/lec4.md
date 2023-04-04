# Input Space Partition Testing

# Input Space Partitioning

## Preliminaries

## Problem - choosing test values

- Suppose we have some hava method we want to test:
  <img src="../image/lec4pic1.png">
- What tests should we write?
  - do not write anything about testing "null"s
- When can we stop writing tests?

# Function-like things

- The technique of **Input Space Partitioning** helps us answer these questions.
- If something we are trying to test can be modelled as a mathematical function, then we can apply the ISP technique to devise tests for it (and to check how throgh our testing currently is).
- Before we use it, we'll go through a few mathematical preliminaries

# Functions - abs

- In mathematics, a function is a mapping from one set (called the domain) to another (called the codomain)
- e.g. the function abs gives the absolute value of an integer. Its domain is the integers, and its codomain is the non-negative integers
  <img src="../image/lec4pic2.png">

# isLeapYear

- Some Java methods can be very naturally modelled as mathematical functions. **java.lang.Math.abs** was intended to implement that mathematival abs function, so the mathematical function is a natural model.
- As another example, a Java method isLeadpYear, with the following signature and description
  <img src="../image/lec4pic3.png">

# mathematics and models

- Models are always simplifications - they abstract from the real world, and leave some details out.
- When we abstract the Java method:

```java
    static boolean isLeapYear(int year)
```

- we're ignoring the fact that a Java int can't actually hold every possible integer value
  - it's limited to the range of values from -2147483648 to 2147483647 (-2^31 ~ 2^31-1)
- But for most purposes, that model will be good enough.
- How much detail we put into our models - how "true to life" they must be - will depend on what the consequences are if our software goes wrong, and how much we want to avoid those consequences.
- If we are writing budgeting software in Python for our own use, then the model above is probably fine.
- If we are working with numbers of very large magnitude (or perhaps are writing a compiler), then we might want to make our model more precise。

# Testing functions

- We know that we cant test most java methods exhaustively (for every 4294967296 ints)
- So when modelling something as a function, we rely on important principles:
  - We dont have to test all the inputs to a software component, but can choose representative samples
  - Programmers tend to make mistakes on or around the boundaries of things

# Equivalence classes

- Instead of writing 4294967296 tests for java.lang.Math.abs, we might instead try to ensure that
  - We have tested it with a positive **int**, negative **int**, 0
- Why? Because in all likelihood, java.lang.Math.abs will treat all positive **int**s thet same - once we've tested a few positive **int**s, changes are that testing moew isn't go to make any difference.
- We have grouped the possible inputs into what are called equivalence classes - sets of values which (for some property we choose) can be treated as equivalent.

# Boundaries

- So having divided up the **int**s into positive, negative and 0, we might decide to test java.lang.Math.abs with, say, the numbers 32, -4059, and 0.
- Knowing that when programmers make mistakes, it is often around the boundaries of things, we might also test the numbers 1 and -1 (and perhaps the numbers -2^31 and 2^31 - 1) - why those numbers?

# Mutating other state

- System.out.println
- println: SetOfPossibleScreenStates(input state) -> SetOfPossibleScreenStates(output state)

# ISP technique

- Let'use the findElement method we saw at the start of the lecture as an example
  <img src="../image/lec4pic4.png">
- ISP is about considering the domain for the function - all its possible inputs - and choosing finite sets of values from the input domain to use as **test values**
- Input parameters define the scope of the input domain:
  - Parameters to a method
  - Data read from a file
  - Global variables
  - User level inputs

# ISP technique

- The domain for each input parameter is partitioned into regions
- At least one value is chosen from each region

# Not just methods

- We can apply the ISP technique not just to Java methods, but anything we're able to model as a function.
  - System
    - e.g. a database system. We could consider it as taking in use requests and spitting out reports
  - Hardware
    - e.g. an Internet-controllable toaster. We can consider as taking in toasters settings and untoasted bread, and spitting out toast.
