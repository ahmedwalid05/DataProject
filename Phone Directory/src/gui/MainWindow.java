package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import data.DataHandler;

import java.awt.Button;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import data.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField idField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTable table;
	private static final String columnNames[] = {"ID", "Name", "Email", "Phone Number"};
	/**
	 * Launch the application.
	 */
	private static DataHandler dataHandler = new DataHandler();
	public static void main(String[] args) {
		dataHandler.addContact(new Contact(1,"Ahmed Walid Massoud","ahmedwalid05@gmail.com",70560364,974));
		dataHandler.addContact(new Contact(2,"Walid Ahmed Massoud","am1703929@qu.edu.qa",70560212,974));

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	@SuppressWarnings("serial")
	public MainWindow() {
		setTitle("Phone Directory ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 482);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 439, 67);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(10, 14, 46, 14);
		panel.add(idLabel);

		idField = new JTextField();
		idField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				@SuppressWarnings("unused")
				int x;
				try {
					x= Integer.parseInt(idField.getText());
				}catch (NumberFormatException  e5) {
					if(idField.getText().length()>0)
						idField.setText(idField.getText().substring(0, idField.getText().length()-1));

				}
			}
		});

		idField.setColumns(10);		
		idField.setBounds(62, 11, 150, 20);
		panel.add(idField);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(222, 14, 46, 14);
		panel.add(lblName);

		nameField = new JTextField();
		nameField.setBounds(278, 11, 150, 20);
		panel.add(nameField);
		nameField.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 39, 46, 14);
		panel.add(lblEmail);

		emailField = new JTextField();
		emailField.setBounds(62, 39, 150, 20);
		panel.add(emailField);
		emailField.setColumns(10);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(222, 42, 46, 14);
		panel.add(lblPhone);

		phoneField = new JTextField();
		phoneField.setBounds(278, 39, 150, 20);
		phoneField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				@SuppressWarnings("unused")
				int x;
				try {
					x= Integer.parseInt(idField.getText());
				}catch (NumberFormatException  e5) {
					if(idField.getText().length()>0)
						idField.setText(idField.getText().substring(0, idField.getText().length()-1));

				}
			}
		});
		panel.add(phoneField);
		phoneField.setColumns(10);



		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {


					dataHandler.addContact(new Contact(Integer.parseInt(idField.getText()),
							nameField.getText(),
							emailField.getText(),
							Integer.parseInt(phoneField.getText()) ,
							974));
					notifydataSetchanged();
					idField.setText("");
					nameField.setText("");
					emailField.setText("");
					phoneField.setText("");
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});
		btnAdd.setBounds(467, 11, 89, 23);
		contentPane.add(btnAdd);

		JButton btnDelete = new JButton("Delete");

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1) {
					dataHandler.deleteContact(table.getSelectedRow());
					notifydataSetchanged();
				}
			}
		});
		btnDelete.setBounds(467, 55, 89, 23);
		contentPane.add(btnDelete);

		JButton btnSearch = new JButton("Search");

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//dataHandler.search(idField.getText(), nameField.getText(), emailField.getText(), phoneField.getText());
				//TODO - fix me
			}
		});
		btnSearch.setToolTipText("Search by Name");
		btnSearch.setBounds(10, 89, 439, 23);
		contentPane.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 123, 544, 309);

		contentPane.add(scrollPane);

		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setModel(new DefaultTableModel(dataHandler.getDataAsTwoArray(),columnNames) 
		{
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(1);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(136);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);

		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(JLabel.LEFT);
		table.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(leftRenderer);

		table.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {

				Contact contact = dataHandler.get(table.getSelectedRow());
				contact.setId((int)table.getValueAt(table.getSelectedRow(), 0));
				contact.setName(table.getValueAt(table.getSelectedRow(), 1).toString());
				contact.setEmail(table.getValueAt(table.getSelectedRow(), 2).toString());
				contact.setNumber((int)table.getValueAt(table.getSelectedRow(), 3));
			}
		});

		scrollPane.setViewportView(table);



	}
	public void notifydataSetchanged() {

		((DefaultTableModel)table.getModel()).setDataVector(dataHandler.getDataAsTwoArray(), columnNames);
		((DefaultTableModel)table.getModel()).fireTableDataChanged();
	}

}
