## Вариант 368823

1.  Создать одномерный массив b типа long. Заполнить его нечётными числами от 5 до 19 включительно в порядке убывания.
2.  Создать одномерный массив x типа float. Заполнить его 16-ю случайными числами в диапазоне от -5.0 до 14.0.
3.  Создать двумерный массив b размером 8x16. Вычислить его элементы по следующей формуле (где x = x[j]):
    -   если b[i] = 15, то b[i][j] = $((\tan(x)/4)^3)^{(1/2*((3/4+\tan(x))^2-4))}$
    -   если b[i] ∈ {7, 9, 11, 13}, то  b[i][j]= $\sin(\sin(\tan(x)))$;
    -   для остальных значений b[i]:  b[i][j] = ${((\sqrt[3]{(e^{(1/4x))}}+1)/{(e^{(1/3/(x+1/3)))}}^2)}^3$
4.  Напечатать полученный в результате массив в формате с двумя знаками после запятой.

**Отчёт по лабораторной работе должен содержать:**

1.  Текст задания.
2.  Исходный код программы.
3.  Результат работы программы.
4.  Выводы по работе.

**Вопросы к защите лабораторной работы:**

1.  Язык Java. Особенности языка.
2.  Средства разработки. JDK и JRE.
3.  Примитивные типы данных в Java.
4.  Работа с переменными. Декларация. Инициализация. Присваивание.
5.  Инструкции ветвления и циклов.
6.  Операторы и выражения в Java. Особенности вычисления, приоритеты операций.
7.  Математические функции в составе стандартной библиотеки Java. Класс`java.lang.Math`.
8.  Форматированный вывод числовых данных.
