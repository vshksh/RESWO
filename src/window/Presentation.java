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
import java.awt.event.ActionEvent;

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
		Reswo reswo = new Reswo();
		
		reswo.setA(195385);
		reswo.setB(700000);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnLiczbaA = new JTextPane();
		txtpnLiczbaA.setText("liczba A:");
		txtpnLiczbaA.setEditable(false);
		txtpnLiczbaA.setBounds(32, 24, 97, 20);
		contentPane.add(txtpnLiczbaA);
		
		JTextPane txtpnLiczbaB = new JTextPane();
		txtpnLiczbaB.setText("liczba B:");
		txtpnLiczbaB.setEditable(false);
		txtpnLiczbaB.setBounds(32, 114, 97, 20);
		contentPane.add(txtpnLiczbaB);

		
		JTextPane txtpnCzNiszaA = new JTextPane();
		txtpnCzNiszaA.setText("Cz\u0119\u015B\u0107 ni\u017Csza:");
		txtpnCzNiszaA.setBounds(32, 55, 190, 20);
		contentPane.add(txtpnCzNiszaA);
		
		JTextPane txtpnCzWyszaA = new JTextPane();
		txtpnCzWyszaA.setText("Cz\u0119\u015B\u0107 wy\u017Csza:");
		txtpnCzWyszaA.setBounds(32, 74, 190, 20);
		contentPane.add(txtpnCzWyszaA);
		
		JTextPane txtpnCzNiszaB = new JTextPane();
		txtpnCzNiszaB.setText("Cz\u0119\u015B\u0107 ni\u017Csza:");
		txtpnCzNiszaB.setBounds(32, 145, 190, 20);
		contentPane.add(txtpnCzNiszaB);
		
		JTextPane txtpnCzWyszaB = new JTextPane();
		txtpnCzWyszaB.setText("Cz\u0119\u015B\u0107 wy\u017Csza:");
		txtpnCzWyszaB.setBounds(32, 163, 190, 20);
		contentPane.add(txtpnCzWyszaB);
		
		
		JButton btnDalej = new JButton("Dalej");
		btnDalej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				reswo.nextStep();
				txtpnLiczbaA.setText("liczba A: " + reswo.getA());
				txtpnLiczbaB.setText("liczba B: " + reswo.getB());
				txtpnCzNiszaA.setText("Cz\u0119\u015B\u0107 ni\u017Csza: " + reswo.AL.toString());
				txtpnCzWyszaA.setText("Cz\u0119\u015B\u0107 wy\u017Csza: " + reswo.AH.toString());
				txtpnCzNiszaB.setText("Cz\u0119\u015B\u0107 ni\u017Csza: " + reswo.BL.toString());
				txtpnCzWyszaB.setText("Cz\u0119\u015B\u0107 wy\u017Csza: " + reswo.BH.toString());
				
			}
		});
		btnDalej.setBounds(335, 24, 89, 23);
		contentPane.add(btnDalej);
	}
}
