Создание документации из командной строки с поддержкой кириллицы, отображением private элементов:
doc.bat:
    SET dest=".\out\docs"
    javadoc -d %dest% -encoding utf8 -private -author -version^
    src\home2\space\Planet.java src\home2\Example.java
    %dest%\index.html

Компиляция и запуск из cmd Windows:
run.bat:
    chcp 65001
    SET dest=".\out\classes"

    javac -d %dest% -encoding utf8^
        src\other\Show.java^
        src\home2\space\Planet.java^
        src\home2\Example.java

    java -classpath out\classes home2.Example^
            .\info2.txt
    PAUSE