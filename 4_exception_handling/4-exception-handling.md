# 4. Exception Handling 

## TOC

```
1. Inleiding
2. Exceptions
3. Exception gooien
4. opvangen && afhandelen exceptions
5. try-with-resources-statement
6. soorten exceptions
7. persoonlijke exception class
8. exception chaining
9. stack trace information
10. testing
```

## 1. Inleiding

**exception** = uitzonderlijke gebeurtenis, die kan optreden bij het uitvoeren van een app en die de normale voortgang van de applicatie onderbreekt

Een  voorbeeld  van  zo  een  uitzonderlijke  gebeurtenis  is  het  uitvoeren  van  een  deling  door  nul.Indien de exception niet wordt afgehandeld zal de applicatie "crashen".

```java
public class DivideByZero {
	public static void main(String[] args){
        // zal voor een unhandeld expection zorgen
		int quotient = 10 / 0;
		System.out.printf("resultaat %f", quotient)
	}
}
```

<img src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.w3resource.com%2Fw3r_images%2Fexcption-in-java-image2.png&f=1&nofb=1" alt="Exceptions in Java programming language - w3resource" style="zoom:73%;" />

- soort fout => **Arithmetic Exception**
- waar fout zich voordoet
- De **stack trace** toont welke methodes werden aangeroepen en waar het precies fout liep.
  - Weergave aanroep methode: klasse, methode, bestandsnaam, regelnummer.
  - Als je het chronologisch in de tijd wil volgen, lees je van onder naar boven.
  - De  hoogste  vermelding  in  het  exceptie  gedeelte  van  de  uitvoer  noemen  we  het  **throw  point**

## 2. Exceptions

```java
if(mijnString == null || mijnString.isBlank()){
    throw new IllegalArgumentException(); 
    // exception object creeren en doorgeven aan runtime systeem
    
    
}
```

exception object 

- bevat informatie over de exceptie, inclusief:
  - zijn type (welke exceptie is er opgetreden)
  - de toestand waarin het programma zich bevond toen de exception optrad

- exceptie  vanuit  een  methode => geen return waarde
- exceptie vanuit een constructor (direct of indirect) => constructie  van  het  object  onderbroken

### verwerken exception

1. exception object opwerpen
2. **runtime systeem** zoekt iets voor exceptie afhandeling 
3. De mogelijkheden voor afhandeling wordt gezocht in de **call stack** (lijst van methoden die aangeroepen werden om tot de methode te komen waar de exceptie optrad)
   1. Indien er geen **exception handler** wordt gevonden zal het programma stoppen en de **call stack** op scherm weergeven
   2. Indien exception handler gevonden zal het runtime systeem het exception object doorgeven als argument aan deze **exception handler.**

<img src="https://docs.oracle.com/javase/tutorial/figures/essential/exceptions-callstack.gif"/>

<img src="https://docs.oracle.com/javase/tutorial/figures/essential/exceptions-errorOccurs.gif"/>

- exception handler => pas geschikt om een exception af te handelen als het type van het exception object === **het type van de exception parameter** (type dat de exception handler kan behandelen)
- De exception handler die de exceptie afhandelt vangt het exception object op (**catching an exception**).

### Voordelen van exception handling

- afzondering van gewone code = vermijden spaghetti code

```
errorCodeType readFile {
	initialize errorCode = 0;
	
	open the file;
	if(isFileOpen){
		determine file length;
		if(isFileLength){
			allocate memory;
			if(sufficientMemory){
				read file into memory;
				if(readFailer){
					errorCode = -1
				}
			} else {
				errorCode = -2
			}
		} else {
			errorCode = -3
		}
	} else {
		errorCode = -4
	}
	return errorCode
}

readFile {
	try{
		open the file;
		determine file length;
		allocate memory;
		read file into memory;
	} catch (fileOpenFail) {
		...
	} catch (sizeDeterminationFail) {
		...
	} catch (memoryAllocationFail) {
		...
	} catch (readFeil) {
		...
	}
}
```

- expections can be **propagated** through the stack
  - Exception handling laat toe om een exceptie op een hoger niveau af te handelen.
  - Voor  een  bepaalde  soort  exceptions  (**checked  exceptions**)  zal  de  compiler  zelfsnagaan  of  deze  wordt  afgehandeld.  Indien  niet  krijg  je  bij  het  compileren  eenfoutboodschap.  De  compiler  gaat  ervan  uit  dat  het  zinloos  is  om  een  fout  tedetecteren en te gooien zonder ze achteraf op te vangen en af te handelen.





## 3. Exception gooien

### throw statement

methodes gebruiken een throw statement om een exceptie te gooien. => het argument is een object dat een instantie is van een subklasse van de klasse **Throwable**

