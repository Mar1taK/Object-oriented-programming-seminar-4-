public class Program{
    public static void main(String[] args){
        ArrayClass<Integer> intMas = new ArrayClass<>();
        intMas.add(15); // вставка в массив
        intMas.add(20);
        intMas.add(50);
        intMas.add(0);
        intMas.add(45);
        intMas.PrintArray();
        intMas.RemoveByIndex(3); // удаление по индексу
        intMas.PrintArray();
        intMas.RemoveData(20); // удаление по значению
        intMas.PrintArray();
        System.out.println(intMas.FindMinData()); // поиск минимума
        System.out.println(intMas.FindMaxData()); // поиск максимума
        System.out.println(intMas.FindSumData()); // поиск суммы элементов массива
        System.out.println(intMas.FindMultData()); // поиск произведения элементов массива
        System.out.println(intMas.FindIndex(5)); // поиск индекса заданного элемента в массиве, если такого элемента в массиве нет то возвращать -1
        System.out.println(intMas.FindData(68)); // проверка наличия элемента в массиве (возвращает true, если элемент в массиве есть, false – нет)
        // пузырьковая сортировка
        try {
            intMas.BubbleSort();
            System.out.print("Отсортированный массив => "); 
            intMas.PrintArray();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ArrayClass<String> stringMas = new ArrayClass<>();
        stringMas.add("Компьютер");
        stringMas.add("Телефон");
        stringMas.add("Планшет");
        stringMas.add("Часы");
        stringMas.PrintArray();
        stringMas.RemoveByIndex(2);
        stringMas.PrintArray();
    }
}