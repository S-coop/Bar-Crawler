package src.controller;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import src.view.MazeView;
import src.view.MonsterView;
import src.view.PlayerView;


public class MonsterController {
    private PlayerView player;
    private Stage stage;
    private MazeView maze;
    private double dx = 1;
    private double dy = 1;

    public MonsterController(Stage stage, PlayerView player, MazeView maze) {
        this.stage = stage;
        this.player = player;
        this.maze = maze;



        final long[] startTime = {System.currentTimeMillis()};
        final long[] lastAttackTime = {0};
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                startTime[0] = System.currentTimeMillis();
                for (MonsterView monster : maze.getCurrent().getMonsterViews()) {
                    if (player.getModel().getPlayerHP() > 0
                            && Math.abs(player.getCenterX() - monster.getCenterX()) < 30
                            && Math.abs(player.getCenterY() - monster.getCenterY()) < 30
                            && startTime[0] - lastAttackTime[0] > 1000) {
                        monster.currentModel().attack(player, monster);
                        System.out.println("attacked player!");
                        lastAttackTime[0] = startTime[0];
                    }
                }
            }
        };
        timer.start();

    }

}
