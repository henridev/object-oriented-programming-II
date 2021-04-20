# 5. User Interface

## TOC

```
1. Opbouw van een JavaFX applicatie
2. UI componenten
3. Event handling
4. Layout managers
5. Menu‘s, toolbars Alert dialogs
```

## 1. Opbouw van een JavaFX applicatie

> voor je begint zorg je ervoor dat javaFx toegevoegd is aan de external libraries

### voorbeeld van een scherm

<img src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Ff%2Ff9%2FJavafx-stage-scene-node.svg%2F1191px-Javafx-stage-scene-node.svg.png&f=1&nofb=1" style="zoom: 33%;" />



- stage = bovenste laag van FX container
- scene = graph van gui-componenten
  - **node** = component in de scene graph, instantie een Node subklasse (javafx.Scene). definieert gedrag voor alle nodes in scene graph
  - **root node** = eerste node in scene graph

<img src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.hs-augsburg.de%2F~meixner%2Fprog%2Fhtml%2Fbenutzeroberflaechen%2Fimages%2FCounterAppSceneGraph.png&f=1&nofb=1"/>

```java
package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

public class WelkomScherm extends Pane {
    public WelkomScherm() {
        Label lblWelkom = new Label("Welkom bij JavaFX !");
        ImageView ivImage = new ImageView(new Image(getClass().getResourceAsStream("/images/bug.png")));

        // In dit voorbeeld gebruik we geen layout
        // We geven de componenten een vaste positie mee
        // Dit doen we met de methoden setLayoutX en setLayoutY
        lblWelkom.setLayoutX(200);
        lblWelkom.setLayoutY(10);
        
        ivImage.setLayoutX(50);
        ivImage.setLayoutY(50);

        // Alle componenten worden verzameld in ons paneel
        
        // vraag huidige componenten van het paneel root op en voeg er 2 aan toe
        this.getChildren().addAll(lblWelkom, ivImage);

    }
}


// ----------------------------

package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.WelkomScherm;

// hoofdklasse => subklasse van Application
public class StartUp extends Application {

    /**
     * uitvoeren applicatie
     * @param primaryStage - hoofdVenster
     */
    @Override
    public void start(Stage primaryStage) {
        WelkomScherm root = new WelkomScherm();
        Scene scene = new Scene(root, 500, 300);

        // koppel Scene aan de Stage (het venster).
        primaryStage.setScene(scene);

        // titel aan het venster en tonen we het op het scherm.
        primaryStage.setTitle("Welkom bij JavaFX");
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}


```

## 2. UI componenten

### [scene control package](https://docs.oracle.com/javafx/2/api/javafx/scene/control/package-summary.html)

```java
public class LoginScherm extends GridPane {
    // Dit attribuut hebben we in meerdere methoden nodig
    private Label lblMessage;
    public LoginScherm() {
        this.setAlignment(Pos.BOTTOM_LEFT); // Aligneert grid in het midden
        this.setHgap(10); // Vrije ruimte tussen kolommen
        this.setVgap(10); // Vrije ruimte tussen rijen
        this.setPadding(new Insets(25, 25, 25, 25)); 
        
        Label lblTitle = new Label("Welcome");
        lblTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        // Bij GridPane kan in elke cel een component geplaatst worden
        // Een component kan over meerdere rijen en/of kolommen geplaatst worden
        // De label wordt hier over 2 kolommen en 1 rij geplaatst
        this.add(lblTitle, 0, 0, 2, 1);

        Label lblUserName = new Label("User Name:"); this.add(lblUserName, 0, 1);
        TextField txfUser = new TextField(); this.add(txfUser, 1, 1);
        Label lblPassword = new Label("Password:"); this.add(lblPassword, 0, 2);
        PasswordField pwfPassword = new PasswordField(); this.add(pwfPassword, 1, 2);

        Tooltip tooltip = new Tooltip();
        tooltip.setText("Your password must be\n" + "at least 8 characters in length\n");
        pwfPassword.setTooltip(tooltip);

        Button btnSignIn = new Button("Sign in");
        setHalignment(btnSignIn, HPos.LEFT); this.add(btnSignIn, 0, 4);

        Button btnCancel = new Button("Cancel");
        setHalignment(btnCancel, HPos.RIGHT); this.add(btnCancel, 1, 4);

        Hyperlink linkForgot = new Hyperlink("Forgot password");
        this.add(linkForgot, 0, 5, 2, 1);

        lblMessage = new Label();
        this.add(lblMessage, 1, 6);

        // eh aan signin via method reference
        btnSignIn.setOnAction(this::buttonPushed);

        // eh lambda expressie
        btnCancel.setOnAction(evt -> lblMessage.setText("Cancel button pressed"));

        // eh anonieme innerklasse
        linkForgot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt)
            {
                lblMessage.setText("Hyperlink clicked");
            }
        });

    } 
    
    // Event-afhandeling: wat er moet gebeuren als we op de knop Sign in klikken
    private void buttonPushed(ActionEvent event){
        lblMessage.setText("Sign in button pressed");
    }
}


```

