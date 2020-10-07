-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 28 May 2020, 21:55:08
-- Sunucu sürümü: 10.1.34-MariaDB
-- PHP Sürümü: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `netflix`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `evaluation`
--

CREATE TABLE `evaluation` (
  `id` int(11) NOT NULL,
  `value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `evaluation`
--

INSERT INTO `evaluation` (`id`, `value`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kind`
--

CREATE TABLE `kind` (
  `id` int(11) NOT NULL,
  `name` varchar(60) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `kind`
--

INSERT INTO `kind` (`id`, `name`) VALUES
(1, 'thriller'),
(2, 'comedy'),
(3, 'romantic'),
(4, 'fantastic'),
(5, 'action'),
(6, 'sci-fi'),
(7, 'horror'),
(8, 'history'),
(9, 'crime'),
(10, 'drama'),
(11, 'tragedy');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `program`
--

CREATE TABLE `program` (
  `id` int(11) NOT NULL,
  `name` varchar(60) COLLATE utf8_turkish_ci NOT NULL,
  `typeID` int(11) NOT NULL,
  `episode_count` int(11) NOT NULL,
  `episode_time` int(11) NOT NULL,
  `score` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `program`
--

INSERT INTO `program` (`id`, `name`, `typeID`, `episode_count`, `episode_time`, `score`) VALUES
(1, 'Game Of Thrones', 1, 60, 45, 9.2),
(2, 'The Walking Dead', 1, 100, 50, 9.1),
(3, 'Cinayet Süsü', 2, 1, 117, 10),
(4, 'Ölümlü Dünya', 2, 1, 110, 10),
(5, 'Lucifer', 1, 67, 45, 8.5),
(6, 'Peaky Blinders', 1, 30, 50, 8),
(7, 'Breaking Bad', 1, 62, 50, 7);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `program_kind`
--

CREATE TABLE `program_kind` (
  `id` int(11) NOT NULL,
  `programID` int(11) DEFAULT NULL,
  `kindID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `program_kind`
--

INSERT INTO `program_kind` (`id`, `programID`, `kindID`) VALUES
(1, 1, 4),
(2, 1, 11),
(3, 2, 7),
(4, 2, 1),
(5, 2, 10),
(6, 2, 6),
(7, 3, 2),
(8, 3, 9),
(9, 4, 2),
(10, 4, 5),
(11, 5, 2),
(12, 5, 10),
(13, 6, 10),
(14, 6, 9),
(15, 6, 8),
(16, 7, 10),
(17, 7, 9),
(18, 7, 5);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `type`
--

CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `name` varchar(60) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `type`
--

INSERT INTO `type` (`id`, `name`) VALUES
(1, 'series'),
(2, 'movie');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(60) COLLATE utf8_turkish_ci NOT NULL,
  `email` varchar(60) COLLATE utf8_turkish_ci NOT NULL,
  `password` varchar(60) COLLATE utf8_turkish_ci NOT NULL,
  `date` varchar(60) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`id`, `username`, `email`, `password`, `date`) VALUES
(1, 'oky', 'oky@oky.com', '123456', '20.09.1995'),
(2, 'burcu', 'burcu@burcu.com', '654321', '06.01.1996'),
(3, 'enesoguz', 'enes@enes.com', '1234123', '16.12.94'),
(4, 'semih', 'semih@semih.com', '123456', '01.07.2002'),
(5, 'burhan', 'burhan@burhan.com', '123456', '17.10.1976'),
(6, 'enesoguz', 'oguz@oguz.com', '123456', '21.12.1994'),
(7, 'yektaanilcicek', 'yekta@anil.com', '123456', '28.10.1996'),
(8, 'gulsah', 'gulsah@kacan.com', '123456', '21.01.1997'),
(9, 'senanureliguzel', 'senanur@eliguzel.com', '123456', '17.05.1996');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user_program`
--

CREATE TABLE `user_program` (
  `id` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `programID` int(11) DEFAULT NULL,
  `w_date` varchar(60) COLLATE utf8_turkish_ci NOT NULL,
  `w_time` int(11) NOT NULL,
  `w_episode` int(11) NOT NULL,
  `evaluationID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `evaluation`
--
ALTER TABLE `evaluation`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `kind`
--
ALTER TABLE `kind`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `program`
--
ALTER TABLE `program`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `program_kind`
--
ALTER TABLE `program_kind`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `user_program`
--
ALTER TABLE `user_program`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `evaluation`
--
ALTER TABLE `evaluation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Tablo için AUTO_INCREMENT değeri `kind`
--
ALTER TABLE `kind`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Tablo için AUTO_INCREMENT değeri `program`
--
ALTER TABLE `program`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `program_kind`
--
ALTER TABLE `program_kind`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Tablo için AUTO_INCREMENT değeri `type`
--
ALTER TABLE `type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `user_program`
--
ALTER TABLE `user_program`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
