package com.Uriel.Ejemplo.Game;

import java.util.ArrayList;

public class Control extends ArrayList<GameObject>{
	
	public Control(){
		
	}
	
	/*public boolean checkCollision(GameObject ob, float deltaX){
		float izquierda = ob.positionX + ob.bounds[0] + deltaX;
		float derecha = ob.positionX + ob.bounds[2] + deltaX;
		float contador = 0;
		for(GameObject other : this){
			if(other != ob){
				float otroIzquierda = other.positionX+other.bounds[0];
				float otroDerecha =  other.positionX+other.bounds[2];
				
				if(checkCollision(izquierda, derecha, otroIzquierda, otroDerecha))
				{
					return true;
				}
			}
		}
		return false;
	}*/
	
	public boolean checkCollision(GameObject ob, float deltaX){
		for(GameObject other : this){
			if(ob != other){
				if(ob.intersects(other)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkCollision(float posO1X1, float posO1X2, float posO2X1, float posO2X2){
		if(posO1X2 < posO2X1) return false;
		if(posO1X1 > posO2X2) return false;
		return true;
	}
}