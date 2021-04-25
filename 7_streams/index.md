# streams / functioneel programmeren

## 1. inleiding

Java SE < 8 ondersteunde Java drie programmeerparadigma’s:
- **procedureel programmeren**
- object-geörienteerd programmeren
- generiek programmeren

Java SE > 8 => **Functioneel programmeren** = Specifieer wat je wil in een taak, maar niet hoe. <=> procedureel specifieert hoe



```java
// procedureel
int sum=0,values[] = {1,2,3,4,5};

for(int counter = 0; counter < values.length ;counter++)
    sum+=values[counter];

// functional
values.stream().reduce((curr,prev)->curr+=prev,0)
```

**External iteratie**
- loop for iterating collection
- requires **sequentiële** approach of elements
- requires veranderlijke variabelen (sum en counter).

**Internal iteratie**
- Laat de bibliotheek de manier bepalen om over een collectie van elementen te itereren.
-  gemakkelijker voor **parallelle** uitvoering.



## 2. functionele / SAM (single abstract method) interfaces

A functional interface is an interface that contains only one abstract method.

```java
@FunctionalInterface
public interface EventHandler<T extends Event>
extends EventListener
    
    
// method summary
// handle(T event) : invoked when event of the type for which this handler is registered happens
    
    
// ----- example of self made SAM
    
@FunctionalInterface
interface Square{
    int calculate(int x);
}
  
class Test{
    public static void main(String args[]){
        int a = 5;
        // lambda expression to define the calculate method
        Square s = (int x)->x*x;
        // parameter passed and return type must be
        // same as defined in the prototype
        int ans = s.calculate(a);
        System.out.println(ans);
    }
}
    
// ----- example of Java included SAM
    
// create a list of strings
List<String> names = Arrays.asList("Geek","GeeksQuiz","g1","QA","Geek2");

// declare the predicate type as string and use
// lambda expression to create object
Predicate<String> p = (s)->s.startsWith("G");

// Iterate through the list
for (String st:names){
    // call the test method
    if (p.test(st)) System.out.println(st);
}
```

<img src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimage.slidesharecdn.com%2Fjava8-141003090600-phpapp02%2F95%2Ffunctional-java-8-in-everyday-life-9-638.jpg%3Fcb%3D1412327296&f=1&nofb=1"/>



## 3. lambda expressies

- anonieme methode
- snelschrift notatie voor het implementeren van een functionele interface.
- Kan gebruikt worden waar functionele interfaces worden verwacht.
- Een lambda expressie bestaat uit een parameterlijst gevolgd door een pijltoken en een body:

```java
(parameterList) -> {statements}
(int x, int y) -> {return x + y;}
(int x, int y) -> x + y
value -> System.out.printf("%d ", value)
( ) -> System.out.println("Welcome to lambdas!")
    
    
// ----- voorbeelden
    
button.setOnAction(
	new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            System.out.println("button clicked");
        }
    });

button.setOnAction(e->System.out.println("button clicked")); 

String[] friendsArray = {"Brian","Nate","Neal","Sara","Betty"};
List<String> friends = new ArrayList<(Arrays.asList(friendsArray));

for(Stringname:friends) System.out.println(name);
System.out.println();

friends.forEach(
    new Consumer<String>(){
        @Override 
        public void accept(String t){
            System.out.println(t);}
    }
);

System.out.println()

    
friends.forEach((String t)->{System.out.println(t);});
System.out.println();
friends.forEach(t->System.out.println(t));
System.out.println();
friends.forEach(System.out::println);
System.out.println();
```

## 4. streams algemeen

- Streams zijn objecten van 
  - klassen die de **interface Stream** (package java.util.stream) **implementeren**
  - Één  van  de  gespecialiseerde  stream  interfaces  voor  verwerking  van  int,  long  of  doublewaarden
- Stream **pipelines**
  - Laat elementen een reeks van verwerkingsstappen doorlopen.
  - Pipeline
    - begint met een databron
    - voert meerdere **intermediate operaties** uit op de elementen van de databron
    - eindigt met een **terminal operatie.**
  - Wordt gevormd door geketende methode aanroepen.
