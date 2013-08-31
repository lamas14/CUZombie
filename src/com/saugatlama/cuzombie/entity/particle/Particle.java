package com.saugatlama.cuzombie.entity.particle;

import java.util.ArrayList;
import java.util.List;

import com.saugatlama.cuzombie.entity.Entity;
import com.saugatlama.cuzombie.graphics.Screen;
import com.saugatlama.cuzombie.graphics.Sprite;

public class Particle extends Entity{
	
	private List<Particle> particles = new ArrayList<Particle>();
	private Sprite sprite;
	
	private int life;
	
	public Particle(int x, int y, int life){
		this.x = x;
		this.y = y;
		this.life = life;
		sprite = Sprite.particle_normal;
		particles.add(this);
	}
	
	public Particle(int x, int y, int life, int amount){
		this(x, y, life);
		for(int i = 0; i <amount - 1; i++){
			particles.add(new Particle(x,y,life));
		}
	}
	
	public void update(){
	}
	
	public void render(Screen screen){
	}

}
