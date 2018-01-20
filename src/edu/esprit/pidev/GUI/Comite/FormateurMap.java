package edu.esprit.pidev.GUI.Comite;

import edu.esprit.pidev.GUI.Admin.*;
import edu.esprit.pidev.dao.classes.GestionUtilisateur;
import edu.esprit.pidev.dao.classes.Rendez_vousDAO;
import edu.esprit.pidev.dao.classes.UtilisateurDAO;
import edu.esprit.pidev.dao.interfaces.Irendez_vousDAO;
import edu.esprit.pidev.entities.Rendez_vous;
import edu.esprit.pidev.entities.User;
import edu.esprit.pidev.util.MyConnection;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FormateurMap extends JPanel
{
    final JFrame frame = new JFrame();
    /**
     * @param args the program args (ignored)
     */
    public static void main(String[] args)
    {
        
        new FormateurMap().setVisible(false);
    }
 public User DisplayOrganisme(int id) {
        Statement st;
        ResultSet rs;
       
           User user = new User();
           String sql= "select * from user where id="+id;
        try 
        {
            st= MyConnection.getInstance().getConnection().createStatement();
            rs=st.executeQuery(sql);
            while (rs.next())
            {
                if((rs.getString(9).equals("organisme"))&&(rs.getInt(13)==1))
                {
                
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setDateNaiss(rs.getString(7));
                user.setSexe(rs.getString(8));
                user.setNbrReclamation(rs.getInt(10));
                user.setLatitude(rs.getDouble(18));
                user.setLongitude(rs.getDouble(19));
                user.setUsername(rs.getString(21));
                user.setPassword(rs.getString(27));
                user.setEmail(rs.getString(23));
                user.setRoles(rs.getString(34));
               
                }
            }
            return user;
        }
         
        catch (SQLException ex) {
           Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }    }
     
    public FormateurMap() {
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

    FormateurMap(User user) {
        
        //IOffreDAO OffreDao = new OffreDAO();
       
        //Offre o1 = OffreDao.FindLatLonById(id_off);
        double latitude = user.getLatitude();
        double longitude = user.getLongitude();
        if (latitude == 0.0 && longitude == 0.0 ){
            JOptionPane.showMessageDialog(this, "Organisme non localisé");
        } else {
        
        final JXMapKit jXMapKit = new JXMapKit();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapKit.setTileFactory(tileFactory);
        
        //location of Java
        final GeoPosition gp = new GeoPosition(latitude, longitude); 

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
                
                retour.setText("Retour à liste des organismes");     
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
