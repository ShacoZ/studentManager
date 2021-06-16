-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2021 年 06 月 11 日 09:16
-- 服务器版本: 5.6.12-log
-- PHP 版本: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `lyd`
--
CREATE DATABASE IF NOT EXISTS `lyd` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `lyd`;

-- --------------------------------------------------------

--
-- 表的结构 `stu`
--

CREATE TABLE IF NOT EXISTS `stu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `sex` varchar(40) NOT NULL,
  `age` varchar(40) NOT NULL,
  `t_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `t_id` (`t_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

--
-- 转存表中的数据 `stu`
--

INSERT INTO `stu` (`id`, `name`, `sex`, `age`, `t_id`) VALUES
(1, '孔沈然', '女', '18', 1),
(2, '孔沈然', '女', '18', 1),
(3, '胡白秋', '女', '18', 1),
(4, '王莺韵', '女', '18', 1),
(5, '程慧心', '女', '18', 1),
(6, '顾语蓉', '女', '18', 1);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

--
-- 限制导出的表
--

--
-- 限制表 `stu`
--
ALTER TABLE `stu`
  ADD CONSTRAINT `stu_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
