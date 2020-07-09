

public  class  Const {


    //Данные для заполнения меню элемента Select
    public static String [] menu_rayon = {"", "Москва", "Московская область"};
    public static String [] menu_okrug = {"", "САО", "СВАО", "СЗАО", "ЮАО", "ЮВАО", "ЮЗАО"};

    //Запрос на получение и сортировку данных о сотрудниках из 3-х таблиц
    public static String sql1 = " select members.num, fio, age, rayon, okrug, adres, start, finish ";
    public static String sql2 = " from pers_files.home_adres, pers_files.members,pers_files.work_time ";
    public static String sql3 = " where (members.num=home_adres.num and members.num=work_time.num ) and (lower(fio)  ~ lower(?)) and (rayon ~ ?) and (okrug ~ ?) ";

    //Запрос на добавление данных нового сотрудника в 3 табицы БД
    public static String sql5 = "insert into pers_files.members (num, fio, age) VALUES (?, ?, ?); ";
    public static String sql6 = "insert into pers_files.home_adres (num ,adres , rayon, okrug) VALUES (?, ?, ?, ?); ";
    public static String sql7 = "insert into pers_files.work_time (num, start, finish) VALUES (?, ?, ?); ";





}
