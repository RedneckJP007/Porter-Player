package com.RedNeckJP007.PorterPlayer.Display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainAbout extends JDialog {

	private static final long serialVersionUID = 1L;

	int MouseX;
	int MouseY;

	private final JPanel contentPanel = new JPanel();
	public static JLabel MainDrag = new JLabel("");
	public static JLabel Title_txt = new JLabel("");
	public static JLabel BackGround = new JLabel("");
	public static JLabel CloseBnt = new JLabel();

	public MainAbout() {
		setUndecorated(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setSize(400, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		CloseBnt = new JLabel();
		CloseBnt.setToolTipText("Close");
		CloseBnt.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				dispose();
			}

			public void mouseEntered(MouseEvent e) {
				CloseBnt.setIcon(new ImageIcon(MainAbout.class.getResource("/res/Backgrounds/close_1.png")));
			}

			public void mouseExited(MouseEvent e) {
				CloseBnt.setIcon(new ImageIcon(MainAbout.class.getResource("/res/Backgrounds/close_2.png")));
			}
		});
		CloseBnt.setIcon(new ImageIcon(MainAbout.class.getResource("/res/Backgrounds/close_2.png")));
		CloseBnt.setBounds(351, 9, 45, 18);
		contentPanel.add(CloseBnt);

		MainDrag = new JLabel("");
		MainDrag.addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - MouseX, y - MouseY);
			}
		});
		MainDrag.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				MainDrag.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				MainDrag.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(MouseEvent e) {
				MouseX = e.getX();
				MouseY = e.getY();

				MainDrag.setCursor(new Cursor(Cursor.MOVE_CURSOR));
			}

			public void mouseReleased(MouseEvent e) {
				MainDrag.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		MainDrag.setBounds(0, 0, 400, 21);
		contentPanel.add(MainDrag);

		Title_txt = new JLabel("ABOUT");
		Title_txt.setForeground(Color.LIGHT_GRAY);
		Title_txt.setHorizontalAlignment(SwingConstants.CENTER);
		Title_txt.setFont(new Font("Verdana", Font.BOLD, 14));
		Title_txt.setBounds(141, 7, 118, 14);
		contentPanel.add(Title_txt);
		
		JTextArea txtrPorterPlayerIs = new JTextArea();
		txtrPorterPlayerIs.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtrPorterPlayerIs.setLineWrap(true);
		txtrPorterPlayerIs.setText("Porter Player is A Mp3 player that does what you think plays MP3 files, its also my first project in java i ever made alone with no help.");
		txtrPorterPlayerIs.setEditable(false);
		txtrPorterPlayerIs.setBounds(10, 62, 380, 175);
		contentPanel.add(txtrPorterPlayerIs);
		
		JLabel Copyright_lbl = new JLabel("\u00A9 RedneckJP007 \u00A9");
		Copyright_lbl.setFont(new Font("Verdana", Font.BOLD, 14));
		Copyright_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		Copyright_lbl.setBounds(73, 263, 253, 26);
		contentPanel.add(Copyright_lbl);

		BackGround = new JLabel("");
		BackGround.setIcon(new ImageIcon(MainAbout.class.getResource("/res/Backgrounds/bg#2.png")));
		BackGround.setBounds(0, 0, 400, 300);
		contentPanel.add(BackGround);
	}
}
