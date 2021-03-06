
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
//test
	private static final String KLEIN = "KLEIN";
	private static final String GROß = "GROß";
	private static final String ZAHLEN = "ZAHLEN";
	private static final String SONDER = "SONDER";
	private static final String GENERIEREN = "GENERIEREN";
	private static final String KOPIEREN = "KOPIEREN";
	private static final String AUSCHLIEßEN = "AUSCHLIEßEN";

	private static final Dimension lbl_size = new Dimension(100, 27);
	private static final Dimension tf_size = new Dimension(25, 27);
	private static final Dimension chbox_size = new Dimension(25, 27);
	private static final Dimension btn_size = new Dimension(142, 27);

	private JTextField tf_großbuchstaben;
	private JTextField tf_kleinbuchstaben;
	private JTextField tf_zahlen;
	private JTextField tf_sonderzeichen;
	private JTextField tf_newPassword;
	private JTextField tf_ausschließen;
	private JCheckBox chbox_sonderzeichen;
	private JCheckBox chbox_kleinbuchstaben;
	private JCheckBox chbox_großbuchstaben;
	private JCheckBox chbox_ausschließen;
	private JCheckBox chbox_zahlen;

	private int klein = 4;
	private int groß = 4;
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

		JLabel lbl_großbuchstaben = new JLabel("Großbuchstaben");
		lbl_großbuchstaben.setSize(lbl_size);
		lbl_großbuchstaben.setLocation(10, 70);
		getContentPane().add(lbl_großbuchstaben);

		chbox_großbuchstaben = new JCheckBox();
		chbox_großbuchstaben.addActionListener(this);
		chbox_großbuchstaben.setActionCommand(GROß);
		chbox_großbuchstaben.setSize(chbox_size);
		chbox_großbuchstaben.setLocation(200, 70);
		chbox_großbuchstaben.setSelected(true);
		getContentPane().add(chbox_großbuchstaben);

		tf_großbuchstaben = new JTextField("" + groß);
		tf_großbuchstaben.setEnabled(false);
		tf_großbuchstaben.setSize(tf_size);
		tf_großbuchstaben.setLocation(250, 70);
		getContentPane().add(tf_großbuchstaben);

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

		JLabel lbl_ausschließen = new JLabel("Ausschließen");
		lbl_ausschließen.setSize(lbl_size);
		lbl_ausschließen.setLocation(10, 160);
		getContentPane().add(lbl_ausschließen);

		chbox_ausschließen = new JCheckBox();
		chbox_ausschließen.addActionListener(this);
		chbox_ausschließen.setSize(chbox_size);
		chbox_ausschließen.setLocation(160, 160);
		chbox_ausschließen.setActionCommand(AUSCHLIEßEN);
		chbox_ausschließen.setSelected(true);
		getContentPane().add(chbox_ausschließen);

		tf_ausschließen = new JTextField("oO0lI");
		tf_ausschließen.setEnabled(false);
		tf_ausschließen.setSize(75, tf_size.width);
		tf_ausschließen.setLocation(200, 160);
		getContentPane().add(tf_ausschließen);

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
		int länge = 0;
		int sonderzeichen = 0, kleinbuchstaben = 0, großbuchstaben = 0, zahlen = 0;
		String passwd = "";
		try {
			if (tf_sonderzeichen.isEnabled())
				sonderzeichen = Integer.parseInt(tf_sonderzeichen.getText());
			if (tf_kleinbuchstaben.isEnabled())
				kleinbuchstaben = Integer.parseInt(tf_kleinbuchstaben.getText());
			if (tf_großbuchstaben.isEnabled())
				großbuchstaben = Integer.parseInt(tf_großbuchstaben.getText());
			if (tf_zahlen.isEnabled())
				zahlen = Integer.parseInt(tf_zahlen.getText());
			länge = sonderzeichen + kleinbuchstaben + großbuchstaben + zahlen;
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

		for (int i = 0; i < großbuchstaben; i++) {
			passwd += getGroßbuchstabe();
		}

		for (int i = 0; i < zahlen; i++) {
			passwd += getZahlen();
		}
		String newPasswd = "";

		ArrayList<Integer> zahlenList = new ArrayList<Integer>();
		int newZahl = 0;

		for (int i = 0; i < passwd.length(); i++) {
			do {

				newZahl = (int) (Math.random() * länge) + 0;
			} while (zahlenList.contains(newZahl) != false);
			zahlenList.add(newZahl);
			String newPasscharacter = passwd.charAt(newZahl) + "";

			newPasswd += newPasscharacter;

		}

		return newPasswd;
	}

	private boolean containsAnyOfAusschließen(String newPasswd) {
		char[] ausschließenChars = tf_ausschließen.getText().trim().replaceAll(" ", "").toCharArray();
		char[] passwdArray = newPasswd.toCharArray();
		
		if(chbox_ausschließen.isSelected()==false) 
			return false;
		
		for (int i = 0; i < ausschließenChars.length; i++) {
			for (int y = 0; y < passwdArray.length; y++) {
				String a = ausschließenChars[i] + "";
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

	private char getGroßbuchstabe() {
		char[] alphabetGroß = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
		int random = (int) (Math.random() * 25) + 0;
		return alphabetGroß[random];
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

		if (chbox_großbuchstaben.isSelected())
			tf_großbuchstaben.setEnabled(true);
		else
			tf_großbuchstaben.setEnabled(false);

		if (chbox_sonderzeichen.isSelected())
			tf_sonderzeichen.setEnabled(true);
		else
			tf_sonderzeichen.setEnabled(false);

		if (chbox_zahlen.isSelected())
			tf_zahlen.setEnabled(true);
		else
			tf_zahlen.setEnabled(false);
		if (chbox_ausschließen.isSelected())
			tf_ausschließen.setEnabled(true);
		else
			tf_ausschließen.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkCheckboxes();
		if (e.getActionCommand().equals(GENERIEREN)) {
			String newPassword = "";
			do {
				newPassword = erzeugePassword();
				
			}while(containsAnyOfAusschließen(newPassword));
			tf_newPassword.setText(newPassword);
		}
		if (e.getActionCommand().equals(KOPIEREN)) {
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(tf_newPassword.getText()),
					null);
		}

	}

}
