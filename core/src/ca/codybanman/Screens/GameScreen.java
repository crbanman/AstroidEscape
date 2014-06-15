package ca.codybanman.Screens;

import ca.codybanman.AEHelpers.InputHandler;
import ca.codybanman.GameWorld.GameRenderer;
import ca.codybanman.GameWorld.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {

	private GameWorld world;
	private GameRenderer renderer;
	private float runTime;

	public GameScreen() {

		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float gameWidth = 136;
		float gameHeight = screenHeight / (screenWidth / gameWidth);

		int midPointX = (int) (gameWidth / 2);
		int midPointY = (int) (gameHeight / 2);

		world = new GameWorld(midPointX, midPointY);
		renderer = new GameRenderer(world, (int) gameHeight, midPointY);
		Gdx.input.setInputProcessor(new InputHandler(world, renderer.getCam()));

	}

	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(runTime);
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("GameScreen - resizeing");
	}

	@Override
	public void show() {
		System.out.println("GameScreen - show called");
	}

	@Override
	public void hide() {
		System.out.println("GameScreen - hide called");
	}

	@Override
	public void pause() {
		System.out.println("GameScreen - pause called");
	}

	@Override
	public void resume() {
		System.out.println("GameScreen - resume called");
	}

	@Override
	public void dispose() {

	}

}