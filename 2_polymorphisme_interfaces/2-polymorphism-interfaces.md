# Polymorfisme & InterfacesTable of Contents

```
1. Doelstellingen
2. Inleiding
3. Polymorfisme
    3.1. Regels voor toekenning  
4. Gekende methodes van een referentie 
    4.1. Static & dynamic binding 
    4.2. Example of Dynamic Binding in Java. 
5. abstract klasse bij polymorfisme  
6. Dependency Injection    
7. Interfaces  
8. Objecten samenbrengen in een context
    8.1. KunstCollectie en KunstWinkel
    8.2. Drawable en Saleable
    8.3. Huisdier en Voertuig
    8.4. Kat, Hond, Auto en Boot   
9. Implementatie van meerdere interfaces 
10. Objecten sorteren
    10.1. Comparable interface
    10.2. The Comparator interface
```



## 1. Doelstellingen

Na het studeren en maken van de oefeningen van dit hoofdstuk ben je in staat om volgende zaken te herkennen, toe te lichten, te definiëren, toe te passen en te implementeren:

- Overerving en polymorfisme
- Static en dynamic binding
- Dependency injection
- Interfaces

## 2. Inleiding

**polymorfisme** 

`betekent dat een referentie variabele van een bepaald type kan verwijzen naar objecten van verschillende types: het type zelf of één van zijn subtypes.`

Op deze manier kan te specialiseren gedrag (gedeclareerd in een supertype),waarvan de implementatie eventueel nog niet bestaat tijdens de ontwikkeling van het programma (abstract), zonder wijzigingen geïnjecteerd worden in het generieke deel van het programma. De enige delen van het programma die later gewijzigd of uitgebreid moeten worden, zijn deze die rechtstreeks te
maken hebben met de specifieke klasse die toegevoegd wordt.

## 3. Polymorfisme


- Polymorfisme of veelvormigheid komt voort uit de 'IS EEN' relatie: overerving. 
- Het laat toe om objecten in dezelfde klassenhiërarchie te aanzien als objecten van de superklasse.
- Polymorfisme betekent dat een referentie variabele van een bepaald type kan
verwijzen naar verschillende objecten van dit type, maar ook naar objecten van subtypes van dit type.

```
ex. Een referentie variabele van het type Object kan refereren naar een Figuur, gezien de relatie 'Figuur IS EEN Object'. Dezelfde referentie kan verwijzen naar een Vierhoek, gezien de relatie 'Vierhoek IS EEN Object'.

```

```java
public class VierkantApp {
    public static void main( String args[]) {
        // Dit statement instantieert een Vierkant en kent
        // de referentie toe aan ref_1
        Vierkant ref_1 = new Vierkant("Vierkant 1");
        // Aangezien Rechthoek de superklasse is
        // van Vierkant kan de superklasse referentie
        // ref_2 verwijzen naar een instantie van Vierkant
        Rechthoek ref_2 = new Vierkant("Vierkant 2");
        // Een referentie van een superklasse kan niet direct
        // toegekend worden aan een referentie van een subklasse.
        // Expliciet casten is nodig!
        if (ref_2 instanceof Vierkant) {
            Vierkant ref_3 = (Vierkant) ref_2;
        }
    }
}
```

**upcasting** = Een superklasse referentie kan refereren naar een instantie van een subklasse. de referentie naar een object van een subtype (lager in de hiërarchie) wordt toegekend aan een referentie van een supertype (hoger in de hiërarchie).

**downcast** = convertering van subklasse hoger in de hierarchie naar een subklasse lager in de hierarchie. Een superklasse referentie kan enkel toegekend worden aan een subklasse referentie na een downcast

> Let op met een downcast: ga vooraf na of de referentie wel refereert naar een object van het juiste type vooraleer de downcast uit te voeren. Gebruik het keyword `instanceof` om na te gaan of een object van een specifiek type is.


### 3.1. Regels voor toekenning

Polymorfisme bepaalt duidelijk wat de regels voor toekenning van referenties zijn:

```javascript
if (typeof variabele === klasse) {
    referentie = [zelfde_klasse, subklasse]
    variabele = null || referentie 
} else if (typeof variabele === interface) {
    referentie = [
        zelfde_interface, 
        subinterface, 
        klasse_die_interface_implementeert, klasse_die_subinterface_implementeert
    ]
    variabele = null || referentie 
}
```

