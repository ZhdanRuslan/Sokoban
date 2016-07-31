package Sokoban.model;

import com.javarush.test.level34.lesson15.big01.model.Box;
import com.javarush.test.level34.lesson15.big01.model.GameObject;
import com.javarush.test.level34.lesson15.big01.model.Home;
import com.javarush.test.level34.lesson15.big01.model.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ruslan on 31.07.16.
 */
public class GameObjects
{
    private Set<com.javarush.test.level34.lesson15.big01.model.Wall> walls;
    private Set<com.javarush.test.level34.lesson15.big01.model.Box> boxes;
    private Set<com.javarush.test.level34.lesson15.big01.model.Home> homes;
    private com.javarush.test.level34.lesson15.big01.model.Player player;

    public GameObjects(Set<com.javarush.test.level34.lesson15.big01.model.Wall> walls, Set<com.javarush.test.level34.lesson15.big01.model.Box> boxes, Set<com.javarush.test.level34.lesson15.big01.model.Home> homes, com.javarush.test.level34.lesson15.big01.model.Player player)
    {
        this.walls = walls;
        this.boxes = boxes;
        this.homes = homes;
        this.player = player;
    }

    public Set<com.javarush.test.level34.lesson15.big01.model.Wall> getWalls()
    {
        return walls;
    }

    public Set<Box> getBoxes()
    {
        return boxes;
    }

    public Set<Home> getHomes()
    {
        return homes;
    }

    public Player getPlayer()
    {
        return player;
    }

    public Set<com.javarush.test.level34.lesson15.big01.model.GameObject> getAll(){
        Set<GameObject> resultSet = new HashSet<>();
        resultSet.addAll(getWalls());
        resultSet.addAll(getBoxes());
        resultSet.addAll(getHomes());
        resultSet.add(getPlayer());
        return resultSet;
    }
}
