package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.time.LocalDate;
import domain.ValidadorDatos;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import domain.GestorUsuario;
import domain.Usuario;
import domain.ValidadorDatos;

public class VentanaRegistro extends JFrame {

	private GestorUsuario gestor;

	private JTextField emailtex = new JTextField();
	private JTextField nombretex = new JTextField();
	private JTextField apellidostex = new JTextField();
	private JTextField diatext = new JTextField();
	private JTextField mestex = new JTextField();
	private JTextField aniotex = new JTextField();
	private JTextField telefonotex = new JTextField();
	private JTextField cinetex = new JTextField();
	private JTextField dnitex = new JTextField();
	private JPasswordField contrasenatex = new JPasswordField();
	private JButton btnCrear = new JButton("Crear Cuenta");

	public VentanaRegistro(GestorUsuario gestor) {
		this.gestor = gestor;

		setTitle("Cine-Registrarse");
		setSize(560, 560);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		// NORTE
		JLabel titulo = new JLabel("Registrarse", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 22));
		add(titulo, BorderLayout.NORTH);

		// CENTRO
		// BLOQUE 1
		JPanel panelEmail = new JPanel(new GridLayout(2, 1));
		panelEmail.add(new JLabel("Email"));
		panelEmail.add(emailtex);

		// BLOQUE 2
		JPanel panelNombre = new JPanel(new GridLayout(2, 2, 10, 0));
		panelNombre.add(new JLabel("Nombre"));
		panelNombre.add(new JLabel("Apellidos"));
		panelNombre.add(nombretex);
		panelNombre.add(apellidostex);

		// BLOQUE 3
		JPanel panelFecha = new JPanel(new GridLayout(1, 3, 3, 0));
		panelFecha.add(diatext);
		panelFecha.add(mestex);
		panelFecha.add(aniotex);

		JPanel panelFechaTelefono = new JPanel(new GridLayout(2, 2, 10, 0));
		panelFechaTelefono.add(new JLabel("Fecha nacimiento (d / m / a)"));
		panelFechaTelefono.add(new JLabel("Telefono"));
		panelFechaTelefono.add(panelFecha);
		panelFechaTelefono.add(telefonotex);

		// BLOQUE 4
		JPanel panelCine = new JPanel(new GridLayout(2, 1));
		panelCine.add(new JLabel("Cine preferido(opcional)"));
		panelCine.add(cinetex);

		// BLOQUE 5
		JPanel panelDni = new JPanel(new GridLayout(2, 1));
		panelDni.add(new JLabel("DNI"));
		panelDni.add(dnitex);

		// BLOQUE 6
		JPanel panelContrasena = new JPanel(new GridLayout(2, 1));
		panelContrasena.add(new JLabel("Contraseña"));
		panelContrasena.add(contrasenatex);

		JPanel panelFormulario = new JPanel(new GridLayout(6, 1, 10, 10));
		panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		panelFormulario.add(panelEmail);
		panelFormulario.add(panelNombre);
		panelFormulario.add(panelFechaTelefono);
		panelFormulario.add(panelCine);
		panelFormulario.add(panelDni);
		panelFormulario.add(panelContrasena);
		add(panelFormulario, BorderLayout.CENTER);

		// SUR
		JPanel panelBoton = new JPanel(new FlowLayout());
		panelBoton.add(btnCrear);
		add(panelBoton, BorderLayout.SOUTH);

		btnCrear.addActionListener(e -> crearCuenta());

	}

	private void crearCuenta() {
		String email = emailtex.getText().trim();
		String nombre = nombretex.getText().trim();
		String apellidos = apellidostex.getText().trim();
		String telefono = telefonotex.getText().trim();
		String cine = cinetex.getText().trim();
		String dni = dnitex.getText().trim();
		String contrasena = new String(contrasenatex.getPassword());

		if (email.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() || telefono.isEmpty() || dni.isEmpty()
				|| contrasena.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Rellena todos los campos obligatorios");
			return;
		}
		if (!ValidadorDatos.esEmailValido(email)) {
			JOptionPane.showMessageDialog(this, "El email no es valido");
			return;
		}
		if (!telefono.matches("[0-9]{9}")) {
			JOptionPane.showMessageDialog(this, "El telefono debe tener 9 digitos");
			return;
		}
		if (!ValidadorDatos.esDniValido(dni)) {
			JOptionPane.showMessageDialog(this, "El DNI debe tener 8 números y una letra");
			return;
		}

		LocalDate fecha = null;
		try {
			int dia = Integer.parseInt(diatext.getText().trim());
			int mes = Integer.parseInt(mestex.getText().trim());
			int anio = Integer.parseInt(aniotex.getText().trim());

			fecha = LocalDate.of(anio, mes, dia);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (fecha == null || fecha.isAfter(LocalDate.now())) {
			JOptionPane.showMessageDialog(this, "La fecha no es valida");
			return;
		}
		if (contrasena.length() < 8) {
			JOptionPane.showMessageDialog(this, "La contraseña debe tener al menos 8 caracteres");
			return;
		}

		Usuario nuevo = new Usuario(email, nombre, apellidos, fecha, telefono, cine, dni, contrasena);
		if (gestor.registrar(nuevo)) {
			JOptionPane.showMessageDialog(this, "Cuenta creada correctamente");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Ya existe una cuenta con este correo electrónico");
		}

	}

	public static void main(String[] args) {
		new VentanaRegistro(new GestorUsuario()).setVisible(true);
	}
}
