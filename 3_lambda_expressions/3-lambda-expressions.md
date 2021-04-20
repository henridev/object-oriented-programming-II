# lambda expressions TOC

```
1. Inleiding
2. Interface implementatie 
3. Anonieme Klasse
4. Lambda expressies
5. Methode referentie   
6. Functionele Interfaces  
7. basis Functionele Interfaces
```

## 1. Inleiding

- **functionele interface** = interface met exact één abstracte methode.
- **lambda expressie** = implementeert de enige abstracte methode van een functionele interface (lambda-expressie implementeert de functionele interface)
- Een lambda-expressie creëert een **instantie** van een functionele interface.
- Lambdaexpressies zijn een stap in de richting van **functioneel programmeren**

## 2. Implementatie van een interface

Een interface implementatue
- in een **gewone klasse**.
- in een **lokale klasse** binnen een code blok
- in een **anonieme klasse** waar je in één stap een klasse declareert en instantieert


```java
public class HelloWorldLocalClass {
    @FunctionalInterface
    private interface HelloWorld {
        public void greetSomeone(String someone);
    }

    public void sayHello {
        // Local Class
        class EnglishGreeting implements HelloWorld {
            public void greetSomeone(String someone) {
                System.out.println("Hello" + someone);
            }
        }
        HelloWorld englishGreeting = new EnglishGreeting();

        // implementatie gedeclareerd via anonieme klasse
        HelloWorld frenchGreeting = new HelloWorld() {
            public void greetSomeone(String someone){
                System.out.println("Salut " + someone);
            }
        };
        
        // implementatie gedeclareerd via lambda expressie
        // lambda expressies enkel gebruikt voor implementatie functionele interfaces
        HelloWorld dutchGreeting = (String someone) -> {
            String name = someone
            System.out.println("Hallo " + name);
        };

        englishGreeting.greetSomeone("world");
        frenchGreeting.greetSomeone("Fred");
    }

    public static void main(String[] args){
        HelloWorldLocalClass myApp = new HelloWorldLocalClass();
        myApp.sayHello();
    }
    
}
```
## 3. Anonieme klasse

- wordt gedifinieerd in een expressie die deel moet uitmaken van een statement
- syntax analoog aan constructor aanroepen
  - `new`
  - naam van te implementeren interface
  - klasse declaratie met implementatie van methode

```java
// implementatie gedeclareerd via anonieme klasse
HelloWorld frenchGreeting = new HelloWorld() {
    public void greetSomeone(String someone){
        System.out.println("Salut " + someone);
    }
};
```


## 4. Lambda expressies

- zorgt voor implementatie en instantiering van functionele interface in een expressie
- vaak gebruikt voor instantiering en implementering functionele interface voor doorgave aan een methode

```java
// implementatie gedeclareerd via lambda expressie
// lambda expressies enkel gebruikt voor implementatie functionele interfaces
HelloWorld dutchGreeting = (String someone) -> {
	String name = someone
    System.out.println("Hallo " + name);
};
// equivalent met supra
HelloWorld dutchGreeting = String someone -> System.out.println("Hallo " + someone);
```

Syntax: 

- Parameterlijst
  - De Java compiler kan vaak uit de context het type van de parameters afleiden. Je kan dit type dus meestal weglaten bij de parameters.
  - Als er maar één parameter is mag je ook de haakjes weglaten
- Statements 
  - bestaan uit één expressie of uit een blok statements.
  - Bij één enkele expressie wordt deze expressie geëvalueerd en het resultaat teruggeven.

## 5. Methode referenties

- Lambda expressies zijn enkel van toepassing op functionele interfaces.
- soms roept de lambdaexpressie enkel een bestaande methode aan. => gebruik **methode referentie**

```java
public void sayHello() {
    // lambda-expressie via method ref
	HelloWorld dutchGreeting = HelloWorldMethodReference::PrintGreeting;
	dutchGreeting.greetSomeone("Henri");
	
	// refered method
	private static void printGreeting(String name){
		System.out.println("Hello " + name);
	}
}
```

<img src="https://i0.wp.com/howtodoinjava.com/wp-content/uploads/2017/06/Java-8-Method-References.png?fit=833%2C410&ssl=1"/>

## 6. functionele interfaces

**abstracte methode** (in functionele interface) = een contract van een **prototype methode** die je later met een lambdaexpressie kan implementeren.

## 7. basis functionele interfaces



| Functionele interface                 | Prototype -abstracte methode               | Beschrijving                        |
| ------------------------------------- | ------------------------------------------ | ----------------------------------- |
| Predicate<T><br />BiPredicate<T,U>    | boolean test(T t, U u)                     | 1 of 2 argumenten return bool       |
| Function<T, R><br />BiFunction<T,U,R> | R apply(T t)<br />R apply(T t, U u)        | return type !== argument type       |
| Consumer<T><br />BiConsumer<T,U,R>    | void accept(T t)<br />void apply(T t, U u) | 1 of 2 argumenten return void       |
| Supplier<T>                           | T get()                                    | geen argumenten return waarde       |
| binaryOperator<T>                     | void apply(T t1, T t2)                     | return type === beide argument type |
| UnaryOperator<T>                      | void apply(T t)                            | return type ===  argument type      |

