# collections

- generieke datastructuur uit het collections kiezen
- generieke datastructuur uit het collections framework correct gebruiken
- iterators gebruiken om een collectie te doorlopen
- methodes uit de Collections klasse toepassen om collecties te verwerken


**collection** = datastructuur, i.e. een **object**, die een verzameling van objecten als geheel representeert. De objecten in de verzameling noemen we de **elementen**.


<img src="https://chercher.tech/images/java-programming/java-collection-architecture.png"/>

## Collection

interface **Collection<E>** bevat belangrijke 'algemene' methodes 


```java
int size()
boolean isEmpty()
boolean contains(Object o) 
// maakt gebruik van de equals methode om op gelijkheid te testen
boolean add(E element)
boolean remove(Object element)
Iterator<E>iterator()
```

Zoals hierboven reeds werd aangehaald **werken collections met objecten**. Indien we gegevens vaneen primitief datatype in collections willen bijhouden zullen we moeten gebruik maken van de **primitieve wrapper klassen** om dergelijke collections te declareren. Via de **auto-boxing** en **auto-unboxing features** van Java zal je daar verder weinig extra voor moeten doen.

Er zijn ook enkele methodes voor bulk operaties aanwezig in Collection<E>. Deze methodes werken met volledige collections in plaats van afzonderlijke elementen. 


```java
boolean containsAll(Collection<?>c)
boolean addAll(Collection<?extendsE>c)
boolean removeAll(Collection<?>c)
boolean retainAll(Collection<?>c)
void clear()
```

## Itterable

Elke collection erft van de interface Iterable<E>. Concreet betekent dit dat we een mechanisme hebben om over de elementen van eender welke collection te itereren.

- elke collection kan overlopen worden met een **enhanced for-loop**
 - tijdens dergelijke iteratie **mag de collection niet gewijzigd worden**
- elke collection kan overlopen worden met behulp van een **iterator**
 - tijdens dergelijke iteratie **kunnen eventueel elementen uit de collection verwijderd** worden 

Een iterator is een object. Door methodes aan te roepen op een iterator kan je een collectie overlopen. Via de volgende methode uit Collection<E> kan je dit object opvragen:

```java
Iterator<E>iterator()
```

```java
booleanhasNext()
// retourneert true als de iteratie nog elementen bevat
E next()// retourneert volgende element van de iteratievoid
remove()
// verwijdert het laatste element dat werd geretourneerd
// door deze iterator uit de onderliggende collection
```

```java
public void iterateWithEnhancedFor(Collection<String>colors){
 for(String color: colors){System.out.printf("%s ",color);}
}
public void iterateWithIterator(Collection<String>colors {
 Iterator<String>iterator = colors.iterator();
 while(iterator.hasNext()){
 System.out.printf("%s ",iterator.next());
 }
}
public void useIteratorAndRemoveElements(Collection<String>colors {
 Iterator<String>iterator = colors.iterator();
 while(iterator.hasNext()){
 StringnextColor=iterator.next();
 if(nextColor.length()>4)iterator.remove();
 }
 System.out.printf("The collection contains %d colors...",colors.size());
}
public void useSomeBasicCollectionOperators(Collection<String>colors){
 System.out.printf("This collection is%s empty%n",colors.isEmpty()?"":"not");String myColor="red";
 print("does %scontain %s%n",colors.contains(myColor)"":"not ",myColor);
 colors.remove(myColor);
 print("does %scontain %s%n",colors.contains(myColor)"":"not ",myColor);
 myColor="yellow";
 print("does %scontain %s%n",colors.contains(myColor)?"":"not ",myColor);
 colors.add(myColor);
 print("does %scontain %s%n",colors.contains(myColor)?"":"not ",myColor);
}

private void removeColors(Collection<String>collection1Collection<String>collection2){
 // 1. met iterator
 Iterator<String>iterator=collection1.iterator();
 while(iterator.hasNext())
 if(collection2.contains(iterator.next()))
 iterator.remove()
```

## List

- geordende collection (aka **sequence**). 
- Elk element in een List heeft een exactepositie in de verzameling = **index** en ze is **zero-based**.
- dubbels toegelaten.

```java
E get(int index)
int indexOf(Object o)
int lastIndexOf(Object o)
E remove(intindex)
E set(int index,E element)

```

enkele handige methodes om de List<E> te sorteren en sub-lists te nemen.Via de toArray-methode is het mogelijk een List om te zetten naar een array. De mogelijkheid om een collection om te zetten naar een array vinden we ook in andere interfaces terug

```java
List<E> subList(int fromIndex, int toIndex)
void sort(Comparator<? super E> c)
<T> T[] toArray(T[] a)
```