## 4. Gekende methodes van een referentie 

Een **referentie** heeft altijd **één specifiek type**. Dit type bepaalt welke **instantiemethodes** kunnen aangeroepen worden op die referentie.

> **Instantiemethodes** kunnen enkel aangeroepen worden op een referentievariabele <=> de methodenaam gekend is binnen het type van die referentievariabele.

```javascript
if(typeof variable === "klasse"){
    instantiemethodes = [
        "zichtbare methodes gedeclareerd binnen die klasse (Let op: binnen de klasse zelf zijn alle methodes binnen die klasse gedeclareerd zichtbaar (dus ook de private methodes))",
        "zichtbare methodes gedeclareerd binnen een superklasse van die klasse",
        "zichtbare methodes gedeclareerd in een interface die die klasse implementeert"
    ]
} else if(typeof variable === "interface"){
    instantiemethodes = [
        "methodes gedeclareerd binnen die interface",
        "zichtbare methodes gedeclareerd in een superinterface van die interface",
        "zichtbare methodes gedeclareerd in een interface die die klasse implementeert"
    ]
}
```

> Is het type van een variabele een klasse, en verwijst deze naar een object van een subklasse van die klasse, dan zijn de instantiemethodes waarmee de subklasse werd uitgebreid niet gekend voor die variabele!

### 4.1. Static & dynamic binding

**binding** = linken van een methode declaratie aan zijn implementatie. 

Er zijn twee types binding:
- **Static Binding** → gebeurt tijdens het compileren (@ compile time (overloading))
- **Dynamic Binding** → gebeurt tijdens de uitvoering (@ runtime (overriding)) 

```java
static binding => kan de link tussen een methode declaratie en zijn implementatie gelegd worden tijdens het compileren. Dit is enkel mogelijk indien het type van het object, waarop de methode wordt uitgevoerd, gekend is tijdens het compileren. 

Bij het gebruik van private, final of static methodes en attributen kan static binding plaatsvinden: deze zijn verbonden met het type zelf.

static, private en final methodes kunnen niet overschreven worden. Het bepalen tot welke klasse de methode behoort kan plaatsvinden tijdens het compileren. Het codeblok dat hoort bij de methode kan bij het uitvoeren rechtstreeks aangeroepen worden.
```

```java
Wegens polymorfisme, waarbij een superklasse referentie kan verwijzen naar een object van een subklasse, is de link tussen de implementatie en de declaratie van een methode tijdens het compileren niet altijd te leggen (@Override). 

Er moet gewacht worden tot het type van het object waarnaar de referentie verwijst, gekend is. Dit kan enkel tijdens de uitvoering van het programma en noemen we 'dynamic binding'.
    
Het overschrijven van een methode in een subklasse is een voorbeeld van 'dynamic binding'. In dit geval hebben zowel de super- als subklasse dezelfde declaratie van een methode en moet gewacht worden tot het precieze type van het object gekend is vooraleer de implementatie van de methode uit te voeren.
    
Bij 'dynamic binding' bepaalt het type van het object (niet het type van de referentie) welke implementatie zal uitgevoerd worden. Het type van het object wordt @runtime dynamisch bepaald, vandaar de term 'dynamic binding'.
```

```java
/**
* De referentie van type Figuur (= parameter 'obj' in de methode tekenFiguur) zal verwijzen naar
* een object van type Cirkel / Rechthoek . Bij het aanroepen van de methode 
* teken zal de implementatie van het type Cirkel worden uitgevoerd.
*
* Bij het aanroepen van de methode teken kan de compiler niet bepalen welk gedrag precies zal
* uitgevoerd worden: zal de methode een Cirkel tekenen of een Rechthoek of een ...? Het 
* uitgevoerde gedrag hangt af van het type van het argument dat wordt meegegeven aan de methode
* tekenFiguur, en kan pas @runtime bepaald worden.
*/

class App {
    public static void tekenFiguur(Figuur obj) {
        obj.teken();
    }
    public static void main( String args[]) {
        tekenFiguur(new Cirkel()); 
        tekenFiguur(new Rechthoek());
    }
}

```

### 4.2. Example of Dynamic Binding in Java. 
```java
public class DynamicBindingTest {
	public static void main(String args[]) {
		Voertuig voertuig;
		voertuig = new Voertuig();
		voertuig.start();
		voertuig = new Auto();
		voertuig.start();
	}
}

class Voertuig {
	public void start() {
		System.out.println("Inside start method of Vehicle");
	}
}

class Auto extends Voertuig {
	@Override
	public void start() {
		System.out.println("Inside start method of Car");
	}
}
```

