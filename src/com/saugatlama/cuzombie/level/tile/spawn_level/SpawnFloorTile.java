package com.saugatlama.cuzombie.level.tile.spawn_level;

import com.saugatlama.cuzombie.graphics.Screen;
import com.saugatlama.cuzombie.graphics.Sprite;
import com.saugatlama.cuzombie.level.tile.Tile;

public class SpawnFloorTile extends Tile {

	public SpawnFloorTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4,  y << 4, this);
	}
}
