/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.octa.invocetransform.View;

import com.octa.invocetransform.Business.XmlToAppModel;
import com.octa.invocetransform.Models.AppModels.DocumentListModel;
import com.octa.invocetransform.Models.ComprobanteRetencionModel.FacturaComprobante;
import com.octa.invocetransform.Utils.FileUtils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author dskat
 */
public class TrasnformView extends javax.swing.JFrame {

    //List related
    private ArrayList<File> selectedFileList;
    private DefaultListModel<DocumentListModel> defaultListModel = new DefaultListModel<>();
    private int itemIndex;
    private int itemIndexNotValid;

    //STATIC VARIABLES
    private static final String DEFAULT_QTY_LIST_MESSAGE = "Cantidad de documentos seleccionados:";

    //Document generation related
    private ArrayList<FacturaComprobante> facturaComprobanteLs;

    //Paths
    /**
     * Creates new form TrasnformView
     */
    public TrasnformView() {
        initComponents();
        initListeners();
    }

    private static void initMetalTheme() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TrasnformView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initListeners() {

        //ADDED DOCS
        jList_DocList.setModel(defaultListModel);
        jList_DocList.setCellRenderer(createListRenderer());

        jList_DocList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 1) {
                    //Set the current item selected index
                    itemIndex = list.locationToIndex(evt.getPoint());

                } else if (evt.getClickCount() == 2) {

                    // Double-click detected
                    DocumentListModel f = (DocumentListModel) list.getSelectedValue();
                    System.out.println("Opening document: " + f.getFileName());

                    //Open the file with registered APP
                    if (Desktop.isDesktopSupported()) {
                        try {
                            File myFile = new File(f.getFilePath());
                            Desktop.getDesktop().open(myFile);
                        } catch (IOException ex) {
                            Logger.getLogger(TrasnformView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
        });

        jLabel_DocsQuantity.setText(DEFAULT_QTY_LIST_MESSAGE + " " + defaultListModel.size());

    }

    private static ListCellRenderer<? super DocumentListModel> createListRenderer() {
        return new DefaultListCellRenderer() {
            private Color background = new Color(0, 100, 255, 15);
            private Color defaultBackground = (Color) UIManager.get("List.background");

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (c instanceof JLabel) {
                    JLabel label = (JLabel) c;
                    DocumentListModel fileContent = (DocumentListModel) value;
                    label.setText(String.format("%s ", fileContent.getFileName()));
                    if (!isSelected) {
                        label.setBackground(index % 2 == 0 ? background : defaultBackground);
                    }
                }
                return c;
            }
        };
    }

    private void selectPathToSave() {

        jTextField_DocToSavePath.setText(FileUtils.selectPath());

    }

    //Open file manager and get documents
    //Add the document to the ListMode
    private void selectDocuments() {

        selectedFileList = FileUtils.openFileManager(this);
        if (selectedFileList != null) {

            defaultListModel = new DefaultListModel<>();

            for (int x = 0; x < selectedFileList.size(); x++) {
                DocumentListModel docLsModel = new DocumentListModel();
                docLsModel.setFileName(selectedFileList.get(x).getName());
                docLsModel.setFilePath(selectedFileList.get(x).getPath());
                defaultListModel.addElement(docLsModel);
                System.out.println("Added " + x + " file: " + docLsModel.getFileName());
            }

            jList_DocList.setModel(defaultListModel);
            jLabel_DocsQuantity.setText(DEFAULT_QTY_LIST_MESSAGE + " " + defaultListModel.size());

        } else {

            System.out.println("Null jList");
        }

    }