## 5. abstract klasse bij polymorfisme  

>  klasse die gedeclareerd met  keyword `abstract`.

- Een abstracte klasse kan niet geïnstantieerd worden, maar kan wel subklassen hebben.
- Een subklasse van een abstracte klasse kan eveneens een abstracte klasse zijn.
- Een abstracte klasse mag zowel abstracte als niet abstracte methodes bevatten, maar dit is niet verplicht.

example 

```java
abstract class Bike{  
    abstract void run();  
}  

class Honda4 extends Bike{  
    void run(){System.out.println("running safely");}  
    public static void main(String args[]){  
     Bike obj = new Honda4();  
     obj.run();  
    }  
}  

//Example of an abstract class that has abstract and non-abstract methods  
abstract class Bike{  
    Bike(){System.out.println("bike is created");}  
    abstract void run();  
    void changeGear(){System.out.println("gear changed");}  
}  
//Creating a Child class which inherits Abstract class  
class Honda extends Bike{  
    void run(){System.out.println("running safely..");}  
}  
//Creating a Test class which calls abstract and non-abstract methods  
class TestAbstraction2{  
     public static void main(String args[]){  
      Bike obj = new Honda();  
      obj.run();  
      obj.changeGear();  
     }  
}  
```

Een **abstracte klasse** wordt gebruikt om een hoger niveau van **generalisatie** te bereiken.

Een **abstracte methode** is een methode declaratie zonder implementatie (zonder {}), gevolgd door een puntkomma.

## 6. Dependency Injection    

> Een abstracte methode dwingt gedrag af dat kan verwacht worden voor het type, maar dat nog niet kan geïmplementeerd worden op dat niveau in de hiërarchie. 
>
> Generieke software kan gebruik maken van abstracte methodes, waarvan de eigenlijke implementatie op een later moment geïnjecteerd wordt: dit noemen we '<u>**Dependency Injection**</u>'. 

Stel dat je een Auto wenst te bouwen, maar de motor op zich is nog niet geïmplementeerd. Wat je kan doen is een 'standaard' afspreken waaraan een motor moet voldoen zodat je met de ontwikkeling van de Auto kan starten: je legt een abstracte klasse Motor vast met daarin een aantal afspraken omtrent zijn gedrag, een 'standaard' of 'contract' waaraan een motor moet voldoen.

```java
public abstract class Motor {
	public abstract void start();
 }
// Op basis van deze abstracte klasse kan de implementatie van een Auto starten, zonder dat een
// concrete motor reeds geïmplementeerd werd.
public class Auto {
	private Motor motor;

    public Auto(Motor motor) {
    	setMotor(motor);
    }
    
    public void start() {
    	motor.start();
    }

    public void setMotor(Motor motor) {
    	this.motor = motor;
    }
}

/**
 * Merk op dat de eigenlijke motor die een Auto zal gebruiken bij creatie van een
 * Auto als argument wordt meegegeven aan de constructor: de werking van een
 * Auto hangt af van een Motor ( Auto HEEFT EEN Motor relatie). Het meegeven van
 * een concrete motor bij de creatie van een Auto noemen we 'Dependency Injection'.
 * Over welk type Motor het zal gaan is nog niet zeker bij de
 * implementatie van de klasse Auto, wel is zeker dat deze concrete Motor een
 * subtype zal zijn van de klasse Motor. Via polymorfisme wordt het gedrag van dit
 * subtype uitgevoerd. op een later tijdstip kunnen verschillende types van Motor geïmplementeerd
 * worden: een ElektrischeMotor en een BenzineMotor. Eén kan geïnjecteerd worden bij creatie
 */


```

