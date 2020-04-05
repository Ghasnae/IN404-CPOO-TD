pathwork = "/home/user/cours/IN404_prog_oriente_obj/td/td5/exo5_3_2"
pathmathlib = "commons-math3-3.6.1/commons-math3-3.6.1.jar"

run: compile
	java -cp $(pathwork)/$(pathmathlib):. Main

compile:
	javac -cp $(pathwork)/$(pathmathlib) Main.java

archive:
	zip exo5_3_2.zip [ Makefile Main.java README.md ]

clean:
	rm -f exo5_3_2.zip
	rm -f *.class
	ls
