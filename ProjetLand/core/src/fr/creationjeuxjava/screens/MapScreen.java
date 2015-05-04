package fr.creationjeuxjava.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class MapScreen implements Screen {
	
	MyGdxGame game;
	
	public static float vitesse_zoom = 0.02f;
    public static float vitesse_deplacement_camera = 20;

    public static float max_zoom = 1f;    // maximum qu'on peut zoomer
    public static float min_zoom = 0.5f;  // minimum qu'on peut zoomer
     
    private int limite_image_maxHauteur ;  // limite déplacement camera
    private int limite_image_maxLargeur ;  // limite déplacement camera
    public static int limite_image_minHauteur = 0;    // limite déplacement camera
    public static int limite_image_minLargeur = 0 ;   // limite déplacement camera
   
   
    private int largeur_Ecran ;
    private int hauteur_Ecran ;
   
    private SpriteBatch batch;
    private Texture mapTexture;
    private OrthographicCamera camera;
   
    int x0,y0,x1,y1;  // position du premier et deuxième doigt
   
    int lastx0 ;      // précédente position du 1er doigt
    int lasty0 ;      // précédente position du 1er doigt
   
    int lastx1 ;      // précédente position du 2eme doigt posé sur l'écran
    int lasty1 ;      // précédente position du 2eme doigt posé sur l'écran
    
    private Sprite boutonRetourSprite;
    
    
    public MapScreen(MyGdxGame g) {

		game = g;

	}
   
   
    

    @Override
    public void dispose() {
    }

    @Override
    public void pause() {
    }

    

    @Override
    public void resize(int arg0, int arg1) {
    }
   
    @Override
    public void resume() {
    }
    
    //*********************** Manipuler la camera*******************************//

    public void manipulerCameraDesktop()
    {
           if(Gdx.input.isKeyPressed(Keys.UP))  // si on appuie sur la touche haut
           {
                 if(camera.position.y<limite_image_maxHauteur) // limiter déplacement vers haut
                 camera.translate(0, +1);
           }
           if(Gdx.input.isKeyPressed(Keys.DOWN))  // si on appuie sur la touche bas
           {
                 if(camera.position.y>limite_image_minHauteur)  // limiter déplacement vers bas
                 camera.position.y--;
                       
           }
           if(Gdx.input.isKeyPressed(Keys.RIGHT))  // si on appuie sur la touche droite
           {
             if(camera.position.x<limite_image_maxLargeur)  // limiter déplacement vers droite
              camera.position.x++;
           }
           if(Gdx.input.isKeyPressed(Keys.LEFT))  // si on appuie sur la touche gauche
           {
                 if(camera.position.x>limite_image_minLargeur)  // limiter déplacement vers gauche
                 camera.position.x--;
           }
           if(Gdx.input.isKeyPressed(Keys.Z))  // si on appuie sur la touche Z
           {
                 if(camera.zoom<max_zoom)  // limiter le zoom arrière
                 camera.zoom+=vitesse_zoom;
           }
           if(Gdx.input.isKeyPressed(Keys.E))// si on appuie sur la touche E
           {
                 if(camera.zoom>min_zoom)  // limiter le zoom avant
                 camera.zoom-=vitesse_zoom;
           }
           if(Gdx.input.isKeyPressed(Keys.R))// si on appuie sur la touche R
           {
                 camera.rotate(0.05f);   // rotation vers la gauche
           }
           if(Gdx.input.isKeyPressed(Keys.A))// si on appuie sur la touche A
           {
                 camera.rotate(-0.05f); //  rotation vers la droite
           }
           if(Gdx.input.isKeyPressed(Keys.M))// si on appuie sur la touche M
           {
                 if(camera.viewportWidth<1024)
                 camera.viewportWidth++;
           }
           if(Gdx.input.isKeyPressed(Keys.K))// si on appuie sur la touche K
           {
                 if(camera.viewportWidth>320)
                 camera.viewportWidth--;
           }
           if(Gdx.input.isKeyPressed(Keys.O))// si on appuie sur la touche O
           {
                 if(camera.viewportHeight<512)
                 camera.viewportHeight++;
           }
           if(Gdx.input.isKeyPressed(Keys.L))// si on appuie sur la touche L
           {
                 if(camera.viewportHeight>320)
                 camera.viewportHeight--;
           }
                       
           }

           public void manipulerCameraAndroid()
           {
                 Gdx.input.setInputProcessor(new InputProcessor() {
                       
                        @Override
                        public boolean touchUp(int x, int y, int pointer, int bouton) {
                        	
                        	if(x>0 && x<40 && y>0 && y<40)

            				{

            					// le bouton retour a été cliqué

                        		game.setScreen(new Menu(game));

            				}
                               return false;
                        }
                       
                        @Override
                        public boolean touchDown(int x, int y, int pointer, int bouton) {
                       
                               return false;
                        }
                       
                        @Override
                        public boolean touchDragged(int x, int y, int pointer) {
                       
                       
                 // ************** Saisir les coordonnées actuelles    ********************/
                               if(pointer==1) // Pour le 2eme doigt
                               {
                                      x1=x;
                                      y1=y;
                               }
                               if(pointer==0) // Pour le 1er doigt
                               {
                                      x0=x;
                                      y0=y;
                               }
                              
                 /*********** Opération : Zoom sur carte *******************************/
          
                 if(Gdx.input.isTouched(1)) // si deux doigt sont posés sur l'écran                                  
                	 {
           // Comparer entre la distance actuelle (entre les 2 doigts) et la distance précédente
           if(Math.pow(x0-x1,2)+Math.pow(y0-y1,2)>Math.pow(lastx0-lastx1,2)+Math.pow(lasty0-lasty1,2))
           {
                 if(camera.zoom>min_zoom)  // limite du zoom avant
                 camera.zoom-=vitesse_zoom;
           }
           else
           {
                 if(camera.zoom<max_zoom)  // limite du zoom arrière
                 camera.zoom+=vitesse_zoom;
           }
                	 } 
                              
                 /********** Operation : Déplacer camera avec un doigt ******************/
                       
           if(!Gdx.input.isTouched(1))             // si un seul doigt est posé sur l'écran
           {
                
                 // les quatres directions principales :
                 //-------------------------------------
           if(y0-lasty0>0 && x0-lastx0<5 &&  x0-lastx0>-5 )  // si drag vers haut avec tolérance sur x
           {
                  if(camera.position.y<limite_image_maxHauteur) // limite de la camera
                 {
                        camera.translate(0, vitesse_deplacement_camera);
                 }
           }
           else
           {
                 if(y0-lasty0<0 && x0-lastx0<5 &&  x0-lastx0>-5)   // Si drag vers bas
                 {
                    if(camera.position.y>limite_image_minHauteur) // Limite de la camera en bas
                    {
                        camera.translate(0, -vitesse_deplacement_camera);
                    }
                 }
           }
           if(x0-lastx0<0 && y0-lasty0>-5 && y0-lasty0<5)    // Si drag vers droite
           {
                 if(camera.position.x<limite_image_maxLargeur) // Limite de la camera a droite
                 {
                        camera.translate(vitesse_deplacement_camera, 0);
                 }
           }
           else
           {
                 if(x0-lastx0>0 && y0-lasty0>-5 && y0-lasty0<5)     // Si drag vers gauche
                 {
                        if(camera.position.x>limite_image_minLargeur)  // Limite de la camera à gauche
                        {
                               camera.translate(-vitesse_deplacement_camera, 0);
                        }
                 }
           }
           }
                              
           // ********* Sauvgarder les coordonnées ****************************/
                              
                               if(pointer==1) //  2eme doigt
                               {
                                     lastx1 = x1;
                                      lasty1 = y1;
                               }
                               if(pointer==0)//   1er doigt
                               {
                                      lastx0 = x0;
                                      lasty0 = y0;
                               }		

							
                               return false;
                        }
                       
                        @Override
                        public boolean scrolled(int arg0) {
                               // TODO Auto-generated method stub
                               return false;
                        }
                       
                        @Override
                        public boolean mouseMoved(int arg0, int arg1) {
                               // TODO Auto-generated method stub
                               return false;
                        }
                       
                        @Override
                        public boolean keyUp(int arg0) {
                               // TODO Auto-generated method stub
                               return false;
                        }
                       
                        @Override
                        public boolean keyTyped(char arg0) {
                               // TODO Auto-generated method stub
                               return false;
                        }
                       
                        @Override
                        public boolean keyDown(int arg0) {
                               // TODO Auto-generated method stub
                               return false;
                        }
                        
                        
                 });
           }


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
	          
	          boutonRetourSprite = new Sprite(new Texture(Gdx.files.internal("retour.png")));
	          boutonRetourSprite.setSize(40, 40);
	          
			
		}


		@Override
		public void render(float delta) {
			
			 GL20 gl = Gdx.graphics.getGL20(); 
		      gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  

		      gl.glViewport(0,0,largeur_Ecran,hauteur_Ecran);
		      //camera.apply(gl);  
		      
		      camera.update();   
		     
		      manipulerCameraAndroid();
		     
		      batch.setProjectionMatrix(camera.combined);
		   
		      batch.begin();
		      batch.draw(mapTexture, 0, 0);
		      
		      boutonRetourSprite.setPosition(0, 445);
		      boutonRetourSprite.draw(batch);
	          
		      batch.end();
			
		}


		@Override
		public void hide() {
			// TODO Auto-generated method stub
			
		}
          
                 
           

    }