Bij een List<E> kan je gebruik maken van de **ListIterator** om over de elementen van de List te itereren. Deze ListIterator is krachtiger dan de Iterator waarvan Collection<E> een sub-interface is.Je kan de ListIterator opvragen via één van de volgende methodes.

```java
ListIterator<E>listIterator()
ListIterator<E>listIterator(intindex)
// iterator die start op de aangegevenindex
```

Zoals je merkt aan de methodes hier onder kan een ListIterator over de List itereren in tweerichtingen en laat ze toe om tijdens het itereren ook elementen toe te voegen, te verwijderenen/of te wijzigen.

```java
void add(Ee)
boolean hasNext() & boolean hasPrevious()
E next()& E previous()
int nextIndex() & int previousIndex()
void remove()
void set(E e)

// Tijdens de iteratie wijzigt de collectie.

ListIterator<String> iterator = lijst.listIterator();
while(iterator.hasNext()){
 String huidig = iterator.next();
 if(huidig.startsWith("M")) iterator.add(huidig);
}
```

Er is bijna nooit een reden om als type van je verzameling een concrete klasse te verkiezen boven een interface...

```java
ArrayList<E> mijnVerzameling = new ArrayList<E>(); // DO NOT! 
List<E> mijnVerzameling= new ArrayList<E>(); // DO
```

Door gebruik te maken van de interface List<E> als type voor je verzameling ben je vrij één van de concrete klassen te instantiëren voor die verzameling. Je behoudt op deze manier de vrijheid om degekozen concrete implementatie te wijzigen zonder dat dit een grote impact heeft op je code. Je kan bovendien op deze manier beter gebruik maken van methodes uit de Java API die vaker een interface type zoals List<E> zullen retourneren dan een concreet type zoals ArrayList<E>. Zo kan je bijvoorbeeld het resultaat van de methode subList, een methode uit de klasse ArrayList, niettoekennen aan een verzameling van het type ArrayList, maar wel aan een verzameling van het typeList.

**conversion constructor** = Naast een parameterloze constructor, zoals hierboven werd gebruikt, kan je ook gebruik makenvan een constructor waar je een collection kan aan doorgeven.

`gelijk welk type collection uit het framework omvormen tot een ander type`

```java
ArrayList(Collection<? extends E> c);
```

<img src="https://s3-us-west-2.amazonaws.com/ib-assessment-tests/problem_images/array-vs-ll.png">

### arrayList

ArrayList<E> maakt gebruik van een **resizeable array implementatie**. De elementen worden dus opgeslagen in een **array**, die bij creatie van een nieuwe lijst een **initiële capaciteit** heeft.Daar een array een **fixed size structuur** is en een lijst kan groeien moet er echter soms op zoek gegaan worden naar een groter stuk geheugen waar een grotere array kan gehuisvest worden. Dit gebeurt wanneer er tijdens het toevoegen van een element aan de lijst geen genoeg plaats meerblijkt te zijn in de onderliggende array. Dit neemt wat tijd in beslag en weegt negatief op de performantie van de ArrayList implementatie. 

Hoewel de initiële capaciteit en het groeien van de array automatisch gebeurt voorziet deze klasse wel in methodes en een constructor die toelaten dit te manipuleren. gebruik van deze methodes kan de performantie ten goedekomen. De methodes vind je hieronder maar we zullen er verder niet mee aan de slag gaan in dit hoofdstuk. De int-parameter bij de methodes stelt het aantal elementen voor die de onderliggende array moet kunnen huisvesten.

```java
ArrayList(int initialCapacity)
void trimToSize()
void ensureCapacity(int minCapacity)
```

### linkedList

Bij een LinkedList<E> worden de elementen in de lijst aaneengeregen via **referenties**. Concreet heeft elk element in een **doubly-linked list** implementatie een **referentie** naar zijn voorganger, en naar zijn opvolger. 

Negatief : Wanneer er gebruikt wordt gemaakt van een index om een bepaald element uit de lijst op te halen dan moet de lijst vanaf het eerste element doorlopen worden, en moet telkens de referentie naar het volgende element gevolgd worden, tot het element op de aangegeven index wordt bereikt. Dit betekent dan ook dat dergelijke operatie trager verloopt dan bij een ArrayList. 

Positief : Anderzijds moeten bij deze implementatie nooit elementen verschoven worden als we ergens in de lijst een element willen tussenvoegen. Referenties naar voorganger en opvolger kunnen eenvoudigen snel aangepast worden. Bij een ArrayList daarentegen betekent dergelijke operatie dat er, mogelijks veel, elementen in de onderliggende array moeten verschoven worden.


