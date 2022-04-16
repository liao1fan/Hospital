# Hospital 社区医院管理系统
功能：注册登录注销、挂号、诊断、取药、管理员增删改查

使用教程：
本系统使用C3P0数据库连接池连接Java后端和Mysql数据库，在c3p0-config.xml文件中将密码改为自己数据库的密码即可使用数据库。
在webapp/sql文件夹中找到.sql文件，运行后数据库中出现名为hospital的schemas。
将Java后端在IDEA中配置完成后，启动程序，在网页中访问 "localhost:8080/login1.jsp"进入登录页面。

![image](https://user-images.githubusercontent.com/61133741/124349104-1b4c9500-dc20-11eb-93f8-7ef1f88e4ba7.png)

在数据库中找到患者、医生和管理员的用户名、密码登录使用，患者也可直接点击注册页面注册新账户登录使用。