```java
public class ElektrischeMotor extends Motor {
	@Override
	public void start() {
		System.out.println("Gedrag van een elektrische motor");
	}
}
public class BenzineMotor extends Motor {
	@Override
	public void start() {
		System.out.println("Gedrag van een benzine motor");
	}
}

// Merk op: een Auto hoeft niet te weten met welke specifieke motor hij werkt, enkel
// dat het een Motor is. Op een nog hoger niveau kan diegene die de Auto aanmaakt beslissen over // welke Motor zijn Auto zal beschikken. Een ElektrischeMotor of een BenzineMotor. Het staat hem // vrij om eventueel nog een derde Motor te ontwikkelen: een DieselMotor.

public class AutoApp {
	public static void main(String[] args) {
		Auto mijnElektrischeAuto = new Auto(new ElektrischeMotor());
		mijnElektrischeAuto.start();
		Auto mijnBenzineAuto = new Auto(new BenzineMotor());
		mijnBenzineAuto.start();
		// Verbouwing aan mijn benzine auto
		mijnBenzineAuto.setMotor(new ElektrischeMotor());
		mijnBenzineAuto.start();
	}
}

// Via de methode setMotor kan de gebruiker van een Auto zelfs het type Motor van
// de Auto wijzigen, @runtime! Ook dit is een vorm van 'Dependency Injection'.
```

## 7. Interfaces  

> There are a number of situations in software engineering when it is important for disparate groups of programmers to agree to a "contract" that spells out how their software interacts. Each group should be able to write their code without any knowledge of how the other group’s code is written. Generally speaking, interfaces are such contracts.
> — Oracle JAVA tutorial

**interface** is een referentietype, vergelijkbaar met een klasse, dat enkel het volgende kan bevatten:

- Like **abstract classes**, interfaces **cannot** be used to create objects (in the example above,  it is not possible to create an "Animal" object in the MyMainClass)
- Interface methods do not have a body - the  body is provided by the "implement" class
- On implementation of an interface, you must override all of its methods
- Interface methods are by default `abstract` and   `public`
- Interface attributes are by default `public`,   `static` and `final`
- An interface cannot contain a constructor (as it cannot be used to create objects)

> Implementaties van methodes binnen een interface bestaan enkel voor default methodes en static methodes.

example 

```java
// Java program to demonstrate 
// static method in Interface. 
  
interface NewInterface { 
    // static method 
    static void hello() { System.out.println("Hello, New Static Method Here"); } 
    // Public and abstract method of Interface 
    void overrideMethod(String str); 
} 
  
// Implementation Class 
public class InterfaceDemo implements NewInterface { 
    public static void main(String[] args) { 
        InterfaceDemo interfaceDemo = new InterfaceDemo(); 
        // Calling the static method of interface 
        NewInterface.hello();
        // Calling the abstract method of interface 
        interfaceDemo.overrideMethod("Hello, Override Method here"); 
    } 

    // Implementing interface method  
    @Override
    public void overrideMethod(String str) { System.out.println(str);} 
} 

```

Implementaties van methodes binnen een interface bestaan enkel voor default methodes en static methodes. een default methode binnen een interface is impliciet public en moet een concrete implementatie bevatten; als een klasse die de interface implementeert, deze methode niet override, dan gebruikt ze de default-definitie.

Een **default methode** laat toe om nieuwe methodes aan een interface toe te voegen, zodat deze automatisch ook beschikbaar zijn binnen een implementatie van de interface. Binnen het hoofdstuk 'Lambda expressies' wordt het gebruik van enkele default methodes toegelicht. 

Daarnaast kan een methode ook static gedeclareerd worden. Een **'static' methode** declareren binnen een interface is identiek als bij een klasse. Net zoals bij klassemethodes horen deze 'static' methodes niet bij een object. Je kan ze aanroepen in combinatie met de naam van de interface.

Het interface type heeft geen instantie variabelen, en declareert typisch één of meerdere abstracte methodes.

! Een interface heeft GEEN constructor! Deze kan dus nooit geïnstantieerd worden. 
! 'Een **'Functionele interface'** is een interface die slechts één abstracte methode
! Een interface methode <u>zonder</u> **private**, **default**, of **static** modifier is **impliciet**
! Elk attribuut gedeclareerd binnen de body van een interface is **impliciet public**, **static** en **final**.

```java
public interface Constants {
	public static final int INSERT = 1 ;
	int MODIFY = 2 ; // implicitly public, static and final
	int DELETE =3 ;
}
```

