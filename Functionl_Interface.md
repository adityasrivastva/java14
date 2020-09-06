## Functional Interface

* In nutshell, a **_functional interface_** is an interface that specifies **_exactly one abstract method_**.
* These interfaces are also called as **_Single Abstract Method (SAM)_**.
* We can use a **_lambda expression_** in context of a **_functional interface_**.
    * The **_lambda expression_** can be used to represent the instance of a **_functional interfaces_**.
* A **_functional interface_**. can have any number of **_default methods_** and **_static mathods_**.
* **_@FunctionalInterface annotation_** is used to ensure an interface can’t have more than one abstract method. The use of this annotation is optional.

##### What we can do with _functional interfaces_?
* **_Lambda expression_** let us provide the implementation of **_abstract method_** of a **_functional interface_** directly inline and **_treat the whole expression as an instance of a functional interface_**.
    * More technically speaking, provides **_an instance of a concrete implementaion of the functional interface_**.
* We can achieve the same thing with an **_anonymous inner classes_**, although it's **clumsier**: we can provide an implementation and instantiate it directly inline.

```java
public class Main {
    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Hello World 1"); // <-Uses a lambda
        
        // Uses an anonymous class
        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("Hello World 2");
            }
        };
        process(r1); // Hello World 1
        process(r2); // Hello World 2

        // with a lambda passed directly
        process(() -> System.out.println("Hello World 3")); // Hello World 3
    }
    public static void process(Runnable r) {
        r.run();
    }
    
}
    
```

### Function descriptor
* The signature of the abstract method of the functional interface describes the signa-
  ture of the lambda expression.
* We call this abstract method a **_function descriptor_**.
* **For Example**
    * the Runnable interface can be viewed as the signature of a function that accepts nothing and returns nothing ( void ) because it has only one abstract method called run , which accepts nothing and returns nothing ( void ).
* We may wondering how **_lambda expresion_** are **_type-checked_**. Will explian later.
* For now, it suffices to understand that a lambda expression can be assigned to a variable or passed to a method expecting a functional interface as argument, provided the lambda expression has the same signature as the abstract method of the functional interface.
* For instance, in our earlier example, you could pass a lambda directly to the process method as follows:

```java
public void process(Runnable r) {
    r.run();
}
/* You don’t have to enclose a single void method invocation
in braces.*/
process(() -> System.out.println("This is awesome!!"));

```
#### Putting lambdas into practice:
#### the execute-around pattern
* A recurrent pattern in resource processing (for example, dealing with files or databases) is to open a resource, do some processing on it, and then close the resource.
* The setup and cleanup phases are always similar and surround the important code doing the processing.
* This is called the execute-around pattern.
```java
public String processFile() throws IOException {
try (BufferedReader br =
new BufferedReader(new FileReader("data.txt"))) {
return br.readLine();//This is the line that does useful work.
}

}
```

![functional-interface-1.png](https://github.com/adityasrivastva/java14/blob/master/images/functional-interface-1.png)

```java
/*
    Four-step process to apply the execute-around pattern
 */
package org.as.techzone.fuctinalprog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFile {
    public static String processFile () throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))){
            return br.readLine() ;
        }
    }

    public static String processFile( BufferedReaderProcessor p) throws
            IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }
    public static void main(String[] args) throws IOException {
        String s = processFile();
        System.out.println(s);

        String oneLine = processFile ((BufferedReader br) ->
                br.readLine());
        String twoLines = processFile ((BufferedReader br) ->
                br.readLine() +" "+ br.readLine());
        System.out.println(oneLine);
        System.out.println(twoLines);
    }


}
@FunctionalInterface
interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}

```

