package com.jpgd.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jpgd.game.card_games.rule_sets.HigherOrLower;
import com.jpgd.game.states.EndGameState;
import com.jpgd.game.states.GSM;
import com.jpgd.game.states.HomeState;
import com.jpgd.game.states.NameInputState;
import com.jpgd.game.states.PlayState;

public class BasicGameSuite extends Game {

	/*
	Work on storing User data/saves/high scores
	 */

	public static final String TITLE = "Basic Game Suite";
	public static final int WIDTH = 800;		// Game is landscape, so longer width
	public static final int HEIGHT = 480;

	//private Preferences preferences;
	private SpriteBatch sb;
	private GSM gsm;
    private OrthographicCamera orthoCam;
    private Viewport viewport;
	private Skin skin;
	private BitmapFont font;

	private String playerName;

	
	@Override
	public void create () {
		Gdx.gl.glClearColor(1, 1, 1, 1);	// grey
		//preferences = Gdx.app.getPreferences("BasicGameSuitePreferences");
		sb = new SpriteBatch();
		gsm = new GSM();
        orthoCam = new OrthographicCamera(this.WIDTH, this.HEIGHT);
        viewport = new FitViewport(this.WIDTH, this.HEIGHT, orthoCam);
        //screenViewport = new ScreenViewport(orthoCam);
		skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		font = new BitmapFont();


		playerName = "";

		// using setScreen();
		this.setScreen(new HomeState(this));
		//this.setScreen(new NameInputState(this));

	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
        try {
			sb.dispose();
			skin.dispose();
			System.out.println("BasicGameSuite disposed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Getters
    public SpriteBatch getSpriteBatch() {
        return this.sb;
    }
	public GSM getGsm() {
		return this.gsm;
	}
    public OrthographicCamera getOrthoCam() {
        return orthoCam;
    }
    public Viewport getViewport() {
        return viewport;
    }
    public Skin getSkin() {
		return skin;
	}
    public BitmapFont getFont() {
        return font;
    }
	public String getPlayerName() {
		return playerName;
	}
}
