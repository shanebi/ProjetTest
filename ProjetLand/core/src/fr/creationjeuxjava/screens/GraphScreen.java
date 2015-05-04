package fr.creationjeuxjava.screens;

import java.util.Vector;

import shape.Cercle;
import shape.Ligne;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MyGdxGame;

/**
 * Affiche des cercles à des positions prédéfini.
 * 
 * @author trynobass
 *
 */
public class GraphScreen implements Screen {

	private MyGdxGame game;
	private SpriteBatch batch;
	private Stage stage;

	
	private int nbC =0;
	private Vector<Cercle> TCercle = new Vector<Cercle>();


	private float x ;
	private float y ;

	private boolean dep = false;
	private float x1 ;
	private float y1 ;
	boolean visible = false;

	Vector<Vector<Float>> contenu = new Vector<Vector<Float>>();


	/**
	 * Constructeur de la classe
	 * 
	 * @param game
	 * La variable du jeu
	 */
	public GraphScreen(MyGdxGame game) {
		this.game = game;
	}

	@Override
	public void show() {

		batch = new SpriteBatch();
		stage = new Stage();

		//cercles
		TCercle.add(new Cercle(40, 50, 30));
		TCercle.add(new Cercle(300, 100, 30));
		TCercle.add(new Cercle(100, 300, 30));


		//ajouter au stage
		while(nbC < TCercle.size()){
			stage.addActor(TCercle.get(nbC));
			nbC++;
		}
		nbC =0;
		stage.draw();	

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		//toucher au doigt
		calculePoint();


		//l3.dessiner(x, y, x1, y1);
		/*if(visible){
			//Ligne l4 = new Ligne();
			new Ligne().dessiner(contenu.get(contenu.size()-1).get(0), contenu.get(contenu.size()-1).get(1), 
					contenu.get(contenu.size()-1).get(2), contenu.get(contenu.size()-1).get(3));
			
		}*/

		if(visible){while(nbC < contenu.size()){

			Ligne l4 = new Ligne();
			l4.dessiner(contenu.get(nbC).get(0), contenu.get(nbC).get(1), 
					contenu.get(nbC).get(2), contenu.get(nbC).get(3));

			nbC++;}
		}nbC=0;


		while(nbC < TCercle.size()){
			TCercle.get(nbC).dessiner(batch, Color.RED, ""+nbC);
			nbC++;
		}
		nbC=0;
		
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
		stage.dispose();
		batch.dispose();
	}

	//methode perso set X tout les ecrans
	public float getEcranPostX(float x){
		float largeur_ecran_actuel = Gdx.graphics.getWidth();
		float X = (x*largeur_ecran_actuel)/480;
		return X;				
	}

	//methode perso set Y tout les ecrans
	public float getEcranPosY(float y){
		float hauteur_ecran_actuel = Gdx.graphics.getHeight();
		float Y = (y*hauteur_ecran_actuel)/320;
		return Y;		
	}

	//methode perso adapte largeur cercle
	public float getEcranLargeur(float largeur){
		float largeur_ecran_actuel = Gdx.graphics.getWidth();
		float new_largeur= (largeur*largeur_ecran_actuel)/480;
		return new_largeur;	
	}

	public void calculePoint(){

		if (Gdx.input.isTouched()){

			if(!dep){
				x = Gdx.input.getX();
				y = (Gdx.graphics.getHeight()-Gdx.input.getY());

				while(nbC < TCercle.size()){
					if(x< TCercle.get(nbC).getX()+25 && x> TCercle.get(nbC).getX()-25 && y< TCercle.get(nbC).getY()+25  && y> TCercle.get(nbC).getY()-25){
						x = Gdx.input.getX();
						y = (Gdx.graphics.getHeight()-Gdx.input.getY());
						dep= true;
						System.out.println("prem's");
					}
					nbC++;
				}
				nbC=0;
				

			}

			else if(dep){
				x1 = Gdx.input.getX();
				y1 = (Gdx.graphics.getHeight()-Gdx.input.getY());

				while(nbC < TCercle.size()){
					if(x1< TCercle.get(nbC).getX()+25 && x1> TCercle.get(nbC).getX()-25 && y1< TCercle.get(nbC).getY()+25  && y1> TCercle.get(nbC).getY()-25){
						if(x!=x1)
						if(zoneVerification(x,y,x1,y1)){
						Vector<Float> ligne = new Vector<Float>();
						ligne.add(x);
						ligne.add(y);
						ligne.add(x1);
						ligne.add(y1);
						contenu.add(ligne);
						System.out.println(contenu);
						visible=true;
						dep=false;
						}
					}
					nbC++;
				}
				nbC=0;

			}

		}
	}
	
	public boolean zoneVerification(float x,float y,float x1,float y1){
		boolean unisiter = true;

		for(int i=0;i<contenu.size();i++){
			if(contenu.get(i).get(0).equals(x) && contenu.get(i).get(1).equals(y) && contenu.get(i).get(2).equals(x1) && contenu.get(i).get(3).equals(y1)){
				unisiter = false;
			}
		}
		return unisiter;

	}

}