```java
// In het voorbeeld van onze Auto kan de abstracte klasse Motor vervangen worden door een interface Motor. Abstracte klasse 

public abstract class Motor {
	public abstract void start();
}
public interface Motor {
	void start();
}

// Een klasse kan een interface implementeren door de abstracte methoden uit de interface te concretiseren 

// Let op de nieuwe relatie in het UML om aan te duiden dat een klasse een interface implementeert.

public class ElektrischeMotor extends Motor {
	@Override
    public void start() {
		System.out.println("Gedrag van een elektrische motor");
	}
}

// Een klasse duidt met het keyword implements aan dat het een interface implementeert.
public class ElektrischeMotor implements Motor {
	@Override
	public void start() {
	System.out.println("Gedrag van een elektrische motor");
	}
}

// De klasse Auto duidt op dezelfde manier aan als voorheen dat deze gebruik maakt van een Motor
// (Auto HEEFT EEN Motor): via een associatie.

public class Auto {
	private Motor motor;
	public Auto(Motor motor) {
		setMotor(motor);
	}
	public void start() {
		motor.start();
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
    }
}

// Merk op: een Auto hoeft nog steeds niet te weten met welke specifieke motor hij
// werkt, enkel dat het een Motor is. De interface Motor is hier op dezelfde manier
// bruikbaar als de abstracte klasse Motor in het vorige voorbeeld. Er is nog altijd
// sprake van 'Dependency Injection' en polymorfisme.
// Merk ook op dat de hoger liggende applicatieklasse niet wijzigt bij de overgang naar een interface:

public class AutoAppMetInterface {
    public static void main(String[] args) {
    	Auto mijnElektrischeAuto = new Auto(new ElektrischeMotor());
    	mijnElektrischeAuto.start();
    	Auto mijnBenzineAuto = new Auto(new BenzineMotor());
    	mijnBenzineAuto.start();
    	// Verbouwing aan mijn benzine auto
    	mijnBenzineAuto.setMotor(new ElektrischeMotor());
    	mijnBenzineAuto.start();
    }
}
```



> Program to an interface, not an implementation!
> — Design Principle

Voorgaand principe duidt aan dat je vaak meer flexibiliteit krijgt door te programmeren naar een interface (Motor) dan naar een implementatie (ElektrischeMotor of BenzineMotor). In combinatie met een associatie (de 'HEEFT EEN' relatie) en 'Dependency Injection' geeft dit de mogelijkheid om later eenvoudig van implementatie te wisselen. (Dit zal later leidden tot het 'Strategy Design Pattern' - keuzevak 'Development'.)

example strategy pattern

```java
public interface Strategy {
   public int doOperation(int num1, int num2);
}

public class OperationAdd implements Strategy{
   @Override
   public int doOperation(int num1, int num2) {return num1 + num2;}
}

public class OperationSubstract implements Strategy{
   @Override
   public int doOperation(int num1, int num2) {return num1 - num2;}
}

public class OperationSubstract implements Strategy{
   @Override
   public int doOperation(int num1, int num2) {return num1 - num2;}
}

public class Context {
   private Strategy strategy;
   public Context(Strategy strategy){this.strategy = strategy;}
   public int executeStrategy(int num1, int num2){return strategy.doOperation(num1, num2);}
}

public class StrategyPatternDemo {
   public static void main(String[] args) {
      Context context = new Context(new OperationAdd());		
      System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

      context = new Context(new OperationSubstract());		
      System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

      context = new Context(new OperationMultiply());		
      System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
   }
}
```

## 8. Objecten samenbrengen in een context

Een andere toepassing van interfaces is het onderbrengen van objecten van niet gerelateerde klassen in een bepaalde context. 

Instanties van een klasse kunnen door middel van een interface in een bepaalde context ondergebracht worden. Zo kunnen ook instanties van klassen die niets met elkaar te maken hebben in een bepaalde context samen komen door de implementatie van een gemeenschappelijke interface (= de implementatie van de abstracte methodes van die interface). 

De klasse Huisdier en Voertuig hebben ogenschijnlijk niets met elkaar te maken.

- Door de klasse Huisdier en Voertuig een gemeenschappelijke interface te laten implementeren
  kunnen ze wel in een bepaalde context samenkomen.
- Stel dat een kunstverzamelaar een verzameling wenst vast te leggen van "tekenbare" (in het Engels
  "Drawable") objecten. Graag had hij tekeningen van zijn Huisdieren en zijn Voertuigen samengebracht in zijn collectie.
  In bovenstaand voorbeeld is dit niet mogelijk via overerving, aangezien de klasse Huisdier al een superklasse Dier heeft.
- Door zowel Huisdier als Voertuig de interface "Drawable" te laten implementeren kunnen objecten
  van beide klassen toch ondergebracht worden in een gemeenschappelijke context: dekunst collectie.