- Elk van deze interfaces heeft 3 varianten die primitieve datatypen aanvaarden: double, int of long
- Volgende variaties aanvaarden ook twee argumenten: BiPredicate, BiFunction, BiConsumer
- Function heeft **6 variaties die primitieve datatypes (double, int en long) omzetten naar andere primitieve datatypes**
- Functionen BiFunction hebben elk 3 variaties die een referentie type aanvaarden en een primitiefdatatype teruggeven: double, intof long
- Supplierheeft een variant dat een booleanteruggeeft
- BiConsumerheeft drie variaties die een referentie type aanvaardten een primitief datatype: double, int of long

### [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)

```java
public interface Function<T, R> {
	<R> apply(T parameter);
}

public interface Function<T, T> identity() {
	return t -> t;
}

public class FunctionApply {
	public static void main(String args[]){
        // implementatie abstract method in interface function + instantiate obj
        Function<Integer, Double> half = a -> a / 2.0;
        System.out.println(half.apply(10)) // 5
        
            
        // and then default method combines previous expression 
        half.andThen(a -> 3 * a);
        System.out.println(half.apply(10)) // 15
            
        // identity default method returns incoming argument
        Function<Integer,Integer> id = Function.identity();
        System.out.println(id.apply(3)); // 3
            
    }
}

```

### [Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)

```java
public interface Predicate<T> {
	boolean test(T t);
}

public class PredicateTest {
    public static void pred(int number, Predicate<Integer> predicate){
        System.out.printf("De voorwaarde op nummer %d is %s", number, predicate.test(number) ? "waar" : "fout");         
    }
	public static void main(String args[]){
        Predicate<Integer> lessThan18 = a -> a < 18;
        System.out.println(lessThan18.test(10)); // true
        Predicate<Integer> greaterThan1 = a -> a > 1;   
        System.out.println(greaterThan1.test(10)); // true
        
        // default method and samengestelde predicatie, 
        // short-circuit and for both
        Predicate<Integer> lessThan18AndgreaterThan1 = lessThan18.and(greaterThan1);
        System.out.println(lessThan18AndgreaterThan1.test(20)); // false
        
        // default method negate returns negation of existing predicate
        System.out.println(lessThan18AndgreaterThan1.negate().test(20)); // true
        
        
        // pred into func 
        pred(10, (i)-> i > 7);
        
        // OR predicate geeft samengestelde predicate terug
        // een short-circuit logische OF van beide implementaties.
        System.out.println(lessThan18.or(greaterThan1).test(-1)); // true
        
    }
}
```

### [consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)

```java
public interface Consumer<T> {
	void accept(T t);
}

public class ConsumerAccept {
	public static void main(String args[]){
        Consumer<String> display = s -> System.out.println(s);
        display.accept("bird is the word");
 		
        List<Integer> list = new ArrayList<Integer>();
        list.add(1); list.add(2); list.add(3);
        
        Consumer<List<Integer>> displayList = l -> System.out.println(l);
        displayList.accept(list);
        
        Consumer<List<Integer>> double = a -> {
            for(int i = 0; i < list.getSize(); i++){
                list.set(i, 2 * list.get(i));
            }
        }
        
        double.AndThen(displayList).accept(list);
    }
}
```

### [supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)

```java
public interface Supplier<T> {
	void get();
}

public class SupplierGet {
	public static void main(String args[]){
        Supplier<Double> randomValue = () -> Math.random();
        
        System.out.println(randomValue.get());
    }
}
```

### binary and unary operator 

```java
package com.concretepage.util.stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;

public class UnaryOperatorDemo {
    public static void main(String[] args) {
       List<Integer> list = Arrays.asList(10,20,30,40,50);
       UnaryOperator<Integer> unaryOpt = i->i*i; 
       unaryOperatorFun(unaryOpt, list).forEach(x->System.out.println(x));       
    }
    private static List<Integer> unaryOperatorFun(UnaryOperator<Integer> unaryOpt, List<Integer> list){
       List<Integer> uniList = new ArrayList<>();
       list.forEach(i->uniList.add(unaryOpt.apply(i))); 
       return uniList;
    }
}

////////////////////

public class BinaryOperatorDemo {
    public static void main(String[] args) {
       Map<String,String> map = new HashMap<>();
       map.put("X", "A");
       map.put("Y", "B");
       map.put("Z", "C");
       BinaryOperator<String> binaryOpt = (s1,s2)-> s1+"-"+s2; 
       binaryOperatorFun(binaryOpt, map).forEach(x->System.out.println(x));       
    }
    private static List<String> binaryOperatorFun(BinaryOperator<String> binaryOpt, Map<String,String> map){
       List<String> biList = new ArrayList<>();
       map.forEach((s1,s2)->biList.add(binaryOpt.apply(s1,s2))); 
       return biList;
    }
} 

```

