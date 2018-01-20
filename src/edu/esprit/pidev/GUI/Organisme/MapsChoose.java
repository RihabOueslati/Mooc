/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.GUI.Organisme;

import edu.esprit.pidev.adapters.SelectionAdapter;
import edu.esprit.pidev.adapters.SelectionPainter;
import edu.esprit.pidev.dao.classes.Rendez_vousDAO;
import edu.esprit.pidev.entities.Rendez_vous;
import edu.esprit.pidev.dao.interfaces.Irendez_vousDAO;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.LocalResponseCache;
import org.jxmapviewer.viewer.TileFactoryInfo;

/**
 * A simple sample application that shows
 * a OSM map of Europe
 * @author Martin Steiger
 */
public class MapsChoose extends JFrame
{
    final JFrame frame = new JFrame();
    static double latitude;
    static double longitude;
    public Rendez_vous rend ;
	/**
	 * @param args the program args (ignored)
	 */
	public static void main(String[] args)
	{
            new MapsChoose().setVisible(false);
	}

    public MapsChoose() {
        
        		// Create a TileFactoryInfo for OpenStreetMap
		TileFactoryInfo info = new OSMTileFactoryInfo();
		DefaultTileFactory tileFactory = new DefaultTileFactory(info);
		tileFactory.setThreadPoolSize(8);

		// Setup local file cache
		File cacheDir = new File(System.getProperty("user.home") + File.separator + ".jxmapviewer2");
		LocalResponseCache.installResponseCache(info.getBaseURL(), cacheDir, false);

		// Setup JXMapViewer
		final JXMapViewer mapViewer = new JXMapViewer();
		mapViewer.setTileFactory(tileFactory);

		GeoPosition frankfurt = new GeoPosition(50.11, 8.68);

		// Set the focus
		mapViewer.setZoom(17);
		mapViewer.setAddressLocation(frankfurt);
                
                
		// Add interactions
		MouseInputListener mia = new PanMouseInputListener(mapViewer);
		mapViewer.addMouseListener(mia);
		mapViewer.addMouseMotionListener(mia);
                
		mapViewer.addMouseListener(new CenterMapListener(mapViewer));
		
		mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
		
		mapViewer.addKeyListener(new PanKeyListener(mapViewer));
		
		// Add a selection painter
		SelectionAdapter sa = new SelectionAdapter(mapViewer); 
		SelectionPainter sp = new SelectionPainter(sa); 
		mapViewer.addMouseListener(sa); 
		mapViewer.addMouseMotionListener(sa); 
		mapViewer.setOverlayPainter(sp);
		
                double lat = mapViewer.getCenterPosition().getLatitude();
		double lon = mapViewer.getCenterPosition().getLongitude();
                
                
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Faire votre choix : ");
                JButton boutton = new JButton();
                boutton.setText("Confirmer");
                boutton.addActionListener(new java.awt.event.ActionListener() {
                                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                                      bouttonActionPerformed(evt);
                 }
                 });
//                boutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIDevRealEstateAgency/UTILS/Email_Icon.png")));
                
                
                JButton annuler = new JButton();
                annuler.setText("Annuler");     
                annuler.addActionListener(new java.awt.event.ActionListener() {
                                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                                      annulerActionPerformed(evt);
                 }
                 });

                
                panel.add(label);
                panel.add(boutton);
                panel.add(annuler);
		panel.setLayout(new GridLayout());
                
		// Display the viewer in a JFrame
		
		frame.setLayout(new BorderLayout());
		frame.add(new JLabel("Use left mouse button to pan, mouse wheel to zoom and right mouse to select"), BorderLayout.NORTH);
		frame.add(mapViewer);
		frame.add(panel, BorderLayout.SOUTH);                
		frame.setSize(800, 600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setUndecorated(true);
		frame.setVisible(true);
		
		mapViewer.addPropertyChangeListener("zoom", new PropertyChangeListener()
		{
			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				updateWindowTitle(frame, mapViewer);
			}
		});
		
		mapViewer.addPropertyChangeListener("center", new PropertyChangeListener()
		{
			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				updateWindowTitle(frame, mapViewer);
			}
		});
		
		updateWindowTitle(frame, mapViewer);
    }
        

	protected static void updateWindowTitle(JFrame frame, JXMapViewer mapViewer)
	{
		 double lat = mapViewer.getCenterPosition().getLatitude();
		 double lon = mapViewer.getCenterPosition().getLongitude();
		int zoom = mapViewer.getZoom();
                
		latitude = lat;
                longitude = lon;
                
		frame.setTitle(String.format("JXMapviewer2 Example 3 (%.2f / %.2f) - Zoom: %d", lat, lon, zoom)); 
	}

    MapsChoose(Rendez_vous rdv) {
        		// Create a TileFactoryInfo for OpenStreetMap
                rend= rdv;
		TileFactoryInfo info = new OSMTileFactoryInfo();
		DefaultTileFactory tileFactory = new DefaultTileFactory(info);
		tileFactory.setThreadPoolSize(8);

		// Setup local file cache
		File cacheDir = new File(System.getProperty("user.home") + File.separator + ".jxmapviewer2");
		LocalResponseCache.installResponseCache(info.getBaseURL(), cacheDir, false);

		// Setup JXMapViewer
		final JXMapViewer mapViewer = new JXMapViewer();
		mapViewer.setTileFactory(tileFactory);

		GeoPosition frankfurt = new GeoPosition(50.11, 8.68);

		// Set the focus
		mapViewer.setZoom(17);
		mapViewer.setAddressLocation(frankfurt);
                
                
		// Add interactions
		MouseInputListener mia = new PanMouseInputListener(mapViewer);
		mapViewer.addMouseListener(mia);
		mapViewer.addMouseMotionListener(mia);
                
		mapViewer.addMouseListener(new CenterMapListener(mapViewer));
		
		mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
		
		mapViewer.addKeyListener(new PanKeyListener(mapViewer));
		
		// Add a selection painter
		SelectionAdapter sa = new SelectionAdapter(mapViewer); 
		SelectionPainter sp = new SelectionPainter(sa); 
		mapViewer.addMouseListener(sa); 
		mapViewer.addMouseMotionListener(sa); 
		mapViewer.setOverlayPainter(sp);
		
                double lat = mapViewer.getCenterPosition().getLatitude();
		double lon = mapViewer.getCenterPosition().getLongitude();
                
                
                
                
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Faire votre choix : ");
                JButton boutton = new JButton();
                boutton.setText("Confirmer");
                boutton.addActionListener(new java.awt.event.ActionListener() {
                                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                                      bouttonActionPerformed(evt);
                 }
                 });
