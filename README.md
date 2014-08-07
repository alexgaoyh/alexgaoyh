项目名为alexgaoyh  但是发布的时候，设定的context root 为web  即发布到容器中之后，使用的是web项目名

#1: 发送邮件的功能，需要手动更改  spring-smtp-mail.xml 配置文件的username&&password两个参数，
	调用方法为直接调用EmailUtil.send(subject, content, to);
	
#2: 本例数据库使用的是mysql5.5版本，并且在项目启动前，需要更改 db-config.properties 文件的数据库对应的ip,username,password