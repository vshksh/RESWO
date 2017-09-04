package window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import alg.Reswo;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Presentation extends JFrame
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Presentation frame = new Presentation();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Presentation()
	{
		setBackground(Color.WHITE);
		Reswo reswo = new Reswo();
		
		String sciezkaDoPliku = "dane.txt";
		try
		{
			Scanner plik = new Scanner(new File(sciezkaDoPliku));
			reswo.setA(plik.nextInt());
			reswo.setB(plik.nextInt());
		} catch (FileNotFoundException e)
		{
			reswo.setA(195385);
			reswo.setB(700000);

		}
		

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 515);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnLiczbaA = new JTextPane();
		txtpnLiczbaA.setText("liczba A:");
		txtpnLiczbaA.setEditable(false);
		txtpnLiczbaA.setBounds(32, 24, 179, 20);
		contentPane.add(txtpnLiczbaA);
		
		JTextPane txtpnLiczbaB = new JTextPane();
		txtpnLiczbaB.setText("liczba B:");
		txtpnLiczbaB.setEditable(false);
		txtpnLiczbaB.setBounds(32, 105, 179, 20);
		contentPane.add(txtpnLiczbaB);

		
		JTextPane txtpnCzNiszaA = new JTextPane();
		txtpnCzNiszaA.setText("Cz\u0119\u015B\u0107 ni\u017Csza:");
		txtpnCzNiszaA.setBounds(32, 43, 328, 20);
		contentPane.add(txtpnCzNiszaA);
		
		JTextPane txtpnCzWyszaA = new JTextPane();
		txtpnCzWyszaA.setText("Cz\u0119\u015B\u0107 wy\u017Csza:");
		txtpnCzWyszaA.setBounds(32, 63, 328, 20);
		contentPane.add(txtpnCzWyszaA);
		
		JTextPane txtpnCzNiszaB = new JTextPane();
		txtpnCzNiszaB.setText("Cz\u0119\u015B\u0107 ni\u017Csza:");
		txtpnCzNiszaB.setBounds(32, 123, 328, 20);
		contentPane.add(txtpnCzNiszaB);
		
		JTextPane txtpnCzWyszaB = new JTextPane();
		txtpnCzWyszaB.setText("Cz\u0119\u015B\u0107 wy\u017Csza:");
		txtpnCzWyszaB.setBounds(32, 143, 328, 20);
		contentPane.add(txtpnCzWyszaB);

		
		JTextPane txtpnSumatorWyszy = new JTextPane();
		txtpnSumatorWyszy.setText("Sumator wy\u017Cszy:");
		txtpnSumatorWyszy.setBounds(32, 184, 97, 20);
		contentPane.add(txtpnSumatorWyszy);
		
		JTextPane sumH = new JTextPane();
		sumH.setBounds(32, 202, 294, 20);
		contentPane.add(sumH);
		
		JTextPane txtpnSumatorNiszy = new JTextPane();
		txtpnSumatorNiszy.setText("Sumator ni\u017Cszy:");
		txtpnSumatorNiszy.setBounds(31, 233, 98, 20);
		contentPane.add(txtpnSumatorNiszy);
		
		JTextPane sumL = new JTextPane();
		sumL.setBounds(32, 252, 294, 20);
		contentPane.add(sumL);

		JTextPane txtpnWynik = new JTextPane();
		txtpnWynik.setText("Wynik:");
		txtpnWynik.setBounds(32, 283, 107, 20);
		contentPane.add(txtpnWynik);
		
		JTextPane wynik = new JTextPane();
		wynik.setBounds(32, 302, 294, 20);
		contentPane.add(wynik);
		
		JTextPane txtpnWynikPoZamianie = new JTextPane();
		txtpnWynikPoZamianie.setText("Wynik po zamianie:");
		txtpnWynikPoZamianie.setBounds(32, 333, 144, 20);
		contentPane.add(txtpnWynikPoZamianie);
		
		JTextPane wynikZam = new JTextPane();
		wynikZam.setBounds(32, 353, 294, 20);
		contentPane.add(wynikZam);
		
		JTextPane krok = new JTextPane();
		krok.setBounds(10, 443, 414, 23);
		contentPane.add(krok);
		

				
				
				JButton btnDalej = new JButton("Dalej");
				btnDalej.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0)
					{
						reswo.nextStep();
						txtpnLiczbaA.setText("liczba A: " + reswo.getA());
						txtpnLiczbaB.setText("liczba B: " + reswo.getB());
						txtpnCzNiszaA.setText("Cz\u0119\u015B\u0107 ni\u017Csza:  " + reswo.AL.toString());
						txtpnCzWyszaA.setText("Cz\u0119\u015B\u0107 wy\u017Csza: " + reswo.AH.toString());
						txtpnCzNiszaB.setText("Cz\u0119\u015B\u0107 ni\u017Csza:  " + reswo.BL.toString());
						txtpnCzWyszaB.setText("Cz\u0119\u015B\u0107 wy\u017Csza: " + reswo.BH.toString());
						sumH.setText(reswo.higherAdder.toString());
						sumL.setText(reswo.lowerAdder.toString());
						wynik.setText(reswo.result.toString());
						wynikZam.setText(reswo.resultSwapped.toString());
						krok.setText(reswo.step);
						
					}
				});
				btnDalej.setBounds(10, 416, 89, 23);
				contentPane.add(btnDalej);
		
	}
}
