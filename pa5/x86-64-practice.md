# Practice reading and writing X86-64 code
An excellent way to learn assembly language is to practice reading and modifying code generated by C compilers.

## Separate compilation
C allows programs to be compiled separately (to assembly language for example), and then linked together.
For this exercise we will compile the following three files and modify the test.s file.

``` C
/* main.c */

long test();  // forward declaration for the compiler

int main(int argc, char *argv[]) {
  test(10,20,30);
  return 1;
}
```

``` C
/* print.c */
#include <stdio.h>

void print(long x){
    printf("%ld\n",x);
}
```

``` C
/* test.c */

void print();

long test(long a, long b, long c){
  long x;
  x = a*b*c;
  return x;
}
```
We can compile these to assembly language with the command
``` bash
gcc -c -S -O0 *.c
```
which will create main.s, print.s, and test.s. The "-c" says to compile
them separately, the "-S" compiles to assembly and the "-O0$ say use the
level 0 optimization (it could be 1,2, or 3 if you want more optimization).


and we can compile those to get an executable (the default is a.out) with
``` bash
gcc main.s test.s print.s
```
which we can run with
``` bash
./a.out
```
You many need to ssh into a X86-64 based computer to run these exercises...


     
