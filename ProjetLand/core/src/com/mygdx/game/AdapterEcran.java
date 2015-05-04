package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class AdapterEcran {

	public AdapterEcran(){
	}

	//methode perso set X tout les ecrans
	public static float setEcranPostX(float x){
		float largeur_ecran_actuel = Gdx.graphics.getWidth();
		float X = (x*largeur_ecran_actuel)/480;
		return X;				
	}

	//methode perso set Y tout les ecrans
	public static float setEcranPosY(float y){
		float hauteur_ecran_actuel = Gdx.graphics.getHeight();
		float Y = (y*hauteur_ecran_actuel)/320;
		return Y;		
	}

	//methode perso adapte largeur cercle
	public static float setEcranLargeur(float largeur){
		float largeur_ecran_actuel = Gdx.graphics.getWidth();
		float new_largeur= (largeur*largeur_ecran_actuel)/480;
		return new_largeur;	
	}

}
