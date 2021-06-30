-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.21 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------


-- 导出 hospital 的数据库结构
CREATE DATABASE IF NOT EXISTS `hospital` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hospital`;

-- 导出  表 hospital.admin 结构
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '取药编号',
  `username` char(20) NOT NULL COMMENT '管理员用户名',
  `password` char(20) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员信息表';

-- 正在导出表  hospital.admin 的数据：~2 rows (大约)
INSERT INTO `admin` (`id`, `username`, `password`) VALUES
	(1, 'admin1', '123123'),
	(2, 'admin2', '000000');


-- 导出  表 hospital.department 结构
CREATE TABLE IF NOT EXISTS `department` (
  `Department_id` int NOT NULL AUTO_INCREMENT COMMENT '科室编号',
  `Department_name` char(100) NOT NULL COMMENT '科室名称',
  `Department_Phone` char(20) DEFAULT NULL COMMENT '科室电话',
  PRIMARY KEY (`Department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='科室信息表';

-- 正在导出表  hospital.department 的数据：~6 rows (大约)
INSERT INTO `department` (`Department_id`, `Department_name`, `Department_Phone`) VALUES
	(1, '内科', '13663894233'),
	(2, '外科', '15288347293'),
	(3, '妇产科', '13294372304'),
	(4, '耳鼻喉科', '13698472397'),
	(5, '眼科', '18978497347'),
	(6, '儿科', '15934984328');


