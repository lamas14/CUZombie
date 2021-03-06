package com.saugatlama.cuzombie.entity;

import java.util.Random;

import com.saugatlama.cuzombie.graphics.Screen;
import com.saugatlama.cuzombie.graphics.Sprite;
import com.saugatlama.cuzombie.level.Level;

public class Entity {

	protected int x, y;
	protected Sprite sprite;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();

	public Entity() {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}

	public void update() {
	}

	public void render(Screen screen) {
		if (sprite != null)
			screen.renderSprite(x, y, sprite, true);
	}

	public void remove() {
		removed = true;
	}

	public Sprite getSprite(){
		return sprite;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public void init(Level level) {
		this.level = level;
	}
}
