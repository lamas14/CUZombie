package com.saugatlama.cuzombie.entity;

import java.util.Random;

import com.saugatlama.cuzombie.graphics.Screen;
import com.saugatlama.cuzombie.level.Level;

public abstract class Entity {
	
	public int x,y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update(){
	}
	
	public void render(Screen screen){
	}
	
	public void remove(){
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
	}
	
	public void init(Level level){
		this.level = level;
	}
}