//                boutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PIDevRealEstateAgency/UTILS/Email_Icon.png")));
                
                
                JButton annuler = new JButton();
                annuler.setText("Annuler");     
                annuler.addActionListener(new java.awt.event.ActionListener() {
                                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                                      annulerActionPerformed(evt);
                 }
                 });

                
                panel.add(label);
                panel.add(boutton);
                panel.add(annuler);
		panel.setLayout(new GridLayout());
                
		// Display the viewer in a JFrame
		
		frame.setLayout(new BorderLayout());
		frame.add(new JLabel("Use left mouse button to pan, mouse wheel to zoom and right mouse to select"), BorderLayout.NORTH);
		frame.add(mapViewer);
		frame.add(panel, BorderLayout.SOUTH);                
		frame.setSize(800, 600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setUndecorated(true);
		frame.setVisible(true);
		
		mapViewer.addPropertyChangeListener("zoom", new PropertyChangeListener()
		{
			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				updateWindowTitle(frame, mapViewer);
			}
		});
		
		mapViewer.addPropertyChangeListener("center", new PropertyChangeListener()
		{
			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				updateWindowTitle(frame, mapViewer);
			}
		});
		
		updateWindowTitle(frame, mapViewer);    }
	
        
            private void bouttonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
           // IOffreDAO OffreDao = new OffreDAO();
                System.out.println(" lon "+longitude+" lan "+latitude);
          
                rend.setLongitude(longitude);
                rend.setLatitude(latitude);
                   Irendez_vousDAO iadd=new Rendez_vousDAO() ;
        iadd.addRendez_vous(rend);
         JOptionPane.showMessageDialog(this, "Ajout effectué avec succès ");
             
            frame.setVisible(false);
            }         
        
            private void annulerActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
                
                frame.setVisible(false);
                
            }  
	
}
