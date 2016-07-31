package Sokoban.model;

import com.javarush.test.level34.lesson15.big01.model.Direction;
import com.javarush.test.level34.lesson15.big01.model.Model;

/**
 * Created by ruslan on 31.07.16.
 */
public abstract class CollisionObject extends com.javarush.test.level34.lesson15.big01.model.GameObject
{
    public CollisionObject(int x, int y)
    {
        super(x, y);
    }

    public boolean isCollision(com.javarush.test.level34.lesson15.big01.model.GameObject gameObject, Direction direction){
        boolean result = false;

        switch (direction) {

            case LEFT:
                if (getX() - com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY())
                    result = true;
                break;
            case RIGHT:
                if (getX() + com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY())
                    result = true;
                break;
            case UP:
                if (getX() == gameObject.getX() && getY() - com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE == gameObject.getY())
                    result = true;
                break;
            case DOWN:
                if (getX() == gameObject.getX() && getY() + Model.FIELD_SELL_SIZE == gameObject.getY())
                    result = true;
                break;
        }
        return result;
    }
}
