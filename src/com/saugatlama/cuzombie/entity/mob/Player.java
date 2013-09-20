package com.saugatlama.cuzombie.entity.mob;

import com.saugatlama.cuzombie.Game;
import com.saugatlama.cuzombie.entity.projectile.Projectile;
import com.saugatlama.cuzombie.entity.projectile.TrainerProjectile;
import com.saugatlama.cuzombie.graphics.AnimatedSprite;
import com.saugatlama.cuzombie.graphics.Screen;
import com.saugatlama.cuzombie.graphics.Sprite;
import com.saugatlama.cuzombie.graphics.SpriteSheet;
import com.saugatlama.cuzombie.input.Keyboard;
import com.saugatlama.cuzombie.input.Mouse;

public class Player extends Mob {

	private Sprite sprite;
	private Keyboard input;
	private int anim = 0;
	private boolean walking = false;
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.player_down,
			32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.player_up, 32,
			32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.player_left,
			32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.player_right,
			32, 32, 3);

	private AnimatedSprite animSprite = down;

	private int fireRate = 0;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_backward;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
		fireRate = TrainerProjectile.FIRERATE;
	}

	public void update() {
		if(walking) animSprite.update();
		else animSprite.setFrame(0);
		if (fireRate > 0)
			fireRate--;
		int xa = 0, ya = 0;
		
		if (input.up) {
			animSprite = up;
			ya--;
		}
		if (input.down) {
			animSprite = down;
			ya++;
		}
		if (input.left) {
			animSprite = left;
			xa--;
		}
		if (input.right) {
			animSprite = right;
			xa++;
		}
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		clear();
		updateShooting();

	}

	private void clear() {
		for (int i = 0; i < level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved())
				level.getProjectiles().remove(i);
		}
	}

	private void updateShooting() {

		if (Mouse.getButton() == 1 && fireRate <= 0) {
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
			fireRate = TrainerProjectile.FIRERATE;
		}

	}

	public void render(Screen screen) {
		int flip = 0;
		sprite = animSprite.getSprite();
		screen.renderMob(x - 16, y - 16, sprite, flip);

	}

}
