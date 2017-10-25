package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class MainMenu {

	private JFrame frmDontGetAngry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmDontGetAngry.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDontGetAngry = new JFrame();
		frmDontGetAngry.setResizable(false);
		frmDontGetAngry.setTitle("Don't get Angry!");
		frmDontGetAngry.setBounds(100, 100, 531, 421);
		frmDontGetAngry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmDontGetAngry.getContentPane().setLayout(gridBagLayout);
		
		JButton btnNewButton = new JButton("Start Game");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 4;
		frmDontGetAngry.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblSelectGametype = new JLabel("Select gametype");
		GridBagConstraints gbc_lblSelectGametype = new GridBagConstraints();
		gbc_lblSelectGametype.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectGametype.gridx = 5;
		gbc_lblSelectGametype.gridy = 7;
		frmDontGetAngry.getContentPane().add(lblSelectGametype, gbc_lblSelectGametype);
		ButtonGroup rule= new ButtonGroup();
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Classic");
		rdbtnNewRadioButton.setSelected(true);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 2;
		gbc_rdbtnNewRadioButton.gridy = 8;
		frmDontGetAngry.getContentPane().add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		rule.add(rdbtnNewRadioButton);
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Nojump");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_1.gridx = 7;
		gbc_rdbtnNewRadioButton_1.gridy = 8;
		frmDontGetAngry.getContentPane().add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		rule.add(rdbtnNewRadioButton_1);
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Barrier");
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnNewRadioButton_2.gridx = 2;
		gbc_rdbtnNewRadioButton_2.gridy = 10;
		frmDontGetAngry.getContentPane().add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		rule.add(rdbtnNewRadioButton_2);
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Backward");
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.gridx = 7;
		gbc_rdbtnNewRadioButton_3.gridy = 10;
		frmDontGetAngry.getContentPane().add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
		rule.add(rdbtnNewRadioButton_3);
	}

}
