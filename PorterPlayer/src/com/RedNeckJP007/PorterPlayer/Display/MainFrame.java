package com.RedNeckJP007.PorterPlayer.Display;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import com.RedNeckJP007.PorterPlayer.MainClass;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.io.File;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private MainClass mc = new MainClass();
    private MainAbout ma = new MainAbout();

    public static JLabel Display = new JLabel("(Test, if you see this just play a song)");
    public static JLabel Loop_display = new JLabel("Loop Is Off");
    public static JLabel background = new JLabel("");
    public static JLabel Display_background = new JLabel("");
    public static JLabel Stop_txt = new JLabel("Stop --->");
    public static JLabel Version_txt = new JLabel("PorterPlayer_V/5.0");
    public static JLabel Title_txt = new JLabel("PORTER PLAYER");
    public static JLabel OpenFile_txt = new JLabel("<--- Open File");
    public static JLabel Stop_bnt = new JLabel("");
    public static JLabel Open_bnt = new JLabel("");
    public static JLabel Loop_bnt = new JLabel("");
    public static JLabel Pause_bnt = new JLabel("");
    public static JLabel Minimise_bnt = new JLabel("");
    public static JLabel Close_bnt = new JLabel("");
    public static JLabel drag_win = new JLabel("");

    public static FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");
    public static String userhome = System.getProperty("user.home");
    public static JFileChooser chooser = new JFileChooser(userhome + "\\Music");

    public static int MouseX;
    public static int MouseY;

    public static int Display_Swich;
    public static int Play_Swich;
    public static int Loop_Swich;

    public MainFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        setTitle("Porter Player");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/res/Backgrounds/profile_pic.png")));
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        drag_win.addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - MouseX, y - MouseY);
            }
        });

        drag_win.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
            	drag_win.setCursor(new Cursor(Cursor.MOVE_CURSOR));
                MouseX = e.getX();
                MouseY = e.getY();
            }

            public void mouseEntered(MouseEvent e) {
            	drag_win.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                drag_win.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        	@Override
        	public void mouseReleased(MouseEvent arg0) {
        		drag_win.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        		
        	}
        });

        Close_bnt.setHorizontalAlignment(SwingConstants.CENTER);
        Close_bnt.setToolTipText("Close");
        Close_bnt.addMouseListener(new MouseAdapter() {

            public void mouseReleased(MouseEvent e) {
                System.exit(0);
            }

            public void mouseEntered(MouseEvent e) {
                Close_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/close_1.png")));
                Close_bnt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                Close_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/close_2.png")));
                Close_bnt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        Close_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/close_2.png")));
        Close_bnt.setBounds(746, 39, 44, 20);
        contentPane.add(Close_bnt);

        Minimise_bnt.setHorizontalAlignment(SwingConstants.CENTER);
        Minimise_bnt.addMouseListener(new MouseAdapter() {

            public void mouseExited(MouseEvent e) {
                Minimise_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/min_1.png")));
                Minimise_bnt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mouseEntered(MouseEvent e) {
                Minimise_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/min_2.png")));
                Minimise_bnt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseReleased(MouseEvent e) {
                setState(Frame.ICONIFIED);
            }
        });

        Minimise_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/min_1.png")));
        Minimise_bnt.setToolTipText("Minimize");
        Minimise_bnt.setBounds(709, 39, 30, 20);
        contentPane.add(Minimise_bnt);

        Pause_bnt.setToolTipText("");
        Pause_bnt.addMouseListener(new MouseAdapter() {

            public void mouseReleased(MouseEvent e) {

                switch (Play_Swich) {
                    case 0:
                        // pause
                        Pause_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/Resume.png")));
                        Play_Swich = 1;
                        mc.Pause();
                        break;
                    case 1:
                        // resume
                        Pause_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/play.png")));
                        Play_Swich = 0;
                        mc.Resume();
                        break;
                }

            }

            public void mouseEntered(MouseEvent e) {
                Pause_bnt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                Pause_bnt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        Pause_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/play.png")));
        Pause_bnt.setHorizontalAlignment(SwingConstants.CENTER);
        Pause_bnt.setBounds(370, 382, 58, 53);
        contentPane.add(Pause_bnt);

        Loop_bnt.setToolTipText("Loop Off");
        Loop_bnt.addMouseListener(new MouseAdapter() {

            public void mouseReleased(MouseEvent e) {

                switch (Loop_Swich) {
                    case 0:
                        // Loop is On
                        Loop_Swich = 1;
                        Loop_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/loop_on.png")));
                        Loop_display.setText("Loop Is On");
                        Loop_bnt.setToolTipText("Loop On");

                        break;
                    case 1:
                        // Loop is Off
                        Loop_Swich = 0;
                        Loop_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/loop_off.png")));
                        Loop_display.setText("Loop Is Off");
                        Loop_bnt.setToolTipText("Loop Off");
                        break;
                }
            }

            public void mouseEntered(MouseEvent e) {
                Loop_bnt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                Loop_bnt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        Loop_display.setFont(new Font("Verdana", Font.BOLD, 12));
        Loop_display.setHorizontalAlignment(SwingConstants.CENTER);
        Loop_display.setBounds(361, 284, 77, 32);
        contentPane.add(Loop_display);
        Loop_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/loop_off.png")));
        Loop_bnt.setHorizontalAlignment(SwingConstants.CENTER);
        Loop_bnt.setBounds(375, 328, 50, 43);
        contentPane.add(Loop_bnt);

        Open_bnt.setToolTipText("Open");
        Open_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/open.png")));
        Open_bnt.addMouseListener(new MouseAdapter() {

            public void mouseReleased(MouseEvent e) {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                String userhome = System.getProperty("user.home");

                chooser = new JFileChooser(userhome + "\\Music");
                chooser.addChoosableFileFilter(filter);
                chooser.setFileFilter(filter);

                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    mc.Stop();
                    File myFile = chooser.getSelectedFile();
                    String song = myFile + "";
                    String name = chooser.getSelectedFile().getName();
                    Display.setText(name);
                    mc.Play(song);
                }
            }

            public void mouseEntered(MouseEvent e) {
                Open_bnt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                Open_bnt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        Open_bnt.setHorizontalAlignment(SwingConstants.CENTER);
        Open_bnt.setBounds(420, 382, 50, 53);
        contentPane.add(Open_bnt);

        Stop_bnt.setToolTipText("Stop");
        Stop_bnt.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/Stop.png")));
        Stop_bnt.addMouseListener(new MouseAdapter() {

            public void mouseReleased(MouseEvent e) {
                mc.Stop();
            }

            public void mouseEntered(MouseEvent e) {
                Stop_bnt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                Stop_bnt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        Stop_bnt.setHorizontalAlignment(SwingConstants.CENTER);
        Stop_bnt.setBounds(320, 382, 58, 53);
        contentPane.add(Stop_bnt);

        OpenFile_txt.setFont(new Font("Verdana", Font.BOLD, 12));
        OpenFile_txt.setHorizontalAlignment(SwingConstants.CENTER);
        OpenFile_txt.setBounds(480, 392, 95, 33);
        contentPane.add(OpenFile_txt);

        Stop_txt.setHorizontalAlignment(SwingConstants.CENTER);
        Stop_txt.setFont(new Font("Verdana", Font.BOLD, 12));
        Stop_txt.setBounds(236, 392, 95, 33);
        contentPane.add(Stop_txt);
        Version_txt.setToolTipText("HI !!");

        Version_txt.addMouseListener(new MouseAdapter() {

            public void mouseReleased(MouseEvent e) {
                ma = new MainAbout();
                ma.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ma.setVisible(true);
                ma.setLocationRelativeTo(null);
                
            }

            public void mouseEntered(MouseEvent e) {
                Version_txt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                Version_txt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        Version_txt.setFont(new Font("Verdana", Font.BOLD, 12));
        Version_txt.setHorizontalAlignment(SwingConstants.CENTER);
        Version_txt.setBounds(643, 557, 147, 32);
        contentPane.add(Version_txt);
        Display.setForeground(Color.BLUE);

        Display.setHorizontalAlignment(SwingConstants.CENTER);
        Display.setFont(new Font("Verdana", Font.BOLD, 14));
        Display.setBounds(125, 140, 565, 33);
        contentPane.add(Display);

        Display_background.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/Display_backgorund_2.png")));
        Display_background.setHorizontalAlignment(SwingConstants.CENTER);
        Display_background.setBounds(24, 90, 766, 141);
        contentPane.add(Display_background);
        drag_win.setBounds(0, 0, 800, 43);
        contentPane.add(drag_win);

        Title_txt.setForeground(Color.LIGHT_GRAY);
        Title_txt.setHorizontalAlignment(SwingConstants.CENTER);
        Title_txt.setFont(new Font("Verdana", Font.BOLD, 14));
        Title_txt.setBounds(326, 25, 147, 18);
        contentPane.add(Title_txt);

        background.setHorizontalAlignment(SwingConstants.CENTER);
        background.setIcon(new ImageIcon(MainFrame.class.getResource("/res/Backgrounds/bg#1.png")));
        background.setBounds(0, 0, 800, 600);
        contentPane.add(background);
        setUndecorated(true);
    }

}
