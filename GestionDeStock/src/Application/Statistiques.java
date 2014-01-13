package Application;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * 
 * @author Imen
 *Classe permettant l'affichage du module statistiques
 *
 */

public class Statistiques extends Panel implements ActionListener {
	Application app;
	private ModeleDynamiqueObjet modele = new ModeleDynamiqueObjet();
	private JLabel titre=new  JLabel("Statistiques",JLabel.CENTER);
	JLabel labelInfo = new JLabel("Pour trier le tableau s�lectionner la colonne corresponadante");
	JLabel labelOrdre = new JLabel("veuillez choisir l'ordre");
	Font font = new Font("Gabriola",Font.BOLD,50);
	JButton simulationButton=new JButton();
	JButton RetourButton=new JButton("Retour");
	 
	JTable tableau ;  
	 JRadioButton yesButton   = new JRadioButton("croissant"  , true);
	 JRadioButton noButton    = new JRadioButton("d�croissant"   , false);

	 ButtonGroup bgroup = new ButtonGroup();
	 Stats stats;
	JScrollPane span=new JScrollPane();
	int nombreligne=10;
	JLabel nbligne=new JLabel("Nombre de lignes � afficher");
	JComboBox comboligne=new JComboBox();
	Category magasin;
	DefaultTableCellRenderer ColorTable = new DefaultTableCellRenderer();
	JPanel labprix=new JPanel();
	JLabel labelprix=new  JLabel("les plus ch�r");
	
	
	public Statistiques(Application app, Category magasin){
		this.magasin=magasin;
		this.app=app;
		tableau = new JTable(modele);
		stats=new Stats(app);
		  TableData(magasin);
		  tableau.setAutoCreateRowSorter(true);
		  
	
		simulationButton.addActionListener(this);
		simulationButton.addActionListener(app);
		this.setLayout(null);
		titre.setFont(font);
		
		titre.setBounds(400, 00, 300, 100);
		
		
		simulationButton.setText("mode simulation");
		simulationButton.setBounds(400, 550, 150, 20);
		RetourButton.setBounds(200, 550, 150, 20);
		RetourButton.addActionListener(app);
		
		tableau.getTableHeader().setBackground(Color.lightGray);
		labelInfo.setBounds(50, 130,500, 30);
		labelOrdre.setBounds(50,155,800,30);
		span.setViewportView(tableau);
		span.setBounds(80, 200, 800, 300);
		
	
	
		
		 bgroup.add(yesButton);
		 bgroup.add(noButton);
		yesButton.setBounds(300, 155, 100, 20);
		noButton.setBounds(410, 155, 100, 20);
      
		labprix.setBounds(900,250, 20, 20);
		labprix.setBackground(Color.blue);
		labelprix.setBounds(930, 250, 100, 20);
		
		this.setBackground(Color.white);
		tableau.setDefaultRenderer(Object.class, new MonCellRenderer());
		//ajouter les diff�rents �lements � l'interface
	
		this.add(span);
		this.add(simulationButton);
		this.add(titre);
		this.add(RetourButton);
		this.add(labelInfo);
		this.add(labprix);
		this.add(labelprix);
		
	}
	
	
	
	
	

	public void  TableData(Category cat){
		System.out.println("entreeeee");
		if(cat==magasin){
			for(Category c:cat.getChildren()){
				TableData(c);
				}
			
		}
		else {
			
			if(cat.getChildren().size()==0){
			Product produit=(Product)cat;
			modele.addProduct(produit);
			}
			
			else for(Category c:cat.getChildren()){
			TableData(c);
			}
		
		}  
	}
	
	
	
	public JButton getRetourButton() {
		return RetourButton;
	}


	public JButton getSimulationButton() {
		return simulationButton;
	}


// colorer une colonne 





@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}


	






	
}