## 3. Event handling

- GUI’s zijn **event driven** = genereert events op het ogenblik dat de gebruiker interactie heeft met een UI component
- **event handler** = code die uitgevoerd wordt als antwoord op het optreden van een event
  - 3 onderdelen
    - Event source: de UI component waarop de
      gebruiker inwerkt
    - Event object: bevat de informatie over het event
      dat opgetreden is
    - Event listener: ontvangt een event object bij het
      optreden van een event en geeft dan een antwoord
      via een event handler
  - 3 opties
    - method reference
    - lambda expressie
    - anonieme innerklasse

### publieke klasse tot anonieme innerklase

#### publieke klasse

#### 

```java
public class DemoEventScherm extends GridPane {
    public DemoEventScherm() {
        Label lblBoodschap = new Label();
        Button btnKlik = new Button("Klik");
        this.add(lblBoodschap, 0, 0);
        this.add(btnKlik, 0, 1);
        this.setAlignment(Pos.CENTER);

        // publieke klasse
        ActionEventAfhandeling eafh = new ActionEventAfhandeling(lblBoodschap);
        btnKlik.setOnAction(eafh);
        // publieke klasse
        MouseEventAfhandeling mafh = new MouseEventAfhandeling();
        this.setOnMouseClicked(mafh);
    }
}

// ---------------------

// implements
public class ActionEventAfhandeling implements EventHandler<ActionEvent> {
    private final Label lblBoodschap;
    public ActionEventAfhandeling(Label lblBoodschap){this.lblBoodschap = lblBoodschap;}

    @Override
    public void handle(ActionEvent event)
    {
        lblBoodschap.setText("Geklikt");
    }
}
// implements
public class MouseEventAfhandeling implements EventHandler<MouseEvent> {   
    @Override
    public void handle(MouseEvent event) {
        System.out.println("x = " + event.getSceneX());
        System.out.println("y = " + event.getSceneY());
    }  
}

```

#### inner klasse

Een klasse kan binnenin een andere klasse gedefinieerd worden. Zulke innerklasses worden dikwijls gebruikt voor event afhandeling. De inner klasse heeft toegang tot alle attributen/methoden van de ‘outer’ klasse.

```java
public class DemoEventSchermMetBenoemdeInnerKlasse extends GridPane {
    private final Label lblBoodschap;

    public DemoEventSchermMetBenoemdeInnerKlasse() {
        lblBoodschap = new Label();
        Button btnKlik = new Button("Klik");
        this.add(lblBoodschap, 0, 0);
        this.add(btnKlik, 0, 1);

        this.setAlignment(Pos.CENTER);
       	// inner klasse
        btnKlik.setOnAction(new InnerklasseActionEventAfhandeling());
        // inner klasse
        this.setOnMouseClicked(new InnerKlasseMouseEventAfhandeling());
    }

    // implements
    private class InnerklasseActionEventAfhandeling implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event)
        {
            lblBoodschap.setText("Geklikt");
        }
    }

    // implements
    private class InnerKlasseMouseEventAfhandeling implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            System.out.println("x = " + event.getSceneX());
            System.out.println("y = " + event.getSceneY());
        }
    }
}

```

#### anonieme inner klasse

