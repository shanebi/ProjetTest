package com.mygdx.game;


import com.badlogic.gdx.Game;

import fr.creationjeuxjava.screens.Menu;



public class MyGdxGame extends Game{

	@Override
	public void create() {

		setScreen(new Menu(this));

	}



}