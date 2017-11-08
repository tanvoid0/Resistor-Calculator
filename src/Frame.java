import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	private JPanel contentPane;
	private String[] list = {"", "Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Grey", "White"};
	private String[] multiplier = {"", "Silver", "Gold", "Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue"};
	private String[] tolerance = {"None", "Violet", "Blue", "Green", "Silver", "Gold", "Brown", "Red"};
	@SuppressWarnings("rawtypes")
	private JComboBox combo1;
	@SuppressWarnings("rawtypes")
	private JComboBox combo2;
	@SuppressWarnings("rawtypes")
	private JComboBox combo3;
	@SuppressWarnings("rawtypes")
	private JComboBox combo4;
	private JLabel lblResult;
	private JToggleButton tgl1;
	private JToggleButton tgl2;
	//private boolean toggle = false;
	private JLabel lbl5;
	@SuppressWarnings("rawtypes")
	private JComboBox combo5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	@SuppressWarnings("rawtypes")
	private JComboBox combo3b;
	@SuppressWarnings("rawtypes")
	private JComboBox combo4b;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Frame() {
		setTitle("Resistor Calculator");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		/*
		 * Layout 1
		 */
		
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(contentPane);
		
        
        /*
         *	Escape code 
         */
        
        contentPane.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "EXIT"); 
        contentPane.getRootPane().getActionMap().put("EXIT", new AbstractAction(){ 
        public void actionPerformed(ActionEvent e)
        	{
        		//frmHome.dispose();
        		System.exit(0);
        	}
        });
        
        
        
		
		
		JLabel lblstBand = new JLabel("1st Band:");
		lblstBand.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblstBand.setBounds(28, 47, 85, 22);
		contentPane.add(lblstBand);
		
		JLabel lblndBand = new JLabel("2nd Band:");
		lblndBand.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblndBand.setBounds(28, 92, 92, 22);
		contentPane.add(lblndBand);
		
		JLabel lblrdBand = new JLabel("3rd Band:");
		lblrdBand.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblrdBand.setBounds(28, 132, 88, 22);
		contentPane.add(lblrdBand);
		
		JLabel lblthBand = new JLabel("4th Band:");
		lblthBand.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblthBand.setBounds(28, 176, 88, 22);
		contentPane.add(lblthBand);
		
		
		combo1 = new JComboBox(list);
		combo1.setBounds(139, 47, 72, 20);
		contentPane.add(combo1);
		
		combo2 = new JComboBox(list);
		combo2.setBounds(139, 92, 72, 20);
		contentPane.add(combo2);
		
		combo3 = new JComboBox(multiplier);
		combo3.setBounds(139, 132, 72, 20);
		contentPane.add(combo3);
		
		combo4 = new JComboBox(tolerance);
		combo4.setBounds(139, 176, 72, 20);
		contentPane.add(combo4);
		
		combo3b = new JComboBox(list);
		combo3b.setBounds(139, 132, 72, 20);
		contentPane.add(combo3b);
		
		combo4b = new JComboBox(multiplier);
		combo4b.setBounds(139, 176, 72, 20);
		contentPane.add(combo4b);
		
		combo5 = new JComboBox(tolerance);
		combo5.setBounds(139, 217, 72, 20);
		contentPane.add(combo5);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calculate();
			}
		});
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCalculate.setBounds(266, 181, 125, 33);
		contentPane.add(btnCalculate);
		
		lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(228, 102, 196, 68);
		contentPane.add(lblResult);
		
		lbl5 = new JLabel("5th Band:");
		lbl5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl5.setBounds(28, 217, 88, 22);
		contentPane.add(lbl5);
		
		
		
		tgl1 = new JToggleButton("4 Band");
		buttonGroup.add(tgl1);
		tgl1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				toggle();
				tgl1.enable(false);
			}
		});
		tgl1.setBounds(59, 11, 121, 23);
		contentPane.add(tgl1);
		
		tgl2 = new JToggleButton("5 Band");
		buttonGroup.add(tgl2);
		tgl2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggle();
			}
		});
		tgl2.setBounds(232, 11, 121, 23);
		contentPane.add(tgl2);
		
		
		tgl1.doClick();
	}
	
	public void Calculate(){
		int value1 = Band((String) combo1.getSelectedItem());
		int value2 = Band((String) combo2.getSelectedItem());
		
		double value3, value4, value5, value;
		if(tgl1.isSelected()){
			value3 = Multiplier((String) combo3.getSelectedItem());
			value5 = Tolerance((String) combo4.getSelectedItem());
			
			value = (((10*value1)+value2) * value3);
		}
		else{
			value3 = Band((String) combo3b.getSelectedItem());
			value4 = Multiplier((String) combo4b.getSelectedItem());
			value5 = Tolerance((String) combo5.getSelectedItem());
			
			value = (((100*value1)+(10*value2)+value3) * value4);
		}
		
		lblResult.setText(prefix(value) + "Ω ±" + value5 + "%");
		
		
	}
	public static boolean isInt(double number){
	    return Math.ceil(number) == Math.floor(number); 
	}
	
	public String prefix(double value)
	{
		
		if(value >= 1000){
			value = value/1000;
			if(isInt(value))
				return String.valueOf((int)value)+" k";
			else
				return String.valueOf(value)+" k";
			
		}
		else if(value >= 1){
			if(isInt(value))
				return String.valueOf((int)value)+" ";
			else
				return String.valueOf(value)+" ";
		}
		else if(value >= .001){
			value = value/.001;
			if(isInt(value))
				return String.valueOf((int)value)+" m";
			else
				return String.valueOf(value)+" m";
		}
		else if(value >= .000001){
			value = value/.000001;
			if(isInt(value))
				return String.valueOf((int)value)+" µ";
			else
			return String.valueOf(value)+" µ";
		}
		else if(value >= .000000001){
			value =  value/.000000001;
			if(isInt(value))
				return String.valueOf((int)value)+" n";
			else
				return String.valueOf(value)+" n";
		}
		else{
			return "";
		}
		
	
	}
	
	public int Band(String color)
	{
		if(color == "Black")
			return 0;
		else if(color == "Brown")
			return 1;
		else if(color == "Red")
			return 2;
		else if(color == "Orange")
			return 3;
		else if(color == "Yellow")
			return 4;
		else if(color == "Green")
			return 5;
		else if(color == "Blue")
			return 6;
		else if(color == "Violet")
			return 7;
		else if(color == "Grey")
			return 8;
		else if(color == "White")
			return 9;
		else 
			return -1;
		}
	
	public double Multiplier(String color)
	{
		if(color == "Black")
			return 1;
		else if(color == "Brown")
			return 10;
		else if(color == "Red")
			return 100;
		else if(color == "Orange")
			return 1000;
		else if(color == "Yellow")
			return 10000;
		else if(color == "Green")
			return 100000;
		else if(color == "Blue")
			return 1000000;
		else if(color == "Gold")
			return 0.1;
		else if(color == "Silver")
			return 0.01;
		else 
			return -1;
	}
	
	public double Tolerance(String color)
	{
		if(color == "Violet")
			return 0.1;
		
		else if(color == "Blue")
			return 0.25;
		else if(color == "Green")
			return 0.5;
		else if(color == "Brown")
			return 1;
		else if(color == "Red")
			return 2;
		else if(color == "Gold")
			return 5;
		else if(color == "Silver")
			return 10;
		else
			return 20;
	}
	
	public void toggle()
	{
		//toggle = !toggle;
		
		if(tgl1.isSelected()){
			lbl5.setVisible(false);
			
			combo3.setVisible(true);
			combo4.setVisible(true);
			
			combo3b.setVisible(false);
			combo4b.setVisible(false);
			combo5.setVisible(false);
		}
		else if (tgl2.isSelected()){

			lbl5.setVisible(true);
			
			combo3b.setVisible(true);
			combo4b.setVisible(true);
			combo5.setVisible(true);
			
			combo3.setVisible(false);
			combo4.setVisible(false);
		}
	}
}
