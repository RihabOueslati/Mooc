package edu.esprit.pidev.GUI.Organisme;

import edu.esprit.pidev.dao.classes.Rendez_vousDAO;
import edu.esprit.pidev.entities.Rendez_vous;
import edu.esprit.pidev.dao.interfaces.Irendez_vousDAO;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolTip;


import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

/**
 * A simple sample application that uses JXMapKit
 * @author Martin Steiger
 */
public class MapsFind extends JFrame
{
    final JFrame frame = new JFrame();
    /**
     * @param args the program args (ignored)
     */
    public static void main(String[] args)
    {
        new MapsFind().setVisible(false);
    }

    public MapsFind() {
        final JXMapKit jXMapKit = new JXMapKit();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapKit.setTileFactory(tileFactory);

        //location of Java
        final GeoPosition gp = new GeoPosition(-7.502778, 111.263056); 

        final JToolTip tooltip = new JToolTip();
        tooltip.setTipText("Java");
        tooltip.setComponent(jXMapKit.getMainMap());
        jXMapKit.getMainMap().add(tooltip);

        jXMapKit.setZoom(11);
        jXMapKit.setAddressLocation(gp);

        jXMapKit.getMainMap().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) { 
                // ignore
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                JXMapViewer map = jXMapKit.getMainMap();

                // convert to world bitmap
                Point2D worldPos = map.getTileFactory().geoToPixel(gp, map.getZoom());

                // convert to screen
                Rectangle rect = map.getViewportBounds();
                int sx = (int) worldPos.getX() - rect.x;
                int sy = (int) worldPos.getY() - rect.y;
                Point screenPos = new Point(sx, sy);

                // check if near the mouse
                if (screenPos.distance(e.getPoint()) < 20)
                {
                    screenPos.x -= tooltip.getWidth() / 2;

                    tooltip.setLocation(screenPos);
                    tooltip.setVisible(true);
                }
                else
                {
                    tooltip.setVisible(false);
                }
            }
        });

        // Display the viewer in a JFrame
	frame.setLayout(new BorderLayout());
        frame.getContentPane().add(jXMapKit);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);        
        
    }

    MapsFind(int id_rendervous) {
        Irendez_vousDAO rendezvous=new Rendez_vousDAO();
        //IOffreDAO OffreDao = new OffreDAO();
        //System.out.println(id_rendervous);
        //Offre o1 = OffreDao.FindLatLonById(id_off);
        Rendez_vous rdv =rendezvous.FindLonLatByIdRdv(id_rendervous);
        if (rdv.getLatitude() == 0.0 && rdv.getLongitude() == 0.0 ){
            JOptionPane.showMessageDialog(this, "Ce rendez vous n'etait pas localisé");
        } else {
        
        final JXMapKit jXMapKit = new JXMapKit();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapKit.setTileFactory(tileFactory);
        
        //location of Java
        final GeoPosition gp = new GeoPosition(rdv.getLatitude(), rdv.getLongitude()); 

        final JToolTip tooltip = new JToolTip();
//        tooltip.setTipText("Java");
        tooltip.setComponent(jXMapKit.getMainMap());
        jXMapKit.getMainMap().add(tooltip);

        jXMapKit.setZoom(5);
        jXMapKit.setAddressLocation(gp);

        jXMapKit.getMainMap().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) { 
                // ignore
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                JXMapViewer map = jXMapKit.getMainMap();

                // convert to world bitmap
                Point2D worldPos = map.getTileFactory().geoToPixel(gp, map.getZoom());

                // convert to screen
                Rectangle rect = map.getViewportBounds();
                int sx = (int) worldPos.getX() - rect.x;
                int sy = (int) worldPos.getY() - rect.y;
                Point screenPos = new Point(sx, sy);

                // check if near the mouse
                if (screenPos.distance(e.getPoint()) < 20)
                {
                    screenPos.x -= tooltip.getWidth() / 2;

                    tooltip.setLocation(screenPos);
                    tooltip.setVisible(true);
                }
                else
                {
                    tooltip.setVisible(false);
                }
            }
        });

		JPanel panel = new JPanel();
		JLabel label = new JLabel("Faire votre choix : ");
                JButton retour = new JButton();
                
                retour.setText("Retour au liste des rendez vous");     
                retour.addActionListener(new java.awt.event.ActionListener() {
                                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                                      retourActionPerformed(evt);
                 }

            private void retourActionPerformed(ActionEvent evt) {
                frame.setVisible(false);
            }
                 });                
        
                panel.add(label);
                panel.add(retour);
                panel.setLayout(new GridLayout());
        // Display the viewer in a JFrame
	frame.setLayout(new BorderLayout());
        frame.getContentPane().add(jXMapKit);
        frame.add(panel, BorderLayout.SOUTH); 
        frame.setSize(800, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setVisible(true);        
                
        }
    }
}