    private boolean generateDocument() {

        boolean allOk = false;

        facturaComprobanteLs = new ArrayList<>();
        StringBuilder stb = new StringBuilder();

        for (int x = 0; x < defaultListModel.size(); x++) {

            System.out.println("Current file path to transform: " + defaultListModel.get(x).getFilePath());
            FacturaComprobante facComp = XmlToAppModel.transformXMLComprobanteRetencion(defaultListModel.get(x).getFilePath());
            System.out.println("is valid current: " + facComp.isIsValidDocApp());

            if (facComp.isIsValidDocApp()) {
                facturaComprobanteLs.add(facComp);
            } else {
                System.out.println("Added not valid file: " + defaultListModel.get(x).getFileName());
                stb.append(defaultListModel.get(x).getFileName() + "\n");
            }

        }
        jTextArea_NotValidDocs.setText(stb.toString());

        if (!facturaComprobanteLs.isEmpty()) {
            allOk = XmlToAppModel.generateExcelDocument(facturaComprobanteLs, jTextField_DocToSavePath.getText());
        }

        return allOk;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton_GenerateDocument = new javax.swing.JButton();
        jScrollPane_DocList = new javax.swing.JScrollPane();
        jList_DocList = new javax.swing.JList<>();
        jButton_SelectDocuments = new javax.swing.JButton();
        jLabel_DocsQuantity = new javax.swing.JLabel();
        jComboBox_InvoiceType = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField_DocToSavePath = new javax.swing.JTextField();
        jButton_SelectPathToSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_NotValidDocs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        jPanel1.setBackground(new java.awt.Color(16, 15, 15));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione los documentos que desea trasnformar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButton_GenerateDocument.setBackground(new java.awt.Color(15, 61, 62));
        jButton_GenerateDocument.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton_GenerateDocument.setForeground(new java.awt.Color(255, 255, 255));
        jButton_GenerateDocument.setText("Generar Documento");
        jButton_GenerateDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GenerateDocumentActionPerformed(evt);
            }
        });

        jList_DocList.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jList_DocList.setModel(defaultListModel);
        jScrollPane_DocList.setViewportView(jList_DocList);

        jButton_SelectDocuments.setBackground(new java.awt.Color(15, 61, 62));
        jButton_SelectDocuments.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton_SelectDocuments.setForeground(new java.awt.Color(255, 255, 255));
        jButton_SelectDocuments.setText("Seleccionar Documentos");
        jButton_SelectDocuments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SelectDocumentsActionPerformed(evt);
            }
        });

        jLabel_DocsQuantity.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel_DocsQuantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_DocsQuantity.setText("Cantidad de documentos seleccionados: ");

        jComboBox_InvoiceType.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jComboBox_InvoiceType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comprobantes de Retención" }));
        jComboBox_InvoiceType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_InvoiceTypeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tipo de factura");

        jTextField_DocToSavePath.setEditable(false);
        jTextField_DocToSavePath.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        jButton_SelectPathToSave.setBackground(new java.awt.Color(15, 61, 62));
        jButton_SelectPathToSave.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jButton_SelectPathToSave.setForeground(new java.awt.Color(255, 255, 255));
        jButton_SelectPathToSave.setText("Seleccionar");
        jButton_SelectPathToSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SelectPathToSaveActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Documentos no validos");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Seleccione la ruta donde desea guardar:");

        jTextArea_NotValidDocs.setColumns(20);
        jTextArea_NotValidDocs.setRows(5);
        jScrollPane1.setViewportView(jTextArea_NotValidDocs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane_DocList)
            .addComponent(jLabel_DocsQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_SelectDocuments, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox_InvoiceType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton_GenerateDocument, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField_DocToSavePath, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_SelectPathToSave, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_SelectDocuments, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_DocsQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_DocList, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_InvoiceType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_DocToSavePath, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_SelectPathToSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_GenerateDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GenerateDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GenerateDocumentActionPerformed
        if (generateDocument()) {
            JOptionPane.showMessageDialog(null, "Documentos generados correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "A ocurrido un error.");
        }
    }//GEN-LAST:event_jButton_GenerateDocumentActionPerformed

    private void jButton_SelectDocumentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SelectDocumentsActionPerformed
        selectDocuments();
    }//GEN-LAST:event_jButton_SelectDocumentsActionPerformed

    private void jButton_SelectPathToSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SelectPathToSaveActionPerformed
        selectPathToSave();
    }//GEN-LAST:event_jButton_SelectPathToSaveActionPerformed

    private void jComboBox_InvoiceTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_InvoiceTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_InvoiceTypeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrasnformView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrasnformView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrasnformView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrasnformView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initMetalTheme();
                new TrasnformView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_GenerateDocument;
    private javax.swing.JButton jButton_SelectDocuments;
    private javax.swing.JButton jButton_SelectPathToSave;
    private javax.swing.JComboBox<String> jComboBox_InvoiceType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_DocsQuantity;
    private javax.swing.JList<DocumentListModel> jList_DocList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane_DocList;
    private javax.swing.JTextArea jTextArea_NotValidDocs;
    private javax.swing.JTextField jTextField_DocToSavePath;
    // End of variables declaration//GEN-END:variables
}
