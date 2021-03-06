package Sokoban.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ruslan on 31.07.16.
 */
public class GameObjects
{
    private Set<Wall> walls;
    private Set<Box> boxes;
    private Set<Home> homes;
    private Player player;

    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player)
    {
        this.walls = walls;
        this.boxes = boxes;
        this.homes = homes;
        this.player = player;
    }

    public Set<Wall> getWalls()
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

    public Set<GameObject> getAll(){
        Set<GameObject> resultSet = new HashSet<>();
        resultSet.addAll(getWalls());
        resultSet.addAll(getBoxes());
        resultSet.addAll(getHomes());
        resultSet.add(getPlayer());
        return resultSet;
    }
}
