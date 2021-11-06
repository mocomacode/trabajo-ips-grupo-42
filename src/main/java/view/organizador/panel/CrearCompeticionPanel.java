package view.organizador.panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import model.ModelFactory;
import model.competicion.CompeticionDto;
import net.miginfocom.swing.MigLayout;
import util.Validate;
import util.exceptions.ModelException;
import view.organizador.OrganizadorMain;
import view.organizador.util.AtrasOrganizadorButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class CrearCompeticionPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel panelFormulario;
	private JButton btnValidarDatos;
	private JTextField textNombre;
	private JLabel lblNombre;
	private JLabel lblDescripcion;
	private JTextArea textAreaDescripcion;
	private JLabel lblTipo;
	private JTextField textTipo;
	private JLabel lblNumeroPlazas;
	private JSpinner spinnerNumeroPlazas;
	private JLabel lblNumeroDorsalesReservados;
	private JSpinner spinnerDorsalesReservados;
	private JPanel panelCategorias;
	private JPanel panelPlazos;
	private JButton btnCategorias;
	private JButton btnPlazos;
	private JPanel panelValidarBtn;
	private AtrasOrganizadorButton btnAtras;
	private JLabel lblFecha;
	private JLabel lblLongitud;
	private JTextField textFecha;
	private JSpinner spinnerLongitud;

	/**
	 * Create the panel.
	 */
	public CrearCompeticionPanel() {
		setLayout(new BorderLayout(0, 0));
		add(getPanelFormulario(), BorderLayout.CENTER);
		add(getPanelValidarBtn(), BorderLayout.SOUTH);
	}
	
	private void showError(String arg) {
		JOptionPane.showMessageDialog(this,
				arg,
			    "ERROR - " + arg,
			    JOptionPane.ERROR_MESSAGE);
	}
	
	public void reset() {
		getTextNombre().setText("");
		getTextTipo().setText("");
		getTextAreaDescripcion().setText("");
		getSpinnerNumeroPlazas().setValue(0);
		getSpinnerDorsalesReservados().setValue(0);
		getSpinnerNumeroPlazas().setValue(0);
		getTextFecha().setText("");
	}
	
	private JPanel getPanelFormulario() {
		if (panelFormulario == null) {
			panelFormulario = new JPanel();
			panelFormulario.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Formulario de Inscripción a la Carrera", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panelFormulario.setLayout(new MigLayout("", "[grow,center][grow,center]", "[grow][][][][grow][][][][][][grow][grow][grow]"));
			panelFormulario.add(getLblNombre(), "flowx,cell 0 1 2 1,alignx left,growy");
			panelFormulario.add(getTextNombre(), "cell 0 2,grow");
			panelFormulario.add(getTextTipo(), "cell 1 2,grow");
			panelFormulario.add(getLblDescripcion(), "cell 0 3 2 1,alignx left");
			panelFormulario.add(getTextAreaDescripcion(), "cell 0 4 2 2,grow");
			panelFormulario.add(getLblNumeroDorsalesReservados(), "cell 0 6,alignx left");
			panelFormulario.add(getLblNumeroPlazas(), "cell 1 6,alignx left");
			panelFormulario.add(getSpinnerDorsalesReservados(), "cell 0 7,growx");
			panelFormulario.add(getLblTipo(), "cell 1 1,alignx left,aligny center");
			panelFormulario.add(getSpinnerNumeroPlazas(), "cell 1 7,growx");
			panelFormulario.add(getLblFecha(), "cell 0 8,growx");
			panelFormulario.add(getLblLongitud(), "cell 1 8,growx");
			panelFormulario.add(getTextFecha(), "cell 0 9,growx");
			panelFormulario.add(getSpinnerLongitud(), "cell 1 9,growx");
			panelFormulario.add(getPanelCategorias(), "cell 0 10 2 1,grow");
			panelFormulario.add(getPanelPlazos(), "cell 0 11 2 1,grow");
		}
		return panelFormulario;
	}
	
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNombre.setDisplayedMnemonic('N');
			lblNombre.setToolTipText("Inserte el nombre de la competición");
			lblNombre.setLabelFor(getTextNombre());
		}
		return lblNombre;
	}
	
	private JTextField getTextNombre() {
		if (textNombre == null) {
			textNombre = new JTextField();
			textNombre.setColumns(10);
		}
		return textNombre;
	}
	
	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Descripción:");
			lblDescripcion.setLabelFor(getTextAreaDescripcion());
			lblDescripcion.setToolTipText("Escriba un breve texto explicando en qué consiste la competición");
			lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDescripcion.setDisplayedMnemonic('D');
		}
		return lblDescripcion;
	}

	private JTextArea getTextAreaDescripcion() {
		if (textAreaDescripcion == null) {
			textAreaDescripcion = new JTextArea();
		}
		return textAreaDescripcion;
	}
	
	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo:");
			lblTipo.setToolTipText("");
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTipo.setDisplayedMnemonic('N');
		}
		return lblTipo;
	}
	
	private JTextField getTextTipo() {
		if (textTipo == null) {
			textTipo = new JTextField();
			textTipo.setColumns(10);
		}
		return textTipo;
	}
	
	private JLabel getLblNumeroPlazas() {
		if (lblNumeroPlazas == null) {
			lblNumeroPlazas = new JLabel("Número de Plazas:");
			lblNumeroPlazas.setLabelFor(getSpinnerNumeroPlazas());
			lblNumeroPlazas.setToolTipText("");
			lblNumeroPlazas.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNumeroPlazas.setDisplayedMnemonic('N');
		}
		return lblNumeroPlazas;
	}
	
	private JSpinner getSpinnerNumeroPlazas() {
		if (spinnerNumeroPlazas == null) {
			spinnerNumeroPlazas = new JSpinner();
			spinnerNumeroPlazas.setModel(new SpinnerNumberModel(0, 0, null, 1));
		}
		return spinnerNumeroPlazas;
	}
	
	private JLabel getLblNumeroDorsalesReservados() {
		if (lblNumeroDorsalesReservados == null) {
			lblNumeroDorsalesReservados = new JLabel("Dorsales Reservados:");
			lblNumeroDorsalesReservados.setLabelFor(getSpinnerDorsalesReservados());
			lblNumeroDorsalesReservados.setToolTipText("");
			lblNumeroDorsalesReservados.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNumeroDorsalesReservados.setDisplayedMnemonic('N');
		}
		return lblNumeroDorsalesReservados;
	}
	
	private JSpinner getSpinnerDorsalesReservados() {
		if (spinnerDorsalesReservados == null) {
			spinnerDorsalesReservados = new JSpinner();
			spinnerDorsalesReservados.setModel(new SpinnerNumberModel(0, 0, null, 1));
		}
		return spinnerDorsalesReservados;
	}
	
	private JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("Fecha:");
			lblFecha.setLabelFor(getTextFecha());
			lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
			lblFecha.setToolTipText("");
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFecha.setDisplayedMnemonic('N');
		}
		return lblFecha;
	}
	
	private JTextField getTextFecha() {
		if (textFecha == null) {
			textFecha = new JTextField();
			textFecha.setColumns(10);
		}
		return textFecha;
	}
	
	private JLabel getLblLongitud() {
		if (lblLongitud == null) {
			lblLongitud = new JLabel("Longitud:");
			lblLongitud.setHorizontalAlignment(SwingConstants.LEFT);
			lblLongitud.setToolTipText("Establece la longitud de la carrera en KM");
			lblLongitud.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblLongitud.setDisplayedMnemonic('N');
		}
		return lblLongitud;
	}
	
	private JSpinner getSpinnerLongitud() {
		if (spinnerLongitud == null) {
			spinnerLongitud = new JSpinner();
			spinnerLongitud.setModel(new SpinnerNumberModel(0, 0, null, 1));
		}
		return spinnerLongitud;
	}
	
	private JPanel getPanelCategorias() {
		if (panelCategorias == null) {
			panelCategorias = new JPanel();
			panelCategorias.setLayout(new GridLayout(0, 1, 0, 0));
			panelCategorias.add(getBtnCategorias());
		}
		return panelCategorias;
	}
	
	private JPanel getPanelPlazos() {
		if (panelPlazos == null) {
			panelPlazos = new JPanel();
			panelPlazos.setLayout(new GridLayout(0, 1, 0, 0));
			panelPlazos.add(getBtnPlazos());
		}
		return panelPlazos;
	}
	
	private JButton getBtnCategorias() {
		if (btnCategorias == null) {
			btnCategorias = new JButton("Configurar Categorías");
		}
		return btnCategorias;
	}
	
	private JButton getBtnPlazos() {
		if (btnPlazos == null) {
			btnPlazos = new JButton("Configurar Plazos");
		}
		return btnPlazos;
	}
	
	private JPanel getPanelValidarBtn() {
		if (panelValidarBtn == null) {
			panelValidarBtn = new JPanel();
			panelValidarBtn.add(getBtnValidarDatos());
			panelValidarBtn.add(getBtnAtras());
		}
		return panelValidarBtn;
	}
	
	private AtrasOrganizadorButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new AtrasOrganizadorButton(OrganizadorMain.ORGANIZADOR_MENU);
		}
		return btnAtras;
	}
	
	private JButton getBtnValidarDatos() {
		if (btnValidarDatos == null) {
			btnValidarDatos = new JButton("Validar mis Datos");
			btnValidarDatos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CompeticionDto competicion = new CompeticionDto();
					
					// Validamos el nombre
					String nombre = getTextNombre().getText();
					if(!nombre.trim().isEmpty())
						competicion.nombreCarrera = nombre;
					else {
						JOptionPane.showMessageDialog(null, "Nombre no puede estar vacío...");
						return;
					} // Show warning
					
					// Validamos el tipo
					String tipo = getTextTipo().getText();
					if(!tipo.trim().isEmpty())
						competicion.tipoCarrera = tipo;
					else {
						JOptionPane.showMessageDialog(null, "Tipo no puede estar vacío...");
						return;
					} // Show warning
					
					// Validamos la descripcion
					String descripcion = getTextAreaDescripcion().getText();
					if(!descripcion.trim().isEmpty())
						competicion.descripcion = descripcion;
					else {
						JOptionPane.showMessageDialog(null, "Descripción no puede estar vacía...");
						return;
					} // Show warning

					// Validamos el numero de dorsales reservados
					int dorsales = (int) getSpinnerDorsalesReservados().getValue();
					competicion.dorsalesReservados = dorsales;
					
					// Validamos el numero de plazas
					int plazas = (int) getSpinnerNumeroPlazas().getValue();
					competicion.plazas = plazas;
					
					// Validamos la fecha
					String fecha = getTextFecha().getText();
					competicion.fecha = Validate.validateFecha(fecha);
					if(competicion.fecha == null) {
						JOptionPane.showMessageDialog(null, "Fecha no valida...");
						return;
					} // Show warning
					
					// Validamos la longitud de la carrera
					int longitud = (int) getSpinnerLongitud().getValue();
					competicion.distancia = longitud;
					
					try {
						if (ModelFactory.forCarreraCrudService().addCompeticion(competicion)) {
							// update the competitions TODO
							
							JOptionPane.showMessageDialog(null, "Hemos añadido la carrera");
						} else {
							JOptionPane.showMessageDialog(null, "No hemos podido añadir la carrera");
						}
						
						OrganizadorMain.getInstance().startPanel();
						reset();
					} catch (ModelException e1) {
						showError("Lo siento, algo ha salido mal...");
						OrganizadorMain.getInstance().startPanel();
						reset();
						return;
					}
				}
			});
		}
		return btnValidarDatos;
	}

}