```java
/** 
De volgende methode pop is terug te vinden in een veelgebruikt stack object. 
De methode verwijdert een element van de top van de stack en geeft dit element terug.
*/

// ! Merk op dat de declaratie van de pop methode geen throws clausule bevat. EmptyStackException is geen checked exception, dus pop is niet verplicht om te declareren dat deze exceptie kan gegooid worden.

// checked exceptions represent errors outside the control of the program. For example, the constructor of FileInputStream throws FileNotFoundException if the input file does not exist. 

throw throwableObject
    
public Object pop(){
    Object obj;
    
    // zijn er geen elementen over op de stack gooi exception
    if(size == 0) { throw new EmptyStackException();}
    
    obj = ObjectAt(size - 1);
    setObjectAt(size - 1, null);
    size--;
    return obj;
}
```

### throwable class en sub-class

Een eigen klasse hierarchy voor excepties kan opgebouwd worden, om specifieke problemen op te vangen. Je kan dus zelf een exception klasse aanmaken en hiervan een object gooien. Zo kan je eenvoudig onderscheid maken tussen verschillende gebeurtenissen.

<img src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fdocs.oracle.com%2Fjavase%2Ftutorial%2Ffigures%2Fessential%2Fexceptions-throwable.gif&f=1&nofb=1">

## 4. opvangen && afhandelen exceptions


Om een exception te gooien maak je gebruik van het throw statement en voorzie je dit statement van een exception object dat informatie bevat van de specifieke error die optrad.

Gebruik je code geschreven door iemand anders, ga dan zeker in de documentatie na of er exceptions kunnen gegooid worden door die code die je best afhandelt! Een applicatie kan exceptions opvangen gebruik makende van een **try/catch blok**, eventueel samen met een **finally blok**.

- **try blok** identificeert waarin een exception kan optreden. 
  *Een exception kan enkel afgehandeld worden indien ze optreedt binnen een try blok.*
- **catch blok** identificeert de exception handler, 
  die een specifieke exception (=het type van de exception parameter) kan afhandelen.
- **finally blok** identificeert waarvan gegarandeerd is dat het uitgevoerd wordt (onafhankelijk of er een error optreedt of niet). 
  Dit is de geschikte plaats om resources af te sluiten en *alles uit het try blok op te ruimen*.

### try-blok

```java
try {
	code
}
catch and finally bloks ... 
```

Als een exceptie wordt gegooid binnen een try blok, kan deze afgehandeld worden door een exception handler van het juiste type. Om een exception handler te koppelen aan het try-blok koppel je aan dit blok een catch-blok

### catch-blok

> Tussen de try-catch kan geen andere code voorkomen

```java
try {
	code
} catch (ExceptionType name) {
    
} catch (OtherExceptionType name) {
    
} catch (IOException|SQLException ex) { 
    // 1 try-blok kan aan meerdere catch-blokken hebben  
    // één enkel catch-blok kan meerdere exceptie types bevatten
	logger.log(ex);
	throw ex;
}

```

**catch declaratie** = exception handler die het type exceptie kan afhandelen vermeld in zijn parameterlijst (de exception parameter types). 

In het voorbeeld declareert het eerste catch blok dat deze exception handler een gegooid exception object van het type ExceptionType kan afhandelen. Dit type moet een subklasse zijn van de klasse Throwable. De handler verwijst ernaar d.m.v. de naam van de klasse.

Het catch blok bevat code die uitgevoerd wordt als de exception handler wordt aangeroepen. Het runtime systeem zal deze exception handler aanroepen als het de eerste is in de call stack wiens exception parameter type overeenkomt met de exceptie die gegooid werd. Het systeem vergelijkt de types en vindt een geschikte kandidaat als het gegooide exception object kan toegekend worden aan het argument van de exception handler.

Een exception handler is in staat meer te doen dan enkel een foutboodschap tonen of de applicatie te stoppen. Een error kan 

- hersteld worden
- de gebruiker kan een boodschap krijgen
- de exceptie kan ingevoegd worden in een exceptie ketting om deze te propageren naar een hoger niveau.

### finally-blok

Het runtime systeem voert altijd de statements uit in het finally-blok onafhankelijk van wat er in het try-blok gebeurt. 
Dit is de ideale plaats om alles op te ruimen.

```java
finally {
	if (out != null) {
		System.out.println("Closing PrintWriter");
		out.close();
	} else {
		System.out.println("PrintWriter not open");
	}
}
```

het meest geschikt om het lekken van resources te voorkomen. Aangezien het finally blok altijd wordt
uitgevoerd kan je resources hier manueel vrijgeven en ben je zeker dat deze code ook wordt uitgevoerd. 

Als programmeur kan je het vrijgeven van resources in een finally blok wel "vergeten" te implementeren. Het **try-with-resources** statement

