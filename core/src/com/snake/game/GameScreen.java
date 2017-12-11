package com.snake.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gabriel on 11/12/2017.
 */

public class GameScreen extends ScreenAdapter{
    private SpriteBatch batch;
    private Texture snakeHead;
    private static final float MOVE_TIME = 1F;
    private float timer = MOVE_TIME;
    private static final int SNAKE_MOVEMENT = 32;
    private int snakeX = 0, snakeY = 0;


    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
    private int snakeDirection = RIGHT;


    @Override
    public void show() {
        batch = new SpriteBatch();
        snakeHead = new Texture(Gdx.files.internal("snakehead.png"));
    }
    @Override
    public void render(float delta) {
        timer -= delta;
        if (timer <= 0) {
            timer = MOVE_TIME;
            snakeX += SNAKE_MOVEMENT;
        }

        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g,
                Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(snakeHead,snakeX,snakeY);
        batch.end();
    }

    private void checkForOutOfBounds() {
        if (snakeX >= Gdx.graphics.getWidth()) {
            snakeX = 0;
        }
        if (snakeX < 0) {
            snakeX = Gdx.graphics.getWidth() - SNAKE_MOVEMENT;
        }
        if (snakeY >= Gdx.graphics.getHeight()) {
            snakeY = 0;
        }
        if (snakeY < 0) {
            snakeY = Gdx.graphics.getHeight() - SNAKE_MOVEMENT;
        }
    }

    private void moveSnake() {
        switch (snakeDirection) {
            case RIGHT: {
                snakeX += SNAKE_MOVEMENT;
                return;
            }
            case LEFT: {
                snakeX -= SNAKE_MOVEMENT;
                return;
            }
            case UP: {
                snakeY += SNAKE_MOVEMENT;
                return;
            }
            case DOWN: {
                snakeY -= SNAKE_MOVEMENT;
                return;
            }
        }
    }
}
