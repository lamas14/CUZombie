package com.saugatlama.cuzombie.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.saugatlama.cuzombie.entity.mob.Creeper;
import com.saugatlama.cuzombie.entity.mob.Dummy;

public class SpawnLevel extends Level {

	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class
					.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file.");
		}
		add(new Creeper(19, 26));
		for (int i = 0; i < 2; i++) {
			add(new Dummy(19, 26));
		}
	}

	protected void generateLevel() {
		System.out.println("Tiles[0] " + tiles[0]);

	}
}