**resource** = gedeelde component. (bv. gedeelde netwerkpoort op een computer: er is maar één ethernetpoort, die gedeeld wordt door alle applicaties. Indien een connectie wordt opgezet via de netwerkpoort, dan krijgt een applicatie een combinatie van het IP adres en een poort nummer. Wordt bij een fout deze resource niet opnieuw vrijgegeven, dan kan later dezelfde combinatie IP adres en poort nummer niet meer opnieuw gebruikt worden.)

Overweeg om het **try-with-resources** statement te gebruiken, die automatisch resources vrijgeeft als ze niet meer nodige zijn

## 5. try-with-resources-statement

Het try-with-resources statement is een try statement dat één of meerdere resources declareert. Een **resource** is een object dat moet gesloten worden nadat een applicatie afsluit of nadat het niet meer nodig is. Het try-with-resources statement garandeert dat resources afgesloten worden op het einde van het try statement. 

Elk object dat de interface `java.lang.AutoCloseable` implementeert, inclusief alle objecten die de interface `java.io.Closeable ` implementeren, kunnen in het try-with-resources statement gebruikt worden.

Onderstaand voorbeeld leest een eerste lijn uit een bestand. Een instantie BufferedReader wordt gebruikt om de data in te lezen. BufferedReader is een resource die gesloten moet worden als de applicatie eindigt:

- De resource gedeclareerd en geïnstantieerd in het try-with-resources statement is de BufferedReader. Dit gebeurt tussen de haakjes, onmiddellijk na het try keyword. De klasse BufferedReader implementeert de interface `java.lang.AutoCloseable`. De variabele br is een lokale variabele binnen het try-blok.
- instantie van BufferedReader gedeclareerd in het try-with-resource statement => wordt gesloten worden met of zonder exception

```java
public static String readFirstLineFromFile(String path) throws IOException {
	try (
    	// ! of meer resources kunnen gedeclareerd worden
    	// Close methode van resources worden gebruikt omgekeerd van hun declaratie/creatie!
		ZipFile zf = new ZipFile(zipFileName); 
		BufferedReader br = new BufferedReader(new FileReader(Paths.get(path)))
	) {
		return br.readLine();
    }
}

public static String readFirstLineFromFile(String path) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader(Paths.get(path)));
    try {
		return br.readLine();
    } finally {
        if(br != null) br.close();
    }
}

// Analoog zonder try-with-resources
```

## 6. soorten exceptions

### groeperen van throwables

Elke exceptie die binnen een applicatie gegooid kan worden is een instantie van een klasse. Het groeperen of categoriseren van exceptions kan dus eenvoudig op basis van een klasse hiërarchie. 

Elke Java Exception klasse erft direct of indirect van de klasse **Exception**, dewelke zelf een subklasse is van **Throwable**. Zo ontstaat er een overervingshiërarchie. Je kan deze boomstructuur zelf ook nog uitbreiden met eigen ontworpen Exception-klassen. Het mechanisme om fouten af te handelen werkt voor alle Throwable-objecten.

<img src="https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fmath.hws.edu%2Fjavanotes%2Fc8%2Fexception-hierarchy.png&f=1&nofb=1"/>

Deze hiërarchie legt ook drie soorten Throwable objecten vast, op basis van de subklassen

- Errors
- Checked exceptions
- Unchecked exceptions

### Errors

Dit zijn events waarop de applicatie geen vat geeft => on-anticipeerbaar + on-herstelbaar

### Runtime Exceptions

- events in applicatie
- meestal niet anticipeerbaar
- niet herstelbaar.
- Meestal aangeduid als software bugs, logische fouten of het onjuist gebruik van een API.
- Runtime exceptions hoeven niet omringd te worden door een try-catch clausule, een methode hoeft
  ook niet aan te geven dat het een RuntimeException kan gooien.
  - Errors en runtime exceptions zijn gekend als **unchecked exceptions**.
    (Vb. ArrayIndexOutOfBoundsException, ArithmeticException…)
  - Ook unchecked exceptions kunnen afgehandeld worden

### Checked exceptions

uitzonderlijke gebeurtenissen in een applicatie 

- anticipeerbaar
- Om te garanderen dat een exception wordt opgevangen, worden checked exceptions gebruikt.
- Een **checked exception** moet omringd worden door een try clausule en moet een
  geschikte catch clausule bevatten. 
  - Indien dit niet het geval is moet de methode aangeven in zijn declaratie dat het deze exception kan gooien (throws).
  - De verantwoordelijkheid voor het afhandelen van de exception wordt zo op een hoger niveau gebracht.
  - Alle exceptions - (Error en RuntimeException of hun subklassen) = checked exceptions

### checked vs unchecked exceptions

