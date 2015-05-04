package voronoi;

import voronoi.fortunes_algorithm.FortunesAlgorithm;
import voronoi.fortunes_algorithm.Site;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.mygdx.game.MyGdxGame;

public class Voronoi extends ApplicationAdapter implements Screen {
	MyGdxGame game;
	private FortunesAlgorithm fa;
	SpriteBatch batch;
	ShapeRenderer sr;
	Texture img;
	BitmapFont fontPerso;
	LabelStyle style;
	Label titre;
	Stage stage;
	int nbc =0;

	public Voronoi(MyGdxGame g) {

		game = g;

	}





	@Override
	public void show() {
		Gdx.graphics.setDisplayMode(1000, 1000, false);

		fontPerso = new BitmapFont(Gdx.files.internal("default.fnt"));
		style = new LabelStyle(fontPerso, new Color(Color.CYAN));//fonte et couleur
		titre = new Label("2", style);

		// Create a new set of sites
		sr = new ShapeRenderer();
		fa = new FortunesAlgorithm(0, 0, 1000, 1000, 20);
		batch = new SpriteBatch();

	}

	@Override
	public void render(float delta) {

		stage = new Stage();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		for(Site s : fa.sites()) {
			sr.begin(ShapeRenderer.ShapeType.Filled);
			sr.setColor(Color.BLUE);
			sr.circle(s.location().x, s.location().y, 50);
			sr.setColor(Color.RED);
			sr.circle(s.location().x, s.location().y, 20);
			nbc++;
			sr.end();


			titre.setPosition(s.location().x,s.location().y);//positionne à l'écran

			stage.addActor(titre);
			stage.draw();
			//stage.act();
		}
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	
	public void actionAndroid(){
		  Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean keyDown(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer,
					int button) {
				titre.setText(String.valueOf(nbc));
				System.out.println(nbc);
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer,
					int button) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				// TODO Auto-generated method stub
				return false;
			}
			});
		  
		  }
}