- bij een insert in een array moeten meerder elementen verschoven worden.
- bij een insert in een doubly linked list moeten enkel een paar referenties aangepast worden.


elementen in resizeable arraye
elementen in doubly linked list

constante toegangstijd voor elk element => random access 
sequentiële toegang ⇒ starten vanaf eerste element

invoegen of verwijderen van element ⇒ veel verschuivingen
efficiënt toevoegen en/of verwijderen van element

bij voorkeur te gebruiken bij veel opzoekingen
bij voorkeur te gebruiken bij veelinvoegen/verwijderen van elementen

### Vector

De klasse **Vector<E>** is een verouderde klasse. Er wordt aangeraden gebruik te maken vanArrayList<E> in plaats  van  Vector<E>.  Een  verschil  tussen  beide  is wel dat Vector<E>gesynchroniseerd is en je dus een thread-safe implementatie hebt. Dit kan een reden zijn om tekiezen voor Vector<E> in multi-threaded code. Deze concepten worden behandeld in AdvancedSoftware Development I.


#### Stack

De klasse **Stack<E>** is een subklasse van Vector<E>. We zullen deze dan ook niet verder behandelen.Verderop zullen we zien hoe stacks beter kunnen geïmplementeerd worden adhv **ArrayDeque<E>**.


## Queue

Een Queue<E> wordt typisch gebruikt om elementen bij te houden alvorens ze te verwerken. Eenqueue is een **FIFO structuur**, ook wel een wachtrij genoemd. De elementen in een queue zijn niet te benaderen via hun positie.

```java
boolean offer(E e)
E peek()
E poll()
```

<img src="https://cdn.programiz.com/sites/tutorial2program/files/java-arraydeque-class.png">


### dequeue 

Deque<E> is een sub-interface van Queue<E> die een **double ended queue** voorstelt. Het toevoegenen verwijderen van elementen kan dus aan beide zijden gebeuren


```java
void push(E e)
E peek()
E pop()
```

```java
Queue<Double> queue = new ArrayDeque<>();

// insert elements to queue

queue.offer(3.2);
queue.offer(9.8);
queue.offer(5.4);
System.out.print("Polling from queue: ");
// display elements in queue
while(queue.size()>0){
    System.out.printf("%.1f ",queue.peek());
    // geeft het top-element weer
    queue.poll();
    // verwijdert het top element

```

In de Queue<E> interface vind je ook de methodes **add**, **remove** & **element**. Deze methodes vormenhet equivalent van **offer**, **poll** & **peek** maar werpen exceptions daar waar offer, peek & poll specialewaarden retourneren. Zo zal de poll-methode null retourneren wanneer de queue geen elementenbevat, terwijl in dezelfde situatie de methode remove een exception zal werpen. Raadpleeg de JavaAPI voor meer details.

### arrayDequeue

Zoals de naam reeds suggereert is dit een resizeable array implementatie van de Deque<E>interface. Deze klasse zal **performanter** zijn **dan** de klasse **Stack<E>** voor een **stack**, of **LinkedList<E> voor stacks en/of queues**. Merk op dat de klasse LinkedList<E> hierboven reedsuitvoerig werd besproken. De klasse implementeert dus zowel de List<E> als de Deque<E>interface.In volgend voorbeeld wordt een stack geïmplementeerd aan de hand van een ArrayDeque. Op destack worden verschillende soorten getallen gezet. De elementen zijn van het type Number, dit iseen superklasse van de primitieve wrapper klassen Integer, Long, Double en Float

```java
public StackTest(){
    Deque<Number>stack=newArrayDeque<>();
    Long longNumber=12L;
    Integer intNumber=34567;
    Float floatNumber=1.0F;
    Double doubleNumber=1234.5678;
    stack.push(longNumber);
    printStack(stack);
    stack.push(intNumber);
    printStack(stack);
    stack.push(floatNumber);
    printStack(stack);
    stack.push(doubleNumber);
    printStack(stack);
    try{
        NumberremovedObject=null;
        while(true){
            removedObject=stack.pop();System.out.printf("%s popped%n",removedObject);printStack(stack);
            }
        } catch(NoSuchElementExceptionnoSuchElementException){
            noSuchElementException.printStackTrace();
        }// end catch
    }// end StackTest constructor
}
```

## Set 

<img src="https://examples.javacodegeeks.com/wp-content/uploads/2020/01/Java-Set-UML-Diagram-1.jpg">


