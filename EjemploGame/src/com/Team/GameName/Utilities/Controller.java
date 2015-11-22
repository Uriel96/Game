package com.Team.GameName.Utilities;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

import com.Team.GameName.Utilities.Rigid.Direction;

public final class Controller{
	
	private static Iterator<Rigid> i;
	private static boolean gameOver = false;
	
	private static float positionX;
	private static float positionY;
	private static int score;

	private static int width;
	private static int height;
	public static HashSet<Rigid> objects = null;
	private static Controller instance = null;
	
	private Controller(int width, int height){
		Controller.width = width;
		Controller.height = height;
		Controller.objects = null;
		Controller.objects = new HashSet<Rigid>();
		Controller.i = null;
		Controller.gameOver = false;
		Controller.score = 0;
		Controller.positionX = 0;
		Controller.positionY = 0;
	}
	
	public static void newInstance(int width, int height){
		instance = new Controller(width, height);
	}

	public static Controller getInstance(){
		return instance;
	}
	
	public static void iterate(){
		Controller.i = Controller.objects.iterator();
	}
	
	public static boolean hasNext(){
		return Controller.i.hasNext();
	}
	
	public static Rigid next(){
		return Controller.i.next();
	}
	
	public static void add(Rigid ob){
		Controller.objects.add(ob);
	}
	
	public static void addAll(LinkedList<? extends Rigid> ob){
		objects.addAll(ob);
	}
	
	public static <T> T checkCollision(Rigid ob, float deltaX, float deltaY, Class<T> cls) throws SlickException{
		ob.setBoundingBox(new Rectangle(ob.getPositionX()+deltaX,ob.getPositionY()+deltaY,ob.getWidth(),ob.getHeight()));
		for(Rigid other : objects){
			if(ob != other && cls.isInstance(other) && ob.intersects(other)){
				return cls.cast(other);
			}
		}
		return null;
	}
	
	public static <T> LinkedList<T> checkCollisionList(Rigid ob, float deltaX, float deltaY, Class<T> cls) throws SlickException{
		ob.setBoundingBox(new Rectangle(ob.getPositionX()+deltaX,ob.getPositionY()+deltaY,ob.getWidth(),ob.getHeight()));
		LinkedList<T> list = new LinkedList<T>();
		for(Rigid other : objects){
			if(ob != other && ob.intersects(other)){
				list.add(cls.cast(other));
			}
		}
		return (list.size() == 0) ? null : list;
	}
	
	public static <T> T doRayCast(Rigid ob, float range, float width, Class<T> cls) {
		Rectangle ray = new Rectangle(ob.getDirection() == Direction.Right ? ob.getPositionX() : ob.getPositionX()-range, ob.getPositionY()-(width/2),range, width);
		float distance = 0;
		T object = null;
		for(Rigid other : objects){
			if(ob != other && cls.isInstance(other) && ray.intersects(other.getBoundingBox())){
				float newDistance = getRange(ob, other);
				if(distance <= 0 || newDistance < distance){
					distance = newDistance;
					object = cls.cast(other);
				}
			}
		}
		return object;
	}
	
	public static <T> LinkedList<T> doRayCastList(Rigid ob, float rayX, float rayY, float range, Class<T> cls) {
		
		Rectangle ray = new Rectangle(rayX, rayY, ob.getDirection() == Direction.Right ? range : -range, 3);
		LinkedList<T> list = new LinkedList<T>();
		for(Rigid other : objects){
			if(ob != other && cls.isInstance(other) && ray.intersects(other.getBoundingBox())){
				list.add(cls.cast(other));
			}
		}
		return (list.size() == 0) ? null : list;
	}

	public static <T> LinkedList<T> checkRangeList(Rigid ob, float rangeX, float rangeY, float radius, Class<T> cls) {
		Circle range = new Circle(rangeX, rangeY, radius);
		LinkedList<T> list = new LinkedList<T>();
		for(Rigid other : objects){
			if(ob != other && cls.isInstance(other) && range.intersects(other.getBoundingBox())){
				list.add(cls.cast(other));
			}
		}
		return (list.size() == 0) ? null : list;
	}
	
	public static <T> T checkRange(Rigid ob, float rangeX, float rangeY, float radius, Class<T> cls) {
		Circle range = new Circle(rangeX,rangeY,radius);
		for(Rigid other : objects){
			if(ob != other && cls.isInstance(other) && range.intersects(other.getBoundingBox())){
				return cls.cast(other);
			}
		}
		return null;
	}
	
	public static float getRange (Rigid ob, Rigid target) {
		return (float) Math.sqrt(Math.pow(ob.getPositionX() - target.getPositionX(), 2) + Math.pow(ob.getPositionY() - target.getPositionY(), 2));
	}
	
	public static void deleteControl(Rigid ob) {
		objects.remove(ob);
		Controller.i = Controller.objects.iterator();
	}
	
	public static <T> boolean deleteControl(Class<T> cls) {
		boolean found = false;
		for(Rigid other : objects){
			if (cls.isInstance(other)) {
				objects.remove(other);
				found = true;
			}
		}
		return found;
	}
	
	public static void follow(Rigid ob, float deltaX, float deltaY){
		if(ob.getPositionX() > 300 && ob.getPositionX() < width-300){
			positionX = ob.getPositionX()-300;
		}
	}
	
	
	//GETTERS AND SETTERS
	public static boolean isGameOver() {
		return gameOver;
	}
	public static void GameOver() {
		Controller.gameOver = true;
	}
	public static void resetGameOver() {
		Controller.gameOver = false;
	}
	public static float getPositionX() {
		return positionX;
	}
	public static void setPositionX(float positionX) {
		Controller.positionX = positionX;
	}
	public static float getPositionY() {
		return positionY;
	}
	public static void setPositionY(float positionY) {
		Controller.positionY = positionY;
	}
	public static int getScore() {
		return score;
	}
	public static void addScore(int points) {
		score += points;
	}
	public static int getWidth() {
		return width;
	}
	public static int getHeight() {
		return height;
	}
}