package window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1111", "0000"},
			},
			new String[] {
				"AH", "AL"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(44, 40, 115, 16);
		contentPane.add(table);
		
		JTextPane txtpnLiczbaA = new JTextPane();
		txtpnLiczbaA.setText("Liczba A:");
		txtpnLiczbaA.setBounds(44, 11, 72, 20);
		contentPane.add(txtpnLiczbaA);
		
		JTextPane txtpnLiczbaB = new JTextPane();
		txtpnLiczbaB.setText("Liczba B:");
		txtpnLiczbaB.setBounds(197, 11, 72, 20);
		contentPane.add(txtpnLiczbaB);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"0000", "1111"},
			},
			new String[] {
				"BH", "BL"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.setBounds(197, 40, 115, 16);
		contentPane.add(table_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(335, 36, 89, 23);
		contentPane.add(btnNewButton);
	}
}