Ook via een interface kan je polymorfisme toepassen: de kunstcollectie 'HEEFT EEN' lijst van drawable objecten. Indien op zo een object de methode draw wordt aangeroepen zal het type object bepalen welke implementatie wordt uitgevoerd.

Wil de kunstverzamelaar later zijn kunstcollectie verkopen in een winkel, dan kan hij de objecten van zijn kunstcollectie samenbrengen in de context van deze winkel. Als een object verkocht zal worden in een winkel, moet het verkoopbaar (in het Engels "Saleable") zijn: de verkoopprijs (cost) moet opgevraagd kunnen worden. 

Vele namen van interfaces in het Engels eindigen op -able. Voorbeelden zijn Serializable, Comparable, AutoCloseable, Runnable...

<img src="https://res.cloudinary.com/dri8yyakb/image/upload/v1613056252/Untitled_Diagram_7_ihbo9q.png" height=900/>

### 8.1. KunstCollectie en KunstWinkel

De klasse KunstCollectie heeft een associatie met de interfaces Drawable, de KunstWinkel met de interface Saleable.

Via polymorfisme kunnen objecten getekend worden binnen de kunstcollectie en kan de verkoopsprijs opgevraagd worden bij verkoop. Polymorfisme zorgt ervoor dat objecten van nieuwe subklassen van Huisdier (bv. Konijn) en/of Voertuigen (bv. Vrachtwagen) zonder wijzigingen in de KunstCollectie en KunstWinkel kunnen opgenomen worden.

```java
public class KunstCollectie {
	private List<Drawable> mijnTekeningen;
}

public class KunstWinkel {
	private List<Saleable> mijnProducten;
}
```

> Code should be open for extension, but closed for modification!
> — Open-closed design principle

### 8.2. Drawable en Saleable

Drawable en Saleable zijn interfaces die de klassen die ze implementeren samenbrengen in eenkunstcollectie en/of kunstwinkel. Objecten van klassen die deze interfaces implementeren zijn tekenbaar en hebben een bepaalde kost.

```java
public interface Drawable {
	public void draw();
}
public interface Saleable {
	public BigDecimal cost();
}
```

### 8.3. Huisdier en Voertuig

De klassen Huisdier en Voertuig hebben op het eerste zicht niets met elkaar te maken. Via hun gemeenschappelijke interface(s) komen ze onder een bepaalde context samen: in dit geval de KunstCollectie.

- Huisdier en Voertuig implementeren elk twee interfaces. Huisdier heeft één superklasse: Dier. Voertuig heeft één superklasse: Object.
- De methoden uit de interfaces worden in deze abstracte klassen niet geïmplementeerd.

```java
public abstract class Huisdier extends Dier implements Drawable, Saleable {
	private String naam;
	public Huisdier(String naam) {
		setNaam(naam);
	}
	public String getNaam() {
		return naam;
	}
	private void setNaam(String naam) {
		this.naam = naam;
	}
	public abstract String maakGeluid();
}

public abstract class Voertuig implements Drawable, Saleable {}
```

### 8.4. Kat, Hond, Auto en Boot   

De klassen Kat, Hond, Auto en Boot implementeren op hun beurt de abstracte methodes vastgelegd in de interfaces die ze volgens hun superklasse dienen te implementeren. Objecten van deze klassen kunnen opgenomen worden in de KunstCollectie en verkocht worden.



```java
public class Hond extends Huisdier{
	public Hond(String naam) {
		super(naam);
	}

	@Override
	public String maakGeluid(){return "Woef, woef...";}
	@Override
    public void draw() {System.out.printf("Tekening van Hond.%n");}
	@Override
	public BigDecimal cost() {
        System.out.printf("Een Hond is onbetaalbaar.%n");
        return BigDecimal.valueOf(1000000);
    }
}
public class Auto extends Voertuig {
	@Override
	public void draw() {System.out.printf("Tekening van Auto.%n");}

	@Override
    public BigDecimal cost() {
        System.out.printf("Een auto is maar een voorwerp.%n");
		return BigDecimal.valueOf(100);
    }
}
```



# 9. Implementatie van meerdere interfaces 
Een Java klasse kan slechts één super klasse hebben. Meervoudige overerving is niet toegelaten. Een Interface is echter geen klasse. Een klasse kan meerdere interfaces implementeren en een interface kan meerdere interfaces uitbreiden.

