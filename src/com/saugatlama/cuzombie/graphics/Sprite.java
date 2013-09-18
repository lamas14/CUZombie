package com.saugatlama.cuzombie.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	private int width, height;
	public int[] pixels;
	protected SpriteSheet sheet;

	public static Sprite grass = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0);

	// spawn level sprites here
	public static Sprite spawn_grass = new Sprite(16, 0, 0,
			SpriteSheet.spawn_level);
	public static Sprite spawn_hedge = new Sprite(16, 1, 0,
			SpriteSheet.spawn_level);
	public static Sprite spawn_water = new Sprite(16, 2, 0,
			SpriteSheet.spawn_level);
	public static Sprite spawn_wall1 = new Sprite(16, 0, 1,
			SpriteSheet.spawn_level);
	public static Sprite spawn_wall2 = new Sprite(16, 0, 2,
			SpriteSheet.spawn_level);
	public static Sprite spawn_floor = new Sprite(16, 1, 1,
			SpriteSheet.spawn_level);

	// Player sprites here
	public static Sprite player_forward = new Sprite(32, 0, 5,
			SpriteSheet.tiles);
	public static Sprite player_backward = new Sprite(32, 2, 5,
			SpriteSheet.tiles);
	public static Sprite player_side = new Sprite(32, 1, 5, SpriteSheet.tiles);

	public static Sprite player_forward_1 = new Sprite(32, 0, 6,
			SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite(32, 0, 7,
			SpriteSheet.tiles);

	public static Sprite player_backward_1 = new Sprite(32, 2, 6,
			SpriteSheet.tiles);
	public static Sprite player_backward_2 = new Sprite(32, 2, 7,
			SpriteSheet.tiles);

	public static Sprite player_side_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite player_side_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);

	// projectile Sprites here
	public static Sprite projectile_trainer = new Sprite(16, 0, 0,
			SpriteSheet.projectile_Trainer);
	
	// Particles 
	public static Sprite particle_normal = new Sprite(3, 0xAAAAAA);

	protected Sprite(SpriteSheet sheet, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.sheet = sheet;
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int width, int height, int color) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColor(color);
	}

	public Sprite(int size, int color) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	public Sprite(int[] pixels, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	private void setColor(int color) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = color;
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y)
						* sheet.SIZE];
			}
		}
	}

}