- Streams bewaren geen data
  - Eenmaal een stream is uitgevoerd kan het  niet worden herbruikt, omdat het geen  kopie bijhoudt van de originele databron.
  - **Intermediate (=tussentijdse) operatie** `ex .map`
    - specifieert een taak op elementen van een stream en resulteert altijd in een nieuwe stream.
    - Zijn **lazy**: worden pas uitgevoerd als een terminal operatie wordt aangeroepen.
  - **Terminal (=eind) operatie
    - Start de verwerking van de stream pipeline’s intermediate operaties
    - Creëert een resultaat
    - Zijn **eager**: voeren de gevraagde operatie uit wanneer ze worden aangeroepen.

samengevat : 

`Volgorde: databron(=datatype) → plaatsen Stream → resultaat (=datatype) `

- Plaatsen van een Stream op de databron:
  - Stream wijzigt databron NIET
  - Stream is GEEN datatype
  - Is ontwikkeld voor lambda’s
  - GEEN geïndexeerde toegang
- intermediate operaties = bewerkingen op de databron
- terminal operaties ⇒ resulteren terug in een datatype (Vb: List)`



## 5. stream creatie en operaties

### intstream operaties

```java
public class IntStreamOperations {
   public static void main(String[] args){
       int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

 	   IntStream.of(values)
           		.forEach(value -> System.out.printf("%d ", value));
       			// forEach is terminale operatie
       			// argument is object die int consumer interface implementeert
       			// int consumer interface accept methode krijgt 1 int waarde mee


	   // count, min, max, sum and average of the values*

 	   System.out.printf("%nCount: %d%n", IntStream.of(values).count());
       System.out.printf("Min: %d%n",IntStream.of(values).min().getAsInt());
       System.out.printf("Max: %d%n", IntStream.of(values).max().getAsInt());
       System.out.printf("Sum: %d%n", IntStream.of(values).sum());
       System.out.printf("Average: %.2f%n", IntStream.of(values).average().getAsDouble()); 

       // sum of values with reduce method*
        System.out.printf("%nSum via reduce method: %d%n", 
        IntStream.of(values).reduce(0, (x, y) -> x + y));
		// 2 argument is object die int intBinaryOperator interface implementeert

        System.out.printf("Sum of squares via reduce method: %d%n", 
        IntStream.of(values).reduce(0, (x, y) -> x + y * y));

        System.out.printf("Product via reduce method: %d%n", 
        IntStream.of(values).reduce(1, (x, y) -> x * y));


        System.out.printf("%nEven values displayed in sorted order: "); 

        IntStream.of(values)
            .filter(value -> value % 2 == 0) // IntPredicate implementeren
            .sorted()
            .forEach(value -> System.out.printf("%d ", value)); 

        System.out.println();


        System.out.printf("Odd values multiplied by 10 displayed in sorted order: "); 

        IntStream.of(values)
            .filter(value -> value % 2 != 0)
            .map(value -> value * 10) // interdemediary operation
            .sorted()
            .forEach(value -> System.out.printf("%d ", value));


         // sum range of integers from 1 to 10, exclusive

         System.out.printf("%nSum of integers from 1 to 9: %d%n",
                           IntStream.range(1, 10).sum());

         // sum range of integers from 1 to 10, inclusive
         System.out.printf("Sum of integers from 1 to 10: %d%n",
                           IntStream.rangeClosed(1, 10).sum());

   } 

} 
```

### arrays en streams

```java
public class ArraysAndStreams{
   public static void main(String[] args){
      Integer[] values = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};

      // display original values
      System.out.printf("Original values: %s%n", Arrays.asList(values));
       
      /*
      * <1> Klasse Arrays biedt overloaded stream methoden voor het creëren van  
      * IntStreams,LongStreams en DoubleStreams uit int, long en double arrays 
      * of reeksen van elementen uit de arrays.
      */

      // sort values in ascending order with streams
      System.out.printf("Sorted values: %s%n", 
         Arrays.stream(values)		// <1>
               .sorted()
               .collect(Collectors.toList())); //<2>
       
      /*
      * <2> Voor het creëren van een verzameling die de resultaten van een stream pipeline
      * bevat, kan je de Stream methode collect (terminal operatie) gebruiken. Methode
      * collect  met  één  argument  krijgt  een  object  dat  de  interface  Collector
      * (packagejava.util.stream)  implementeert, die specifieert hoe de veranderlijke
      * reductie  moet  worden uitgevoerd..
      */

      // values greater than 4
      List<Integer> greaterThan4 =
         Arrays.stream(values)
               .filter(value -> value > 4)
               .collect(Collectors.toList());
      System.out.printf("Values greater than 4: %s%n", greaterThan4);

