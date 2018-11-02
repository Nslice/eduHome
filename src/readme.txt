создание документации из командной строки:
	.bat:
		javadoc -d myDoc -encoding utf8 -private -author -version home2\space\Planet.java home2\Example.java
    	

	.sh: (команда отличается от виндовой слешами)
		#!/usr/bin/env bash
		javadoc -d myDoc -encoding utf8 -private -author -version home2/space/Planet.java home2/Example.java
	
		// для запуска .sh файлов:
		chmod +x some.sh
		./some.sh   или  sh some.sh