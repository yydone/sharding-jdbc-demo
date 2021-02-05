DROP TABLE IF EXISTS `t_user_01`;
CREATE TABLE `t_user_01` (
  `user_id` varchar(16) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(32) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_user_01
-- ----------------------------
INSERT INTO `t_user_01` VALUES ('1000101', 'user01', '2021-02-04 17:57:00', 'system', '2021-02-04 17:57:00', 'system');
