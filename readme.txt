Создание документации из командной строки с поддержкой кириллицы, отображением private элементов,
флагами @version и @author:
    Пример скрипта для винды 
    docScript.bat:
        SET dest=".\out\production\Home\Docs\home2"
        javadoc -d %dest% -encoding utf8 -private -author -version^
            src\home2\space\Planet.java src\home2\Example.java
        REM EXPLORER %dest%
        %dest%\index.html


    Пример скрипта для линукса (команда отличается от виндовой слешами)
    docScript.sh:
        #!/usr/bin/env bash
        javadoc -d docPath -encoding utf8 -private -author -version home2/space/Planet.java home2/Example.java
 		
        # для запуска .sh файлов:
        # chmod +x some.sh
        #./some.sh   или  sh some.sh


Компиляция и запуск из командной строки для Windows (в линукс терминале и в intelliJ с кодировками все ок):
    runScript.bat:
        REM mkdir classes
        chcp 1251
        SET dest=".\out\classes"

        javac -d %dest% -encoding utf8^
            src\other\Show.java^
            src\home2\space\Planet.java^
            src\home2\Example.java

        java -classpath out\classes home2.Example^
            .\info2.txt
