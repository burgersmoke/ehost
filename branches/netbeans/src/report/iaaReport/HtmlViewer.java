/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HtmlViewer.java
 *
 * Created on Aug 19, 2011, 4:53:05 AM
 */

package report.iaaReport;

import java.io.File;
import java.io.IOException;
import java.net.URLClassLoader;
import java.util.logging.Level;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

/**
 *
 * @author leng
 */
public class HtmlViewer extends javax.swing.JPanel implements HyperlinkListener  {

    IAA __iaa = null;
    /** Creates new form HtmlViewer */
    public HtmlViewer(IAA _iaa) {
        try {



            this.__iaa = _iaa;
            initComponents();
            this.jEditorPane1.setEditable(false);
            File file = new File( env.Parameters.WorkSpace.CurrentProject.getAbsolutePath() + File.separatorChar + "reports" + File.separatorChar + "index.html");
            log.LoggingToFile.log(Level.INFO, "trying to show index.html file on screen ["+file.getAbsolutePath() + "].");
            String path = "file:"+file.getAbsolutePath();
            this.jEditorPane1.setContentType("text/html");

            URLClassLoader urlLoader = (URLClassLoader)this.getClass().getClassLoader();
            //URL url = urlLoader.;//可以用html格式文件做你的帮助系统了
            jEditorPane1.setPage(path);
            //this.jEditorPane1.setPage("file://localhost/Users/leng/Dropbox/eHOST/test/2_Partnerstest/reports/class_and_span_matcher.html");

            jEditorPane1.addHyperlinkListener(this);
        } catch (IOException ex) {
            log.LoggingToFile.log(Level.SEVERE, ex.getMessage());
        }
    }

    /**open the hyper link on any html page we display on the text editor panel. */
    public void hyperlinkUpdate(HyperlinkEvent e)
    {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
        {
            JEditorPane pane = (JEditorPane) e.getSource();
         if (e instanceof HTMLFrameHyperlinkEvent)
         {
            HTMLFrameHyperlinkEvent evt = (HTMLFrameHyperlinkEvent) e;
            HTMLDocument doc = (HTMLDocument) pane.getDocument();
            doc.processHTMLFrameHyperlinkEvent(evt);
         }
         else
         {
            try
            {
               pane.setPage(e.getURL());
            }
            catch (Throwable t)
            {
               t.printStackTrace();
            }
         }
      }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createMatteBorder(15, 15, 10, 15, new java.awt.Color(255, 255, 254)));
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jEditorPane1.setFont(new java.awt.Font("Georgia", 0, 13)); // NOI18N
        jScrollPane1.setViewportView(jEditorPane1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 254));

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(508, Short.MAX_VALUE)
                .add(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jButton1)
        );

        add(jPanel1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        __iaa.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
