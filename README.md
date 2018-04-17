# hadoop-hive-test

1. 搭建hdfs和hadoop环境
2. 搭建hive
3. 运行httpserver2
3. 运行程序前，先使用beeline，创建表和导入数据

连接默认库
!connect jdbc:hive2://localhost:10000/default

建内部表（数据存在hdfs的 {hive.metastore.warehouse.dir}上）
create table fz
(id int,name string,age int,tel string)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',';

导入数据
load data local inpath '/home/ys/testdata.txt' into table fz;
