package com.saugatlama.cuzombie.entity.projectile;

import com.saugatlama.cuzombie.entity.spawner.ParticleSpawner;
import com.saugatlama.cuzombie.graphics.Screen;
import com.saugatlama.cuzombie.graphics.Sprite;

public class TrainerProjectile extends Projectile {

	public static final int FIRERATE = 23; // Higher is slower

	public TrainerProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 100;
		speed = 3;
		damage = 20;
		sprite = Sprite.projectile_trainer;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void update() {
		if ((level.tileCollision((int)(x + nx), (int)(y + ny), 8, 8, 4))) {
			level.add(new ParticleSpawner((int) x, (int) y, 44, 50, level));
			remove();
		}
		move();
	}

	protected void move() {
		x += nx;
		y += ny;
		if (distance() > range)
			remove();
	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y)
				* (yOrigin - y)));
		return dist;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 5, (int) y - 2, this);
	}
}
