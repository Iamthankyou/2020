package com.duy.view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.duy.controller.GameController;
import com.duy.utils.Constants;
import com.duy.utils.Observable;
import com.duy.utils.Observer;

public class BoardView extends JFrame implements MouseListener, Observer {
	private PlayPanel playPanel;
	private MenuPanel menuPanel;
	private TaskBarPanel taskBarPanel;
	private LeftPanel leftPanel;
	private RightPanel rightPanel;
	private ChoosePlayer choosePlayer;
	private ChooseTeam chooseTeam;
	private GameController controller;
	private LegalView legalView;

	public BoardView() {
		new JFrame("Chess");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		controller = new GameController(this);
		playPanel = new PlayPanel(controller);
		menuPanel = new MenuPanel();
		taskBarPanel = new TaskBarPanel();
		leftPanel = new LeftPanel();
		rightPanel = new RightPanel();
		controller.getElementManager().add(playPanel);

		choosePlayer = new ChoosePlayer(controller);
		chooseTeam = new ChooseTeam(controller);
		legalView = new LegalView(controller);

		setSize(Constants.maxWidth, Constants.maxHeight);
		setLocation(100, 200);
//		setContentPane(new JLabel(new ImageIcon("/home/duy/2020/GameImplSwing/src/com/duy/images/board03.jpg")));
//		setLayout(new BorderLayout());
//		add(menuPanel,BorderLayout.NORTH);
//		add(playPanel,BorderLayout.CENTER);
//		add(taskBarPanel,BorderLayout.SOUTH);
//		add(leftPanel,BorderLayout.WEST);
//		add(rightPanel,BorderLayout.EAST);
//		
//		getContentPane().removeAll();
//		choosePlayer = new ChoosePlayer(controller);
//		setLayout(new BorderLayout());
//		add(menuPanel, BorderLayout.NORTH);
//		add(choosePlayer, BorderLayout.CENTER);
//		add(leftPanel, BorderLayout.WEST);
//		add(rightPanel, BorderLayout.EAST);
//		add(taskBarPanel, BorderLayout.SOUTH);
		
		showChoosePlayer();
	}

	public void showPlay() {
		getContentPane().removeAll();
		setLayout(new BorderLayout());
		add(menuPanel, BorderLayout.NORTH);
		add(playPanel, BorderLayout.CENTER);
		add(taskBarPanel, BorderLayout.SOUTH);
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);

		// Refresh
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void showLegal() {
		getContentPane().removeAll();
		setLayout(new BorderLayout());
		add(menuPanel, BorderLayout.NORTH);
		add(legalView, BorderLayout.CENTER);
		add(taskBarPanel, BorderLayout.SOUTH);
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);

		// Refresh
		SwingUtilities.updateComponentTreeUI(this);
	}

	public void showChoosePlayer() {
		getContentPane().removeAll();

		setLayout(new BorderLayout());
		add(menuPanel, BorderLayout.NORTH);
		add(choosePlayer, BorderLayout.CENTER);
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		add(taskBarPanel, BorderLayout.SOUTH);

		// Refresh
		SwingUtilities.updateComponentTreeUI(this);
	}

	public void showChooseTeam() {
		getContentPane().removeAll();

		setLayout(new BorderLayout());
		add(menuPanel, BorderLayout.NORTH);
		add(chooseTeam, BorderLayout.CENTER);
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		add(taskBarPanel, BorderLayout.SOUTH);

		// Refresh
		SwingUtilities.updateComponentTreeUI(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable o) {
		playPanel.update();
	}
}
