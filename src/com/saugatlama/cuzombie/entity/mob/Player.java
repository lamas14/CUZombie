package com.saugatlama.cuzombie.entity.mob;

import com.saugatlama.cuzombie.graphics.Screen;
import com.saugatlama.cuzombie.graphics.Sprite;
import com.saugatlama.cuzombie.input.Keyboard;

public class Player extends Mob{
	
	private Sprite sprite;
	private Keyboard input;
	private int anim = 0;
	private boolean walking = false;
	
	public Player(Keyboard input){
		this.input = input;
		sprite = Sprite.player_backward;
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update(){
		int xa = 0, ya = 0;
		if(anim<7500) anim++; 
		else anim = 0;
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		
		if(xa != 0 || ya != 0) {
			move(xa,ya);
			walking = true;
		}
		else{
			walking = false;
		}
		
	}
	
	public void render(Screen screen){
		int flip = 0;
		if(dir==0) {
			sprite = Sprite.player_forward;
			if(walking){
				if(anim%20 > 10){
					sprite = Sprite.player_forward_1;
				}
				else{
					sprite = Sprite.player_forward_2;
				}
			}
		}
		if(dir==1) {
			sprite = Sprite.player_side;
			if(walking){
				if(anim%20 > 10){
					sprite = Sprite.player_side_1;
				}
				else{
					sprite = Sprite.player_side_2;
				}
			}
		}
		if(dir==2) {
			sprite = Sprite.player_backward;
			if(walking){
				if(anim%20 > 10){
					sprite = Sprite.player_backward_1;
				}
				else{
					sprite = Sprite.player_backward_2;
				}
			}
		}
		if(dir==3) {
			sprite = Sprite.player_side;
			if(walking){
				if(anim%20 > 10){
					sprite = Sprite.player_side_1;
				}
				else{
					sprite = Sprite.player_side_2;
				}
			}
			flip = 1;
		}
		screen.RenderPlayer(x-16, y-16, sprite, flip);
		
	}
	
}