De compiler maakt wel degelijk een verschil tussen deze twee types Exception: een checked Exception moet afgehandeld worden of moet expliciet gepropageerd worden (catch-or-declare requirement). Bij compilatie wordt dit gecontroleerd: de compiler waarschuwt je dus dat een mogelijke fout niet wordt afgehandeld (→ je zegt dat er een fout kan optreden, maar je handelt ze niet af…)

*Bij een **unchecked exception** treedt deze controle tijdens compilatie niet op!*

### specificieren expection gooien

Soms is het handig in code om exceptions direct op te vangen, binnen dezelfde methode. Vaak is het echter handiger om exceptions op te vangen op een hoger niveau, hogerop de call stack.

Als een methode zelf niet de checked exception opvangt die mogelijk kunnen gegooid worden, dan moet deze methode aangeven in zijn declaratie dat het deze exception zou kunnen gooien! Indien dit niet gedeclareerd wordt, treedt een
compilatie fout op.

Om te specifiëren dat een methode een checked exception kan gooien, maar deze zelf niet afhandelt, dient een **throws clausule** toegevoegd te worden aan de declaratie van de methode. Deze clausule omvat het throws keyword, gevolgd door een lijst van excepties gescheiden door een komma.

```java
public void writeList() throws IOException, IndexOutOfBoundsException {
	...
}
```

## 7. persoonlijke exception class 

erft van een bestaande **Exception klasse**.

- Als het de bedoeling is dat het programma zich kan herstellen na de Exception, maak dan een
  **checked Exception** (m.a.w. erf van Exception, maar niet van RuntimeException)
- Als het de bedoeling is dat de Exception kan genegeerd worden, maak dan een **unchecked**
  **Exception** en erf van RuntimeException.
- Het is de gewoonte om de naam van die nieuwe klasse te laten eindigen op Exception
- Een Exception klasse heeft typisch 4 of minstens 2 constructoren. In de body van deze
  constructoren roepen we via super() de overeenkomstige constructor van de superklasse aan

```java
package exceptions

public class EmailException extends RuntimeException {
	public EmailException() {
		super("e-mail fout")
	}
	public EmailException(String msg) {
		super(msg)
	}
	public EmailException(String msg, Throwable cause) {
		super(msg, cause)
	}
	public EmailException(Throwable cause) {
		super(cause)
	}
}
```



## 8. exception chaining

Een ketting van excepties ontstaat als een exceptie die opgevangen wordt resulteert in een nieuwe exceptie. De eerste is oorzaak van de tweede.

Soms is het handig om te weten welke exceptie een andere exceptie tot gevolg heeft. Dit kan bereikt worden door een ketting van excepties te maken. Bij het gooien van een exceptie kan de exceptie die de oorzaak was als argument meegegeven worden.

```java
try {

} catch (IOException e) {
	throw new SampleException("Other IOException", e); ①
}
```

- Als een IOException opgevangen wordt, wordt een nieuwe SampleException instantie gemaakt met als oorzaak de originele exceptie. Deze ketting van excepties wordt gegooid om op een hoger niveau afgehandeld te worden.

- Via de methode `getCause()` uit de `klasse Throwable` kan je terugvinden welke subklasse van
  Throwable initieel de Exception veroorzaakt heeft.

<img src="https://res.cloudinary.com/dri8yyakb/image/upload/v1614674719/Screenshot_from_2021-03-02_09-44-54_yzjkf1.png"/>

## 9. stack trace information

stack trace 

- zit vervat in een Exception object
- bevat informatie over de executie geschiedenis van een thread. 
- Deze omvat o.a. de namen van klassen en methoden die werden aangeroepen tot het punt waar de exceptie optrad.

Zo een stack trace is zeer handige bij het debuggen, waar zeker voordeel uit gehaald kan worden indien een exceptie wordt gegooid (waar trad de exceptie op!). De stack trace die bij een exceptie hoort geeft o.a. aan waar (in welke file en op welke regel) in de source de exceptie precies optrad.

```javascript
catch (Exception cause) {
    // Toont aan hoe je een stack trace kan opvragen o.b.v. een exceptie object.
	StackTraceElement elements[] = cause.getStackTrace();
	for (int i = 0, n = elements.length; i < n; i++) {
        System.err.println(elements[i].getFileName()+ ":" + elements[i].getLineNumber() + ">> " + elements[i].getMethodName() + "()");
	}
}
```

## 10. testing

````java
// Is onderstaande snippet geldige code? ja
try {    
} finally {
}

// Welke exceptie types zal volgende exception handler opvangen: geen enkele, exact één of meerdere (zo ja, welke dan…)? alles exception types en subKlassen van exception
catch (Exception e) {
}

// Waarom implementeer je deze exception handler beter niet? Wat loopt er mis? Zal deze code compileren? arithmetic expression zal nooit uitgevoerd worden
try {
} catch (Exception e) {
} catch (ArithmeticException a) {
}

````