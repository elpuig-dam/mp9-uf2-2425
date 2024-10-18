package s3.filosofs;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Taula extends JFrame {

	private JPanel contentPane;
	public  JLabel lblFilosof0;
	public  JLabel lblFilosof1;
	public  JLabel lblFilosof2;
	public  JLabel lblFilosof3;

	//Objectes per sincronitzar i evitar el deadlock
	public static Object lock1 = new Object();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Taula f = new Taula();

		EventQueue.invokeLater(() -> f.setVisible(true));

	}

	
	public Taula() {
		iniciarTauler();
		iniciarSopar();				
	}
	
	private void iniciarSopar() {

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		int numFilosofs=4;
		Cobert[] coberts;
		
		coberts = new Cobert[numFilosofs];
		
		// crear coberts
		for (int i=0;i<coberts.length;i++) {
			coberts[i] = new Cobert();
		}
		
		// Crear Filosofs i assignar coberts
		Filosof f1 = new Filosof("Abel", coberts[0], coberts[1],lblFilosof0);
		Filosof f2 = new Filosof("Belen", coberts[1], coberts[2],lblFilosof1);
		Filosof f3 = new Filosof("Carles", coberts[2], coberts[3],lblFilosof2);
		Filosof f4 = new Filosof("Dani", coberts[3], coberts[0],lblFilosof3);
		// Activar Filosofs	
		executor.execute(f1);
		executor.execute(f2);
		executor.execute(f3);
		executor.execute(f4);

		executor.shutdown();

		
	}

	public void iniciarTauler() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		lblFilosof0 = new JLabel("Filosof0");
		lblFilosof0.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilosof0.setOpaque(true);
		contentPane.add(lblFilosof0);
		
		lblFilosof1 = new JLabel("Filosof1");
		lblFilosof1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilosof1.setOpaque(true);
		contentPane.add(lblFilosof1);
		
		lblFilosof3 = new JLabel("Filosof3");
		lblFilosof3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilosof3.setOpaque(true);
		contentPane.add(lblFilosof3);
		
		
		lblFilosof2 = new JLabel("Filosof2");
		lblFilosof2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilosof2.setOpaque(true);
		contentPane.add(lblFilosof2);
		
	}

}