- I.p.v. een innerklasse te definiëren, definiëren we de implementatie van de interface onmiddellijk bij instantiatie van het object.
- We kunnen de objectreferentie dan ook ineens ter plaatse leveren, nl. als actueel argument van
  de methode setOnAction.
- We doen dit voor elke GUI-component die events levert.

```java
public class DemoEventSchermMetAnoniemeInnerKlassen extends GridPane {
    public DemoEventSchermMetAnoniemeInnerKlassen() {
        Label lblBoodschap = new Label();
        Button btnKlik = new Button("Klik");

        this.add(lblBoodschap, 0, 0);
        this.add(btnKlik, 0, 1);
        this.setAlignment(Pos.CENTER);

        btnKlik.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                lblBoodschap.setText("Joepie!");
            }
        });

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("x = " + event.getSceneX());
                System.out.println("y = " + event.getSceneY());
            }
        });
    }
}


// --------------


public class StartUp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        DemoEventSchermMetAnoniemeInnerKlassen root = new DemoEventSchermMetAnoniemeInnerKlassen();

        Scene scene = new Scene(root,300,300);
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Eventafhandeling");
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
              @Override
              public void handle(WindowEvent event){
                  System.out.println("We sluiten het venster en dus... ook de applicatie");
                  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Bevestig");
                  alert.setContentText("Wil je de applicatie afsluiten?");
                  Optional<ButtonType> result = alert.showAndWait();
                  if (result.get() == ButtonType.OK){
	                    System.out.println("We sluiten het venster en dus... ook de applicatie");
                        Platform.exit();
                  } else { 
                  	  // annuleren van event
                      event.consume();
                  }
            }
        });
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
```

## 4. Layout managers

- Nodes met afstammelingen zijn meestal **layout containers** die hun afstammelingen ordenen in de scene.
- Nodes die geordend zijn in een layout container zijn een combinatie van UI controls en mogelijk andere layout
  containers.
- Layout panelen kunnen gecombineerd worden

### types 

- **borderPane** = In een BorderPane heb je 5 gebieden om nodes in te plaatsen: top, bottom, right, left en center.

- **HBox / VBox** = worden de nodes horizon/verticaal in één rij geplaatst.

- **StackPane** = nodes boven elkaar geplaatst. De meest recente node komt bovenaan zoals bij een stack.

- **GridPane** = nodes in een flexibele tabel geplaatst

- **FlowPane / TilePane ** =   nodes in een rij / kolom geplaatst. Indien de beschikbare breedte / hoogte overschreden wordt dan komt de node in een nieuwe rij / kolom

  - In een TilePane worden de nodes geplaatst in cellen die allemaal even groot zijn. De grootte van elke cel wordt bepaald door de grootst nodige. Of zelf instellen via **prefTileWidth** en **prefTileHeight**!

- **AnchorePane** = ankerpunten geplaatst bij de top, left, right, center en bottom van de layout

  



<img src="https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2F3.bp.blogspot.com%2F-IrZheG2-us4%2FT3MUuSZI3ZI%2FAAAAAAAAAFk%2FAwq-EvhpCBM%2Fw1200-h630-p-k-no-nu%2Fborderpane_architecture.png&f=1&nofb=1" width=500/>

<img src="https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fhajsoftutorial.com%2Fjavafx-tutorial%2Fwp-content%2Fuploads%2F2015%2F04%2F13.png&f=1&nofb=1" width=500/>

<img src="https://res.cloudinary.com/dri8yyakb/image/upload/v1614762044/Screenshot_from_2021-03-03_10-00-27_cyny2h.png" width=600/>

<img src="https://res.cloudinary.com/dri8yyakb/image/upload/v1614761676/Screenshot_from_2021-03-03_09-54-06_mmf404.png"/>

### uitlijnen

Gebruik de methode setAlignment(Pos value)

- Pos - verticaal en horizontaal uitlijnen De waarde links van de underscore geeft de verticale uitlijning weer, de waarde rechts van de underscore geeft de horizontale uitlijning weer. (vb: Pos.BOTTOM_LEFT lijnt verticaal uit aan
  de onderkant en horizontaal aan de linkerkant | FXVoorbeeld2: this.setAlignment(Pos.CENTER);)

## 5. Menu‘s, toolbars Alert dialogs