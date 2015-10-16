package mainV5;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JRadioButton;

import mainV5.Calcul;
import mainV5.Saisie;
import mainV5.Tarifs;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.Color;

public class window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDept;
	private JTextField txtKm;
	private JTextField txtDuree;
	private ButtonGroup button1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window frame = new window();
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
	public window() {
		final List<Tarifs> liste = BDD.coBdd();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		button1 = new ButtonGroup();
		txtDept = new JTextField();
		txtDept.setBounds(205, 61, 28, 22);
		contentPane.add(txtDept);
		//contentPane.add(button1);
		txtDept.setColumns(10);
		
		final JLabel labelDept = new JLabel("Veuillez saisir le d\u00E9partement du trajet :");
		labelDept.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelDept.setBounds(10, 65, 244, 14);
		contentPane.add(labelDept);
		
		JLabel lblCalculPrixVoyage = new JLabel("Calcul prix voyage en taxiiiiii");
		lblCalculPrixVoyage.setFont(new Font("Pokemon Emerald Narrow", Font.PLAIN, 11));
		lblCalculPrixVoyage.setBounds(23, 11, 209, 23);
		contentPane.add(lblCalculPrixVoyage);
		
		final JLabel labelKm = new JLabel("Veuillez saisir le nombre de km parcourus :");
		labelKm.setVisible(false);
		labelKm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelKm.setBounds(10, 122, 282, 14);
		contentPane.add(labelKm);
		
		JButton btnReset = new JButton("R\u00E9initialiser");
		btnReset.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		btnReset.setBounds(203, 307, 117, 23);
		contentPane.add(btnReset);
		
		final JLabel labelDuree = new JLabel("Veuillez saisir la dur\u00E9e du trajet :");
		labelDuree.setVisible(false);
		labelDuree.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelDuree.setBounds(10, 171, 244, 14);
		contentPane.add(labelDuree);
		
		txtKm = new JTextField();
		txtKm.setVisible(false);
		txtKm.setColumns(10);
		txtKm.setBounds(264, 118, 44, 22);
		contentPane.add(txtKm);
		
		txtDuree = new JTextField();
		txtDuree.setVisible(false);
		txtDuree.setColumns(10);
		txtDuree.setBounds(205, 167, 44, 22);
		contentPane.add(txtDuree);
		
		final JRadioButton rdbtnSemaine = new JRadioButton("semaine");
		rdbtnSemaine.setVisible(false);
		rdbtnSemaine.setBounds(84, 225, 94, 50);
		contentPane.add(rdbtnSemaine);
		button1.add(rdbtnSemaine);
		
		final JRadioButton rdbtnDimanche = new JRadioButton("dimanche");
		rdbtnDimanche.setVisible(false);
		rdbtnDimanche.setBounds(193, 225, 89, 50);
		contentPane.add(rdbtnDimanche);
		button1.add(rdbtnDimanche);
		
		final JLabel labelErreurDept = new JLabel("Le d\u00E9partement ne fait pas partie de la liste");
		labelErreurDept.setVisible(false);
		labelErreurDept.setForeground(Color.RED);
		labelErreurDept.setBounds(10, 282, 298, 14);
		contentPane.add(labelErreurDept);
		
		final JLabel labelErreurJour = new JLabel("Veuillez s\u00E9lectionner un jour !");
		labelErreurJour.setVisible(false);
		labelErreurJour.setForeground(Color.RED);
		labelErreurJour.setBounds(112, 206, 208, 22);
		contentPane.add(labelErreurJour);
		
		final JLabel labelErreurChamps = new JLabel("Les champs ne sont pas s\u00E9lectionn\u00E9s ou ne sont pas du bon type !");
		labelErreurChamps.setVisible(false);
		labelErreurChamps.setForeground(Color.RED);
		labelErreurChamps.setBounds(10, 282, 387, 14);
		contentPane.add(labelErreurChamps);
		
		final JLabel labelRes = new JLabel("");
		labelRes.setForeground(Color.RED);
		labelRes.setBounds(10, 352, 387, 14);
		contentPane.add(labelRes);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				boolean bool = false;
				String saisie = txtDept.getText(); 
				
				for(int j=0; j<=liste.size()-1; j++){
					
					if(Double.parseDouble(saisie) == liste.get(j).getDept()){
						bool = true;
						
						labelKm.setVisible(true);
						txtKm.setVisible(true);
						labelDuree.setVisible(true);
						txtDuree.setVisible(true);
						rdbtnSemaine.setVisible(true);
						rdbtnDimanche.setVisible(true);
						labelErreurDept.setVisible(false);
						break;

					}
					
				}
				
				if(bool == false){
					labelErreurDept.setVisible(true);
				}
			}

			
		});
		btnRechercher.setBounds(264, 61, 108, 23);
		contentPane.add(btnRechercher);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				labelErreurChamps.setVisible(false);
				labelErreurJour.setVisible(false);
				labelRes.setVisible(false);
				try{
					
				if(rdbtnSemaine.isSelected()){
					
					Saisie var = new Saisie(Double.parseDouble(txtDept.getText()),Double.parseDouble(txtKm.getText()),"semaine",Integer.parseInt(txtDuree.getText()));
					
					labelRes.setText("Le prix à payer est : "+Calcul.calcul(liste, var)+" euros");	
					labelRes.setVisible(true);
				}
				
				else if(rdbtnDimanche.isSelected()){
					
					Saisie var = new Saisie(Double.parseDouble(txtDept.getText()),Double.parseDouble(txtKm.getText()),"dimanche",Integer.parseInt(txtDuree.getText()));
					
					labelRes.setText("Le prix à payer est : "+Calcul.calcul(liste, var)+" euros");	
					labelRes.setVisible(true);
				}
				
				else
					labelErreurJour.setVisible(true);
				
				}				
				catch(Exception e){
					labelErreurChamps.setVisible(true);
				}
				
				
				
			}
		});
		btnValider.setBounds(89, 307, 89, 23);
		contentPane.add(btnValider);
		
		
		
		
		
		
		
		
		
		
	}
}
