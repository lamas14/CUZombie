package com.saugatlama.cuzombie.entity.projectile;

import java.util.Random;

import com.saugatlama.cuzombie.entity.Entity;
import com.saugatlama.cuzombie.graphics.Sprite;

public abstract class Projectile extends Entity{

	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x, y;
	protected double nx, ny;
	protected double speed, range, damage;
	
	protected final Random random = new Random();
	
	public Projectile(int x, int y, double dir){
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	
	public Sprite getSprite(){
		return sprite;
	}
	
	public int getSpriteSize(){
		return sprite.SIZE;
	}
	
	protected void move(){
	}
}
