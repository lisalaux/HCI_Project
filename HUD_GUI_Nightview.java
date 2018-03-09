import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//background of GUI needs to be transparent to that it can be overlayed over the driving video
// http://1bestcsharp.blogspot.co.uk/2016/01/java-images-navigation-from-folder.html
// https://docs.oracle.com/javase/tutorial/uiswing/events/keylistener.html

public class HUD_GUI_Nightview extends JFrame implements KeyListener {

	// GUI components
	private JPanel panel1, panel2, panel3, panel4, p11, p12, p13, p21, p22, p23, p31, p32, p41, p42;
	private JLabel buttonLeft, buttonRight, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12;
	private JLabel placeholder1, placeholder2, menuDescription, menuDescription1, actionSuccessA, actionSuccessB, actionSuccess1;
	private ImageIcon smartHome, music, phone, door, wifi, thermometer, light, power, sliderlock, locked, unlocked, heating, button1, button2;
	
	//control components
	private boolean menu1, menu2, menu3, menu4;
	private String selectedIcon;
	private boolean isLocked;

	// Counter for the heat adjustment
	private int heatCounter;

	// Counter for all mapped keys (except G as this starts the system (once) and H because this terminates counting)
	private int counterRightArrow, counterLeftArrow, counterUpArrow, counterDownArrow, counterQ, counterA;

	// Logger object
	HUD_Logger logger;

	// constructor
	public HUD_GUI_Nightview() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Head up Display");
		setSize(1000, 250);

		// setLocationRelativeTo(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		final int width = screenSize.width;
		final int height = screenSize.height;

		this.setLocation(width/2-500, height-(250));

		setFocusable(true);
		this.addKeyListener(this);
		//makes it opaque and without control panel
		setUndecorated(true);
		getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		setBackground(new Color(1.0f,1.0f,1.0f,0.0f));

		// Set the heatCounter to a default value of 20
		heatCounter = 20;

		// Initialize all key press counters with the value 0
		initializeKeyCounters();

