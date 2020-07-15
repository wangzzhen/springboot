#启动springboot应用

1.直接本地启动
	直接运行Application类，run as java application
2.服务器启动
	java -jar /build/libs/gs-spring-boot-0.1.0.jar
	//当前ssh窗口被锁定，可按CTRL + C打断程序运行，或直接关闭窗口，程序退出 

	java -jar /build/libs/gs-spring-boot-0.1.0.jar &
	//当前ssh窗口不被锁定，但是当窗口关闭时，程序中止运行。

	nohup java -jar /build/libs/gs-spring-boot-0.1.0.jar
	//nohup 意思是不挂断运行命令,当账户退出或终端关闭时,程序仍然运行
	缺省情况下该应用的所有输出被重定向到nohup.out的文件中，除非另外指定了输出文件。

	nohup java -jar /build/libs/gs-spring-boot-0.1.0.jar >logs.txt
	// >logs.txt意思为将输出指定到logs.txt。
	
#公共配置官网地址(Common application properties)
https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html

