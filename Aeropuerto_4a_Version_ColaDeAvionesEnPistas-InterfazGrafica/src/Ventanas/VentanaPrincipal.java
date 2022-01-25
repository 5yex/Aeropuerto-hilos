package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultCaret;

import Operaciones.OperacionesAeropuerto;

/**
 * Proyecto TORRE DE CONTROL AEROPUERTO
 * 
 * Versi�n 2: (LA ACORDE CON EL ENUNCIADO)
 * 
 * - En esta versi�n los aviones piden una pista a la torre de control: � Si la
 * pista est� ocupada, repite su bucle hasta que vuelve a pedir pista. � Si la
 * pista est� LIBRE, aterriza en ella y realiza todas sus acciones.
 *
 * - La pista asignada es aleatoria-
 * 
 * 
 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
 * 
 */
public class VentanaPrincipal {
	static JFrame frame = new JFrame();

	public static void main(String[] args) {
		frame.setTitle("SIMULADOR AEROPUERTO Y TORRE DE CONTROL");
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LaminaPrincipal laminaPrincipal = new LaminaPrincipal();
		frame.add(laminaPrincipal);
		frame.setVisible(true);

	}
}

class LaminaPrincipal extends JPanel {
	/**
	 * 
	 */
	private OperacionesAeropuerto aeropuerto;
	private static final long serialVersionUID = 1L;
	private JPanel LaminaBarraSuperior = new JPanel();
	private JButton parar;
	private JTextArea output = new JTextArea();
	private int nAviones;
	private int nPistas;
	private boolean funcionarEnBucle = false;

	public LaminaPrincipal() {
		setLayout(new BorderLayout());
		LaminaBarraSuperior.add(generarBotonPedirNumeroPistas());
		LaminaBarraSuperior.add(generarBotonIntroducirNAviones());
		LaminaBarraSuperior.add(generarBotonComenzar());
		parar = new JButton("Parar Bucle");
		parar.setEnabled(false);
		parar.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				aeropuerto.pararAviones();
			}

		});
		LaminaBarraSuperior.add(generarJCheckBucle());
		LaminaBarraSuperior.add(parar);
		this.add(generarTerminalGui(), BorderLayout.CENTER);
		this.add(LaminaBarraSuperior, BorderLayout.NORTH);
		this.add(generarFooter(), BorderLayout.SOUTH);
	}

	/**
	 * Alterna entre que el aeropuerto funcione en bucle o no
	 * 
	 * Si la funci�n en bucle est� descativada bloquea el boton parar
	 * 
	 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
	 * 
	 */
	private JCheckBox generarJCheckBucle() {
		JCheckBox modBucle = new JCheckBox("Funcionar en bucle");
		modBucle.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JCheckBox tmp = (JCheckBox) e.getSource();
				if (tmp.isSelected()) {
					funcionarEnBucle = true;
					parar.setEnabled(true);
				} else {
					funcionarEnBucle = false;
					parar.setEnabled(false);
				}
			}
		});
		return modBucle;
	}

	/**
	 * Este m�todo pasa la salida estandar de terminal al jtext area
	 * 
	 * y devuelve un jscrollPane con el jtextarea dentro para poder hacer scroll
	 * 
	 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
	 * 
	 */
	private JScrollPane generarTerminalGui() {
		output.setCaretPosition(output.getDocument().getLength());
		DefaultCaret caret = (DefaultCaret) output.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		PrintStream out = new PrintStream(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				output.append("" + (char) (b & 0xFF));
			}
		});
		System.setOut(out);
		JScrollPane sp = new JScrollPane(output);
		sp.setAutoscrolls(true);
		return sp;
	}

	/**
	 * Este m�todo genera un boton que comienza la simulaci�n, y en caso de tener
	 * una configuraci�n incorrecta, te avisa
	 * 
	 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
	 * 
	 */
	private JButton generarBotonComenzar() {
		JButton comenzar = new JButton("Comenzar");
		comenzar.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				if (funcionarEnBucle) {
					JOptionPane.showMessageDialog(null,
							"La funci�n parar, no detendr� la ejecuci�n directamente.\nLos aviones se parar�n una vez aterricen y terminen su ciclo.\nPor lo que en algunos casos si hay gran cantidad puede tardar unos segundos.",
							"INFO", JOptionPane.INFORMATION_MESSAGE);
				}
				output.setText("");
				aeropuerto = new OperacionesAeropuerto(nAviones, nPistas, funcionarEnBucle);
				if (!aeropuerto.iniciarAeropuerto()) {
					JOptionPane.showMessageDialog(null,
							"CONFIGURACI�N INCONRRECTA\n\nNOTA:\n IMPORTANTE INTRODUCIR MAS AVIONES QUE PISTAS!",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		return comenzar;
	}

	/**
	 * Este m�todo genera un bot�n en el que sale una ventana para pedirte el n�mero
	 * de aviones
	 * 
	 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
	 * 
	 */
	private JButton generarBotonIntroducirNAviones() {
		JButton comenzar = new JButton("Insertar Num. de aviones [" + nAviones + "]");
		comenzar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton tmp = (JButton) e.getSource();
				try {
					nAviones = Integer
							.parseInt(JOptionPane.showInputDialog(null, "Introduce el n�mero de Aviones", nAviones));
					tmp.setText("Insertar Num. de Aviones [" + nAviones + "]");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Solo se pueden introducir n�meros!", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		return comenzar;
	}

	/**
	 * Este m�todo genera un bot�n en el que sale una ventana para pedirte el
	 * n�mero de pistas
	 * 
	 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
	 * 
	 */

	private JButton generarBotonPedirNumeroPistas() {
		JButton comenzar = new JButton("Insertar Num. de Pistas [" + nPistas + "]");
		comenzar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton tmp = (JButton) e.getSource();
				try {
					nPistas = Integer
							.parseInt(JOptionPane.showInputDialog(null, "Introduce el n�mero de Pistas", nPistas));
					tmp.setText("Insertar Num. de Pistas [" + nPistas + "]");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Solo se pueden introducir n�meros!", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		return comenzar;
	}

	private static JLabel generarFooter() {
		JLabel JLFooter = new JLabel("Autor: Jos� Miguel Garcia Orejudo y Jos� Miguel Calder�n de la Barca Guti�rrez.",
				SwingConstants.LEFT);
		JLFooter.setFont(new Font("arial", Font.ITALIC, 12));
		JLFooter.setBorder(new EmptyBorder(6, 8, 6, 0));
		JLFooter.setBackground(Color.BLUE);
		JLFooter.setOpaque(true);
		JLFooter.setForeground(Color.WHITE);
		return JLFooter;
	}

}
