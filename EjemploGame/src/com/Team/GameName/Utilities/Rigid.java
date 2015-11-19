package com.Team.GameName.Utilities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public abstract class Rigid{
	//FIELDS
	private float positionX;
	private float positionY;
	private int width;
	private int height;
	private int widthImage;
	private int heightImage;
	private boolean repeat;
	private Animation currentAnimation;
	private Shape boundingBox;
	private Direction currentDirection = Direction.Right;
	public static enum Direction{
		Left,Right
	}
	
	//CONSTRUCTORS
	public Rigid() throws SlickException{
		init();
	}
	public Rigid(float positionX, float positionY) throws SlickException{
		this.positionX = positionX;
		this.positionY = positionY;
		init();
	}
	public Rigid(float positionX, float positionY, int width, int height) throws SlickException{
		this(positionX, positionY);
		this.width = width;
		this.height = height;
		this.widthImage = width;
		this.heightImage = height;
		this.boundingBox = new Rectangle(positionX, positionY, width, height);
		init();
	}
	public Rigid(float positionX, float positionY, int width, int height, int widthImage, int heightImage, boolean repeat) throws SlickException{
		this(positionX, positionY);
		this.width = width;
		this.height = height;
		this.widthImage = widthImage;
		this.heightImage = heightImage;
		this.repeat = repeat;
		init();
	}
	
	//METHODS
	/**
	 * Función que checa si hay colisión entre un objeto y si mismo.
	 * @param other Objeto con el que se desea checar si tiene una colisión.
	 * @return Regresa si encontró o no un objeto en colisión consigo mismo.
	 */
	public boolean intersects(Rigid other) {
	    return other.getBoundingBox() == null ? false : this.getBoundingBox().intersects(other.getBoundingBox());
	}
	
	//GETTERS AND SETTERS
	public Direction getDirection(){
		return this.currentDirection;
	}
	public void setDirection(Direction direction){
		this.currentDirection = direction;
	}
	public float getPositionX() {
		return positionX;
	}
	public void addPositionX(float deltaX){
		this.positionX += deltaX;
	}
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}
	public float getPositionY() {
		return positionY;
	}
	public void addPositionY(float deltaY){
		this.positionY -= deltaY;
	}
	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public int getWidthImage() {
		return this.widthImage;
	}
	public int getHeightImage() {
		return this.heightImage;
	}
	public boolean repeat() {
		return this.repeat;
	}
	public Animation getCurrentAnimation() {
		return currentAnimation;
	}
	public void setCurrentAnimation(Animation currentAnimation) {
		this.currentAnimation = currentAnimation;
	}	
	public Shape getBoundingBox() {
		return this.boundingBox;
	}
	public void setBoundingBox() {
		this.boundingBox = new Rectangle(this.positionX,this.positionY,this.width,this.height);
	}
	public void setBoundingBox(Shape shape) {
		this.boundingBox = shape;
	}
	public Animation getAnimation(Image i, int spriteX, int spriteY, int spriteWidth, int spriteHeight, int frames, int duration){
		Animation a = new Animation(false);
		for(int y = 0; y < spriteY; y++){
			for(int x = 0; x < spriteX; x++){
				a.addFrame(i.getSubImage(x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight), duration);
			}
		}
		return a;
	}
	
	//ABSTRACT METHODS
	/**
	 * Función que realiza las instrucciones que se desea ejecutar antes de crear el objeto.
	 * @throws SlickException
	 */
	public abstract void init() throws SlickException;
	/**
	 * Función que muestra algún grafico en la pantalla.
	 * @param controller Controlador que guarda las instancias de los objetos.
	 * @param g Los graficos con los que se desea poder mostrar algo en la pantalla.
	 * @throws SlickException
	 */
	public abstract void Render(Controller controller, Graphics g) throws SlickException;
	/**
	 * Función que Actualiza constantemente procesos del objeto.
	 * @param controller Controlador que guarda las instancias de los objetos.
	 * @param delta Tiempo transcurrido entre frames.
	 * @throws SlickException
	 */
	public abstract void Update(Controller controller, int delta) throws SlickException;
}