-- 导出  表 hospital.doctor 结构
CREATE TABLE IF NOT EXISTS `doctor` (
  `Doctor_id` int NOT NULL AUTO_INCREMENT COMMENT '医生编号',
  `Doctor_name` char(20) NOT NULL COMMENT '医生姓名',
  `Doctor_age` int NOT NULL COMMENT '医生年龄',
  `Doctor_sex` char(20) NOT NULL COMMENT '医生性别',
  `Doctor_title` char(20) DEFAULT NULL COMMENT '医生职称',
  `Doctor_speciality` char(100) DEFAULT NULL COMMENT '医生专长',
  `Department_id` int NOT NULL COMMENT '科室编号',
  `username` char(20) DEFAULT NULL COMMENT '医生用户名',
  `password` char(20) DEFAULT NULL COMMENT '医生密码',
  PRIMARY KEY (`Doctor_id`),
  KEY `Department_id` (`Department_id`),
  CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`Department_id`) REFERENCES `department` (`Department_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `doctor_chk_1` CHECK (((`Doctor_age` > 0) and (`Doctor_age` < 70)))
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='医生信息表';

-- 正在导出表  hospital.doctor 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` (`Doctor_id`, `Doctor_name`, `Doctor_age`, `Doctor_sex`, `Doctor_title`, `Doctor_speciality`, `Department_id`, `username`, `password`) VALUES
	(1, '徐宝双', 48, '男', '主任医师', '神经及心血管疾病', 1, 'baoshuang', '123123'),
	(2, '张成', 45, '男', '副主任医师', '外科及骨科疾病', 2, 'chengcheng', '123123'),
	(3, '刘丽娟', 50, '女', '主任医师', '妇产科疾病及妇女保健', 3, 'lijuan', '123123'),
	(4, '闫玉红', 50, '女', '主任医师', '鼻炎、咽炎、中耳炎等耳鼻喉疾病', 4, 'yuhong', '123123'),
	(5, '孙海霞', 46, '女', '副主任医师', '眼科疾病', 5, 'haixia', '123123'),
	(6, '赵晨', 39, '男', '医师', '儿科疾病与儿童护理', 6, 'chenge', '123123');


-- 导出  表 hospital.doctor_state 结构
CREATE TABLE IF NOT EXISTS `doctor_state` (
  `Doctor_state_id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Doctor_id` int NOT NULL COMMENT '医生编号',
  `Date` date NOT NULL COMMENT '日期',
  `Fee` float NOT NULL COMMENT '挂号费用',
  `Num` int NOT NULL DEFAULT '20' COMMENT '剩余号码数量',
  PRIMARY KEY (`Doctor_state_id`),
  KEY `Doctor_id` (`Doctor_id`),
  CONSTRAINT `doctor_state_ibfk_1` FOREIGN KEY (`Doctor_id`) REFERENCES `doctor` (`Doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='医生挂号日期状态表';

-- 正在导出表  hospital.doctor_state 的数据：~31 rows (大约)

INSERT INTO `doctor_state` (`Doctor_state_id`, `Doctor_id`, `Date`, `Fee`, `Num`) VALUES
	(2, 3, '2021-06-08', 40, 8),
	(3, 4, '2021-06-08', 40, 20),
	(4, 5, '2021-06-08', 20, 20),
	(5, 6, '2021-06-08', 10, 20),
	(6, 1, '2021-06-08', 40, 9),
	(7, 2, '2021-06-08', 20, 20),
	(8, 1, '2021-06-09', 40, 20),
	(9, 2, '2021-06-09', 20, 20),
	(10, 3, '2021-06-09', 40, 20),
	(11, 4, '2021-06-09', 40, 20),
	(12, 5, '2021-06-09', 20, 20),
	(13, 6, '2021-06-09', 10, 20),
	(14, 1, '2021-06-10', 40, 30),
	(15, 2, '2021-06-10', 20, 20),
	(16, 3, '2021-06-10', 40, 20),
	(17, 4, '2021-06-10', 40, 20),
	(18, 5, '2021-06-10', 20, 20),
	(19, 6, '2021-06-10', 10, 20),
	(20, 1, '2021-06-11', 40, 20),
	(21, 2, '2021-06-11', 20, 20),
	(22, 3, '2021-06-11', 40, 19),
	(23, 4, '2021-06-11', 40, 20),
	(24, 5, '2021-06-11', 20, 20),
	(25, 6, '2021-06-11', 10, 20),
	(26, 1, '2021-06-12', 40, 20),
	(27, 2, '2021-06-12', 20, 20),
	(28, 3, '2021-06-12', 40, 20),
	(29, 4, '2021-06-12', 40, 20),
	(30, 5, '2021-06-12', 20, 20),
	(31, 6, '2021-06-12', 10, 20),
	(32, 1, '2021-06-13', 40, 20);


-- 导出  表 hospital.drug 结构
CREATE TABLE IF NOT EXISTS `drug` (
  `Drug_id` int NOT NULL AUTO_INCREMENT COMMENT '药品编号',
  `Drug_name` char(100) NOT NULL COMMENT '药品名称',
  `Drug_lotnumber` char(20) NOT NULL COMMENT '药品批号',
  `Drug_indication` char(200) NOT NULL COMMENT '药品主治',
  `Drug_price` float NOT NULL COMMENT '药品单价',
  PRIMARY KEY (`Drug_id`),
  KEY `Drug_price` (`Drug_price`),
  CONSTRAINT `drug_chk_1` CHECK (((`Drug_price` > 0) and (`Drug_price` <= 5000)))
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='药品信息表';

-- 正在导出表  hospital.drug 的数据：~8 rows (大约)

INSERT INTO `drug` (`Drug_id`, `Drug_name`, `Drug_lotnumber`, `Drug_indication`, `Drug_price`) VALUES
	(1, '999感冒灵颗粒', '2', '解热镇痛，用于感冒引起的头痛，发热等', 9.9),
	(2, '康恩贝肠炎宁片', '2', '清热利湿，行气；用于大肠湿热所致的腹泻，急慢性肠炎', 16.9),
	(3, '辅舒良 丙酸氟替卡松鼻喷雾剂', '1', '预防和治疗季节性过敏性鼻炎', 81),
	(4, '珍视明 四味珍层冰硼滴眼液', '1', '清热解痉，去翳明目。用于肝阴不足，肝气偏盛所致的不能久视、青少年视力下降。', 18.8),
	(5, '班赛 过氧苯甲酰凝胶', '3', '适用于治疗寻常痤疮的外用治疗', 29.8),
	(6, '斯利安 叶酸片', '1', '预防胎儿先天性神经管畸形，妊娠期、哺乳期妇女预防用药', 69),
	(8, '维尔固 盐酸氨基葡萄糖胶囊', '2', '治疗和预防全身所有部位的骨关节炎，可缓解和消除骨关节炎的疼痛、肿胀等症状，改善关节活动功能。', 52),
	(9, '罗每乐 盐酸阿莫罗芬搽剂', '3', '用于治疗敏感真菌引起的指(趾)甲感染', 252);


-- 导出  表 hospital.getdrug 结构
CREATE TABLE IF NOT EXISTS `getdrug` (
  `Get_id` int NOT NULL AUTO_INCREMENT COMMENT '取药编号',
  `Drug_id` int NOT NULL COMMENT '药品编号',
  `Drug_num` int NOT NULL COMMENT '药品数量',
  `Get_time` datetime NOT NULL COMMENT '取药时间',
  `Treat_id` int NOT NULL COMMENT '看病编号',
  PRIMARY KEY (`Get_id`),
  KEY `Drug_id` (`Drug_id`),
  KEY `Treat_id` (`Treat_id`),
  CONSTRAINT `getdrug_ibfk_1` FOREIGN KEY (`Drug_id`) REFERENCES `drug` (`Drug_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `getdrug_ibfk_2` FOREIGN KEY (`Treat_id`) REFERENCES `treat` (`Treat_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='取药信息表';

-- 正在导出表  hospital.getdrug 的数据：~6 rows (大约)

INSERT INTO `getdrug` (`Get_id`, `Drug_id`, `Drug_num`, `Get_time`, `Treat_id`) VALUES
	(17, 1, 3, '2021-06-11 10:15:03', 1),
	(18, 5, 3, '2021-06-11 10:15:03', 1),
	(19, 4, 1, '2021-06-11 10:15:03', 1),
	(20, 6, 4, '2021-06-11 10:15:03', 1),
	(21, 9, 5, '2021-06-11 10:15:03', 1),
	(22, 9, 1, '2021-06-11 10:15:03', 1);


-- 导出  表 hospital.patient 结构
CREATE TABLE IF NOT EXISTS `patient` (
  `Patient_id` int NOT NULL AUTO_INCREMENT COMMENT '患者编号',
  `Patient_name` char(20) NOT NULL COMMENT '患者姓名',
  `Patient_age` int NOT NULL COMMENT '患者年龄',
  `Patient_sex` char(20) NOT NULL COMMENT '患者性别',
  `Patient_Address` char(100) DEFAULT NULL COMMENT '患者地址',
  `Patient_Phone` char(20) DEFAULT NULL COMMENT '患者电话',
  `username` char(20) DEFAULT NULL COMMENT '患者用户名',
  `password` char(20) DEFAULT NULL COMMENT '患者密码',
  PRIMARY KEY (`Patient_id`),
  CONSTRAINT `patient_chk_1` CHECK (((`Patient_age` > 0) and (`Patient_age` < 100)))
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='患者信息表';

-- 正在导出表  hospital.patient 的数据：~4 rows (大约)
INSERT INTO `patient` (`Patient_id`, `Patient_name`, `Patient_age`, `Patient_sex`, `Patient_Address`, `Patient_Phone`, `username`, `password`) VALUES
	(1, '张三', 28, '男', '北京市海淀区清华东路17号', '13883292814', 'zhangsan', '123123'),
	(5, 'Yiwen Wang', 21, '男', '北京市海淀区清华东路17号', '13691131099', 'wyw', '123123'),
	(6, 'cau', 29, '女', '北京市海淀区清华东路17号', '15153643878', 'CAU', 'cau123'),
	(7, '小红', 38, '女', '北京市海淀区清华东路17号', '13691131099', 'xiaohong', '123123');

-- 导出  表 hospital.treat 结构
CREATE TABLE IF NOT EXISTS `treat` (
                                       `Treat_id` int NOT NULL AUTO_INCREMENT COMMENT '病例编号',
                                       `Patient_id` int NOT NULL COMMENT '患者编号',
                                       `Doctor_id` int NOT NULL COMMENT '医生编号',
                                       `Treat_dateTime` datetime NOT NULL COMMENT '看病时间',
                                       `symptom` char(200) NOT NULL COMMENT '患者症状',
                                       `Diagnose_info` char(200) NOT NULL COMMENT '诊断信息',
                                       PRIMARY KEY (`Treat_id`),
                                       KEY `Patient_id` (`Patient_id`),
                                       KEY `Doctor_id` (`Doctor_id`),
                                       CONSTRAINT `treat_ibfk_1` FOREIGN KEY (`Patient_id`) REFERENCES `patient` (`Patient_id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                       CONSTRAINT `treat_ibfk_2` FOREIGN KEY (`Doctor_id`) REFERENCES `doctor` (`Doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='看病信息表';

-- 正在导出表  hospital.treat 的数据：~6 rows (大约)
INSERT INTO `treat` (`Treat_id`, `Patient_id`, `Doctor_id`, `Treat_dateTime`, `symptom`, `Diagnose_info`) VALUES
(1, 1, 3, '2021-06-11 10:15:03', '流鼻涕，喉咙疼,四肢酸痛', '流行性感冒'),
(2, 1, 3, '2021-06-11 10:53:13', '', ''),
(3, 1, 3, '2021-06-11 11:23:34', '', ''),
(4, 1, 3, '2021-06-11 11:41:09', '', ''),
(5, 1, 3, '2021-06-11 20:37:05', '', ''),
(6, 1, 3, '2021-06-11 21:24:21', '', '');

-- 导出  表 hospital.register 结构
CREATE TABLE IF NOT EXISTS `register` (
  `Register_id` int NOT NULL AUTO_INCREMENT COMMENT '挂号编号',
  `Patient_id` int NOT NULL COMMENT '患者编号',
  `Doctor_id` int NOT NULL COMMENT '医生编号',
  `Register_time` date NOT NULL COMMENT '挂号时间',
  `Register_fee` double NOT NULL COMMENT '挂号费用',
  `Register_state` int NOT NULL COMMENT '挂号状态',
  PRIMARY KEY (`Register_id`),
  KEY `Patient_id` (`Patient_id`),
  KEY `Doctor_id` (`Doctor_id`),
  CONSTRAINT `register_ibfk_1` FOREIGN KEY (`Patient_id`) REFERENCES `patient` (`Patient_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `register_ibfk_2` FOREIGN KEY (`Doctor_id`) REFERENCES `doctor` (`Doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='挂号信息表';

-- 正在导出表  hospital.register 的数据：~4 rows (大约)
INSERT INTO `register` (`Register_id`, `Patient_id`, `Doctor_id`, `Register_time`, `Register_fee`, `Register_state`) VALUES
	(1, 1, 3, '2021-06-08', 40, 1),
	(2, 1, 1, '2021-06-08', 40, 1),
	(3, 1, 3, '2021-06-08', 40, 1),
	(4, 1, 3, '2021-06-08', 40, 1),
	(5, 1, 1, '2021-06-08', 40, 2),
	(6, 1, 3, '2021-06-11', 40, 1);

