//Реализуйте структуру телефонной книги с помощью HashMap. Программа также должна учитывать,
//что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать,
//как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
import java.beans.PropertyEditorManager;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phonebook = new HashMap<>();


        while (true) {
            String[] mainMenu = {"1. Создать контакт",
                    "2. Показать контакты",
                    "3. Найти контакт",
                    "4. Изменить контакт",
                    "5. Удалить контакт",
                    "6. Выход"};

            System.out.println(Arrays.toString(mainMenu));

            Scanner scan = new Scanner(System.in);
            System.out.print("Выберите пункт меню: ");
            int choice = scan.nextInt();
//            scan.close();
            if (choice == 1) {
                System.out.println("Введите ФИО: ");
                Scanner first = new Scanner(System.in);
                String name = first.nextLine();
//                first.close();
                System.out.println("Введите номер телефона: ");
                Scanner nNum = new Scanner(System.in);
                String number = nNum.nextLine();
                if (phonebook.containsKey(name)){
                    if(phonebook.get(name).contains(number)){
                        continue;
                    }else {
                        ArrayList<String> val = phonebook.get(name);
                        val.add(number);
                        phonebook.put(name, val);
                    }

                }else {
                    ArrayList<String> val = new ArrayList<>();
                    val.add(number);
                    phonebook.put(name,val);

                }
            }
            if (choice == 2) {
                ArrayList<Integer> indVal = new ArrayList<>();
                HashMap<String, String> indKey = new HashMap<>();
                for (String k : phonebook.keySet()) {
                    indVal.add(phonebook.get(k).size());
                    int size = phonebook.get(k).size();
                    indKey.put(String.valueOf(size),k);
                }

       indVal.sort(Collections.reverseOrder());

                for (int size : indVal) {
                    System.out.println((indKey.get(String.valueOf(size)) + " " + phonebook.get((indKey.get(String.valueOf(size))))));

                }
            }



            if (choice == 3) {
                System.out.println("Введите ФИО для поиска: ");
                Scanner find = new Scanner(System.in);
                String findName = find.nextLine();
//                find.close();
                if (phonebook.get(findName)!=null) System.out.println(findName + ": " + phonebook.get(findName));
                else System.out.println("Контакт не найден");
            }
            if (choice == 4) {
                System.out.println("Введите ФИО для изменения контакта: ");
                Scanner change = new Scanner(System.in);
                String changeContact = change.nextLine();
//                change.close();
                if (phonebook.get(changeContact) != null){
                    System.out.println("Для изменения ФИО введите 1, для изменения номера введите 2");
                    Scanner ch = new Scanner(System.in);
                    int way = ch.nextInt();
//                    ch.close();
                    if (way == 1){
                        ArrayList<String > obj = phonebook.remove(changeContact);
                        System.out.println("Введите новые ФИО");
                        Scanner scnN = new Scanner(System.in);
                        String newName = scnN.nextLine();
//                        scnN.close();
                        phonebook.put(newName,obj);

                    } else {
                        if (way == 2){
                            List<String> values = phonebook.get(changeContact);
                            System.out.println("Выберите номер для изменения: ");
                            for (int i=0; i<values.size();i++){
                                System.out.println(i++ + ". " + values.get(i));
                            }
                            System.out.println("Введите число: ");
                            Scanner numb = new Scanner(System.in);
                            int num = numb.nextInt()-1;
//                            numb.close();

                            System.out.println("Введите новый номер: ");
                            Scanner phone = new Scanner(System.in);
                            String  newPhone = phone.nextLine();
//                            phone.close();

                            values.add(num,newPhone);

                        }
                    }


                }
            }
            if (choice == 5) {
                System.out.println("Введите ФИО для удаления контакта: ");
                Scanner del = new Scanner(System.in);
                String delContact = del.nextLine();
//                del.close();
                phonebook.remove(delContact);
            }
            if (choice == 6) {
                System.out.println("До свидания!");
                break;
            }


        }
    }
}
