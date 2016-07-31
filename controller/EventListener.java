package Sokoban.controller;

import com.javarush.test.level34.lesson15.big01.model.Direction;

/**
 * Created by ruslan on 31.07.16.
 */
public interface EventListener
{
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);
}
