package com.saugatlama.cuzombie.entity.spawner;

import com.saugatlama.cuzombie.entity.Entity;
import com.saugatlama.cuzombie.entity.particle.Particle;
import com.saugatlama.cuzombie.level.Level;

public class Spawner extends Entity {

	
	public enum Type {
		MOB, PARTICLE;
	}

	private Type type;

	public Spawner(int x, int y, Type type, int amount, Level level) {
		this.x = x;
		this.y = y;
		this.type = type;
		init(level);
	}

}
