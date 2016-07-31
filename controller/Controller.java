package Sokoban.controller;

import Sokoban.model.Direction;
import Sokoban.model.GameObjects;
import Sokoban.model.Model;
import Sokoban.view.View;


/**
 * Created by ruslan on 30.07.16.
 */
public class Controller implements EventListener
{
    private View view;
    private Model model;

    public Controller()
    {
        this.model = new Model();
        model.restart();
        model.setEventListener(this);
        this.view = new View(this);
        view.init();
        view.setEventListener(this);
    }

    public static void main(String[] args)
    {
        Controller controller = new Controller();
    }

    @Override
    public void move(Direction direction)
    {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart()
    {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel()
    {
        model.startNextLevel();
        view.update();
    }

    @Override
    public void levelCompleted(int level)
    {
        view.completed(level);
    }

    public GameObjects getGameObjects()
    {
        return model.getGameObjects();
    }
}
