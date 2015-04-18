package com.RedNeckJP007.PorterPlayer;

import com.RedNeckJP007.PorterPlayer.Display.MainFrame;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

	FileInputStream FIS;
	BufferedInputStream BIS;

	public Player player;
	public long pauselocation;
	public long songTotalLength;

	public String filelocation;

	public void Stop() {
		if (player != null) {
			player.close();

			pauselocation = 0;
			songTotalLength = 0;
			filelocation = null;
			MainFrame.Display.setText("");

		}
	}

	public void Pause() {
		if (player != null) {
			try {
				pauselocation = FIS.available();
				player.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void Resume() {
		try {
			FIS = new FileInputStream(filelocation);
			BIS = new BufferedInputStream(FIS);

			player = new Player(BIS);

			FIS.skip(songTotalLength - pauselocation);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}

		new Thread() {
			public void run() {
				try {
					player.play();
				} catch (JavaLayerException e) {
					Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		}.start();

	}

	public void Play(String path) {
		try {
			FIS = new FileInputStream(path);
			BIS = new BufferedInputStream(FIS);

			player = new Player(BIS);

			songTotalLength = FIS.available();

			filelocation = path + "";

		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}

		new Thread() {
			public void run() {
				try {
					player.play();
					if (player.isComplete() && MainFrame.Loop_Swich == 1) {
						Play(filelocation);
					}

					if (player.isComplete()) {
						MainFrame.Display.setText("");
					}

				} catch (JavaLayerException e) {

				}
			}
		}.start();
	}

	public static void main(String[] e) {
		MainFrame MF = new MainFrame();
		MF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MF.setVisible(true);
		MF.setLocationRelativeTo(null);
		MainFrame.Display.setText("");
	}

}