```java
public interface Hockey extends Sports, Event
public interface Hockey extends Sports, Event
```



# 10.  Objecten sorteren

## 10.1. Comparable interface
Deze veelgebruikte interface legt een 'orde' vast tussen objecten van klassen die de interface implementeren.

De Comparable interface laat je toe om objecten te sorteren! Deze manier van sorteren op basis van deze Comparable interface noemt men ook **'natuurlijke sortering'**. Natuurlijke sortering van getallen is van klein naar groot. Natuurlijke
sortering van letters en woorden is alfabetisch

De Comparable interface legt volgende methode vast, dit is een functionele interface (met één abstracte methode):

```java
public interface Comparable<T> {
	public int compareTo(T o);
}

// De methode compareTo vergelijkt het argument van de methode met het object 
// waarop de methode wordt aangeroepen. Het resultaat is een negatief, 0, of een
// positief geheel getal (int) afhankelijk of het argument kleiner dan, gelijk aan
// (~equals), of groter dan het eigenlijke object zelf is. Als het argument niet kan
// vergeleken worden met het eigenlijke object, dan gooit de methode ClassCastException.

public class Name implements Comparable<Name> {
	private final String firstName, lastName;
    
	public Name(String firstName, String lastName) {
        if (firstName == null || lastName == null)
			throw new NullPointerException();
        	this.firstName = firstName;
        	this.lastName = lastName;
	}

	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }

	/**
	* De compareTo methode vergelijkt eerst op achternaam. 
	* Als deze gelijk moesten zijn wordt op voornaam vergeleken.
	* De 'natuurlijke sortering' van de klasse String
	* wordt gebruikt om achter-en voornamen alfabetisch te sorteren.
	*/
	@Override
    public int compareTo(Name n) { 
		int lastCmp = lastName.compareTo(n.lastName);
        return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
    }

    
   	/**
	* Ook de methode hashCode wordt gespecialiseerd.. 
	* Dit is nodig aangezien ook de methode equals wordt geherdefinieerd. 
	* (Gelijke objecten dienen een gelijke hash code te hebben!)
	*/
	@Override
    public int hashCode() { return 31 * firstName.hashCode() + lastName.hashCode();}
	
    

    /**
	* De methode equals geeft aan dat Name objecten gelijk zijn als ze dezelfde achternaam en 
	* voornaam hebben. Let op: in dit geval is het resultaat van compareTo gelijk aan '0'.
	*/
    @Override
	public boolean equals(Object o) { 
		if (!(o instanceof Name)) return false;
        Name n = (Name) o;
        return n.firstName.equals(firstName) && n.lastName.equals(lastName);
    }

    @Override
    public String toString() {return firstName + " " + lastName;}

public static void main(String[] args) {
    Name nameArray[] = {new Name("John", "Smith"),
                        new Name("Karl", "Ng"),
                        new Name("Jeff", "Smith"),
                        new Name("Tom", "Rich")};

    List<Name> names = Arrays.asList(nameArray);
    // Een sorteeralgoritme kan op basis van deze Comparable interface een lijst van elementen
    // sorteren op natuurlijke wijze.
    Collections.sort(names); 
    System.out.println(names);}
}
```

## 10.2. The Comparator interface  

De Comparator interface laat toe om objecten te sorteren op een andere manier dan op natuurlijke wijze.
De natuurlijke sortering voor de klasse Name is: eerst sorteren op achternaam, dan op voornaam.

Stel dat je toch wil sorteren op voornaam, en dan op achternaam (dus niet op natuurlijke wijze volgens de Comparable interface) kan je dit doen dmv een Comparator, waarbinnen de nieuwe sortering wordt vastgelegd.

```java
public interface Comparator<T> {
	int compare(T o1, T o2);
}
```

> De methode compare vergelijkt twee argumenten met elkaar. Het resultaat is een negatief, 0, of een positief geheel getal (int) afhankelijk of het eerste argument kleiner dan, gelijk aan (~equal), of groter dan het tweede argument.

```java
public class FirstNameComparator implements Comparator<Name> {
	@Override
	public int compare(Name o1, Name o2) {
		int firstCmp = o1.getFirstName().compareTo(o2.getFirstName());
		return (firstCmp != 0 ? firstCmp : o1.getLastName().compareTo(o2.getLastName()));
	}
}
```




