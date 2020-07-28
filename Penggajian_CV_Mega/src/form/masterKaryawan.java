/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class masterKaryawan extends javax.swing.JFrame {

    koneksi kon = new koneksi();

    /**
     * Creates new form masterKaryawan
     */
    public masterKaryawan() {
        initComponents();
        kon.setKoneksi();
        tampil();
        nonaktif();
    }

    String idj;
    String nmj;
    public java.util.Date date = new java.util.Date();
    public SimpleDateFormat noformat = new SimpleDateFormat("yyMM");

    public String getIdj() {
        return idj;
    }

    public String getNmj() {
        return nmj;
    }

    private void tampil() {
        Object header[] = {"ID Karyawan", "Nama Lengkap", "TTL", "Kelamin", "Agama",
            "Kontak", "Status", "Pendidikan", "Rekening", "No. Rekening", "Alamat", "Tanggal Gabung",
            "ID Jabatan"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        tabel.setModel(data);

        kon.setKoneksi();
        String sql = "select * from karyawan";
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
                String kolom8 = rs.getString(8);
                String kolom9 = rs.getString(9);
                String kolom10 = rs.getString(10);
                String kolom11 = rs.getString(11);
                String kolom12 = rs.getString(12);
                String kolom13 = rs.getString(13);

                String kolom[] = {kolom1, kolom2, kolom3, kolom4, kolom5,
                    kolom6, kolom7, kolom8, kolom9, kolom10, kolom11, kolom12, kolom13};
                data.addRow(kolom);
            }
        } catch (SQLException e) {
        }
    }

    private void simpan() {
        String tgl = new SimpleDateFormat("yyyy-MM-dd").format(gabung.getDate());
        String jk;
        if (lk.isSelected()) {
            jk = "Laki-Laki";
        } else {
            jk = "Perempuan";
        }
        String jkl = jk;

        String s;
        if (kawin.isSelected()) {
            s = "Kawin";
        } else {
            s = "Belum Kawin";
        }
        String status = s;

        String sql = "insert into karyawan values ('"
                + id.getText()
                + "','" + nama.getText()
                + "','" + ttl.getText()
                + "','" + jkl
                + "','" + agama.getSelectedItem()
                + "','" + telepon.getText()
                + "','" + status
                + "','" + pendidikan.getText()
                + "','" + rek.getText()
                + "','" + norek.getText()
                + "','" + alamat.getText()
                + "','" + tgl
                + "','" + id_jab.getText()
                + "')";
        try {
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            tampil();
        } catch (SQLException e) {
        }
    }

    private void ubah() {
        try {
            kon.setKoneksi();
            String tgl = new SimpleDateFormat("yyyy-MM-dd").format(gabung.getDate());
            String jk;
            if (lk.isSelected()) {
                jk = "Laki-Laki";
            } else {
                jk = "Perempuan";
            }
            String jkl = jk;

            String s;
            if (kawin.isSelected()) {
                s = "Kawin";
            } else {
                s = "Belum Kawin";
            }
            String status = s;
            String sqli = "update karyawan set id_karyawan='" + id.getText()
                    + "',nama='" + nama.getText()
                    + "',ttlahir='" + ttl.getText()
                    + "',jkelamin='" + jkl
                    + "',agama='" + agama.getSelectedItem()
                    + "',telepon='" + telepon.getText()
                    + "',status='" + status
                    + "',pendidikan='" + pendidikan.getText()
                    + "',rek='" + rek.getText()
                    + "',norek='" + norek.getText()
                    + "',alamat='" + alamat.getText()
                    + "',tgl_gabung='" + tgl
                    + "',id_jabatan='" + id_jab.getText()
                    + "' where id_karyawan='" + id.getText() + "'";
            kon.st.executeUpdate(sqli);
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
            tampil();
            n.setVisible(true);
            nama_jabatan.setVisible(true);
        } catch (SQLException e) {
            System.out.println("Mungkin Syntaks sql error" + e.toString());
        }
    }

    private void hapus() {
        String sql = "delete from karyawan where id_karyawan='" + id.getText() + "'";
        try {
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            tampil();
            n.setVisible(true);
            nama_jabatan.setVisible(true);
        } catch (SQLException e) {
        }
    }

    private void bersih() {
        nama.setText("");
        ttl.setText("");
        telepon.setText("");
        pendidikan.setText("");
        rek.setText("");
        norek.setText("");
        alamat.setText("");
        id_jab.setText("");
        nama_jabatan.setText("");
        tcari.setText("");
    }

    private void aktif() {
        id.setEnabled(true);
        nama.setEnabled(true);
        tcari.setEnabled(true);
        cari.setEnabled(true);
        telepon.setEnabled(true);

        ttl.setEnabled(true);
        lk.setEnabled(true);
        pr.setEnabled(true);
        agama.setEnabled(true);
        alamat.setEnabled(true);
        browse.setEnabled(true);
        pendidikan.setEnabled(true);
        rek.setEnabled(true);
        norek.setEnabled(true);
        gabung.setEnabled(true);
        kawin.setEnabled(true);
        belum.setEnabled(true);

    }

    private void nonaktif() {
        id.setEnabled(false);
        nama.setEnabled(false);
        telepon.setEnabled(false);
        tcari.setText("");
        ubah.setEnabled(false);
        hapus.setEnabled(false);

        ttl.setEnabled(false);
        lk.setEnabled(false);
        pr.setEnabled(false);
        agama.setEnabled(false);
        alamat.setEnabled(false);
        browse.setEnabled(false);
        pendidikan.setEnabled(false);
        rek.setEnabled(false);
        norek.setEnabled(false);
        gabung.setEnabled(false);
        kawin.setEnabled(false);
        belum.setEnabled(false);

        tambah.setText("TAMBAH");
        tambah.setEnabled(true);
        tutup.setEnabled(true);
        tutup.setText("TUTUP");
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
        id = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        telepon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tambah = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        tutup = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        ttl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lk = new javax.swing.JRadioButton();
        pr = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        agama = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        kawin = new javax.swing.JRadioButton();
        belum = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        id_jab = new javax.swing.JTextField();
        browse = new javax.swing.JButton();
        n = new javax.swing.JLabel();
        nama_jabatan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        pendidikan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        gabung = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        rek = new javax.swing.JTextField();
        norek = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "FORM KARYAWAN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(740, 450));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ID KARYAWAN");

        id.setEditable(false);
        id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idKeyPressed(evt);
            }
        });

        nama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namaKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("NAMA LENGKAP");

        telepon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        telepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                teleponKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                teleponKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NO. TELEPON");

        tambah.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tambah.setText("TAMBAH");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        ubah.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ubah.setText("UBAH");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        tutup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tutup.setText("TUTUP");
        tutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutupActionPerformed(evt);
            }
        });

        jLabel4.setText("CARI ID");

        tcari.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });
        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tcariKeyTyped(evt);
            }
        });

        cari.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cari.setText("CARI");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tambah)
                .addGap(18, 18, 18)
                .addComponent(ubah)
                .addGap(18, 18, 18)
                .addComponent(hapus)
                .addGap(18, 18, 18)
                .addComponent(tutup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cari)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(ubah)
                    .addComponent(hapus)
                    .addComponent(tutup)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jScrollPane1.setViewportView(tabel);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("TEMPAT, TANGGAL LAHIR");

        ttl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ttl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ttlKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("JENIS KELAMIN");

        lk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lk.setText("LAKI-LAKI");
        lk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lkActionPerformed(evt);
            }
        });

        pr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pr.setText("PEREMPUAN");
        pr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("AGAMA");

        agama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        agama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Islam", "Katolik", "Protestan", "Hindu", "Buddha", "Konghucu" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("STATUS");

        kawin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kawin.setText("KAWIN");
        kawin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kawinActionPerformed(evt);
            }
        });

        belum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        belum.setText("BELUM KAWIN");
        belum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                belumActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("ID JABATAN");

        id_jab.setEditable(false);
        id_jab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        id_jab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_jabKeyPressed(evt);
            }
        });

        browse.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        browse.setText("...");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        n.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        n.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        n.setText("PENDIDIKAN");

        nama_jabatan.setEditable(false);
        nama_jabatan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nama_jabatan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nama_jabatanKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("REKENING");

        pendidikan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pendidikan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pendidikanKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("TANGGAL GABUNG");

        gabung.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("ALAMAT");

        alamat.setColumns(20);
        alamat.setRows(3);
        alamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                alamatKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(alamat);

        rek.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rek.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rekKeyPressed(evt);
            }
        });

        norek.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        norek.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                norekKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("NO. REKENING");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ttl)
                                    .addComponent(nama)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lk)
                                        .addGap(48, 48, 48)
                                        .addComponent(pr))
                                    .addComponent(agama, 0, 280, Short.MAX_VALUE)
                                    .addComponent(telepon)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(kawin)
                                        .addGap(55, 55, 55)
                                        .addComponent(belum)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(18, 18, 18)
                                            .addComponent(gabung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jScrollPane2))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(48, 48, 48)
                                            .addComponent(id_jab, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(nama_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(browse))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(36, 36, 36)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(norek)
                                                .addComponent(rek)
                                                .addComponent(pendidikan)))))))
                        .addGap(14, 14, 14))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rek, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ttl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(norek, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(gabung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lk)
                            .addComponent(pr))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kawin)
                            .addComponent(belum)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_jab, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(browse))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            nama.requestFocus();
        }
    }//GEN-LAST:event_idKeyPressed

    private void teleponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teleponKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') && telepon.getText().length() < 13
                || (c == com.sun.glass.events.KeyEvent.VK_BACKSPACE)
                || (c == com.sun.glass.events.KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_teleponKeyTyped

    private void namaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ttl.requestFocus();
        }
    }//GEN-LAST:event_namaKeyPressed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        try {
            kon.setKoneksi();
            String sql = "select * from karyawan where id_karyawan='"
                    + tcari.getText() + "'";
            ResultSet rss = kon.st.executeQuery(sql);
            if (rss.next()) {
                JOptionPane.showMessageDialog(null,
                        "Silahkan Ubah atau Hapus Data yang Telah di Cari");
                ubah.setEnabled(true);
                hapus.setEnabled(true);
                tambah.setEnabled(false);
                tutup.setEnabled(true);
                tutup.setText("BATAL");
                aktif();
                tambah.setEnabled(false);
                String sqli = "select * from karyawan where id_karyawan='"
                        + tcari.getText() + "'";
                ResultSet rs = kon.st.executeQuery(sqli);
                while (rs.next()) {
                    String kolom1 = rs.getString(1);
                    String kolom2 = rs.getString(2);
                    String kolom3 = rs.getString(3);
                    String kolom4 = rs.getString(4);
                    String kolom5 = rs.getString(5);
                    String kolom6 = rs.getString(6);
                    String kolom7 = rs.getString(7);
                    String kolom8 = rs.getString(8);
                    String kolom9 = rs.getString(9);
                    String kolom10 = rs.getString(10);
                    String kolom11 = rs.getString(11);
                    String kolom13 = rs.getString(13);

                    id.setText(kolom1);
                    nama.setText(kolom2);
                    ttl.setText(kolom3);
                    if (kolom4.equalsIgnoreCase("Laki-Laki")) {
                        lk.setSelected(true);
                        pr.setSelected(false);
                    } else {
                        pr.setSelected(true);
                        lk.setSelected(false);
                    }
                    agama.setSelectedItem(kolom5);
                    telepon.setText(kolom6);
                    if (kolom7.equalsIgnoreCase("Kawin")) {
                        kawin.setSelected(true);
                        belum.setSelected(false);
                    } else {
                        belum.setSelected(true);
                        kawin.setSelected(false);
                    }
                    pendidikan.setText(kolom8);
                    rek.setText(kolom9);
                    norek.setText(kolom10);
                    alamat.setText(kolom11);
                    gabung.setDate(rs.getDate("tgl_gabung"));
                    id_jab.setText(kolom13);
                    jab();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak Tersedia !!");

            }
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_cariActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        if (tambah.getText().equals("TAMBAH")) {
            aktif();
            try {
                kon.setKoneksi();
                String sql = "select right(id_karyawan,3)+1 from karyawan";
                ResultSet rs = kon.st.executeQuery(sql);

                if (rs.next()) {
                    rs.last();
                    String no = rs.getString(1);
                    while (no.length() < 3) {
                        no = "0" + no;
                        id.setText(noformat.format(date) + no);
                    }
                } else {
                    id.setText(noformat.format(date) + "001");
                }
            } catch (SQLException e) {
            }
            tambah.setText("SIMPAN");
            tutup.setText("BATAL");
        } else if (tambah.getText().equals("SIMPAN")) {
            if (id.getText().equals("") || nama.getText().equals("")
                    || telepon.getText().equals("") || ttl.getText().equals("")
                    || alamat.getText().equals("") || id_jab.getText().equals("")
                    || pendidikan.getText().equals("") || rek.getText().equals("")
                    || norek.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
                bersih();
                nama.requestFocus();
            } else {
                simpan();
                bersih();
                nonaktif();
            }
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        if (id.getText().equals("") || nama.getText().equals("")
                || telepon.getText().equals("") || ttl.getText().equals("")
                || alamat.getText().equals("") || id_jab.getText().equals("")
                || pendidikan.getText().equals("") || rek.getText().equals("")
                || norek.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            bersih();
            nonaktif();
            nama.requestFocus();
        } else {
            ubah();
            bersih();
            nonaktif();
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        if (id.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data ID Karywan tidak boleh kosong");
            bersih();
            nonaktif();
            nama.requestFocus();
        } else {
            hapus();
            bersih();
            nonaktif();
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void tutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutupActionPerformed
        // TODO add your handling code here:
        if (tutup.getText().equals("TUTUP")) {
            this.dispose();
        } else if (tutup.getText().equals("BATAL")) {
            n.setVisible(true);
            nama_jabatan.setVisible(true);
            tampil();
            bersih();
            nonaktif();
        }
    }//GEN-LAST:event_tutupActionPerformed

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed
        // TODO add your handling code here:
        cari.grabFocus();
    }//GEN-LAST:event_tcariActionPerformed

    private void tcariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyTyped
        // TODO add your handling code here:
        evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }//GEN-LAST:event_tcariKeyTyped

    private void ttlKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttlKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            lk.requestFocus();
        }
    }//GEN-LAST:event_ttlKeyPressed

    private void lkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lkActionPerformed
        // TODO add your handling code here:
        if (lk.isSelected()) {
            pr.setSelected(false);
        }
    }//GEN-LAST:event_lkActionPerformed

    private void prActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prActionPerformed
        // TODO add your handling code here:
        if (pr.isSelected()) {
            lk.setSelected(false);
        }
    }//GEN-LAST:event_prActionPerformed

    private void kawinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kawinActionPerformed
        // TODO add your handling code here:
        if (kawin.isSelected()) {
            belum.setSelected(false);
        }
    }//GEN-LAST:event_kawinActionPerformed

    private void belumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_belumActionPerformed
        // TODO add your handling code here:
        if (belum.isSelected()) {
            kawin.setSelected(false);
        }
    }//GEN-LAST:event_belumActionPerformed

    private void id_jabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_jabKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_jabKeyPressed

    private void nama_jabatanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nama_jabatanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_jabatanKeyPressed

    private void pendidikanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pendidikanKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            rek.requestFocus();
        }
    }//GEN-LAST:event_pendidikanKeyPressed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        // TODO add your handling code here:
        boolean closable = true;
        dataJabatan dj = new dataJabatan(null, closable);
        dj.mk = this;
        dj.setVisible(true);
        dj.setResizable(true);
        id_jab.setText(idj);
        nama_jabatan.setText(nmj);
    }//GEN-LAST:event_browseActionPerformed

    private void teleponKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teleponKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            alamat.requestFocus();
        }
    }//GEN-LAST:event_teleponKeyPressed

    private void alamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alamatKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            browse.grabFocus();
        }
    }//GEN-LAST:event_alamatKeyPressed

    private void rekKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rekKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            norek.requestFocus();
        }
    }//GEN-LAST:event_rekKeyPressed

    private void norekKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_norekKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            gabung.grabFocus();
        }
    }//GEN-LAST:event_norekKeyPressed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        int row = tabel.getSelectedRow();
        tcari.setText((String) tabel.getValueAt(row, 0));
    }//GEN-LAST:event_tabelMouseClicked
    int x, y;
    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int a, b;

        a = evt.getXOnScreen();
        b = evt.getYOnScreen();
        this.setLocation(a - x, b - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

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
            java.util.logging.Logger.getLogger(masterKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(masterKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(masterKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(masterKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new masterKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> agama;
    private javax.swing.JTextArea alamat;
    private javax.swing.JRadioButton belum;
    private javax.swing.JButton browse;
    private javax.swing.JButton cari;
    private com.toedter.calendar.JDateChooser gabung;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField id;
    private javax.swing.JTextField id_jab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton kawin;
    private javax.swing.JRadioButton lk;
    private javax.swing.JLabel n;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nama_jabatan;
    private javax.swing.JTextField norek;
    private javax.swing.JTextField pendidikan;
    private javax.swing.JRadioButton pr;
    private javax.swing.JTextField rek;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField telepon;
    private javax.swing.JTextField ttl;
    private javax.swing.JButton tutup;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables

    private void jab() {
        try {
            String jab = "select id_jabatan, nama from jabatan where id_jabatan='" + id_jab.getText() + "'";
            kon.rs = kon.st.executeQuery(jab);
            if (kon.rs.next()) {
                nama_jabatan.setText(kon.rs.getString("nama"));
            }
        } catch (Exception e) {

        }
    }

}
