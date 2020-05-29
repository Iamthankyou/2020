package com.duy.entity;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.duy.utils.Constants;

public class Tom implements Element {

	private Point x;
	private URL url = getClass().getResource("/com/duy/images/");
	
	public Tom(Point x) {
		this.x = x;
	}
	
	@Override
	public List<Element> movesPossible(Element[][] boardData) {
//		for (int i=0; i<7; i++) {
//			for (int j=0; j<5; j++) {
//				if (boardData[i][j] instanceof Hum) {
//					System.out.print(boardData[i][j].corr().getX()+"H"+boardData[i][j].corr().getY());
//				}
//				else if (boardData[i][j] instanceof BTom) {
//					System.out.print(boardData[i][j].corr().getX()+"B"+boardData[i][j].corr().getY());
//
//				}
//				else if (boardData[i][j] instanceof Tom) {
//					System.out.print(boardData[i][j].corr().getX()+"T"+boardData[i][j].corr().getY());
//				}
//				else {
//					System.out.print("###");
//				}
//			}
//			System.out.println();
//		}
		
		List<Element> moves = new ArrayList<>();
		int i = x.getX();
		int j = x.getY();
		
		if (( i-1>=0  && (i>=3 || j==2)) && boardData[i-1][j] instanceof Empty) {
			moves.add(boardData[i-1][j]);
		}
		
		if ((i+1<=6 && (i>=2 || j==2)) && boardData[i+1][j] instanceof Empty) {
			moves.add(boardData[i+1][j]);
		}

		if ((j-1>=0 && (j==2 || i>=2 || j==3)) && boardData[i][j-1] instanceof Empty) {
			moves.add(boardData[i][j-1]);
		}
		
		if ((j+1<=4 && (j==2 || i>=2 || j==1) ) && boardData[i][j+1] instanceof Empty) {
			moves.add(boardData[i][j+1]);
		}
		
		if (i+1<=6 && j+1 <=4  && (i-j==4||i-j==2||i-j==0||i-j==-2 && i!=1) && boardData[i+1][j+1] instanceof Empty) {
			moves.add(boardData[i+1][j+1]);
		}
		
		if (i-1>=0 && j-1 >=0 &&  (i-j==4||i-j==2||i-j==0||i-j==-2) && boardData[i-1][j-1] instanceof Empty) {
			moves.add(boardData[i-1][j-1]);
		}
		
		if (i-1>=0 && j+1<=4 && (i+j==2|| i+j==4||i+j==6||i+j==8) && boardData[i-1][j+1] instanceof Empty) {
			moves.add(boardData[i-1][j+1]);
		}
		
		if (i+1<=6 && j-1>=0 && ((i+j==2 && i!=1)|| i+j==4||i+j==6||i+j==8) && boardData[i+1][j-1] instanceof Empty) {
			moves.add(boardData[i+1][j-1]);
		}
		return moves;
	}

	@Override
	public Point corr() {
		return x;
	}

	public void setCorr(Point x) {
		this.x = x;
	}
}
