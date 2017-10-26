package view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameScreen implements MouseListener {

	private JFrame frmDontGetAngry;
	private boolean rolled = false;
	private boolean toBeRestrted = false;
	private List<String> clicked = new ArrayList<String>();

	public boolean isToBeRestrted() {
		return toBeRestrted;
	}

	public List<String> getClicked() {
		return clicked;
	}

	public void cleanClicked() {
		this.clicked = new ArrayList<String>();
	}

	public void addClicked(String text) {
		if (!text.equals("ROLL") && this.clicked.size() < 2 && !this.clicked.contains(text)) {
			this.clicked.add(text);
		}
	}

	/*
	 * public void showActivePlayer(String color){ for(Component c :
	 * getFrmDontGetAngry().getContentPane().getComponents()) {
	 * if("lblNewLabel".equals(c.getName())) {
	 * c.getAccessibleContext().getaccess } } }
	 */
	public void enableButton(String text) {
		Component[] comps = getFrmDontGetAngry().getContentPane().getComponents();
		for (Component comp : comps) {
			if (comp instanceof JButton) {
				JButton temp = (JButton) comp;
				if (temp.getText().equalsIgnoreCase(text)) {
					comp.setEnabled(true);
					((JButton) comp).setOpaque(true);
				}
			}
		}
	}

	public void disableButton(String text) {
		Component[] comps = getFrmDontGetAngry().getContentPane().getComponents();
		for (Component comp : comps) {
			if (comp instanceof JButton) {
				JButton temp = (JButton) comp;
				if (temp.getText().equalsIgnoreCase(text)) {
					comp.setEnabled(false);
				}
			}
		}
	}

	public void changeLabel(String text) {
		Component[] comps = getFrmDontGetAngry().getContentPane().getComponents();
		for (Component comp : comps) {
			if (comp instanceof JLabel) {
				JLabel temp = (JLabel) comp;
				if (temp.getText().startsWith("Don") || temp.getText().startsWith("It")) {
					((JLabel) comp).setText(text);
				}
			}
		}
	}

	public void changeDiceLabel(String text) {
		Component[] comps = getFrmDontGetAngry().getContentPane().getComponents();
		for (Component comp : comps) {
			if (comp instanceof JLabel) {
				JLabel temp = (JLabel) comp;
				if (!temp.getText().startsWith("D") && !temp.getText().startsWith("It")) {
					((JLabel) comp).setText(text);
				}
			}
		}
	}

	public void placeIcon(String place, int[] rgb) {
		Component[] comps = getFrmDontGetAngry().getContentPane().getComponents();
		for (Component comp : comps) {
			if (comp instanceof JButton) {
				JButton temp = (JButton) comp;
				if (temp.getText().equalsIgnoreCase(place)) {
					try {
						((JButton) comp).setOpaque(true);
						((JButton) comp).setBackground(new Color(rgb[0], rgb[1], rgb[2]));
						if (rgb[0] == 240 && rgb[1] == 240 && rgb[2] == 240) {
							((JButton) comp).setOpaque(false);
						}
					} catch (Exception ex) {
						try {
							failToPaint();
						} catch (Exception exc) {
							System.out.println(exc);
						}
					}
				}
			}
		}
	}

	public boolean isRolled() {
		return rolled;
	}

	public void setRolled(boolean rolled) {
		this.rolled = rolled;
	}

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { GameScreen window = new
	 * GameScreen(); window.getFrmDontGetAngry().setVisible(true); } catch
	 * (Exception e) { e.printStackTrace(); } } }); }
	 * 
	 * /** Create the application.
	 */
	public GameScreen() {
		initialize();
	}

	public void Win() {
		JOptionPane.showMessageDialog(frmDontGetAngry, "YOU WIN!");
	}

	public void WrongMove() {
		JOptionPane.showMessageDialog(frmDontGetAngry, "Wrong Move!");
	}

	public void failToPaint() {
		JOptionPane.showMessageDialog(frmDontGetAngry, "Failed to paint");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmDontGetAngry(new JFrame());
		getFrmDontGetAngry().setTitle("Don't get Angry!");
		getFrmDontGetAngry().setBounds(100, 100, 759, 538);
		getFrmDontGetAngry().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		getFrmDontGetAngry().setJMenuBar(menuBar);

		JMenu mnNewGame = new JMenu("Menu");
		menuBar.add(mnNewGame);

		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmDontGetAngry,
						"Players alternate turns in a clockwise direction.To enter a token into play from its yard to its starting square,\n a player must roll a 6.Rolling a 6 earns the player an additional or \"bonus\" roll in that turn. \n If the player has no tokens yet in play and rolls other than a 6, the turn passes to the next player.\n Once a player has one or more tokens in play, he selects a token and moves \nit forwards along the track the number of squares indicated by the die. Players must always move a token according\n to the die value rolled. Passes are not allowed; if no move is possible, the turn moves to the next player.\nPlayers may not end their move on a square they already occupy. If the advance of a token ends on a square occupied by\n an opponent's token, the opponent token is returned to its owner's yard. ");

			}

		});
		mnNewGame.add(mntmHelp);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewGame.add(mntmExit);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getFrmDontGetAngry().getContentPane().setLayout(gridBagLayout);

		JButton btnSr1 = new JButton("SR");
		btnSr1.setBackground(new Color(255, 0, 0));
		btnSr1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSr1.setEnabled(false);
		btnSr1.setForeground(Color.RED);
		GridBagConstraints gbc_btnSr = new GridBagConstraints();
		gbc_btnSr.insets = new Insets(0, 0, 5, 5);
		gbc_btnSr.gridx = 1;
		gbc_btnSr.gridy = 1;
		getFrmDontGetAngry().getContentPane().add(btnSr1, gbc_btnSr);

		JButton btnSr2 = new JButton("SR");
		btnSr2.setBackground(new Color(255, 0, 0));
		btnSr2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSr2.setEnabled(false);
		btnSr2.setForeground(Color.RED);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 1;
		getFrmDontGetAngry().getContentPane().add(btnSr2, gbc_button);

		JLabel lblNewLabel = new JLabel("Don't get Angry!");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 1;
		getFrmDontGetAngry().getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JButton btnSb1 = new JButton("SB");
		btnSb1.setBackground(new Color(0, 0, 255));
		btnSb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSb1.setEnabled(false);
		btnSb1.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnSb = new GridBagConstraints();
		gbc_btnSb.insets = new Insets(0, 0, 5, 5);
		gbc_btnSb.gridx = 12;
		gbc_btnSb.gridy = 1;
		getFrmDontGetAngry().getContentPane().add(btnSb1, gbc_btnSb);

		JButton btnSb2 = new JButton("SB");
		btnSb2.setBackground(new Color(0, 0, 255));
		btnSb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSb2.setEnabled(false);
		btnSb2.setForeground(Color.BLUE);
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.insets = new Insets(0, 0, 5, 5);
		gbc_button_9.gridx = 13;
		gbc_button_9.gridy = 1;
		getFrmDontGetAngry().getContentPane().add(btnSb2, gbc_button_9);

		JButton btnSr3 = new JButton("SR");
		btnSr3.setBackground(new Color(255, 0, 0));
		btnSr3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSr3.setEnabled(false);
		btnSr3.setForeground(Color.RED);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 2;
		getFrmDontGetAngry().getContentPane().add(btnSr3, gbc_button_1);

		JButton btnSr4 = new JButton("SR");
		btnSr4.setBackground(new Color(255, 0, 0));
		btnSr4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSr4.setEnabled(false);
		btnSr4.setForeground(Color.RED);
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 2;
		getFrmDontGetAngry().getContentPane().add(btnSr4, gbc_button_2);

		JButton btnSb3 = new JButton("SB");
		btnSb3.setBackground(new Color(0, 0, 255));
		btnSb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});

		JLabel lblNewLabel_2 = new JLabel("Die:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 6;
		gbc_lblNewLabel_2.gridy = 2;
		frmDontGetAngry.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("0");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 7;
		gbc_lblNewLabel_1.gridy = 2;
		frmDontGetAngry.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		btnSb3.setEnabled(false);
		btnSb3.setForeground(Color.BLUE);
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.insets = new Insets(0, 0, 5, 5);
		gbc_button_10.gridx = 12;
		gbc_button_10.gridy = 2;
		getFrmDontGetAngry().getContentPane().add(btnSb3, gbc_button_10);

		JButton btnSb4 = new JButton("SB");
		btnSb4.setBackground(new Color(0, 0, 255));
		btnSb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSb4.setEnabled(false);
		btnSb4.setForeground(Color.BLUE);
		GridBagConstraints gbc_button_11 = new GridBagConstraints();
		gbc_button_11.insets = new Insets(0, 0, 5, 5);
		gbc_button_11.gridx = 13;
		gbc_button_11.gridy = 2;
		getFrmDontGetAngry().getContentPane().add(btnSb4, gbc_button_11);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn8.setEnabled(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 3;
		getFrmDontGetAngry().getContentPane().add(btn8, gbc_btnNewButton);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn9.setEnabled(false);
		GridBagConstraints gbc_button_12 = new GridBagConstraints();
		gbc_button_12.insets = new Insets(0, 0, 5, 5);
		gbc_button_12.gridx = 7;
		gbc_button_12.gridy = 3;
		getFrmDontGetAngry().getContentPane().add(btn9, gbc_button_12);

		JButton btn10 = new JButton("10");
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn10.setEnabled(false);
		GridBagConstraints gbc_button_13 = new GridBagConstraints();
		gbc_button_13.insets = new Insets(0, 0, 5, 5);
		gbc_button_13.gridx = 8;
		gbc_button_13.gridy = 3;
		getFrmDontGetAngry().getContentPane().add(btn10, gbc_button_13);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn7.setEnabled(false);
		GridBagConstraints gbc_button_14 = new GridBagConstraints();
		gbc_button_14.insets = new Insets(0, 0, 5, 5);
		gbc_button_14.gridx = 6;
		gbc_button_14.gridy = 4;
		getFrmDontGetAngry().getContentPane().add(btn7, gbc_button_14);

		JButton btnAb = new JButton("AB");
		btnAb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnAb.setEnabled(false);
		btnAb.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnAb = new GridBagConstraints();
		gbc_btnAb.insets = new Insets(0, 0, 5, 5);
		gbc_btnAb.gridx = 7;
		gbc_btnAb.gridy = 4;
		getFrmDontGetAngry().getContentPane().add(btnAb, gbc_btnAb);

		JButton btn11 = new JButton("11");
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn11.setEnabled(false);
		GridBagConstraints gbc_button_18 = new GridBagConstraints();
		gbc_button_18.insets = new Insets(0, 0, 5, 5);
		gbc_button_18.gridx = 8;
		gbc_button_18.gridy = 4;
		getFrmDontGetAngry().getContentPane().add(btn11, gbc_button_18);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn6.setEnabled(false);
		GridBagConstraints gbc_button_15 = new GridBagConstraints();
		gbc_button_15.insets = new Insets(0, 0, 5, 5);
		gbc_button_15.gridx = 6;
		gbc_button_15.gridy = 5;
		getFrmDontGetAngry().getContentPane().add(btn6, gbc_button_15);

		JButton btnBb = new JButton("BB");
		btnBb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnBb.setEnabled(false);
		btnBb.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnBb = new GridBagConstraints();
		gbc_btnBb.insets = new Insets(0, 0, 5, 5);
		gbc_btnBb.gridx = 7;
		gbc_btnBb.gridy = 5;
		getFrmDontGetAngry().getContentPane().add(btnBb, gbc_btnBb);

		JButton btn12 = new JButton("12");
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn12.setEnabled(false);
		GridBagConstraints gbc_button_19 = new GridBagConstraints();
		gbc_button_19.insets = new Insets(0, 0, 5, 5);
		gbc_button_19.gridx = 8;
		gbc_button_19.gridy = 5;
		getFrmDontGetAngry().getContentPane().add(btn12, gbc_button_19);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn5.setEnabled(false);
		GridBagConstraints gbc_button_16 = new GridBagConstraints();
		gbc_button_16.insets = new Insets(0, 0, 5, 5);
		gbc_button_16.gridx = 6;
		gbc_button_16.gridy = 6;
		getFrmDontGetAngry().getContentPane().add(btn5, gbc_button_16);

		JButton btnCb = new JButton("CB");
		btnCb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnCb.setEnabled(false);
		btnCb.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnCb = new GridBagConstraints();
		gbc_btnCb.insets = new Insets(0, 0, 5, 5);
		gbc_btnCb.gridx = 7;
		gbc_btnCb.gridy = 6;
		getFrmDontGetAngry().getContentPane().add(btnCb, gbc_btnCb);

		JButton btn13 = new JButton("13");
		btn13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn13.setEnabled(false);
		GridBagConstraints gbc_button_20 = new GridBagConstraints();
		gbc_button_20.insets = new Insets(0, 0, 5, 5);
		gbc_button_20.gridx = 8;
		gbc_button_20.gridy = 6;
		getFrmDontGetAngry().getContentPane().add(btn13, gbc_button_20);

		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn0.setEnabled(false);
		GridBagConstraints gbc_button_25 = new GridBagConstraints();
		gbc_button_25.insets = new Insets(0, 0, 5, 5);
		gbc_button_25.gridx = 2;
		gbc_button_25.gridy = 7;
		getFrmDontGetAngry().getContentPane().add(btn0, gbc_button_25);

		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn1.setEnabled(false);
		GridBagConstraints gbc_button_24 = new GridBagConstraints();
		gbc_button_24.insets = new Insets(0, 0, 5, 5);
		gbc_button_24.gridx = 3;
		gbc_button_24.gridy = 7;
		getFrmDontGetAngry().getContentPane().add(btn1, gbc_button_24);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn2.setEnabled(false);
		GridBagConstraints gbc_button_23 = new GridBagConstraints();
		gbc_button_23.insets = new Insets(0, 0, 5, 5);
		gbc_button_23.gridx = 4;
		gbc_button_23.gridy = 7;
		getFrmDontGetAngry().getContentPane().add(btn2, gbc_button_23);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn3.setEnabled(false);
		GridBagConstraints gbc_button_22 = new GridBagConstraints();
		gbc_button_22.insets = new Insets(0, 0, 5, 5);
		gbc_button_22.gridx = 5;
		gbc_button_22.gridy = 7;
		getFrmDontGetAngry().getContentPane().add(btn3, gbc_button_22);

		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn4.setEnabled(false);
		GridBagConstraints gbc_button_17 = new GridBagConstraints();
		gbc_button_17.insets = new Insets(0, 0, 5, 5);
		gbc_button_17.gridx = 6;
		gbc_button_17.gridy = 7;
		getFrmDontGetAngry().getContentPane().add(btn4, gbc_button_17);

		JButton btnDb = new JButton("DB");
		btnDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnDb.setEnabled(false);
		btnDb.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnDb = new GridBagConstraints();
		gbc_btnDb.insets = new Insets(0, 0, 5, 5);
		gbc_btnDb.gridx = 7;
		gbc_btnDb.gridy = 7;
		getFrmDontGetAngry().getContentPane().add(btnDb, gbc_btnDb);

		JButton btn14 = new JButton("14");
		btn14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn14.setEnabled(false);
		GridBagConstraints gbc_button_21 = new GridBagConstraints();
		gbc_button_21.insets = new Insets(0, 0, 5, 5);
		gbc_button_21.gridx = 8;
		gbc_button_21.gridy = 7;
		getFrmDontGetAngry().getContentPane().add(btn14, gbc_button_21);

		JButton btn15 = new JButton("15");
		btn15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn15.setEnabled(false);
		GridBagConstraints gbc_button_50 = new GridBagConstraints();
		gbc_button_50.insets = new Insets(0, 0, 5, 5);
		gbc_button_50.gridx = 9;
		gbc_button_50.gridy = 7;
		getFrmDontGetAngry().getContentPane().add(btn15, gbc_button_50);

		JButton btn16 = new JButton("16");
		btn16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn16.setEnabled(false);
		GridBagConstraints gbc_button_49 = new GridBagConstraints();
		gbc_button_49.insets = new Insets(0, 0, 5, 5);
		gbc_button_49.gridx = 10;
		gbc_button_49.gridy = 7;
		getFrmDontGetAngry().getContentPane().add(btn16, gbc_button_49);

		JButton btn17 = new JButton("17");
		btn17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn17.setEnabled(false);
		GridBagConstraints gbc_button_48 = new GridBagConstraints();
		gbc_button_48.insets = new Insets(0, 0, 5, 5);
		gbc_button_48.gridx = 11;
		gbc_button_48.gridy = 7;
		getFrmDontGetAngry().getContentPane().add(btn17, gbc_button_48);

		JButton btn18 = new JButton("18");
		btn18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn18.setEnabled(false);
		GridBagConstraints gbc_button_47 = new GridBagConstraints();
		gbc_button_47.insets = new Insets(0, 0, 5, 5);
		gbc_button_47.gridx = 12;
		gbc_button_47.gridy = 7;
		getFrmDontGetAngry().getContentPane().add(btn18, gbc_button_47);

		JButton btn39 = new JButton("39");
		btn39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn39.setEnabled(false);
		GridBagConstraints gbc_button_26 = new GridBagConstraints();
		gbc_button_26.insets = new Insets(0, 0, 5, 5);
		gbc_button_26.gridx = 2;
		gbc_button_26.gridy = 8;
		getFrmDontGetAngry().getContentPane().add(btn39, gbc_button_26);

		JButton btnAr = new JButton("AR");
		btnAr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnAr.setEnabled(false);
		btnAr.setForeground(Color.RED);
		GridBagConstraints gbc_btnAr = new GridBagConstraints();
		gbc_btnAr.insets = new Insets(0, 0, 5, 5);
		gbc_btnAr.gridx = 3;
		gbc_btnAr.gridy = 8;
		getFrmDontGetAngry().getContentPane().add(btnAr, gbc_btnAr);

		JButton btnBr = new JButton("BR");
		btnBr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnBr.setEnabled(false);
		btnBr.setForeground(Color.RED);
		GridBagConstraints gbc_btnBr = new GridBagConstraints();
		gbc_btnBr.insets = new Insets(0, 0, 5, 5);
		gbc_btnBr.gridx = 4;
		gbc_btnBr.gridy = 8;
		getFrmDontGetAngry().getContentPane().add(btnBr, gbc_btnBr);

		JButton btnCr = new JButton("CR");
		btnCr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnCr.setEnabled(false);
		btnCr.setForeground(Color.RED);
		GridBagConstraints gbc_btnCr = new GridBagConstraints();
		gbc_btnCr.insets = new Insets(0, 0, 5, 5);
		gbc_btnCr.gridx = 5;
		gbc_btnCr.gridy = 8;
		getFrmDontGetAngry().getContentPane().add(btnCr, gbc_btnCr);

		JButton btnDr = new JButton("DR");
		btnDr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnDr.setEnabled(false);
		btnDr.setForeground(Color.RED);
		GridBagConstraints gbc_btnDr = new GridBagConstraints();
		gbc_btnDr.insets = new Insets(0, 0, 5, 5);
		gbc_btnDr.gridx = 6;
		gbc_btnDr.gridy = 8;
		getFrmDontGetAngry().getContentPane().add(btnDr, gbc_btnDr);

		JButton btnRoll = new JButton("ROLL");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setRolled(true);
			}
		});
		btnRoll.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnRoll = new GridBagConstraints();
		gbc_btnRoll.insets = new Insets(0, 0, 5, 5);
		gbc_btnRoll.gridx = 7;
		gbc_btnRoll.gridy = 8;
		getFrmDontGetAngry().getContentPane().add(btnRoll, gbc_btnRoll);

		JButton btnDg = new JButton("DG");
		btnDg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnDg.setEnabled(false);
		btnDg.setForeground(Color.GREEN);
		GridBagConstraints gbc_btnDg = new GridBagConstraints();
		gbc_btnDg.insets = new Insets(0, 0, 5, 5);
		gbc_btnDg.gridx = 8;
		gbc_btnDg.gridy = 8;
		getFrmDontGetAngry().getContentPane().add(btnDg, gbc_btnDg);

		JButton btnCg = new JButton("CG");
		btnCg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnCg.setEnabled(false);
		btnCg.setForeground(Color.GREEN);
		GridBagConstraints gbc_btnCg = new GridBagConstraints();
		gbc_btnCg.insets = new Insets(0, 0, 5, 5);
		gbc_btnCg.gridx = 9;
		gbc_btnCg.gridy = 8;
		getFrmDontGetAngry().getContentPane().add(btnCg, gbc_btnCg);

		JButton btnBg = new JButton("BG");
		btnBg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnBg.setEnabled(false);
		btnBg.setForeground(Color.GREEN);
		GridBagConstraints gbc_btnBg = new GridBagConstraints();
		gbc_btnBg.insets = new Insets(0, 0, 5, 5);
		gbc_btnBg.gridx = 10;
		gbc_btnBg.gridy = 8;
		getFrmDontGetAngry().getContentPane().add(btnBg, gbc_btnBg);

		JButton btnAg = new JButton("AG");
		btnAg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnAg.setEnabled(false);
		btnAg.setForeground(Color.GREEN);
		GridBagConstraints gbc_btnAg = new GridBagConstraints();
		gbc_btnAg.insets = new Insets(0, 0, 5, 5);
		gbc_btnAg.gridx = 11;
		gbc_btnAg.gridy = 8;
		getFrmDontGetAngry().getContentPane().add(btnAg, gbc_btnAg);

		JButton btn19 = new JButton("19");
		btn19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn19.setEnabled(false);
		GridBagConstraints gbc_button_46 = new GridBagConstraints();
		gbc_button_46.insets = new Insets(0, 0, 5, 5);
		gbc_button_46.gridx = 12;
		gbc_button_46.gridy = 8;
		getFrmDontGetAngry().getContentPane().add(btn19, gbc_button_46);

		JButton btn38 = new JButton("38");
		btn38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn38.setEnabled(false);
		GridBagConstraints gbc_button_27 = new GridBagConstraints();
		gbc_button_27.insets = new Insets(0, 0, 5, 5);
		gbc_button_27.gridx = 2;
		gbc_button_27.gridy = 9;
		getFrmDontGetAngry().getContentPane().add(btn38, gbc_button_27);

		JButton btn37 = new JButton("37");
		btn37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn37.setEnabled(false);
		GridBagConstraints gbc_button_28 = new GridBagConstraints();
		gbc_button_28.insets = new Insets(0, 0, 5, 5);
		gbc_button_28.gridx = 3;
		gbc_button_28.gridy = 9;
		getFrmDontGetAngry().getContentPane().add(btn37, gbc_button_28);

		JButton btn36 = new JButton("36");
		btn36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn36.setEnabled(false);
		GridBagConstraints gbc_button_29 = new GridBagConstraints();
		gbc_button_29.insets = new Insets(0, 0, 5, 5);
		gbc_button_29.gridx = 4;
		gbc_button_29.gridy = 9;
		getFrmDontGetAngry().getContentPane().add(btn36, gbc_button_29);

		JButton btn35 = new JButton("35");
		btn35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn35.setEnabled(false);
		GridBagConstraints gbc_button_30 = new GridBagConstraints();
		gbc_button_30.insets = new Insets(0, 0, 5, 5);
		gbc_button_30.gridx = 5;
		gbc_button_30.gridy = 9;
		getFrmDontGetAngry().getContentPane().add(btn35, gbc_button_30);

		JButton btn34 = new JButton("34");
		btn34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn34.setEnabled(false);
		GridBagConstraints gbc_button_31 = new GridBagConstraints();
		gbc_button_31.insets = new Insets(0, 0, 5, 5);
		gbc_button_31.gridx = 6;
		gbc_button_31.gridy = 9;
		getFrmDontGetAngry().getContentPane().add(btn34, gbc_button_31);

		JButton btnDy = new JButton("DY");
		btnDy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnDy.setEnabled(false);
		btnDy.setForeground(Color.YELLOW);
		GridBagConstraints gbc_btnDy = new GridBagConstraints();
		gbc_btnDy.insets = new Insets(0, 0, 5, 5);
		gbc_btnDy.gridx = 7;
		gbc_btnDy.gridy = 9;
		getFrmDontGetAngry().getContentPane().add(btnDy, gbc_btnDy);

		JButton btn24 = new JButton("24");
		btn24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn24.setEnabled(false);
		GridBagConstraints gbc_button_41 = new GridBagConstraints();
		gbc_button_41.insets = new Insets(0, 0, 5, 5);
		gbc_button_41.gridx = 8;
		gbc_button_41.gridy = 9;
		getFrmDontGetAngry().getContentPane().add(btn24, gbc_button_41);

		JButton btn23 = new JButton("23");
		btn23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn23.setEnabled(false);
		GridBagConstraints gbc_button_42 = new GridBagConstraints();
		gbc_button_42.insets = new Insets(0, 0, 5, 5);
		gbc_button_42.gridx = 9;
		gbc_button_42.gridy = 9;
		getFrmDontGetAngry().getContentPane().add(btn23, gbc_button_42);

		JButton btn22 = new JButton("22");
		btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn22.setEnabled(false);
		GridBagConstraints gbc_button_43 = new GridBagConstraints();
		gbc_button_43.insets = new Insets(0, 0, 5, 5);
		gbc_button_43.gridx = 10;
		gbc_button_43.gridy = 9;
		getFrmDontGetAngry().getContentPane().add(btn22, gbc_button_43);

		JButton btn21 = new JButton("21");
		btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn21.setEnabled(false);
		GridBagConstraints gbc_button_44 = new GridBagConstraints();
		gbc_button_44.insets = new Insets(0, 0, 5, 5);
		gbc_button_44.gridx = 11;
		gbc_button_44.gridy = 9;
		getFrmDontGetAngry().getContentPane().add(btn21, gbc_button_44);

		JButton btn20 = new JButton("20");
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn20.setEnabled(false);
		GridBagConstraints gbc_button_45 = new GridBagConstraints();
		gbc_button_45.insets = new Insets(0, 0, 5, 5);
		gbc_button_45.gridx = 12;
		gbc_button_45.gridy = 9;
		getFrmDontGetAngry().getContentPane().add(btn20, gbc_button_45);

		JButton btn33 = new JButton("33");
		btn33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn33.setEnabled(false);
		GridBagConstraints gbc_button_32 = new GridBagConstraints();
		gbc_button_32.insets = new Insets(0, 0, 5, 5);
		gbc_button_32.gridx = 6;
		gbc_button_32.gridy = 10;
		getFrmDontGetAngry().getContentPane().add(btn33, gbc_button_32);

		JButton btnCy = new JButton("CY");
		btnCy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnCy.setEnabled(false);
		btnCy.setForeground(Color.YELLOW);
		GridBagConstraints gbc_btnCy = new GridBagConstraints();
		gbc_btnCy.insets = new Insets(0, 0, 5, 5);
		gbc_btnCy.gridx = 7;
		gbc_btnCy.gridy = 10;
		getFrmDontGetAngry().getContentPane().add(btnCy, gbc_btnCy);

		JButton btn25 = new JButton("25");
		btn25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn25.setEnabled(false);
		GridBagConstraints gbc_button_40 = new GridBagConstraints();
		gbc_button_40.insets = new Insets(0, 0, 5, 5);
		gbc_button_40.gridx = 8;
		gbc_button_40.gridy = 10;
		getFrmDontGetAngry().getContentPane().add(btn25, gbc_button_40);

		JButton btn32 = new JButton("32");
		btn32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn32.setEnabled(false);
		GridBagConstraints gbc_button_33 = new GridBagConstraints();
		gbc_button_33.insets = new Insets(0, 0, 5, 5);
		gbc_button_33.gridx = 6;
		gbc_button_33.gridy = 11;
		getFrmDontGetAngry().getContentPane().add(btn32, gbc_button_33);

		JButton btnBy = new JButton("BY");
		btnBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnBy.setEnabled(false);
		btnBy.setForeground(Color.YELLOW);
		GridBagConstraints gbc_btnBy = new GridBagConstraints();
		gbc_btnBy.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_btnBy.insets = new Insets(0, 0, 5, 5);
		gbc_btnBy.gridx = 7;
		gbc_btnBy.gridy = 11;
		getFrmDontGetAngry().getContentPane().add(btnBy, gbc_btnBy);

		JButton btn26 = new JButton("26");
		btn26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn26.setEnabled(false);
		GridBagConstraints gbc_button_39 = new GridBagConstraints();
		gbc_button_39.insets = new Insets(0, 0, 5, 5);
		gbc_button_39.gridx = 8;
		gbc_button_39.gridy = 11;
		getFrmDontGetAngry().getContentPane().add(btn26, gbc_button_39);

		JButton btn31 = new JButton("31");
		btn31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn31.setEnabled(false);
		GridBagConstraints gbc_button_34 = new GridBagConstraints();
		gbc_button_34.insets = new Insets(0, 0, 5, 5);
		gbc_button_34.gridx = 6;
		gbc_button_34.gridy = 12;
		getFrmDontGetAngry().getContentPane().add(btn31, gbc_button_34);

		JButton btnAy = new JButton("AY");
		btnAy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnAy.setEnabled(false);
		btnAy.setForeground(Color.YELLOW);
		GridBagConstraints gbc_btnAy = new GridBagConstraints();
		gbc_btnAy.insets = new Insets(0, 0, 5, 5);
		gbc_btnAy.gridx = 7;
		gbc_btnAy.gridy = 12;
		getFrmDontGetAngry().getContentPane().add(btnAy, gbc_btnAy);

		JButton btn27 = new JButton("27");
		btn27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn27.setEnabled(false);
		GridBagConstraints gbc_button_38 = new GridBagConstraints();
		gbc_button_38.insets = new Insets(0, 0, 5, 5);
		gbc_button_38.gridx = 8;
		gbc_button_38.gridy = 12;
		getFrmDontGetAngry().getContentPane().add(btn27, gbc_button_38);

		JButton btn30 = new JButton("30");
		btn30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn30.setEnabled(false);
		GridBagConstraints gbc_button_35 = new GridBagConstraints();
		gbc_button_35.insets = new Insets(0, 0, 5, 5);
		gbc_button_35.gridx = 6;
		gbc_button_35.gridy = 13;
		getFrmDontGetAngry().getContentPane().add(btn30, gbc_button_35);

		JButton btn29 = new JButton("29");
		btn29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn29.setEnabled(false);
		GridBagConstraints gbc_button_36 = new GridBagConstraints();
		gbc_button_36.insets = new Insets(0, 0, 5, 5);
		gbc_button_36.gridx = 7;
		gbc_button_36.gridy = 13;
		getFrmDontGetAngry().getContentPane().add(btn29, gbc_button_36);

		JButton btn28 = new JButton("28");
		btn28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btn28.setEnabled(false);
		GridBagConstraints gbc_button_37 = new GridBagConstraints();
		gbc_button_37.insets = new Insets(0, 0, 5, 5);
		gbc_button_37.gridx = 8;
		gbc_button_37.gridy = 13;
		getFrmDontGetAngry().getContentPane().add(btn28, gbc_button_37);

		JButton btnSy1 = new JButton("SY");
		btnSy1.setBackground(new Color(255, 255, 0));
		btnSy1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSy1.setEnabled(false);
		btnSy1.setForeground(Color.YELLOW);
		GridBagConstraints gbc_btnSy = new GridBagConstraints();
		gbc_btnSy.insets = new Insets(0, 0, 5, 5);
		gbc_btnSy.gridx = 1;
		gbc_btnSy.gridy = 14;
		getFrmDontGetAngry().getContentPane().add(btnSy1, gbc_btnSy);

		JButton btnSy2 = new JButton("SY");
		btnSy2.setBackground(new Color(255, 255, 0));
		btnSy2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSy2.setEnabled(false);
		btnSy2.setForeground(Color.YELLOW);
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 2;
		gbc_button_5.gridy = 14;
		getFrmDontGetAngry().getContentPane().add(btnSy2, gbc_button_5);

		JButton btnSg1 = new JButton("SG");
		btnSg1.setBackground(new Color(0, 255, 0));
		btnSg1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSg1.setEnabled(false);
		btnSg1.setForeground(Color.GREEN);
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 12;
		gbc_button_8.gridy = 14;
		getFrmDontGetAngry().getContentPane().add(btnSg1, gbc_button_8);

		JButton btnSg2 = new JButton("SG");
		btnSg2.setBackground(new Color(0, 255, 0));
		btnSg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSg2.setEnabled(false);
		btnSg2.setForeground(Color.GREEN);
		GridBagConstraints gbc_btnSg = new GridBagConstraints();
		gbc_btnSg.insets = new Insets(0, 0, 5, 5);
		gbc_btnSg.gridx = 13;
		gbc_btnSg.gridy = 14;
		getFrmDontGetAngry().getContentPane().add(btnSg2, gbc_btnSg);

		JButton btnSy3 = new JButton("SY");
		btnSy3.setBackground(new Color(255, 255, 0));
		btnSy3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSy3.setEnabled(false);
		btnSy3.setForeground(Color.YELLOW);
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 1;
		gbc_button_3.gridy = 15;
		getFrmDontGetAngry().getContentPane().add(btnSy3, gbc_button_3);

		JButton btnSy4 = new JButton("SY");
		btnSy4.setBackground(new Color(255, 255, 0));
		btnSy4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSy4.setEnabled(false);
		btnSy4.setForeground(Color.YELLOW);
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 2;
		gbc_button_4.gridy = 15;
		getFrmDontGetAngry().getContentPane().add(btnSy4, gbc_button_4);

		JButton btnSg3 = new JButton("SG");
		btnSg3.setBackground(new Color(0, 255, 0));
		btnSg3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSg3.setEnabled(false);
		btnSg3.setForeground(Color.GREEN);
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 12;
		gbc_button_7.gridy = 15;
		getFrmDontGetAngry().getContentPane().add(btnSg3, gbc_button_7);

		JButton btnSg4 = new JButton("SG");
		btnSg4.setBackground(new Color(0, 255, 0));
		btnSg4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				addClicked(temp.getText());
			}
		});
		btnSg4.setEnabled(false);
		btnSg4.setForeground(Color.GREEN);
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 13;
		gbc_button_6.gridy = 15;
		getFrmDontGetAngry().getContentPane().add(btnSg4, gbc_button_6);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public JFrame getFrmDontGetAngry() {
		return frmDontGetAngry;
	}

	public void setFrmDontGetAngry(JFrame frmDontGetAngry) {
		this.frmDontGetAngry = frmDontGetAngry;
	}

}