		// Instantiate the logger
		logger = new HUD_Logger();

	}

	// Helper method instantiating all key press counters
	private void initializeKeyCounters() {
		counterRightArrow = 0;
		counterLeftArrow = 0;
		counterUpArrow = 0;
		counterDownArrow = 0;
		counterQ = 0;
		counterA = 0;
	}

	//setup menu 1
	private void setUpMenu1() {
		
		this.menu1 = true;
		
		this.button1 = new ImageIcon("button11.png");
		this.button2 = new ImageIcon("button12.png");
        this.smartHome = new ImageIcon("smartHome1.png");
        this.music = new ImageIcon("music1.png");
        this.phone = new ImageIcon("phone1.png");
        
		this.image1 = new JLabel(smartHome);
		this.image2 = new JLabel(music);
		image2.setBorder(BorderFactory.createLineBorder(Color.white, 5));
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

	//setup menu 2
	private void setUpMenu2() {
		
		this.menu2 = true;
		
		this.button1 = new ImageIcon("button11.png");
		this.button2 = new ImageIcon("button12.png");
        this.door = new ImageIcon("door1.png");
        this.wifi = new ImageIcon("wifi1.png");
        this.thermometer = new ImageIcon("thermometer1.png");
        this.light = new ImageIcon("light1.png");
        this.power = new ImageIcon("power1.png");
        
		this.image4 = new JLabel(door);
		this.image5 = new JLabel(wifi);
		this.image6 = new JLabel(thermometer);
		image6.setBorder(BorderFactory.createLineBorder(Color.white, 5));
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
	
	//setup menu 3
	private void setUpMenu3() {
		
		this.menu3 = true;
		this.isLocked = false;
		
        this.sliderlock = new ImageIcon("sliderlock1.png");
        this.locked = new ImageIcon("locked1.png"); //will be added after keyboard action
        this.unlocked = new ImageIcon("unlock1.png"); //will be added after keyboard action
        
		this.image9 = new JLabel(sliderlock);
		this.image10 = new JLabel(locked);
		this.image12 = new JLabel(unlocked);
		this.menuDescription = new JLabel("Slide to lock");
		menuDescription.setForeground(new Color(29, 224, 65));
		menuDescription.setFont(new Font("Arial", Font.BOLD, 50));
		this.actionSuccessA = new JLabel("Locked"); //will be added after keyboard action
		actionSuccessA.setForeground(new Color(29, 224, 65));
		actionSuccessA.setFont(new Font("Arial", Font.BOLD, 50));
		this.actionSuccessB = new JLabel("Unlocked"); //will be added after keyboard action
		actionSuccessB.setForeground(new Color(29, 224, 65));
		actionSuccessB.setFont(new Font("Arial", Font.BOLD, 50));
		this.placeholder1 = new JLabel("				");
		placeholder1.setSize(500, 500);
		
		this.panel3 = new JPanel();
		panel3.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		
		this.p31 = new JPanel();
		p31.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p31.setPreferredSize(new Dimension(1000, 60));
		p31.add(menuDescription);
		
		this.p32 = new JPanel();
		p32.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p32.setPreferredSize(new Dimension(1000, 150));
		p32.add(image9);

		panel3.add(p31, BorderLayout.NORTH);
		panel3.add(p32, BorderLayout.SOUTH);

		this.add(panel3);
	}
	
	//setup menu 4
	private void setUpMenu4() {
		
		this.menu4 = true;
		
        this.heating = new ImageIcon("heating1.png");
        
		this.image11 = new JLabel(heating);
		this.menuDescription1 = new JLabel("Slide to adjust heat");
		menuDescription1.setVerticalAlignment(JLabel.CENTER);
		menuDescription1.setHorizontalAlignment(JLabel.CENTER);
		menuDescription1.setForeground(new Color(29, 224, 65));
		menuDescription1.setFont(new Font("Arial", Font.BOLD, 50));
		this.actionSuccess1 = new JLabel(); //will be manipulated keyboard action
		actionSuccess1.setForeground(new Color(29, 224, 65));
		actionSuccess1.setFont(new Font("Arial", Font.BOLD, 50));
		
		this.panel4 = new JPanel();
		panel4.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		
		this.p41 = new JPanel();
		p41.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p41.setPreferredSize(new Dimension(500, 200));
		p41.add(menuDescription1);
		
		this.p42 = new JPanel();
		p42.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		p42.setPreferredSize(new Dimension(100, 200));
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
		
		//right arrow pressed
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {

			//Increase the counter for the corresponding key
			counterRightArrow++;

			//log the key press event
			logger.logRightArrow();

			// navigation menu 1
			
			if (menu1 == true && selectedIcon == "music") {
				image2.setBorder(BorderFactory.createEmptyBorder());
				image3.setBorder(BorderFactory.createLineBorder(Color.white, 5));
				selectedIcon = "phone";
			}
			
			else if (menu1 == true && selectedIcon == "smartHome") {
				image1.setBorder(BorderFactory.createEmptyBorder());
				image2.setBorder(BorderFactory.createLineBorder(Color.white, 5));
				selectedIcon = "music";
			}
			
			//navigation menu 2
			
			else if (menu2 == true && selectedIcon == "thermometer") {
				image6.setBorder(BorderFactory.createEmptyBorder());
				image7.setBorder(BorderFactory.createLineBorder(Color.white, 5));
				selectedIcon = "light";
			}
			
			else if (menu2 == true && selectedIcon == "light") {
				image7.setBorder(BorderFactory.createEmptyBorder());
				image8.setBorder(BorderFactory.createLineBorder(Color.white, 5));
				selectedIcon = "power";
			}
			
			else if (menu2 == true && selectedIcon == "door") {
				image4.setBorder(BorderFactory.createEmptyBorder());
				image5.setBorder(BorderFactory.createLineBorder(Color.white, 5));
				selectedIcon = "wifi";
			}
			
			else if (menu2 == true && selectedIcon == "wifi") {
				image5.setBorder(BorderFactory.createEmptyBorder());
				image6.setBorder(BorderFactory.createLineBorder(Color.white, 5));
				selectedIcon = "thermometer";
			}
			
			//navigation menu3

			else if (menu3 == true && isLocked == false) {
				p31.remove(menuDescription);
				p31.remove(actionSuccessB);
				p31.add(actionSuccessA);
				p32.remove(image9);
				p32.remove(image12);
				p32.add(image10);
				isLocked = true;
				this.setVisible(true);
			}
			
			
		}
		
		//left arrow pressed
		else if (e.getKeyCode()==KeyEvent.VK_LEFT) {

			//Increase the counter for the corresponding key
			counterLeftArrow++;

			//log the key press event
			logger.logLeftArrow();

			//navigation menu 1
			
			if (menu1 == true && selectedIcon == "music") {
				image2.setBorder(BorderFactory.createEmptyBorder());
				image1.setBorder(BorderFactory.createLineBorder(Color.white, 5));
				selectedIcon = "smartHome";
			}
			
			else if (menu1 == true && selectedIcon == "phone") {
				image3.setBorder(BorderFactory.createEmptyBorder());
				image2.setBorder(BorderFactory.createLineBorder(Color.white, 5));
				selectedIcon = "music";
			}
			
			//navigation menu 2
			
			else if (menu2 == true && selectedIcon == "thermometer") {
				image6.setBorder(BorderFactory.createEmptyBorder());
				image5.setBorder(BorderFactory.createLineBorder(Color.white, 5));
				selectedIcon = "wifi";
			}
			
			else if (menu2 == true && selectedIcon == "wifi") {
				image5.setBorder(BorderFactory.createEmptyBorder());
				image4.setBorder(BorderFactory.createLineBorder(Color.white, 5));
				selectedIcon = "door";
			}
			
			else if (menu2 == true && selectedIcon == "power") {
				image8.setBorder(BorderFactory.createEmptyBorder());
				image7.setBorder(BorderFactory.createLineBorder(Color.white, 5));
				selectedIcon = "light";
			}
			
			else if (menu2 == true && selectedIcon == "light") {
				image7.setBorder(BorderFactory.createEmptyBorder());
				image6.setBorder(BorderFactory.createLineBorder(Color.white, 5));
				selectedIcon = "thermometer";
			}
			
			//navigation menu 3
			else if (menu3 == true && isLocked == true) {
				p31.remove(actionSuccessA);
				p31.add(actionSuccessB);
				p32.remove(image10);
				p32.add(image12);
				isLocked = false;
				this.setVisible(true);
			}
			
			
		}
		
		//up arrow; menu 4 only
		else if (e.getKeyCode()==KeyEvent.VK_UP) {

			//Increase the counter for the corresponding key
			counterUpArrow++;

			//log the key press event
			logger.logUpArrow();

			if (menu4==true) {
				p41.remove(menuDescription1);
				heatCounter ++;
				String s = "Heat is: "+heatCounter+"°C";
				actionSuccess1.setText(s);
				p41.add(actionSuccess1);
				this.setVisible(true);
			}
			
		}
		
		//down arrow; menu 4 only
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {

			//Increase the counter for the corresponding key
			counterDownArrow++;

			//log the key press event
			logger.logDownArrow();

			if (menu4==true) {
				p41.remove(menuDescription1);
				heatCounter --;
				String s = "Heat is: "+heatCounter+"°C";
				actionSuccess1.setText(s);
				p41.add(actionSuccess1);
				this.setVisible(true);
			}
		
		}
		
		//Q key = "Enter"
		else if (e.getKeyCode()==KeyEvent.VK_Q) {

			//Increase the counter for the corresponding key
			counterQ++;

			//log the key press event
			logger.logQKey();

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
		
		//A key = "Back"
		else if (e.getKeyCode()==KeyEvent.VK_A) {

			//Increase the counter for the corresponding key
			counterA++;

			//log the key press event
			logger.logAKey();

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
				heatCounter = 20;
				setUpMenu2();
			}	
		}
		
		//G key
		else if (e.getKeyCode()==KeyEvent.VK_G) {
			setUpMenu1();
		}
		
		//H key for exit the program
		else if (e.getKeyCode()==KeyEvent.VK_H) {
			logger.writeSummary(counterRightArrow,counterLeftArrow,counterUpArrow,counterDownArrow,counterQ,counterA);
			logger.closeFileHandler();
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
