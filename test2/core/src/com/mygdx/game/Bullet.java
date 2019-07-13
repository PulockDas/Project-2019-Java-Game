package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class Bullet {
    /*public static final int Speed = 500;
    //public static final float d_x = 40;*/

    private static Texture texture;
    //float x, y;

    private Body b2body;

    //new
    PVector location;
    PVector velocity;
    PVector acceleration;

    float topspeed;


    //new

    public boolean remove = false;

    public Bullet(float x, float y){

        //new
        location = new PVector(x, y);
        velocity = new PVector(0, 0);
        topspeed = 5;


        //new

        if(texture == null)
            texture = new Texture("bullet.png");
        //System.out.println(Gdx.graphics.getHeight());
    }

    public void update (){

        //new
        float mx = Gdx.input.getX(), my = Gdx.input.getY();
        //System.out.println(mx+" "+my);

        PVector mouse = new PVector(mx, 480-my);
        PVector dir = PVector.sub(mouse, location);
        dir.normalize();
        dir.mult(.5f);
        acceleration = dir;

        velocity.add(acceleration);
        velocity.limit(topspeed);
        location.add(velocity);

        //new

        //x += Speed * d_time;

        if(location.x > Gdx.graphics.getWidth() || location.y > Gdx.graphics.getHeight() || location.y < 0)
            remove = true;

    }

    public void render (SpriteBatch batch)
    {
        batch.begin();
        batch.draw(texture, location.x, location.y);
        batch.end();
    }

    ///Souhardya
    private void defineBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.gravityScale = 0;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.bullet = true;
         b2body =

    }

}
