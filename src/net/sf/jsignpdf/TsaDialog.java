package net.sf.jsignpdf;

import javax.swing.JComponent;

/**
 * JDialog for setting timestamp authority and enabling OCSP.
 * @author Josef Cacek
 */
public class TsaDialog extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;

	protected final ResourceProvider res = ResourceProvider.getInstance();
	private BasicSignerOptions options;

	/** Creates new form TsaDialog */
	public TsaDialog(java.awt.Frame parent, boolean modal,
			BasicSignerOptions anOpts) {
		super(parent, modal);
		options = anOpts;
		initComponents();
		translateLabels();
		switchTsaEnabled();
	}

		/**
	 * Translates labels in this dialog.
	 */
	private void translateLabels() {
		setTitle(res.get("gui.tsa.title"));

		setLabelAndMnemonic(cbTsaEnabled, "gui.tsa.enabled.checkbox");

		setLabelAndMnemonic(lblTsaUrl, "gui.tsa.url.label");
		setLabelAndMnemonic(lblTsaUser, "gui.tsa.user.label");
		setLabelAndMnemonic(lblTsaPwd, "gui.tsa.pwd.label");

		setLabelAndMnemonic(cbOcspEnabled, "gui.tsa.ocspEnabled.checkbox");
	}


	/**
	 * Loads properties saved by previous run of application
	 */
	private void updateFromOptions() {
		cbTsaEnabled.setSelected(options.isTimestamp());
		tfTsaUrl.setText(ConvertUtils.toString(options.getTsaUrl()));
		tfTsaUser.setText(ConvertUtils.toString(options.getTsaUser()));
		pfTsaPwd.setText(ConvertUtils.toString(options.getTsaPasswd()));
		cbOcspEnabled.setSelected(options.isOcspEnabled());
	}

	/**
	 * Enabling text field
	 */
	private void switchTsaEnabled() {
		boolean tmpEnabled = cbTsaEnabled.isSelected();
		tfTsaUrl.setEnabled(tmpEnabled);
		tfTsaUser.setEnabled(tmpEnabled);
		pfTsaPwd.setEnabled(tmpEnabled);
	}

	/**
	 * stores values from this Form to the instance of {@link SignerOptions}
	 */
	private void storeToOptions() {
		options.setTimestamp(cbTsaEnabled.isSelected());
		options.setTsaUrl(tfTsaUrl.getText());
		options.setTsaUser(tfTsaUser.getText());
		options.setTsaPasswd(new String(pfTsaPwd.getPassword()));
		options.setOcspEnabled(cbOcspEnabled.isSelected());

		//if there are fixed values update them in the form;
		updateFromOptions();
	}

	/**
	 * Facade for {@link ResourceProvider#setLabelAndMnemonic(JComponent, String)}
	 * @param aComponent
	 * @param aKey
	 */
	private void setLabelAndMnemonic(final JComponent aComponent, final String aKey) {
		res.setLabelAndMnemonic(aComponent, aKey);
	}


	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		cbTsaEnabled = new javax.swing.JCheckBox();
		lblTsaUrl = new javax.swing.JLabel();
		tfTsaUrl = new javax.swing.JTextField();
		lblTsaUser = new javax.swing.JLabel();
		lblTsaPwd = new javax.swing.JLabel();
		tfTsaUser = new javax.swing.JTextField();
		pfTsaPwd = new javax.swing.JPasswordField();
		cbOcspEnabled = new javax.swing.JCheckBox();
		btnTsaOK = new javax.swing.JButton();

		addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentHidden(java.awt.event.ComponentEvent evt) {
				formComponentHidden(evt);
			}
			public void componentShown(java.awt.event.ComponentEvent evt) {
				formComponentShown(evt);
			}
		});
		getContentPane().setLayout(new java.awt.GridBagLayout());

		cbTsaEnabled.setText("Use timestamp server");
		cbTsaEnabled.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
		cbTsaEnabled.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbTsaEnabledActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(cbTsaEnabled, gridBagConstraints);

		lblTsaUrl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblTsaUrl.setLabelFor(tfTsaUrl);
		lblTsaUrl.setText("TSA URL");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(lblTsaUrl, gridBagConstraints);

		tfTsaUrl.setMinimumSize(new java.awt.Dimension(200, 20));
		tfTsaUrl.setPreferredSize(new java.awt.Dimension(200, 20));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 4.0;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(tfTsaUrl, gridBagConstraints);

		lblTsaUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblTsaUser.setLabelFor(tfTsaUser);
		lblTsaUser.setText("TSA user");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(lblTsaUser, gridBagConstraints);

		lblTsaPwd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblTsaPwd.setLabelFor(lblTsaPwd);
		lblTsaPwd.setText("TSA password");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(lblTsaPwd, gridBagConstraints);

		tfTsaUser.setMinimumSize(new java.awt.Dimension(70, 20));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(tfTsaUser, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(pfTsaPwd, gridBagConstraints);

		cbOcspEnabled.setText("Use OCSP");
		cbOcspEnabled.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
		getContentPane().add(cbOcspEnabled, gridBagConstraints);

		btnTsaOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jsignpdf/back16.png"))); // NOI18N
		btnTsaOK.setText("OK");
		btnTsaOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTsaOKActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(7, 5, 2, 5);
		getContentPane().add(btnTsaOK, gridBagConstraints);
	}// </editor-fold>//GEN-END:initComponents

	private void btnTsaOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTsaOKActionPerformed
		setVisible(false);
}//GEN-LAST:event_btnTsaOKActionPerformed

	private void cbTsaEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTsaEnabledActionPerformed
		switchTsaEnabled();
	}//GEN-LAST:event_cbTsaEnabledActionPerformed

	private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
		updateFromOptions();
		switchTsaEnabled();
	}//GEN-LAST:event_formComponentShown

	private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
		storeToOptions();
	}//GEN-LAST:event_formComponentHidden


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnTsaOK;
	private javax.swing.JCheckBox cbOcspEnabled;
	private javax.swing.JCheckBox cbTsaEnabled;
	private javax.swing.JLabel lblTsaPwd;
	private javax.swing.JLabel lblTsaUrl;
	private javax.swing.JLabel lblTsaUser;
	private javax.swing.JPasswordField pfTsaPwd;
	private javax.swing.JTextField tfTsaUrl;
	private javax.swing.JTextField tfTsaUser;
	// End of variables declaration//GEN-END:variables

}