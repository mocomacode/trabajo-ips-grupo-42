package view.atleta;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import controller.atleta.AtletaCrudService;
import controller.atleta.AtletaCrudServiceImpl;
import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import model.atleta.AtletaDto;
import model.inscripcion.InscripcionDto;

public class VerInscripcionesPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JScrollPane competicionesPane;
	private JButton btnAtras;

	private AtletaMain main;
	private JPanel pnEmail;
	private JLabel lbEmail;
	private JTextField tfEmail;
	private JButton btnBuscarCompeticion;
	private JTable tabCompeticiones;

	/**
	 * Create the panel.
	 */
	public VerInscripcionesPanel(AtletaMain main) {
		this.main = main;

		setLayout(new BorderLayout(0, 0));
		add(getPnEmail(), BorderLayout.NORTH);
		add(getCompeticionesPane(), BorderLayout.CENTER);
		add(getBtnAtras(), BorderLayout.SOUTH);

	}

	private JScrollPane getCompeticionesPane() {
		if (competicionesPane == null) {
			competicionesPane = new JScrollPane();
			competicionesPane.setViewportView(getTabCompeticiones());
		}
		return competicionesPane;
	}

	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atrás");

			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					main.flipCard(AtletaMain.ATLETAS_MENU);
				}
			});
		}
		return btnAtras;
	}

	private JPanel getPnEmail() {
		if (pnEmail == null) {
			pnEmail = new JPanel();
			pnEmail.add(getLbEmail());
			pnEmail.add(getTfEmail());
			pnEmail.add(getBtnBuscarCompeticion());
		}
		return pnEmail;
	}

	private JLabel getLbEmail() {
		if (lbEmail == null) {
			lbEmail = new JLabel("Email:");
		}
		return lbEmail;
	}

	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}

	private JButton getBtnBuscarCompeticion() {
		if (btnBuscarCompeticion == null) {
			btnBuscarCompeticion = new JButton("Buscar competiciones");
			btnBuscarCompeticion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buscarCompeticiones();
				}
			});
		}
		return btnBuscarCompeticion;
	}
	
	private void buscarCompeticiones() {
		if (!checkEmail()) {
			showMessage("No hay ningún email con el que iniciar la búsqueda", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		} else {
			try {
				AtletaCrudService acs = new AtletaCrudServiceImpl();
				AtletaDto atleta = new AtletaDto();
				atleta.email = tfEmail.getText();
				
				List<InscripcionDto> inscripciones = acs.getCompetionesInscritas(atleta);
				
				TableModel tmodel = SwingUtil.getTableModelFromPojos(inscripciones, new String[] {"nombreCompeticion", "estadoInscripcion", "fechaCambioEstado"});
				
				getTabCompeticiones().setModel(tmodel);
				SwingUtil.autoAdjustColumns(getTabCompeticiones());
				
			} catch (ApplicationException e) {
				showMessage(e.getMessage(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
			} catch (RuntimeException e) { 
				e.printStackTrace(); 
				showMessage(e.toString(), "Excepcion no controlada", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}

	private void showMessage(String message, String title, int type) {
		JOptionPane pane = new JOptionPane(message, type, JOptionPane.DEFAULT_OPTION);
		pane.setOptions(new Object[] { "ACEPTAR" }); 
		JDialog d = pane.createDialog(pane, title);
		d.setLocation(200, 200);
		d.setVisible(true);

	}

	private boolean checkEmail() {
		if (tfEmail.getText().strip().isEmpty())
			return false;
		return true;
	}

	
	private JTable getTabCompeticiones() {
		if (tabCompeticiones == null) {
			tabCompeticiones = new JTable();
		}
		return tabCompeticiones;
	}
}