      // filter values greater than 4 then sort the results
      System.out.printf("Sorted values greater than 4: %s%n",
         Arrays.stream(values)
               .filter(value -> value > 4)
               .sorted()
               .collect(Collectors.toList()));

      // greaterThan4 List sorted with streams
      System.out.printf(
         "Values greater than 4 (ascending with streams): %s%n",
         greaterThan4.stream()
               .sorted()
               .collect(Collectors.toList()));
   }
}
```



```java
public class ArraysAndStreams2 {
   public static void main(String[] args) {
      String[] strings = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

      // display original strings
      System.out.printf("Original strings: %s%n", Arrays.asList( ));

     /*
      * <1> map zet ieder element om naar een nieuwe waarde en maakt een nieuwe stream met
      * hetzelfde aantal elementen als de originele stream.
      * - Een methodereferentie is een snelschrift notatie voor een lambda
      * expressie.
      * - ClassName::instanceMethodName stelt een methodereferentie voor van    
      * een instantie methode van de klasse.
      * - objectName::instanceMethodName stelt een methodereferentie voor, voor     
      * een instantie methode specifiek voor een object.
      * - ClassName::staticMethodName stelt een methodereferentie voor, voor een 
      * static methode van een klasse.
      */
       
      /*
      * <2> Stream methode sorted kan een Comparator als argument ontvangen, om zo de
      * sorteervolgorde vast te leggen. By default,methode sorted gebruikt de natuurlijke
      * volgorde voor de stream’s element type.Voor Strings, de natuurlijke volgorde is
      * case sensitive, dit betekent dat "Z" is kleiner dan "a".
      */
       
      /*
      * <3> Functional interface Comparator’s default methode reversed keert 
      * een bestaande Comparator’svolgorde om.
      */
       
      // strings in uppercase
      System.out.printf("strings in uppercase: %s%n",
         Arrays.stream(strings)
               .map(String::toUpperCase)  // <1> 
               .collect(Collectors.toList()));

      // strings greater than "m" (case insensitive) sorted ascending
      System.out.printf("strings greater than m sorted ascending: %s%n",
         Arrays.stream(strings)
               .filter(s -> s.compareToIgnoreCase("m") > 0)
               .sorted(String.CASE_INSENSITIVE_ORDER) // <2>
               .collect(Collectors.toList()));

      // strings greater than "m" (case insensitive) sorted descending
      System.out.printf("strings greater than m sorted descending: %s%n",
         Arrays.stream(strings)
               .filter(s -> s.compareToIgnoreCase("m") > 0)
               .sorted(String.CASE_INSENSITIVE_ORDER.reversed()) //<3>
               .collect(Collectors.toList()));
   }
}
```

### lists en streams

```java
public class ProcessingEmployees{
   public static void main(String[] args){
      // initialize array of Employees
      Employee[] employees = {
         new Employee("Jason", "Red", 5000, "IT"),
         new Employee("Ashley", "Green", 7600, "IT"),
         new Employee("Matthew", "Indigo", 3587.5, "Sales"),
         new Employee("James", "Indigo", 4700.77, "Marketing"),
         new Employee("Luke", "Indigo", 6200, "IT"),
         new Employee("Jason", "Blue", 3200, "Sales"),
         new Employee("Wendy", "Brown", 4236.4, "Marketing")};

      // get List view of the Employees
      List<Employee> list = Arrays.asList(employees);

      // display all Employees
      System.out.println("Complete Employee list:");
      list.stream().forEach(System.out::println);  
       /* <1> Instantie methode referentie wordt door de compiler omgezet naar een 
       * object  dat  de  Consumer  functionalinterface implementeert
       */
       
      // Predicate that returns true for salaries in the range $4000-$6000
      Predicate<Employee> fourToSixThousand = 
         e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);  
       /* <2> Om een lambda te hergebruiken,kan je het toekennen 
       * aan een variabele van het juistefunctional interface type.
       */
       
       
      // Display Employees with salaries in the range $4000-$6000
      // sorted into ascending order by salary
      System.out.printf(
         "%nEmployees earning $4000-$6000 per month sorted by salary:%n");
      list.stream()
          .filter(fourToSixThousand)
          .sorted(Comparator.comparing(Employee::getSalary)) // 
          .forEach(System.out::println);

       /* <3> De Comparator interface’s static methode comparing ontvangt een functie
       * die gebruikt wordt om een waarde uit een object in de stream te halen, 
       * die verder gebruikt wordt in vergelijkingenen een Comparator object teruggeeft.
       */
       
