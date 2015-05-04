package shape;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.mygdx.game.AdapterEcran;

/**
 * Classe qui se charge de créer un cercle
 * 
 * @author trynobass
 *
 */
public class Cercle extends Actor{

	private float x, y, radius;
	private ShapeRenderer sr;
	private Color couleur ;

	private Label lbl;
	private LabelStyle lblStyle;
	private BitmapFont bFont;
	private Stage stage;

	/**
	 * Constructeur de la classe
	 * 
	 * @param x
	 *            Coordonnée x du cercle
	 * @param y
	 *            Coordonnée y du cercle
	 * @param radius
	 *            Taille du cercle
	 */
	public Cercle(float x, float y, float radius) {
		this.x = AdapterEcran.setEcranPostX(x);
		this.y = AdapterEcran.setEcranPosY(y);
		this.radius = AdapterEcran.setEcranLargeur(radius);
		sr = new ShapeRenderer();
		bFont = new BitmapFont(Gdx.files.internal("default.fnt"));
		lblStyle = new LabelStyle(bFont, Color.WHITE);
		lbl = new Label(null, lblStyle);
		stage = new Stage();
	}

	/**
	 * Méthode qui affiche le cercle
	 * 
	 * @param batch
	 *            SpriteBatch du screen
	 * @param couleur
	 *            Couleur du cercle
	 * @param txt
	 *            Texte à l'intérieur du cercle
	 * 
	 */
	public void dessiner(SpriteBatch batch, Color couleur, String txt) {

		bFont.scale(1f); //Taille de la police de caractère

		sr.begin(ShapeRenderer.ShapeType.Filled);

		//Premier cercle qui va servir de bordure noir
		sr.setColor(Color.BLACK);
		sr.circle(x, y, radius);

		//Deuxième cercle avec la couleur du joueur
		sr.setColor(couleur);
		sr.circle(x, y, radius-10);


		sr.end();

		lbl.setText(txt);
		lbl.setPosition(getX()-10, getY());

		stage.addActor(lbl);
		stage.draw();

	}

	/**
	 * Retourne l'ordonné X du cercle
	 */
	public float getX() {
		return x;
	}

	/**
	 * Retourne l'ordonné Y du cercle
	 */
	public float getY() {
		return y;
	}

	/**
	 * Retourne la couleur du cercle
	 * @return Couleur du cercle
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * Défini une couleur au cercle
	 * @param couleur La couleur que l'on souhaite afficher
	 */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}


}
