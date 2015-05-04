package shape;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Classe qui se charge de créer une ligne entre deux points
 * 
 * @author trynobass
 *
 */
public class Ligne {

	private ShapeRenderer sr;

	/**
	 * Constructeur de la classe
	 */
	public Ligne() {
		sr = new ShapeRenderer();
	}

	/**
	 * Dessine une ligne entre deux points
	 * 
	 * @param x1
	 *            Ordonné X du premier point (Depart)
	 * @param y1
	 *            Ordonné Y du premier point (Depart)
	 * @param x2
	 *            Ordonné X du deuxième point (Arrivée)
	 * @param y2
	 *            Ordonné Y du deuxième point (Arrivée)
	 */
	public void dessiner(float x1, float y1, float x2, float y2) {
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.BLACK);
		sr.rectLine(x1, y1, x2, y2, 15);
		sr.end();
	}

}
