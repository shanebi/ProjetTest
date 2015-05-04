package fr.creationjeuxjava.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TestScreen implements Screen {
	
	private int largeur_Ecran ;
    private int hauteur_Ecran ;
    
    private SpriteBatch batch;
    private Texture mapTexture;
    private OrthographicCamera camera;
    
    private int limite_image_maxHauteur ;  // limite déplacement camera
    private int limite_image_maxLargeur ;  // limite déplacement camera
    public static int limite_image_minHauteur = 0;    // limite déplacement camera
    public static int limite_image_minLargeur = 0 ;   // limite déplacement camera

	@Override
	public void show() {
		
		largeur_Ecran = Gdx.graphics.getWidth();
        hauteur_Ecran = Gdx.graphics.getHeight();
         
        batch = new SpriteBatch();
         
        mapTexture = new Texture(Gdx.files.internal("map.png"));
       
          camera = new OrthographicCamera(largeur_Ecran,hauteur_Ecran);
          camera.position.set(largeur_Ecran*0.5f, hauteur_Ecran*0.5f, 0);
          camera.update();
         
          limite_image_maxHauteur = mapTexture.getHeight() /2;
          limite_image_maxLargeur = mapTexture.getWidth() /2;
         
          limite_image_minHauteur = hauteur_Ecran/2;
          limite_image_minLargeur = largeur_Ecran/2;
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
