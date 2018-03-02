
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//background of GUI needs to be transparent to that it can be overlayed over the driving video
// http://1bestcsharp.blogspot.co.uk/2016/01/java-images-navigation-from-folder.html
// https://docs.oracle.com/javase/tutorial/uiswing/events/keylistener.html

public class HUD_GUI extends JFrame implements KeyListener {

	// GUI components
	private JPanel panel1, panel2, panel3, panel4, p11, p12, p13, p21, p22, p23, p31, p32, p41, p42;
	private JLabel buttonLeft, buttonRight, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, placeholder1, placeholder2, menuDescription, menuDescription1, actionSuccess, actionSuccess1;
	private ImageIcon smartHome, music, phone, door, wifi, thermometer, light, power, sliderlock, locked, heating, button1, button2;
	private boolean menu1, menu2, menu3, menu4;
	private String selectedIcon;
	private int counter;
	

	// constructor
	public HUD_GUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Head up Display");
		setSize(1000, 250);
		setLocationRelativeTo(null);
		setFocusable(true);
		this.addKeyListener(this);
		//makes it opaque and without control panel
		// setUndecorated(true);
		// getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		// setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		setUpMenu1();
		counter = 20;
	}
	
	
	private void setUpMenu1() {
		
		this.menu1 = true;
		
		this.button1 = new ImageIcon("button1.png");
		this.button2 = new ImageIcon("button2.png");
        this.smartHome = new ImageIcon("smartHome.png");
        this.music = new ImageIcon("music.png");
        this.phone = new ImageIcon("phone.png");
        
		this.image1 = new JLabel(smartHome);
		this.image2 = new JLabel(music);
		image2.setBorder(BorderFactory.createLineBorder(Color.red, 5));
		selectedIcon = "music";
		this.image3 = new JLabel(phone);
		this.buttonLeft = new JLabel(button1);
		this.buttonRight = new JLabel(button2);
		this.placeholder1 = new JLabel("				");
		placeholder1.setSize(500, 500);
		this.placeholder2 = new JLabel("				");
		placeholder2.setSize(500, 500);
		
		this.panel1 = new JPanel();
		panel1.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		
		this.p11 = new JPanel();
		p11.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p11.add(buttonLeft);
		p11.add(placeholder1);
		
		this.p12 = new JPanel();
		p12.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p12.add(image1);
		p12.add(image2);
		p12.add(image3);

		this.p13 = new JPanel();
		p13.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p13.add(placeholder2);
		p13.add(buttonRight);

		panel1.add(p11, BorderLayout.WEST);
		panel1.add(p12, BorderLayout.CENTER);
		panel1.add(p13, BorderLayout.EAST);

		this.add(panel1);
	}


	private void setUpMenu2() {
		
		this.menu2 = true;
		
		this.button1 = new ImageIcon("button1.png");
		this.button2 = new ImageIcon("button2.png");
        this.door = new ImageIcon("door.png");
        this.wifi = new ImageIcon("wifi.png");
        this.thermometer = new ImageIcon("thermometer.png");
        this.light = new ImageIcon("light.png");
        this.power = new ImageIcon("power.png");
        
		this.image4 = new JLabel(door);
		this.image5 = new JLabel(wifi);
		this.image6 = new JLabel(thermometer);
		image6.setBorder(BorderFactory.createLineBorder(Color.red, 5));
		selectedIcon = "thermometer";
		this.image7 = new JLabel(light);
		this.image8 = new JLabel(power);
		
		this.buttonLeft = new JLabel(button1);
		this.buttonRight = new JLabel(button2);
		this.placeholder1 = new JLabel("				");
		placeholder1.setSize(500, 500);
		this.placeholder2 = new JLabel("				");
		placeholder2.setSize(500, 500);
		
		this.panel2 = new JPanel();
		panel2.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		
		this.p21 = new JPanel();
		p21.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p21.add(buttonLeft);
		p21.add(placeholder1);
		
		this.p22 = new JPanel();
		p22.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p22.add(image4);
		p22.add(image5);
		p22.add(image6);
		p22.add(image7);
		p22.add(image8);

		this.p23 = new JPanel();
		p23.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p23.add(placeholder2);
		p23.add(buttonRight);

		panel2.add(p21, BorderLayout.WEST);
		panel2.add(p22, BorderLayout.CENTER);
		panel2.add(p23, BorderLayout.EAST);

		this.add(panel2);
		
	}
	
	private void setUpMenu3() {
		
		this.menu3 = true;
		
        this.sliderlock = new ImageIcon("sliderlock.png");
        this.locked = new ImageIcon("locked.png"); //comes later
        
		this.image9 = new JLabel(sliderlock);
		this.image10 = new JLabel(locked);
		this.menuDescription = new JLabel("Slide and hold to lock");
		this.actionSuccess = new JLabel("Locked"); //comes later
		this.placeholder1 = new JLabel("				");
		placeholder1.setSize(500, 500);
		
		this.panel3 = new JPanel();
		panel3.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		
		this.p31 = new JPanel();
		p31.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p31.setPreferredSize(new Dimension(1000, 50));
		p31.add(menuDescription);
		
		this.p32 = new JPanel();
		p32.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p32.setPreferredSize(new Dimension(1000, 150));
		p32.add(image9);

		panel3.add(p31, BorderLayout.NORTH);
		panel3.add(p32, BorderLayout.SOUTH);

		this.add(panel3);
	}
	
	private void setUpMenu4() {
		
		this.menu4 = true;
		
        this.heating = new ImageIcon("heating.png");
        
		this.image11 = new JLabel(heating);
		this.menuDescription1 = new JLabel("Slide to adjust heat");
		this.actionSuccess1 = new JLabel(); //comes later; can be done in a loop as well with more scales
		
		this.panel4 = new JPanel();
		panel4.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		
		this.p41 = new JPanel();
		p41.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p41.setPreferredSize(new Dimension(200, 200));
		p41.add(menuDescription1);
		
		this.p42 = new JPanel();
		p42.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p42.setPreferredSize(new Dimension(200, 200));
		p42.add(image11);

		panel4.add(p42, BorderLayout.WEST);
		panel4.add(p41, BorderLayout.EAST);

		this.add(panel4);
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// not used
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		//right arrow
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			
			// navigation menu 1
			
			if (menu1 == true && selectedIcon == "music") {
				image2.setBorder(BorderFactory.createEmptyBorder());
				image3.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				selectedIcon = "phone";
			}
			
			else if (menu1 == true && selectedIcon == "smartHome") {
				image1.setBorder(BorderFactory.createEmptyBorder());
				image2.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				selectedIcon = "music";
			}
			
			//navigation menu 2
			
			else if (menu2 == true && selectedIcon == "thermometer") {
				image6.setBorder(BorderFactory.createEmptyBorder());
				image7.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				selectedIcon = "light";
			}
			
			else if (menu2 == true && selectedIcon == "light") {
				image7.setBorder(BorderFactory.createEmptyBorder());
				image8.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				selectedIcon = "power";
			}
			
			else if (menu2 == true && selectedIcon == "door") {
				image4.setBorder(BorderFactory.createEmptyBorder());
				image5.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				selectedIcon = "wifi";
			}
			
			else if (menu2 == true && selectedIcon == "wifi") {
				image5.setBorder(BorderFactory.createEmptyBorder());
				image6.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				selectedIcon = "thermometer";
			}
			
			//navigation menu3

			else if (menu3 == true) {
				p31.remove(menuDescription);
				p31.add(actionSuccess);
				p32.remove(image9);
				p32.add(image10);
				this.setVisible(true);
			}
			
			
		}
		
		//left arrow
		else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			
			//navigation menu 1
			
			if (menu1 == true && selectedIcon == "music") {
				image2.setBorder(BorderFactory.createEmptyBorder());
				image1.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				selectedIcon = "smartHome";
			}
			
			else if (menu1 == true && selectedIcon == "phone") {
				image3.setBorder(BorderFactory.createEmptyBorder());
				image2.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				selectedIcon = "music";
			}
			
			//navigation menu 2
			
			else if (menu2 == true && selectedIcon == "thermometer") {
				image6.setBorder(BorderFactory.createEmptyBorder());
				image5.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				selectedIcon = "wifi";
			}
			
			else if (menu2 == true && selectedIcon == "wifi") {
				image5.setBorder(BorderFactory.createEmptyBorder());
				image4.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				selectedIcon = "door";
			}
			
			else if (menu2 == true && selectedIcon == "power") {
				image8.setBorder(BorderFactory.createEmptyBorder());
				image7.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				selectedIcon = "light";
			}
			
			else if (menu2 == true && selectedIcon == "light") {
				image7.setBorder(BorderFactory.createEmptyBorder());
				image6.setBorder(BorderFactory.createLineBorder(Color.red, 5));
				selectedIcon = "thermometer";
			}
			
			
		}
		
		//up arrow
		else if (e.getKeyCode()==KeyEvent.VK_UP) {
			
			if (menu4==true) {
				p41.remove(menuDescription1);
				counter ++;
				String s = "Heat is: "+counter+"°C";
				actionSuccess1.setText(s);
				p41.add(actionSuccess1);
				this.setVisible(true);
			}
			
		}
		
		//down arrow
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			
			if (menu4==true) {
				p41.remove(menuDescription1);
				counter --;
				String s = "Heat is: "+counter+"°C";
				actionSuccess1.setText(s);
				p41.add(actionSuccess1);
				this.setVisible(true);
			}
		
		}
		
		//Q key
		else if (e.getKeyCode()==KeyEvent.VK_Q) {
			
			// menu 1
			if (menu1 == true && selectedIcon == "smartHome") { //needs adjustment, only when icon is smartHome
				this.remove(panel1);
				menu1 = false;
				setUpMenu2();
			}
			
			// menu 2
			else if (menu2 == true && selectedIcon == "door") { 
				this.remove(panel2);
				menu2 = false;
				setUpMenu3();
			}
			
			else if (menu2 == true && selectedIcon == "thermometer") {
				this.remove(panel2);
				menu2 = false;
				setUpMenu4();
			}
			
		}
		
		//A key
		else if (e.getKeyCode()==KeyEvent.VK_A) {
			if (menu2 == true) {
				this.remove(panel2);
				menu2 = false;
				setUpMenu1();
			}
			else if (menu3 == true) {
				this.remove(panel3);
				menu3 = false;
				setUpMenu2();
			}
			else if (menu4 == true) {
				this.remove(panel4);
				menu4 = false;
				counter = 20;
				setUpMenu2();
			}	
		}
		
		//Z key
		else if (e.getKeyCode()==KeyEvent.VK_Z) {
			System.exit(0);
		}
		
		repaint();
		this.setVisible(true);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// not used
	}


}
