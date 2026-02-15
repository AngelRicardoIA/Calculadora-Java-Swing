/*
 * R1. UML y eventos - Entrega
 * Alumno: Angel Ricardo Ibañez Aceves
 * Maestro: Andrés Espinal Jiménez
 * Materia: Tópicos avanzados de programación v2
 */

package com.mycompany.micalculadora;

public class Calculadora extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Calculadora.class.getName());
    
    // Variables de estado y lógica
    private String display = "";
    private String operador = "";
    private Double valor1;
    private Double valor2;
    private Double resultado;
    
    // Banderas de control de flujo
    private boolean esPrimerValor = false;
    private boolean esSegundoValor = false;
    private boolean resultadoMostrado = false;
    
    //Constructor
    public Calculadora() {
        initComponents();
    }
    
    private void actualizarDisplay(){
        this.campoTexto.setText(display);
    }
    
    private void limpiarDisplay(){
        display = "";
        this.campoTexto.setText(display);
    }
    
    /**
     * Guarda el número actual en memoria antes de una operación.
     * Valida que no se intente guardar un operador como número.
     */
    private void guardarValor(){ 
        if(!display.equals("+") && !display.equals("-") && !display.equals("*") && !display.equals("/") && !display.equals("") ){
            if(!esPrimerValor){
                try{
                valor1 = Double.parseDouble(display);
                System.out.println("Valor1 = " + valor1);
                esPrimerValor = true;
                }catch(NumberFormatException e){
                    System.out.println("Ingresa un numero primero");
                }
            }else {
                valor2 = Double.parseDouble(display);
                System.out.println("Valor2: " + valor2);
            }
        }
    }
    
    //Restablece la calculadora a su estado inicial.
    private void borrarDatos(){
        limpiarDisplay();
        valor1 = 0.0;
        valor2 = 0.0;
        resultado = 0.0;
        esPrimerValor = false;
        esSegundoValor = false;
        resultadoMostrado = false;
        operador = "";
    }
    
    /**
     * Agrega un dígito al display manejando la concatenación.
     * Si hay un resultado previo mostrándose, reinicia la cuenta.
     * @param num El número en formato String a agregar.
     */
    private void agregarNum(String num){
        if(resultadoMostrado == true){
            borrarDatos();
        }
        
        if(esSegundoValor){
            display = "";
            esSegundoValor = false;
        }
        display += num;
        actualizarDisplay();
    }
    
    /**
     * Realiza la operación matemática basada en el operador seleccionado.
     * Maneja la excepción de división por cero visualmente.
     */
    private void calcular(){
        if(valor1 == null || valor2 == null) return;
        
        switch(operador){
            case "+": 
                resultado = valor1 + valor2;
                break;
            case "-": 
                resultado = valor1 - valor2;
                break;
            case "*": 
                resultado = valor1 * valor2;
                break;
            case "/": 
                if(valor2 != 0){
                resultado = valor1 / valor2;
                }else{
                    limpiarDisplay();
                    display = "Error: Div/0";
                    actualizarDisplay();
                    System.out.println("Error: Div/0");
                    resultadoMostrado = true;
                }
                break;
            default:
                System.out.println("Operador desconocido");
                return;
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        campoTexto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btnSuma = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btnResta = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnMulti = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnIgual = new javax.swing.JButton();
        btnDivision = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mi Calculadora");
        setBackground(new java.awt.Color(255, 227, 197));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 248, 234));

        campoTexto.setEditable(false);
        campoTexto.setBackground(new java.awt.Color(255, 248, 234));
        campoTexto.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        campoTexto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoTexto.setBorder(null);

        jPanel2.setBackground(new java.awt.Color(255, 239, 222));
        jPanel2.setPreferredSize(new java.awt.Dimension(320, 400));
        jPanel2.setLayout(new java.awt.GridLayout(4, 4, 5, 5));

        btn1.setBackground(new java.awt.Color(255, 223, 179));
        btn1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        btn1.setForeground(new java.awt.Color(61, 39, 9));
        btn1.setText("1");
        btn1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn1.setBorderPainted(false);
        btn1.setFocusPainted(false);
        btn1.addActionListener(this::btn1ActionPerformed);
        jPanel2.add(btn1);

        btn2.setBackground(new java.awt.Color(255, 223, 179));
        btn2.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        btn2.setForeground(new java.awt.Color(61, 39, 9));
        btn2.setText("2");
        btn2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn2.setBorderPainted(false);
        btn2.setFocusPainted(false);
        btn2.addActionListener(this::btn2ActionPerformed);
        jPanel2.add(btn2);

        btn3.setBackground(new java.awt.Color(255, 223, 179));
        btn3.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        btn3.setForeground(new java.awt.Color(61, 39, 9));
        btn3.setText("3");
        btn3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn3.setBorderPainted(false);
        btn3.setFocusPainted(false);
        btn3.addActionListener(this::btn3ActionPerformed);
        jPanel2.add(btn3);

        btnSuma.setBackground(new java.awt.Color(255, 133, 0));
        btnSuma.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        btnSuma.setForeground(new java.awt.Color(36, 19, 0));
        btnSuma.setText("+");
        btnSuma.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSuma.setBorderPainted(false);
        btnSuma.setFocusPainted(false);
        btnSuma.addActionListener(this::btnSumaActionPerformed);
        jPanel2.add(btnSuma);

        btn4.setBackground(new java.awt.Color(255, 223, 179));
        btn4.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        btn4.setForeground(new java.awt.Color(61, 39, 9));
        btn4.setText("4");
        btn4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn4.setBorderPainted(false);
        btn4.setFocusPainted(false);
        btn4.addActionListener(this::btn4ActionPerformed);
        jPanel2.add(btn4);

        btn5.setBackground(new java.awt.Color(255, 223, 179));
        btn5.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        btn5.setForeground(new java.awt.Color(61, 39, 9));
        btn5.setText("5");
        btn5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn5.setBorderPainted(false);
        btn5.setFocusPainted(false);
        btn5.addActionListener(this::btn5ActionPerformed);
        jPanel2.add(btn5);

        btn6.setBackground(new java.awt.Color(255, 223, 179));
        btn6.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        btn6.setForeground(new java.awt.Color(61, 39, 9));
        btn6.setText("6");
        btn6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn6.setBorderPainted(false);
        btn6.setFocusPainted(false);
        btn6.addActionListener(this::btn6ActionPerformed);
        jPanel2.add(btn6);

        btnResta.setBackground(new java.awt.Color(255, 133, 0));
        btnResta.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        btnResta.setForeground(new java.awt.Color(36, 19, 0));
        btnResta.setText("-");
        btnResta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnResta.setBorderPainted(false);
        btnResta.setFocusPainted(false);
        btnResta.addActionListener(this::btnRestaActionPerformed);
        jPanel2.add(btnResta);

        btn7.setBackground(new java.awt.Color(255, 223, 179));
        btn7.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        btn7.setForeground(new java.awt.Color(61, 39, 9));
        btn7.setText("7");
        btn7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn7.setBorderPainted(false);
        btn7.setFocusPainted(false);
        btn7.addActionListener(this::btn7ActionPerformed);
        jPanel2.add(btn7);

        btn8.setBackground(new java.awt.Color(255, 223, 179));
        btn8.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        btn8.setForeground(new java.awt.Color(61, 39, 9));
        btn8.setText("8");
        btn8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn8.setBorderPainted(false);
        btn8.setFocusPainted(false);
        btn8.addActionListener(this::btn8ActionPerformed);
        jPanel2.add(btn8);

        btn9.setBackground(new java.awt.Color(255, 223, 179));
        btn9.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        btn9.setForeground(new java.awt.Color(61, 39, 9));
        btn9.setText("9");
        btn9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn9.setBorderPainted(false);
        btn9.setFocusPainted(false);
        btn9.addActionListener(this::btn9ActionPerformed);
        jPanel2.add(btn9);

        btnMulti.setBackground(new java.awt.Color(255, 133, 0));
        btnMulti.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        btnMulti.setForeground(new java.awt.Color(36, 19, 0));
        btnMulti.setText("*");
        btnMulti.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMulti.setBorderPainted(false);
        btnMulti.setFocusPainted(false);
        btnMulti.addActionListener(this::btnMultiActionPerformed);
        jPanel2.add(btnMulti);

        btnC.setBackground(java.awt.Color.orange);
        btnC.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnC.setForeground(new java.awt.Color(36, 19, 0));
        btnC.setText("C");
        btnC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnC.setBorderPainted(false);
        btnC.setFocusPainted(false);
        btnC.addActionListener(this::btnCActionPerformed);
        jPanel2.add(btnC);

        btn0.setBackground(new java.awt.Color(255, 223, 179));
        btn0.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        btn0.setForeground(new java.awt.Color(61, 39, 9));
        btn0.setText("0");
        btn0.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn0.setBorderPainted(false);
        btn0.setFocusPainted(false);
        btn0.addActionListener(this::btn0ActionPerformed);
        jPanel2.add(btn0);

        btnIgual.setBackground(javax.swing.UIManager.getDefaults().getColor("Objects.Yellow"));
        btnIgual.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnIgual.setForeground(new java.awt.Color(36, 19, 0));
        btnIgual.setText("=");
        btnIgual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIgual.setBorderPainted(false);
        btnIgual.setFocusPainted(false);
        btnIgual.addActionListener(this::btnIgualActionPerformed);
        jPanel2.add(btnIgual);

        btnDivision.setBackground(new java.awt.Color(255, 133, 0));
        btnDivision.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        btnDivision.setForeground(new java.awt.Color(36, 19, 0));
        btnDivision.setText("/");
        btnDivision.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDivision.setBorderPainted(false);
        btnDivision.setFocusPainted(false);
        btnDivision.addActionListener(this::btnDivisionActionPerformed);
        jPanel2.add(btnDivision);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(campoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(363, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(147, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(25, 25, 25)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumaActionPerformed
        guardarValor();
        limpiarDisplay();
        display = "+";
        actualizarDisplay();
        operador = "+";
        esSegundoValor = true;
        resultadoMostrado = false;
    }//GEN-LAST:event_btnSumaActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
       agregarNum("1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        agregarNum("2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        agregarNum("3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        agregarNum("5");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        agregarNum("6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btnRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaActionPerformed
        guardarValor();
        limpiarDisplay();
        display = "-";
        actualizarDisplay();
        operador = "-";
        esSegundoValor = true;
        resultadoMostrado = false;
    }//GEN-LAST:event_btnRestaActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        agregarNum("7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        agregarNum("8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        agregarNum("9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btnMultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiActionPerformed
        guardarValor();
        limpiarDisplay();
        display = "*";
        actualizarDisplay();
        operador = "*";
        esSegundoValor = true;
        resultadoMostrado = false;
    }//GEN-LAST:event_btnMultiActionPerformed

    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
        borrarDatos();
    }//GEN-LAST:event_btnCActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        agregarNum("0");
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgualActionPerformed
        if(resultadoMostrado == false){
            guardarValor();
            calcular();
            
            if(!display.equals("Error: Div/0")){
                limpiarDisplay();
                display = String.valueOf(resultado);
                campoTexto.setText(display);
                valor1 = resultado;
                valor2 = 0.0;
                esSegundoValor = false;
                resultadoMostrado = true;
            }
        }
    }//GEN-LAST:event_btnIgualActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        agregarNum("4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btnDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivisionActionPerformed
        guardarValor();
        limpiarDisplay();
        display = "/";
        actualizarDisplay();
        operador = "/";
        esSegundoValor = true;
        resultadoMostrado = false;
    }//GEN-LAST:event_btnDivisionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Calculadora().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnDivision;
    private javax.swing.JButton btnIgual;
    private javax.swing.JButton btnMulti;
    private javax.swing.JButton btnResta;
    private javax.swing.JButton btnSuma;
    private javax.swing.JTextField campoTexto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