      // Display first Employee with salary in the range $4000-$6000
      System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
         list.stream()
             .filter(fourToSixThousand)
             .findFirst()
             .get());  
       
      /* <4> Stream methode findFirst = short-circuit terminal operation die de stream
      * pipeline uitvoerten stopt wanneer het eerste object in de stream pipeline 
      * isgevonden.
	  */
       
       
      // Functions for getting first and last names from an Employee
      Function<Employee, String> byFirstName = Employee::getFirstName;
      Function<Employee, String> byLastName = Employee::getLastName;

      // Comparator for comparing Employees by first name then last name
      Comparator<Employee> lastThenFirst = 
         Comparator.comparing(byLastName).thenComparing(byFirstName);  
       
      /*<5> Om objecten te sorteren op twee velden, 
      * creëer je een Comparator die twee Functions gebruikt
	  */
       
      // sort employees by last name, then first name 
      System.out.printf(
         "%nEmployees in ascending order by last name then first:%n");
      list.stream()
          .sorted(lastThenFirst)
          .forEach(System.out::println);

      // sort employees in descending order by last name, then first name
      System.out.printf(
         "%nEmployees in descending order by last name then first:%n");
      list.stream()
          .sorted(lastThenFirst.reversed())
          .forEach(System.out::println);

      // display unique employee last names sorted
      System.out.printf("%nUnique employee last names:%n");
      list.stream()
          .map(Employee::getLastName)
          .distinct()    
          .sorted()
          .forEach(System.out::println);

       /*<6> 
       * Stream methode distinct verwijdert dubbele objecten uit de stream.
       */
       
      // display only first and last names
      System.out.printf(
         "%nEmployee names in order by last name then first name:%n"); 
      list.stream()
          .sorted(lastThenFirst)
          .map(Employee::getName)
          .forEach(System.out::println);


      // sum of Employee salaries with DoubleStream sum method
      System.out.printf(
         "%nSum of Employees' salaries (via sum method): %.2f%n",
         list.stream()
             .mapToDouble(Employee::getSalary)   //<7>
             .sum());

      /* 7 Stream methode mapToDouble beeldt objecten af op double waarden en geeft  
      * een DoubleStream terug. Stream methode mapToDouble ontvangt een object die de   
      * functionele interfaceToDoubleFunction (package java.util.function)     
      * implementeert.(Deze interface’s applyAsDouble methode geeft een double waardeterug.)
      */
       
      // calculate sum of Employee salaries with Stream reduce method
      System.out.printf(
         "Sum of Employees' salaries (via reduce method): %.2f%n",
         list.stream()
             .mapToDouble(Employee::getSalary)
             .reduce(0, (value1, value2) -> value1 + value2));  

      // average of Employee salaries with DoubleStream average method
      System.out.printf("Average of Employees' salaries: %.2f%n",
         list.stream()
             .mapToDouble(Employee::getSalary)  
             .average()
             .getAsDouble());      
   } // end main
}
```

### Extras



#### flatMap

```java
public class VbFlatmap {
	public static void main(String[] args) {

		List<List<String>> namesNested = Arrays.asList(
               Arrays.asList("Jeff", "Bezos"), 
               Arrays.asList("Bill", "Gates"),
               Arrays.asList("Mark", "Zuckerberg")
            );
		System.out.println(namesNested);

		List<String> namesFlatStream = 
				namesNested.stream()
						   .flatMap(Collection::stream) // <1>
						   .collect(Collectors.toList());
		System.out.println(namesFlatStream);
	}
}
```



#### orElse


```java
public class VbOrElse {
	public static void main(String[] args)
    {
        List<String> names = Arrays.asList("Brad" , "Kate" , "Kimmy", "Jack" , "Joey");
        
        String eersteNaamMet3Letters = 
                names.stream()
                     .filter(name -> name.length()==3)
                     .findFirst()
                     .get(); // <1> no such element exception
        System.out.println(eersteNaamMet3Letters);
        
        String eersteNaamMet3Letters2 = 
                names.stream()
                     .filter(name -> name.length()==3)
                     .findFirst()
                     .orElse("Geen naam met 3 letters"); // <2> 
              
        System.out.println(eersteNaamMet3Letters2);
    }
}
```


## overview

<img src="https://res.cloudinary.com/dri8yyakb/image/upload/v1619074710/Screenshot_from_2021-04-22_08-57-59_exdiqm.png">





















