
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.*;



public class GameofLife extends Application {


     Customsquare[][] csarray;

    @Override
    public void start(Stage primaryStage) throws Exception {


        //Creating a Group object
        Group group = new Group();

        Button button = new Button("Start");
        button.setTranslateY(550);


        AnimationTimer timer = new AnimationTimer() {

            private long lastUpdate = 0 ;
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 150_000_000) {
                    refreshcell rfc= new refreshcell(csarray);
                    rfc.run();
                    System.out.println("test");
                    lastUpdate = now ;
                }
            }


        };

        button.setOnMouseClicked(e -> {


            timer.start();
        });




        addelements(group);


        group.getChildren().add(button);
        //Creating a Scene by passing the group object, height and width
        Scene scene = new Scene(group, 500, 600);


        //setting color to the scene
        scene.setFill(Color.LIGHTGRAY);

        //Setting the title to Stage.
        primaryStage.setTitle("Game of Life");

        //Adding the scene to Stage
        primaryStage.setScene(scene);

        //Displaying the contents of the stage
        primaryStage.show();
    }

    public static void main(String args[]) {

        launch(args);




    }

    public void addelements(Group group) {

        addsquares(group);
        addbutton(group);

    }

    public boolean addbutton(Group group) {

//        group.getChildren().add();
        return true;
    }

    public boolean addsquares(Group group) {


        int xlen = 500, ylen = 500;

        csarray = new Customsquare[xlen/5][ylen/5];

        for (int i = 0; i < xlen; i = i=i+5) {
            for (int j = 0; j < ylen; j=j+5) {
                csarray[i/5][j/5] = Customsquare.makesquares(i, j, 4.9);

                group.getChildren().add(csarray[i/5][j/5]);
//                group.getChildren().add(Customsquare.makesquares(i, j, 4.9));
            }

        }

        return true;
    }




}