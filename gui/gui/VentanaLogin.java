package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.nio.ReadOnlyBufferException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import domain.GestorUsuario;
import domain.Usuario;

public class VentanaLogin extends JFrame {

	private GestorUsuario gestor;

	private JTextField email = new JTextField();
	private JPasswordField contrasenha = new JPasswordField();
	private JCheckBox mostrar = new JCheckBox("Mostrar");
	private JCheckBox recuerdame = new JCheckBox("Recuerdame");
	private JCheckBox robot = new JCheckBox("No soy un robot");
	private JButton entrar = new JButton("Entrar");
	private JButton recuperar = new JButton("Recuperar contraseña");
	private JButton registro = new JButton("Regístrate");

	private JLabel errorCon = new JLabel("", JLabel.CENTER);

	public VentanaLogin(GestorUsuario gestor) {
		this.gestor = gestor;

		setTitle("Cine - Inicia Sesión");
		setSize(480, 560);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Barra de arriba más el titulo

		// Menú de la izquierda
		JPanel panelMenu = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelMenu.add(new JLabel("Películas  /"));
		panelMenu.add(new JLabel("Promociones  /"));

		// La barra completa, el menú de la iaquierda y "cuenta" a la derecha
		JPanel panelCabecera = new JPanel(new BorderLayout());
		panelCabecera.add(panelMenu, BorderLayout.WEST);
		panelCabecera.add(new JLabel("/  Cuenta   "), BorderLayout.EAST);

		// Titulo
		JLabel titulo = new JLabel("Iniciar sesión", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 22));

		JPanel panelNorte = new JPanel(new BorderLayout(0, 15));
		panelNorte.add(panelCabecera, BorderLayout.NORTH);
		panelNorte.add(titulo, BorderLayout.CENTER);

		add(panelNorte, BorderLayout.NORTH);

		JPanel panelEmail = new JPanel(new GridLayout(2, 1));
		panelEmail.add(new JLabel("Correo electrónico"));
		panelEmail.add(email);

		JPanel panelCampoContrasenha = new JPanel(new BorderLayout());
		panelCampoContrasenha.add(contrasenha, BorderLayout.CENTER);
		panelCampoContrasenha.add(mostrar, BorderLayout.EAST);

		JPanel panelContrasena = new JPanel(new GridLayout(2, 1));
		panelContrasena.add(new JLabel("Contraseña"));
		panelContrasena.add(panelCampoContrasenha);

		errorCon.setForeground(Color.RED);

		robot.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		recuperar.setBorderPainted(false);
		JPanel panelRecuperar = new JPanel(new FlowLayout());
		panelRecuperar.add(recuperar);

		JPanel panelRegistro = new JPanel(new FlowLayout());
		panelRegistro.add(registro);

		// Formulario
		JPanel panelFormulario = new JPanel(new GridLayout(8, 1, 5, 5));
		panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 60));
		panelFormulario.add(panelEmail);
		panelFormulario.add(panelContrasena);
		panelFormulario.add(errorCon);
		panelFormulario.add(recuerdame);
		panelFormulario.add(robot);
		panelFormulario.add(entrar);
		panelFormulario.add(panelRecuperar);
		panelFormulario.add(panelRegistro);

		add(panelFormulario, BorderLayout.CENTER);

		// "RECUERDAME", si fue marcado rellenamos el correo

		email.setText(gestor.getEmailRecordado());
		recuerdame.setSelected(!gestor.getEmailRecordado().isEmpty());

		// Eventos

		mostrar.addActionListener(e -> {
			if (mostrar.isSelected()) {
				contrasenha.setEchoChar((char) 0); // (char) 0 significa "no ocultar nada"
			} else {
				contrasenha.setEchoChar('*');
			}
		});

		entrar.addActionListener(e -> {
			errorCon.setText(""); // se borra el anterior error

			String correo = email.getText().trim();
			String pass = new String(contrasenha.getPassword());

			if (!robot.isSelected()) {
				errorCon.setText("Marca la casilla 'No soy un robot' ");
			} else {
				Usuario user = gestor.iniciarSesion(correo, pass);
				if (user != null) {
					if (recuerdame.isSelected()) {
						gestor.setEmailRecordado(correo);
					} else {
						gestor.setEmailRecordado("");
					}
					JOptionPane.showMessageDialog(this, "¡Bienvenido, " + user.getNombre() + "!");

					dispose();

				} else if (gestor.existeEmail(correo)) {
					errorCon.setText("Error esa no es la contraseña. ¿Quieres recuperarla?");
					contrasenha.setText("");
				} else {
					errorCon.setText("No existe ninguna cuenta con ese correo");
				}
			}
		});

		recuperar.addActionListener(e -> recuperarContrasenha());

	}

	private void recuperarContrasenha() {
		String email = JOptionPane.showInputDialog(this, "Escribe tu correo electronico: ");
		if (email != null) {
			if (gestor.existeEmail(email)) {
				JOptionPane.showMessageDialog(this, "Te hemos enviado un correo para recuperar tu contraseña");
			} else {
				JOptionPane.showMessageDialog(this, "Este correo no pertenece a ninguna cuenta");
			}
		}
	}

}
