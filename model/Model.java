package Sokoban.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.Box;
import com.javarush.test.level34.lesson15.big01.model.Home;
import com.javarush.test.level34.lesson15.big01.model.Wall;

import java.nio.file.Paths;

/**
 * Created by ruslan on 30.07.16.
 */
public class Model
{
    public static int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("/home/ruslan/Документы/JavaRushHomeWork/src/com/javarush/test/level34/lesson15/big01/res/levels.txt"));

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects()
    {
        return gameObjects;
    }

    public void restartLevel(int level)
    {
        this.gameObjects = levelLoader.getLevel(level);
    }

    public void restart()
    {
        restartLevel(currentLevel);
    }

    public void startNextLevel()
    {
        restartLevel(++currentLevel);
    }


    public void move(Direction direction)
    {
        Player player = gameObjects.getPlayer();

        if (checkWallCollision(player, direction))
        {
            return;
        }
        if (checkBoxCollision(direction))
        {
            return;
        }

        int sellSize = FIELD_SELL_SIZE;
        switch (direction)
        {
            case LEFT:
                player.move(-sellSize, 0);
                break;
            case RIGHT:
                player.move(sellSize, 0);
                break;
            case UP:
                player.move(0, -sellSize);
                break;
            case DOWN:
                player.move(0, sellSize);
        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction)
    {

        for (Wall wall : gameObjects.getWalls())
        {

            if (gameObject.isCollision(wall, direction))
            {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction)
    {

        Player player = gameObjects.getPlayer();

        GameObject stoped = null;
        for (GameObject gameObject : gameObjects.getAll())
        {
            if (!(gameObject instanceof Player) && !(gameObject instanceof com.javarush.test.level34.lesson15.big01.model.Home) && player.isCollision(gameObject, direction))
            {
                stoped = gameObject;
            }
        }

        if ((stoped == null))
        {
            return false;
        }
        if (stoped instanceof com.javarush.test.level34.lesson15.big01.model.Box)
        {
            com.javarush.test.level34.lesson15.big01.model.Box stopedBox = (com.javarush.test.level34.lesson15.big01.model.Box) stoped;
            if (checkWallCollision(stopedBox, direction))
            {
                return true;
            }
            for (com.javarush.test.level34.lesson15.big01.model.Box box : gameObjects.getBoxes())
            {
                if (stopedBox.isCollision(box, direction))
                {
                    return true;
                }
            }
            switch (direction)
            {
                case LEFT:
                    stopedBox.move(-FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_SELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_SELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_SELL_SIZE);
            }
        }
        return false;
    }

    public void checkCompletion()
    {
        boolean yes = true;

        for (Home home : gameObjects.getHomes())
        {
            boolean currentyes = false;

            for (Box box : gameObjects.getBoxes())
            {
                if ((box.getX() == home.getX()) && (box.getY() == home.getY()))
                    currentyes = true;
            }

            if (!currentyes) yes = false;
        }
        if (yes)
            eventListener.levelCompleted(currentLevel);
    }
}
