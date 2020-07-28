/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class gaji extends javax.swing.JFrame {

    koneksi kon = new koneksi();
    String sql;
    int x, y;

    /**
     * Creates new form gaji
     */
    public gaji() {
        initComponents();
        kon.setKoneksi();
        awal();
    }

    private void awal() {
        tampil();
        idj.setVisible(false);
        idp1.setVisible(false);
        idp2.setVisible(false);
        idp3.setVisible(false);
        bpot1.setEnabled(false);
        bpot2.setEnabled(false);
        bpot3.setEnabled(false);
        setTanggal();
    }

    String idab, m, s, a, idka, idu;
    String nm_pot1, tot_pot1, nm_pot2, tot_pot2, nm_pot3, tot_pot3;
    String idpot1, idpot2, idpot3;

    public String getidu() {
        return idu;
    }

    public String getidab() {
        return idab;
    }

    public String getm() {
        return m;
    }

    public String gets() {
        return s;
    }

    public String geta() {
        return a;
    }

    public String getidka() {
        return idka;
    }

    public String getnm_pot1() {
        return nm_pot1;
    }

    public String gettot_pot1() {
        return tot_pot1;
    }

    public String getnm_pot2() {
        return nm_pot2;
    }

    public String gettot_pot2() {
        return tot_pot2;
    }

    public String getnm_pot3() {
        return nm_pot3;
    }

    public String gettot_pot3() {
        return tot_pot3;
    }

    public String getidpot1() {
        return idpot1;
    }

    public String getidpot2() {
        return idpot2;
    }

    public String getidpot3() {
        return idpot3;
    }

    public java.util.Date date = new java.util.Date();
    public SimpleDateFormat noformat = new SimpleDateFormat("yyMMdd");

    private void setTanggal() {
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("yyyy-MM-dd");
        tgl.setText(kal.format(date));
    }

    private void bersih() {
        no.setText("");
        ida.setText("");
        idk.setText("");
        nmk.setText("");
        idj.setText("");
        nmj.setText("");
        gapok.setText("0");
        tjab.setText("0");
        masuk.setText("0");
        sakit.setText("0");
        alfa.setText("0");
        ttrans.setText("0");
        tgaji.setText("0");

        jumpot1.setText("0");
        jumpot2.setText("0");
        jumpot3.setText("0");
        totpot.setText("0");

        terimagaji.setText("0");

        idp1.setText("");
        idp2.setText("");
        idp3.setText("");
    }

    private void aktif() {
        browse.setEnabled(true);
    }

    private void nonaktif() {
        browse.setEnabled(false);

        tambah.setEnabled(true);
        tutup.setEnabled(true);
        tutup.setText("TUTUP");
        tambah.setText("TAMBAH");
    }

    private void simpan() {
        sql = "insert into gaji values ('"
                + no.getText()
                + "','" + tgl.getText()
                + "','" + ida.getText()
                + "','" + tgaji.getText()
                + "','" + totpot.getText()
                + "','" + terimagaji.getText()
                + "','" + iduser.getText()
                + "')";
        try {
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            tampil();

        } catch (SQLException e) {
        }
    }

    private void hapus() {
        int row = tabel.getSelectedRow();
        sql = "delete from gaji where no_slip='" + (String) tabel.getValueAt(row, 0) + "'";
        try {
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            tampil();
        } catch (SQLException e) {
        }
    }

    private void tampil() {
        Object header[] = {"NO SLIP", "Tanggal", "Id Absen", "Total Gaji",
            "Total Potongan", "Terima Gaji", "Id User"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        tabel.setModel(data);

        kon.setKoneksi();
        sql = "select * from gaji";
        try {
            ResultSet rs = kon.st.executeQuery(sql);
            while (rs.next()) {
                String kolom1 = rs.getString(1);
                String kolom2 = rs.getString(2);
                String kolom3 = rs.getString(3);
                String kolom4 = rs.getString(4);
                String kolom5 = rs.getString(5);
                String kolom6 = rs.getString(6);
                String kolom7 = rs.getString(7);

                String kolom[] = {kolom1, kolom2, kolom3, kolom4, kolom5,
                    kolom6, kolom7};
                data.addRow(kolom);
            }
        } catch (SQLException e) {
        }
    }

    private void nomor() {
        try {
            kon.setKoneksi();
            sql = "select right(no_slip,3)+1 from gaji";
            ResultSet rs = kon.st.executeQuery(sql);

            if (rs.next()) {
                rs.last();
                String nom = rs.getString(1);
                while (nom.length() < 3) {
                    nom = "0" + nom;
                    no.setText(noformat.format(date) + nom);
                }
            } else {
                no.setText(noformat.format(date) + "001");
            }
        } catch (SQLException e) {
        }
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        no = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tgl = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        iduser = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ida = new javax.swing.JTextField();
        browse = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        idk = new javax.swing.JTextField();
        nmk = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nmj = new javax.swing.JTextField();
        idj = new javax.swing.JTextField();
        gapok = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        masuk = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        sakit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        alfa = new javax.swing.JTextField();
        tjab = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ttrans = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tgaji = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        nmpot1 = new javax.swing.JTextField();
        bpot1 = new javax.swing.JButton();
        cb1 = new javax.swing.JCheckBox();
        jumpot1 = new javax.swing.JTextField();
        cb2 = new javax.swing.JCheckBox();
        bpot2 = new javax.swing.JButton();
        nmpot2 = new javax.swing.JTextField();
        jumpot2 = new javax.swing.JTextField();
        cb3 = new javax.swing.JCheckBox();
        bpot3 = new javax.swing.JButton();
        nmpot3 = new javax.swing.JTextField();
        jumpot3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        totpot = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        terimagaji = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        idp1 = new javax.swing.JTextField();
        idp2 = new javax.swing.JTextField();
        idp3 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        tambah = new javax.swing.JButton();
        tutup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(java.awt.Color.lightGray);
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel3.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("NO SLIP GAJI");

        no.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("TANGGAL");

        tgl.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("USER");

        iduser.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iduser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(iduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("ID ABSEN");

        ida.setEditable(false);

        browse.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        browse.setText("...");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("NAMA KARYAWAN");

        idk.setEditable(false);

        nmk.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("JABATAN");

        nmj.setEditable(false);

        idj.setEditable(false);

        gapok.setEditable(false);
        gapok.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("GAJI POKOK");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("MASUK");

        masuk.setEditable(false);
        masuk.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        masuk.setText("0");
        masuk.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("SAKIT");

        sakit.setEditable(false);
        sakit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        sakit.setText("0");
        sakit.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ALFA");

        alfa.setEditable(false);
        alfa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        alfa.setText("0");
        alfa.setToolTipText("");

        tjab.setEditable(false);
        tjab.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("TUNJ. JABATAN");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("TUNJ. TRANSPORTASI =");

        ttrans.setEditable(false);
        ttrans.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ttrans.setText("0");
        ttrans.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("TOTAL GAJI");

        tgaji.setEditable(false);
        tgaji.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tgaji.setText("0");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("POTONGAN");

        nmpot1.setEditable(false);

        bpot1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bpot1.setText("...");
        bpot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpot1ActionPerformed(evt);
            }
        });

        cb1.setOpaque(false);
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });

        jumpot1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jumpot1.setText("0");
        jumpot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumpot1ActionPerformed(evt);
            }
        });
        jumpot1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jumpot1KeyTyped(evt);
            }
        });

        cb2.setOpaque(false);
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });

        bpot2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bpot2.setText("...");
        bpot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpot2ActionPerformed(evt);
            }
        });

        nmpot2.setEditable(false);

        jumpot2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jumpot2.setText("0");
        jumpot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumpot2ActionPerformed(evt);
            }
        });
        jumpot2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jumpot2KeyTyped(evt);
            }
        });

        cb3.setOpaque(false);
        cb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb3ActionPerformed(evt);
            }
        });

        bpot3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bpot3.setText("...");
        bpot3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpot3ActionPerformed(evt);
            }
        });

        nmpot3.setEditable(false);

        jumpot3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jumpot3.setText("0");
        jumpot3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumpot3ActionPerformed(evt);
            }
        });
        jumpot3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jumpot3KeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("TOTAL POTONGAN");

        totpot.setEditable(false);
        totpot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totpot.setText("0");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("GAJI YANG DITERIMA");

        terimagaji.setEditable(false);
        terimagaji.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        terimagaji.setText("0");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("ID KARYAWAN");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText(")");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("(");

        idp1.setEditable(false);

        idp2.setEditable(false);

        idp3.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tjab, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(nmk, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gapok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nmj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(browse)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(masuk)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sakit)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(alfa)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel12)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(idj)
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(idp1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idp2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idp3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ttrans, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tgaji))
                                .addGap(9, 9, 9)))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20)
                                .addGap(8, 8, 8))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cb3)
                                .addGap(18, 18, 18)
                                .addComponent(bpot3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nmpot3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totpot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(jumpot3)
                            .addComponent(terimagaji)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(cb2)
                                        .addGap(18, 18, 18)
                                        .addComponent(bpot2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nmpot2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(cb1)
                                        .addGap(18, 18, 18)
                                        .addComponent(bpot1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nmpot1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jumpot2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(jumpot1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browse)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(idk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(masuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sakit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alfa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cb1)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bpot1)
                                .addComponent(nmpot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jumpot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(nmj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ttrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gapok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tjab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(idp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb2)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nmpot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bpot2)
                                .addComponent(jumpot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb3)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jumpot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nmpot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bpot3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel15)
                                .addComponent(tgaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(totpot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19)
                                .addComponent(jLabel20)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(terimagaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel5.setOpaque(false);

        tambah.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tambah.setText("TAMBAH");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        tutup.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tutup.setText("TUTUP");
        tutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(tutup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(676, 676, 676))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(tutup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        tabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        // TODO add your handling code here:
        boolean closable = true;
        int x, y, z;
        dataAbsen dj = new dataAbsen(null, closable);
        dj.gaj = this;
        dj.setVisible(true);
        dj.setResizable(true);
        ida.setText(idab);
        idk.setText(idka);
        masuk.setText(m);
        sakit.setText(s);
        alfa.setText(a);
        kar();
        jab();
        x = Integer.parseInt(masuk.getText());
        y = Integer.parseInt(ttrans.getText());
        z = x * y;
        ttrans.setText(Integer.toString(z));
        toga();
        hitung1();
    }//GEN-LAST:event_browseActionPerformed

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        // TODO add your handling code here:
        if (cb1.isSelected()) {
            bpot1.setEnabled(true);
        } else {
            bpot1.setEnabled(false);
            nmpot1.setText("");
            jumpot1.setText("0");
            hitung1();
            hapusDetail_1();
        }
    }//GEN-LAST:event_cb1ActionPerformed

    private void hapusDetail_1() {
        try {
            sql = "Delete from detailgaji where id_potongan='" + idp1.getText() + "'";
            kon.st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        // TODO add your handling code here:
        if (cb2.isSelected()) {
            bpot2.setEnabled(true);
        } else {
            bpot2.setEnabled(false);
            nmpot2.setText("");
            jumpot2.setText("0");
            hitung1();
            hapusDetail_2();
        }
    }//GEN-LAST:event_cb2ActionPerformed

    private void hapusDetail_2() {
        try {
            sql = "Delete from detailgaji where id_potongan='" + idp2.getText() + "'";
            kon.st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void cb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb3ActionPerformed
        // TODO add your handling code here:
        if (cb3.isSelected()) {
            bpot3.setEnabled(true);
        } else {
            bpot3.setEnabled(false);
            nmpot3.setText("");
            jumpot3.setText("0");
            hitung1();
            hapusDetail_3();
        }
    }//GEN-LAST:event_cb3ActionPerformed

    private void hapusDetail_3() {
        try {
            sql = "Delete from detailgaji where id_potongan='" + idp3.getText() + "'";
            kon.st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void bpot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpot1ActionPerformed
        // TODO add your handling code here:
        boolean closable = true;
        dataPotongan dj = new dataPotongan(null, closable);
        dj.gg = this;
        dj.setVisible(true);
        dj.setResizable(true);
        idp1.setText(idpot1);
        nmpot1.setText(nm_pot1);
        jumpot1.setText(tot_pot1);
        hitung1();
        simpan1();
    }//GEN-LAST:event_bpot1ActionPerformed

    private void simpan1() {
        sql = "insert into detailgaji values ('"
                + no.getText()
                + "','" + idp1.getText()
                + "','" + jumpot1.getText()
                + "')";
        try {
            kon.st.executeUpdate(sql);

        } catch (SQLException e) {
        }
    }

    private void bpot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpot2ActionPerformed
        // TODO add your handling code here:
        boolean closable = true;
        dataPotongan dj = new dataPotongan(null, closable);
        dj.gg = this;
        dj.setVisible(true);
        dj.setResizable(true);
        idp2.setText(idpot2);
        nmpot2.setText(nm_pot2);
        jumpot2.setText(tot_pot2);
        hitung1();
        simpan2();
    }//GEN-LAST:event_bpot2ActionPerformed

    private void simpan2() {
        sql = "insert into detailgaji values ('"
                + no.getText()
                + "','" + idp2.getText()
                + "','" + jumpot2.getText()
                + "')";
        try {
            kon.st.executeUpdate(sql);

        } catch (SQLException e) {
        }
    }

    private void bpot3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpot3ActionPerformed
        // TODO add your handling code here:
        boolean closable = true;
        dataPotongan dj = new dataPotongan(null, closable);
        dj.gg = this;
        dj.setVisible(true);
        dj.setResizable(true);
        idp3.setText(idpot3);
        nmpot3.setText(nm_pot3);
        jumpot3.setText(tot_pot3);
        hitung1();
        simpan3();
    }//GEN-LAST:event_bpot3ActionPerformed

    private void simpan3() {
        sql = "insert into detailgaji values ('"
                + no.getText()
                + "','" + idp3.getText()
                + "','" + jumpot3.getText()
                + "')";
        try {
            kon.st.executeUpdate(sql);

        } catch (SQLException e) {
        }
    }

    private void jumpot1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumpot1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') && jumpot1.getText().length() < 11
                || (c == com.sun.glass.events.KeyEvent.VK_BACKSPACE)
                || (c == com.sun.glass.events.KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jumpot1KeyTyped

    private void jumpot2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumpot2KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') && jumpot2.getText().length() < 11
                || (c == com.sun.glass.events.KeyEvent.VK_BACKSPACE)
                || (c == com.sun.glass.events.KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jumpot2KeyTyped

    private void jumpot3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumpot3KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') && jumpot3.getText().length() < 11
                || (c == com.sun.glass.events.KeyEvent.VK_BACKSPACE)
                || (c == com.sun.glass.events.KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jumpot3KeyTyped

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        if (tambah.getText().equals("TAMBAH")) {
            aktif();
            nomor();
            tambah.setText("SIMPAN");
            tutup.setText("BATAL");
        } else if (tambah.getText().equals("SIMPAN")) {
            if (ida.getText().equals("") || idk.getText().equals("")
                    || tgaji.getText().equals("") || totpot.getText().equals("")
                    || terimagaji.getText().equals("") || no.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
                bersih();
                browse.grabFocus();
            } else if (totpot.getText().equals("0")) {
                simpan_Kosong();
                lanjut();
            } else {
                lanjut();
            }
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void simpan_Kosong() {
        sql = "insert into detailgaji values ('"
                + no.getText() + "', '1', '0' )";
        try {
            kon.st.executeUpdate(sql);

        } catch (SQLException e) {
        }
    }

    private void lanjut() {
        simpan();
        if (JOptionPane.showConfirmDialog(this, "Mau Cetak Struk?", "Konfirmasi",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            pilihan tg = new pilihan();
            tg.setVisible(true);
            tg.setLocationRelativeTo(null);
            tg.nos = no.getText();
            tg.off();
            bersih();
            nonaktif();
        } else {
            bersih();
            nonaktif();
        }
    }

    private void tutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutupActionPerformed
        // TODO add your handling code here:
        if (tutup.getText().equals("TUTUP")) {
            this.dispose();
        } else if (tutup.getText().equals("BATAL")) {
            tampil();
            bersih();
            nonaktif();
        }
    }//GEN-LAST:event_tutupActionPerformed

    private void tabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE
                || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            hapus();
            bersih();
            nonaktif();
        }
    }//GEN-LAST:event_tabelKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        iduser.setText(idu);
        tampil();
    }//GEN-LAST:event_formWindowActivated

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        pilihan tg = new pilihan();
        tg.setVisible(true);
        tg.setLocationRelativeTo(null);
        int row = tabel.getSelectedRow();
        tg.nos = (String) tabel.getValueAt(row, 0);
    }//GEN-LAST:event_tabelMouseClicked

    private void jumpot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumpot1ActionPerformed
        // TODO add your handling code here:
        hitung1();
        simpan1();
    }//GEN-LAST:event_jumpot1ActionPerformed

    private void jumpot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumpot2ActionPerformed
        // TODO add your handling code here:
        hitung1();
        simpan2();
    }//GEN-LAST:event_jumpot2ActionPerformed

    private void jumpot3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumpot3ActionPerformed
        // TODO add your handling code here:
        hitung1();
        simpan3();
    }//GEN-LAST:event_jumpot3ActionPerformed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int a, b;
        
        a = evt.getXOnScreen();
        b = evt.getYOnScreen();
        this.setLocation(a - x, b - y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void kar() {
        try {
            sql = "select nama, id_jabatan from karyawan where id_karyawan='"
                    + idk.getText() + "'";
            kon.rs = kon.st.executeQuery(sql);
            if (kon.rs.next()) {
                nmk.setText(kon.rs.getString("nama"));
                idj.setText(kon.rs.getString("id_jabatan"));
            }
        } catch (Exception e) {
        }
    }

    private void jab() {
        try {
            sql = "select * from jabatan where id_jabatan='" + idj.getText() + "'";
            kon.rs = kon.st.executeQuery(sql);
            if (kon.rs.next()) {
                nmj.setText(kon.rs.getString("nama"));
                gapok.setText(kon.rs.getString("gapok"));
                tjab.setText(kon.rs.getString("jab"));
                ttrans.setText(kon.rs.getString("transp"));
            }
        } catch (Exception e) {
        }
    }

    private void toga() {
        int gap, tjaba, ttranspor, totg;
        gap = Integer.parseInt(gapok.getText());
        tjaba = Integer.parseInt(tjab.getText());
        ttranspor = Integer.parseInt(ttrans.getText());
        totg = gap + tjaba + ttranspor;
        tgaji.setText(Integer.toString(totg));
    }

    private void hitung1() {
        int a = 0, b = 0, c = 0;
        a = Integer.parseInt(jumpot1.getText());
        b = Integer.parseInt(jumpot2.getText());
        c = Integer.parseInt(jumpot3.getText());
        int topot = a + b + c;
        totpot.setText(Integer.toString(topot));
        tg();
    }

    private void tg() {
        int tgaj, tpot, tergaji;
        tgaj = Integer.parseInt(tgaji.getText());
        tpot = Integer.parseInt(totpot.getText());
        tergaji = tgaj - tpot;
        terimagaji.setText(Integer.toString(tergaji));
    }

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
            java.util.logging.Logger.getLogger(gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gaji().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alfa;
    private javax.swing.JButton bpot1;
    private javax.swing.JButton bpot2;
    private javax.swing.JButton bpot3;
    private javax.swing.JButton browse;
    private javax.swing.JCheckBox cb1;
    private javax.swing.JCheckBox cb2;
    private javax.swing.JCheckBox cb3;
    private javax.swing.JTextField gapok;
    private javax.swing.JTextField ida;
    private javax.swing.JTextField idj;
    private javax.swing.JTextField idk;
    private javax.swing.JTextField idp1;
    private javax.swing.JTextField idp2;
    private javax.swing.JTextField idp3;
    private javax.swing.JTextField iduser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumpot1;
    private javax.swing.JTextField jumpot2;
    private javax.swing.JTextField jumpot3;
    private javax.swing.JTextField masuk;
    private javax.swing.JTextField nmj;
    private javax.swing.JTextField nmk;
    private javax.swing.JTextField nmpot1;
    private javax.swing.JTextField nmpot2;
    private javax.swing.JTextField nmpot3;
    private javax.swing.JTextField no;
    private javax.swing.JTextField sakit;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField terimagaji;
    private javax.swing.JTextField tgaji;
    private javax.swing.JTextField tgl;
    private javax.swing.JTextField tjab;
    private javax.swing.JTextField totpot;
    private javax.swing.JTextField ttrans;
    private javax.swing.JButton tutup;
    // End of variables declaration//GEN-END:variables
}
