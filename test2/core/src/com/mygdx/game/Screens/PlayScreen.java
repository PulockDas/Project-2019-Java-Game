package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Bullet;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;

public class PlayScreen implements Screen {

    private MyGdxGame game;
    Texture texture;
    private World world;
    ArrayList <Bullet> bullets;
    float x, y;

    public PlayScreen(MyGdxGame game){

        this.game = game;
        x = 0;
        y = 0;
        bullets = new ArrayList<Bullet>();

        ///creating World
        world = new World(new Vector2(0.0f, -15f), true);



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //Shooting code
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            bullets.add(new Bullet(x+0, y + 0));
            //bullets.add(new Bullet(x+0, y + 50));
        }

        // Update bullets
        ArrayList <Bullet> bulletsToRemove = new ArrayList<Bullet>();
        for(Bullet bullet : bullets){
            bullet.update();
            if(bullet.remove)
                bulletsToRemove.add(bullet);

        }

        /*System.out.println(Gdx.graphics.getWidth());
        System.out.println(Gdx.graphics.getHeight());*/

        bullets.removeAll(bulletsToRemove);

        //Movement code

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        for(Bullet bullet : bullets){
            bullet.render(game.batch);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
