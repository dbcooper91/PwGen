
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PassGenerator extends JFrame implements ActionListener {

	private static final int x_size = 320;
	private static final int y_size = 320;
//test223
	private static final String KLEIN = "KLEIN";
	private static final String GRO� = "GRO�";
	private static final String ZAHLEN = "ZAHLEN";
	private static final String SONDER = "SONDER";
	private static final String GENERIEREN = "GENERIEREN";
	private static final String KOPIEREN = "KOPIEREN";
	private static final String AUSCHLIE�EN = "AUSCHLIE�EN";

	private static final Dimension lbl_size = new Dimension(100, 27);
	private static final Dimension tf_size = new Dimension(25, 27);
	private static final Dimension chbox_size = new Dimension(25, 27);
	private static final Dimension btn_size = new Dimension(142, 27);

	private JTextField tf_gro�buchstaben;
	private JTextField tf_kleinbuchstaben;
	private JTextField tf_zahlen;
	private JTextField tf_sonderzeichen;
	private JTextField tf_newPassword;
	private JTextField tf_ausschlie�en;
	private JCheckBox chbox_sonderzeichen;
	private JCheckBox chbox_kleinbuchstaben;
	private JCheckBox chbox_gro�buchstaben;
	private JCheckBox chbox_ausschlie�en;
	private JCheckBox chbox_zahlen;

	private int klein = 4;
	private int gro� = 4;
	private int sonder = 2;
	private int zahlen = 4;

	public static void main(String[] args) {
		PassGenerator pg = new PassGenerator();
		pg.checkCheckboxes();

	}

	public PassGenerator() {

		setTitle("PassGenerator");
		setSize(x_size, y_size);

		setLayout(null);

		JLabel lbl_anzahl = new JLabel("Anzahl");
		lbl_anzahl.setSize(lbl_size);
		lbl_anzahl.setLocation(245, 10);
		getContentPane().add(lbl_anzahl);

		JLabel lbl_kleinbuchstaben = new JLabel("Kleinbuchstaben");
		lbl_kleinbuchstaben.setSize(lbl_size);
		lbl_kleinbuchstaben.setLocation(10, 40);
		getContentPane().add(lbl_kleinbuchstaben);

		chbox_kleinbuchstaben = new JCheckBox();
		chbox_kleinbuchstaben.addActionListener(this);
		chbox_kleinbuchstaben.setActionCommand(KLEIN);
		chbox_kleinbuchstaben.setSize(chbox_size);
		chbox_kleinbuchstaben.setLocation(200, 40);
		chbox_kleinbuchstaben.setSelected(true);
		getContentPane().add(chbox_kleinbuchstaben);

		tf_kleinbuchstaben = new JTextField("" + klein);
		tf_kleinbuchstaben.setEnabled(false);
		tf_kleinbuchstaben.setSize(tf_size);
		tf_kleinbuchstaben.setLocation(250, 40);
		getContentPane().add(tf_kleinbuchstaben);

		JLabel lbl_gro�buchstaben = new JLabel("Gro�buchstaben");
		lbl_gro�buchstaben.setSize(lbl_size);
		lbl_gro�buchstaben.setLocation(10, 70);
		getContentPane().add(lbl_gro�buchstaben);

		chbox_gro�buchstaben = new JCheckBox();
		chbox_gro�buchstaben.addActionListener(this);
		chbox_gro�buchstaben.setActionCommand(GRO�);
		chbox_gro�buchstaben.setSize(chbox_size);
		chbox_gro�buchstaben.setLocation(200, 70);
		chbox_gro�buchstaben.setSelected(true);
		getContentPane().add(chbox_gro�buchstaben);

		tf_gro�buchstaben = new JTextField("" + gro�);
		tf_gro�buchstaben.setEnabled(false);
		tf_gro�buchstaben.setSize(tf_size);
		tf_gro�buchstaben.setLocation(250, 70);
		getContentPane().add(tf_gro�buchstaben);

		JLabel lbl_zahlen = new JLabel("Zahlen");
		lbl_zahlen.setSize(lbl_size);
		lbl_zahlen.setLocation(10, 100);
		getContentPane().add(lbl_zahlen);

		chbox_zahlen = new JCheckBox();
		chbox_zahlen.addActionListener(this);
		chbox_zahlen.setActionCommand(ZAHLEN);
		chbox_zahlen.setSize(chbox_size);
		chbox_zahlen.setLocation(200, 100);
		chbox_zahlen.setSelected(true);
		getContentPane().add(chbox_zahlen);

		tf_zahlen = new JTextField("" + zahlen);
		tf_zahlen.setEnabled(false);
		tf_zahlen.setSize(tf_size);
		tf_zahlen.setLocation(250, 100);
		getContentPane().add(tf_zahlen);

		JLabel lbl_sonderzeichen = new JLabel("Sonderzeichen");
		lbl_sonderzeichen.setSize(lbl_size);
		lbl_sonderzeichen.setLocation(10, 130);
		getContentPane().add(lbl_sonderzeichen);

		chbox_sonderzeichen = new JCheckBox();
		chbox_sonderzeichen.addActionListener(this);
		chbox_sonderzeichen.setActionCommand(SONDER);
		chbox_sonderzeichen.setSize(chbox_size);
		chbox_sonderzeichen.setLocation(200, 130);
		chbox_sonderzeichen.setSelected(false);
		getContentPane().add(chbox_sonderzeichen);

		tf_sonderzeichen = new JTextField("" + sonder);
		tf_sonderzeichen.setEnabled(false);
		tf_sonderzeichen.setSize(tf_size);
		tf_sonderzeichen.setLocation(250, 130);
		getContentPane().add(tf_sonderzeichen);

		tf_newPassword = new JTextField();
		tf_newPassword.setSize(x_size - 25, 27);
		tf_newPassword.setLocation(10, 220);
		tf_newPassword.setFont(new Font("Consolas", Font.BOLD, 16));
		getContentPane().add(tf_newPassword);

		JLabel lbl_ausschlie�en = new JLabel("Ausschlie�en");
		lbl_ausschlie�en.setSize(lbl_size);
		lbl_ausschlie�en.setLocation(10, 160);
		getContentPane().add(lbl_ausschlie�en);

		chbox_ausschlie�en = new JCheckBox();
		chbox_ausschlie�en.addActionListener(this);
		chbox_ausschlie�en.setSize(chbox_size);
		chbox_ausschlie�en.setLocation(160, 160);
		chbox_ausschlie�en.setActionCommand(AUSCHLIE�EN);
		chbox_ausschlie�en.setSelected(true);
		getContentPane().add(chbox_ausschlie�en);

		tf_ausschlie�en = new JTextField("oO0lI");
		tf_ausschlie�en.setEnabled(false);
		tf_ausschlie�en.setSize(75, tf_size.width);
		tf_ausschlie�en.setLocation(200, 160);
		getContentPane().add(tf_ausschlie�en);

		JButton btn_passwordErzeugen = new JButton("Generieren");
		btn_passwordErzeugen.setSize(btn_size);
		btn_passwordErzeugen.setLocation(10, 255);
		btn_passwordErzeugen.addActionListener(this);
		btn_passwordErzeugen.setActionCommand(GENERIEREN);
		getContentPane().add(btn_passwordErzeugen);

		JButton btn_zwischenspeichern = new JButton("Kopieren");
		btn_zwischenspeichern.addActionListener(this);
		btn_zwischenspeichern.setActionCommand(KOPIEREN);
		btn_zwischenspeichern.setSize(btn_size);
		btn_zwischenspeichern.setLocation(162, 255);
		getContentPane().add(btn_zwischenspeichern);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	private String erzeugePassword() {
		int l�nge = 0;
		int sonderzeichen = 0, kleinbuchstaben = 0, gro�buchstaben = 0, zahlen = 0;
		String passwd = "";
		try {
			if (tf_sonderzeichen.isEnabled())
				sonderzeichen = Integer.parseInt(tf_sonderzeichen.getText());
			if (tf_kleinbuchstaben.isEnabled())
				kleinbuchstaben = Integer.parseInt(tf_kleinbuchstaben.getText());
			if (tf_gro�buchstaben.isEnabled())
				gro�buchstaben = Integer.parseInt(tf_gro�buchstaben.getText());
			if (tf_zahlen.isEnabled())
				zahlen = Integer.parseInt(tf_zahlen.getText());
			l�nge = sonderzeichen + kleinbuchstaben + gro�buchstaben + zahlen;
		} catch (NumberFormatException n) {
			n.printStackTrace();
		}
		// 33-47
		for (int i = 0; i < sonderzeichen; i++) {
			passwd += getSonderzeichen();
		}

		for (int i = 0; i < kleinbuchstaben; i++) {
			passwd += getKleinbuchstabe();
		}

		for (int i = 0; i < gro�buchstaben; i++) {
			passwd += getGro�buchstabe();
		}

		for (int i = 0; i < zahlen; i++) {
			passwd += getZahlen();
		}
		String newPasswd = "";

		ArrayList<Integer> zahlenList = new ArrayList<Integer>();
		int newZahl = 0;

		for (int i = 0; i < passwd.length(); i++) {
			do {

				newZahl = (int) (Math.random() * l�nge) + 0;
			} while (zahlenList.contains(newZahl) != false);
			zahlenList.add(newZahl);
			String newPasscharacter = passwd.charAt(newZahl) + "";

			newPasswd += newPasscharacter;

		}

		return newPasswd;
	}

	private boolean containsAnyOfAusschlie�en(String newPasswd) {
		char[] ausschlie�enChars = tf_ausschlie�en.getText().trim().replaceAll(" ", "").toCharArray();
		char[] passwdArray = newPasswd.toCharArray();
		
		if(chbox_ausschlie�en.isSelected()==false) 
			return false;
		
		for (int i = 0; i < ausschlie�enChars.length; i++) {
			for (int y = 0; y < passwdArray.length; y++) {
				String a = ausschlie�enChars[i] + "";
				String p = passwdArray[y] + "";
				if (a.equals(p)) {
					return true;
				}
			}
		}

		return false;

	}

	private char getSonderzeichen() {
		char[] sonderzeichen = "!\"#$%&'()*+,-./".toCharArray();
		int random = (int) (Math.random() * 15) + 0;
		return sonderzeichen[random];
	}

	private char getGro�buchstabe() {
		char[] alphabetGro� = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
		int random = (int) (Math.random() * 25) + 0;
		return alphabetGro�[random];
	}

	private char getKleinbuchstabe() {
		char[] alphabetKlein = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int random = (int) (Math.random() * 25) + 0;
		return alphabetKlein[random];
	}

	private char getZahlen() {
		char[] zahlen = "0123456789".toCharArray();
		int random = (int) (Math.random() * 10) + 0;
		return zahlen[random];
	}

	private void checkCheckboxes() {
		if (chbox_kleinbuchstaben.isSelected())
			tf_kleinbuchstaben.setEnabled(true);
		else
			tf_kleinbuchstaben.setEnabled(false);

		if (chbox_gro�buchstaben.isSelected())
			tf_gro�buchstaben.setEnabled(true);
		else
			tf_gro�buchstaben.setEnabled(false);

		if (chbox_sonderzeichen.isSelected())
			tf_sonderzeichen.setEnabled(true);
		else
			tf_sonderzeichen.setEnabled(false);

		if (chbox_zahlen.isSelected())
			tf_zahlen.setEnabled(true);
		else
			tf_zahlen.setEnabled(false);
		if (chbox_ausschlie�en.isSelected())
			tf_ausschlie�en.setEnabled(true);
		else
			tf_ausschlie�en.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkCheckboxes();
		if (e.getActionCommand().equals(GENERIEREN)) {
			String newPassword = "";
			do {
				newPassword = erzeugePassword();
				
			}while(containsAnyOfAusschlie�en(newPassword));
			tf_newPassword.setText(newPassword);
		}
		if (e.getActionCommand().equals(KOPIEREN)) {
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(tf_newPassword.getText()),
					null);
		}

	}

}