De Set<E> interface benadert het best de notie die we hebben van het wiskundig begrip **verzameling**. Elementen in dergelijke verzamelingen zijn **niet toegankelijk via hun positie**, ze hebben **geen index**. Bovendien is het typisch voor dergelijke verzamelingen dat ze **geen dubbels** mogen bevatten. We benadrukken nogmaals dat deze gelijkheid gebaseerd is op de **equals-methode**.Een set bevat nooit twee elementen e1 en e2 waarvoor e1.equals(e2) true is.In deze interface zijn er naast de methodes die geërfd worden uit de super-interface Collection<E> **geen extra methodes gedefinieerd**.

### hashset

**HashSet<E>** is een concrete implementatie van **Set<E>** die een hashtabel als onderliggendestructuur heeft. Dieper ingaan op deze structuur valt buiten de scope van deze cursus maar het is handig om weten dat in dergelijke structuur de hashcode van **een object wordt gebruikt als een index in een tabel**. Dit betekent concreet **fastlookup** en dat ook het toevoegen en verwijderen van elementen heel performant kan gebeuren. Wat betreft het itereren over de elementen van de verzameling zullen andere collections dikwijls een betere performantie geven.

```java
private void printNonDuplicates(Collection<String>collection){
    // een HashSet creëren
    Set<String>set=newHashSet<>(collection);
    System.out.println("\nNonduplicates are: ");
    for(String s:set) System.out.printf("%s ",s);
}
```

### sortedSet

Zoals uit de naam af te leiden valt is een SortedSet<E> een set met een **ordening** van deelementen. 

De ordening van de elementen kan op natuurlijke of op totale wijze zijn. Het ordenen van objecten werd uitvoerig behandeld in het hoofdstuk "Polymorfisme en Interfaces".

- **natuurlijk ordening** maakt gebruik van de **compareTo-methode**
  - de elementen in de set moeten Comparable<E> implementeren 
  - deze ordening wordt gebruikt indien je geen **comparator** specifieert tijdens constructie van concrete SortedSet<E> implementaties
- **totale ordening** maakt gebruik van een **comparator**
    - er moet een comparator die Comparator<E> implementeert voorzien worden
    - de comparator kan aan de constructor van concrete SortedSet<E>implementaties meegegeven worden
  
Het feit dat de elementen gesorteerd in deze verzameling zitten geeft dan ook aanleiding tot meerspecifieke functionaliteit die van de volgorde van de elementen gebruik maakt:

```java
E first()
E last()
SortedSet<E> subset(E fromElement,E toElement)
SortedSet<E> headset(E toElement)
SortedSet<E> tailset(E fromElement)
```

### navigableSet

Een NavigableSet<E> heeft een extra notie van nabijheid. Dit vertaalt zich in volgende methodes.

```java
E floor(E e) // het grootste element <= e (of null indien geen element <=e)
E lower(E e) // het grootste element < e (of null indien geen element < e)
E ceiling(E e)// het kleinste element >= e (of null indien geen element >=e)
E higher(E e) // het kleinste element > e (of null indien geen element > e)
```

### treeSet

Deze concrete implementatie van NavigableSet<E> is gebaseerd op een boomstructuur. We gaan opdeze onderliggende structuur ook niet verder ingaan in dit hoofdstuk. Het is goed om weten dat ook deze implementatie *performant opzoeken, toevoegen en verwijderen van elementen* garandeert.

## brug tussen arrays en collections

```java
private static final String NAMES[]={"yellow","green","black","tan","grey""white","orange","red","green"};

publicSortedSetTest(){
    SortedSet <String> tree = newTreeSet<>(Arrays.asList(NAMES));
    System.out.println("sorted set: ");
    printSet(tree);
    // alle elementen die < zijn dan element "orange"
    System.out.print("\nheadSet (\"orange\"):  ");
    printSet(tree.headSet("orange"));
    // alle elementen die >= zijn dan element "orange"
    System.out.print("tailSet (\"orange\"):  ");
    printSet(tree.tailSet("orange"));
    // het eerste en het laatste element
    System.out.printf("first: %s%n",tree.first());
    System.out.printf("last : %s%n",tree.last());
}
```

<img src="https://geekscoder.s3.ap-south-1.amazonaws.com/a0733f9d-b92b-4e5e-ba8f-26d23735e027Arrays.asList.drawio.png">


- Arrays uit de java.util package => geen onderdeel van het collections framework.
- bevat heel wat interessante methodes om in arrays te zoeken, om arrays te sorteren, om arrays of delen ervan te kopiëren, enz. 
- Het kan dan ook soms handig zijn om een collection tekunnen omvormen naar een array, en ook omgekeerd. zo bruggen we array-based API’s en collection-based API’s.
