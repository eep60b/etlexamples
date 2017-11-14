/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.netbeans.rcp.catalog;

import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.nodes.AbstractNode;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.etlsolutions.examples.netbeans.rcp.catalog//Catalog//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "CatalogTopComponent",
        iconBase = "com/etlsolutions/examples/netbeans/rcp/catalog/catalog.png",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "com.etlsolutions.examples.netbeans.rcp.catalog.CatalogTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_CatalogAction",
        preferredID = "CatalogTopComponent"
)
@Messages({
    "CTL_CatalogAction=Catalog",
    "CTL_CatalogTopComponent=Catalog Window",
    "HINT_CatalogTopComponent=This is a Catalog window"
})
public final class CatalogTopComponent extends TopComponent {

    private final transient ExplorerManager explorerManager = new ExplorerManager();

    public CatalogTopComponent() {
        initComponents();
        setName(Bundle.CTL_CatalogTopComponent());
        setToolTipText(Bundle.HINT_CatalogTopComponent());
        associateLookup(ExplorerUtils.createLookup(explorerManager, getActionMap()));
        explorerManager.setRootContext(new AbstractNode(new CategoryChildren()));
        explorerManager.getRootContext().setDisplayName("Book Category");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        beanTreeView2 = new org.openide.explorer.view.BeanTreeView();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(beanTreeView2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(beanTreeView2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openide.explorer.view.BeanTreeView beanTreeView2;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    public ExplorerManager getExplorerManager() {
        return explorerManager;
    }
}
