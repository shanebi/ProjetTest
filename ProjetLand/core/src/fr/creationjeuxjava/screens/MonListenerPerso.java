package fr.creationjeuxjava.screens;

import shape.Cercle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MonListenerPerso implements EventListener {

	public MonListenerPerso() {
		
	}

	@Override
	public boolean handle(Event event) {
		
		
		Cercle c;
		c = new Cercle(180, 200, 20);
		Dialog d = new Dialog("hello", new Skin());
		d.show(new Stage());
		
		System.out.println("OKOKOKOKOKOK");
		return false;
	}

}
