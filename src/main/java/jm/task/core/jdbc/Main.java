package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        // Создание таблицы User(ов)
        userService.createUsersTable();
        System.out.println("Таблица 'users' была успешно создана!");

        // Добавление 4 User(ов) в таблицу с данными на свой выбор.
        // После каждого добавления должен быть вывод в консоль
        //  ( User с именем – name добавлен в базу данных )

        String[] names = {"Шерлок", "Джон", "Марта", "Майкрофт"};

        userService.saveUser(names[0], "Холмс", (byte) 20);
        userService.saveUser(names[1], "Ватсон", (byte) 25);
        userService.saveUser(names[2], "Хадсон", (byte) 51);
        userService.saveUser(names[3], "Холмс", (byte) 38);

        for (String name : names) {
            System.out.printf("User с именем %s добавлен в базу данных.\n", name);
        }

//         Получение всех User из базы и вывод в консоль
//         (должен быть переопределен toString в классе User)
        System.out.println();
        System.out.println("Текущие User в таблице: ");
        System.out.println(userService.getAllUsers().toString());

        // Очистка таблицы User(ов)
        System.out.println();
        userService.cleanUsersTable();
        System.out.println("Таблица была успешно очищена!");

        // Удаление таблицы
        userService.dropUsersTable();
        System.out.println("Таблица была успешно удалена!");
    }
}
