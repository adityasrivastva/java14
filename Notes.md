## Behavior Parameterization
* Behavior parameterization is the ability for a method to take multiple different behaviors as parameters and use them internally to accomplish different behaviors.
* Behavior parameterization lets us make our code more adaptive to changing requirements and saves on engineering efforts in the future.
* Passing code is a way to give new behaviors as arguments to a method. But it’s
  verbose prior to Java 8. Anonymous classes helped a bit before Java 8 to get rid
  of the verbosity associated with declaring multiple concrete classes for an inter-
  face that are needed only once.
* The Java API contains many methods that can be parameterized with different
  behaviors, which include sorting, threads, and GUI handling.
## Lambda Expression
* Passing code with behavior parameterization is useful for coping with frequent requirement changes in your code.
* Anonymous classes helped a bit before Java 8 to get rid of the verbosity associated with declaring multiple concrete classes for an interface that are needed only once.
* Java 8 tackle the verbosity issue of Anonymous classes by introducing **lambda-expression**. They let us reprsent behaviour or pass code in concise way.


### Lambda in a nutshell
* A **lambda-expression** can be understood as a concise representation of an annonymous function that can be pass around.
* It doesn't have **name**  
## Functional Interfaces
* An Interface which contain only one **single abstract method** called **Functional Interface** or **(SAM)**.
* These can be represented using:
    * **lambda-expression**
    * **method-reference** and 
    * **constructor-reference**
    
