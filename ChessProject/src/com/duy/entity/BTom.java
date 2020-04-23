package com.duy.entity;

import java.net.URL;

import com.duy.utils.Constants;

import javafx.scene.image.Image;

public class BTom implements Element {

	private Point x;
	private URL url = getClass().getResource("/com/duy/images/");
	private Image image = new Image(url+"BTom01.png",Constants.squareSize,Constants.squareSize,true,true);
	
	public BTom(Point x) {
		this.x = x;
	}
	
	@Override
	public Element[] movesPossible() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point corr() {
		return x;
	}

	@Override
	public Image getImage() {
		return image;
	}


}
