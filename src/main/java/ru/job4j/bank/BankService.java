package ru.job4j.bank;
import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Класс описывает модель банковской системы.
 *
 * @author "Ivan Popov"
 * @version 1.0
 */
public class BankService {
    /**
     * Поле содержит всех пользователей системы, с их счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляем пользовотедля
     * @param user - пользователь будет добавлен в коллекцию
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляем пользовотеля.
     * @param passport - идентификатор пользователя
     * @return
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Создаем новый банковский счет
     * @param passport - идентификатор пользователя
     * @param account - добавляемый банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Поиск банковского счета по паспорту
     * @param passport - идентификатор пользователя
     * @return - возвращает пользователя
     */
    public User findByPassport(String passport) {
        for (User user :users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Поиск пользователя по паспорту
     * @param passport - идентификатор пользователя
     * @param requisite - реквизиты счета
     * @return - возвращает найденый счет
     */
    public Account findByRequisite(String passport, String requisite) {
        Account resultAccount = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    resultAccount = account;
                    break;
                }
            }
        }
        return resultAccount;
    }

    /**
     * Переводим деньги с обного счет на другой
     * @param srcPassport   - паспорт отправителя
     * @param srcRequisite  - реквизиты отправителя
     * @param destPassport  - паспорт получателя
     * @param destRequisite - реквизиты получателя
     * @param amount        - сумма к переводу
     * @return - результат операции (true - если перечисление успешно, иначе - false)
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            rsl = true;
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
        }
        return rsl;
    }

    /**
     * Метод для получения всех банковских счетов конкретного клиента
     *
     * @param user - клиент
     * @return - возвращает список со всеми счетами клиента
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}