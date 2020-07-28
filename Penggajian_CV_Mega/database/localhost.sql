-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Waktu pembuatan: 13. Agustus 2018 jam 17:20
-- Versi Server: 5.5.16
-- Versi PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `penggajian_cv_mega`
--
CREATE DATABASE `penggajian_cv_mega` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `penggajian_cv_mega`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `absen`
--

CREATE TABLE IF NOT EXISTS `absen` (
  `id_absen` varchar(9) NOT NULL,
  `tgl` varchar(30) NOT NULL,
  `masuk` int(2) NOT NULL,
  `sakit` int(2) NOT NULL,
  `alfa` int(2) NOT NULL,
  `id_karyawan` varchar(7) NOT NULL,
  PRIMARY KEY (`id_absen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `absen`
--

INSERT INTO `absen` (`id_absen`, `tgl`, `masuk`, `sakit`, `alfa`, `id_karyawan`) VALUES
('180811001', '23 Agustus 2018', 26, 0, 0, '1808001'),
('180811002', '23 Agustus 2018', 26, 0, 0, '1808002'),
('180811003', '23 Agustus 2018', 25, 1, 0, '1808003'),
('180811004', '23 Agustus 2018', 26, 0, 0, '1808004'),
('180811005', '23 Agustus 2018', 26, 0, 0, '1808005');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detailgaji`
--

CREATE TABLE IF NOT EXISTS `detailgaji` (
  `no_slip` varchar(9) NOT NULL,
  `id_potongan` varchar(7) NOT NULL,
  `jumpot` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `detailgaji`
--

INSERT INTO `detailgaji` (`no_slip`, `id_potongan`, `jumpot`) VALUES
('180811001', '2018001', 60000),
('180811001', '2018002', 95000),
('180811002', '2018001', 60000),
('180811002', '2018002', 95000),
('180811003', '2018001', 60000),
('180811003', '2018003', 52000),
('180811003', '2018002', 95000),
('180811004', '2018001', 60000),
('180811004', '2018003', 52000),
('180811005', '2018001', 60000),
('180811005', '2018003', 52000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `gaji`
--

CREATE TABLE IF NOT EXISTS `gaji` (
  `no_slip` varchar(9) NOT NULL,
  `tgl` varchar(30) DEFAULT NULL,
  `id_absen` varchar(9) DEFAULT NULL,
  `tot_gaj` int(8) DEFAULT NULL,
  `tot_pot` int(8) DEFAULT NULL,
  `terimagaji` int(8) DEFAULT NULL,
  `id_user` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`no_slip`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `gaji`
--

INSERT INTO `gaji` (`no_slip`, `tgl`, `id_absen`, `tot_gaj`, `tot_pot`, `terimagaji`, `id_user`) VALUES
('180811001', '2018-08-11', '180811001', 11600000, 155000, 11445000, '002'),
('180811002', '2018-08-11', '180811002', 11600000, 155000, 11445000, '002'),
('180811003', '2018-08-11', '180811003', 7750000, 155000, 7595000, '002'),
('180811004', '2018-08-11', '180811004', 4950000, 112000, 4838000, '002'),
('180811005', '2018-08-11', '180811005', 3590000, 112000, 3478000, '002');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jabatan`
--

CREATE TABLE IF NOT EXISTS `jabatan` (
  `id_jabatan` varchar(3) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `gapok` int(8) DEFAULT NULL,
  `jab` int(8) DEFAULT NULL,
  `transp` int(8) DEFAULT NULL,
  PRIMARY KEY (`id_jabatan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jabatan`
--

INSERT INTO `jabatan` (`id_jabatan`, `nama`, `gapok`, `jab`, `transp`) VALUES
('001', 'Pemilik', 7000000, 2000000, 100000),
('002', 'Kepala Toko', 5000000, 1500000, 50000),
('003', 'Admin', 3800000, 500000, 25000),
('004', 'Pelayan', 3000000, 200000, 15000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE IF NOT EXISTS `karyawan` (
  `id_karyawan` varchar(7) NOT NULL,
  `nama` varchar(40) DEFAULT NULL,
  `ttlahir` varchar(50) DEFAULT NULL,
  `jkelamin` varchar(10) DEFAULT NULL,
  `agama` varchar(10) DEFAULT NULL,
  `telepon` varchar(13) DEFAULT NULL,
  `status` varchar(12) DEFAULT NULL,
  `pendidikan` varchar(12) NOT NULL,
  `rek` varchar(12) NOT NULL,
  `norek` varchar(13) NOT NULL,
  `alamat` text,
  `tgl_gabung` varchar(20) DEFAULT NULL,
  `id_jabatan` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id_karyawan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama`, `ttlahir`, `jkelamin`, `agama`, `telepon`, `status`, `pendidikan`, `rek`, `norek`, `alamat`, `tgl_gabung`, `id_jabatan`) VALUES
('1808001', 'Santo Rusli', 'Karawang, 24 Januari 1967', 'Laki-Laki', 'Islam', '082218888115', 'Kawin', 'S1 Ekonomi', 'BCA ', '5220304312', 'JL. Tuparev No. 313 B RT:003/RW 021 Kel. Nagasari Kec. KArawang BArat Kab. Karawang', '2005-02-11', '001'),
('1808002', 'Wina ', 'Medan, 26 Juni 1973', 'Perempuan', 'Katolik', '082218888115', 'Kawin', 'S1 Ekonomi', 'BCA', '8610197095', 'Jl. Tuparev No 313 B RT: 003/ RW: 021 Kel. Nagasari Kec. Karawang Barat Kab. Karawang\n', '2005-02-11', '001'),
('1808003', 'Wanto', 'Karawang, 23 Agustus 1982', 'Laki-Laki', 'Islam', '0821828282728', 'Kawin', 'S1 Menejemen', 'BCA', '5600188552', 'Perumahan Griya Mas Lestaru', '2010-07-11', '002'),
('1808004', 'Billy ', 'Karawang, 01 Januari 1989', 'Laki-Laki', 'Islam', '0897172727277', 'Kawin', 'D3 Akuntansi', 'BCA', '5672892816', 'Perum Pepabri', '2012-07-19', '003'),
('1808005', 'Caca Hermansyah', 'Cirebon, 09 Oktober 1992', 'Laki-Laki', 'Islam', '0897829292711', 'Kawin', 'SMA', 'BCA', '1192839039', 'Perumahan Adiarsa Barat', '2012-07-25', '004');

-- --------------------------------------------------------

--
-- Struktur dari tabel `potongan`
--

CREATE TABLE IF NOT EXISTS `potongan` (
  `id_potongan` varchar(7) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `jumlah` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `potongan`
--

INSERT INTO `potongan` (`id_potongan`, `nama`, `jumlah`) VALUES
('2018001', 'BPJS Ketenagakerjaan', 60000),
('2018002', 'BPJS Kesehatan Kelas I', 95000),
('2018003', 'BPJS Kesehatan Kelas II', 52000),
('2018004', 'BPJS Kesehatan Kelas III', 35000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` varchar(3) NOT NULL,
  `nm_user` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `level` varchar(15) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `nm_user`, `password`, `level`) VALUES
('001', 'Admin', '11111', 'Admin'),
('002', 'Ali Farhan', '22222', 'Administrator');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
