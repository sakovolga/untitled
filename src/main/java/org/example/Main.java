package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        moveElements(list1, 3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(10);
        list2.add(12);
        list2.add(13);
        list2.add(13);
        list2.add(10);
        list2.add(15);
        list2.add(12);
        list2.add(18);
        deleteRepeatedElements(list2);
    }
    public static void getReversedList(List<Integer> list){
        ListIterator<Integer> it = list.listIterator(list.size());
        while (it.hasPrevious()){
            System.out.println(it.previous());
        }
    }

    public static void joinLists(List<Integer> list1, List<Integer> list2){
        ListIterator<Integer> iteratorList1 = list1.listIterator();
        ListIterator<Integer> iteratorList2 = list2.listIterator();
        List<Integer> unitedList = new ArrayList<>();
        while (iteratorList1.hasNext() || iteratorList2.hasNext()){
            if(iteratorList1.hasNext()) {
                unitedList.add(iteratorList1.next());
            }
            if (iteratorList2.hasNext())
                unitedList.add(iteratorList2.next());
        }
        System.out.println(unitedList);
    }

//    Напишите метод, который принимает на вход List и число k, и использует ListIterator
//    для циклического сдвига элементов списка на k позиций вправо.

    public static void moveElements(List<Integer> list, int k){
        ListIterator<Integer> listIterator = list.listIterator();
        System.out.println(list);
        for (int i = 1; i <= k; i++) {
            do {
                listIterator.next();
            }
            while (listIterator.hasNext());
            int end = listIterator.previous();
            listIterator.remove();
            do {
                listIterator.previous();
            } while (listIterator.hasPrevious());
            listIterator.add(end);
        }
        System.out.println(list);
    }
//    Напишите метод, который принимает на вход List и использует ListIterator
//    для удаления повторяющихся элементов из списка, оставляя только уникальные.
    public static void deleteRepeatedElements(List<Integer> list){
        ListIterator<Integer> li = list.listIterator();
        List<Integer> newList = new ArrayList<>();
        System.out.println(list);
        while (li.hasNext()){
            int temp = li.next();
            li.remove();
            while (li.hasNext()){
                if (temp == li.next()){
                    li.remove();
                }
            }
            newList.add(temp);
            while (li.hasPrevious()){
                li.previous();
            }
            li.next();
        }
        System.out.println(newList);
    }

// Решение Chat GPT
        public static void deleteRepeatedElements1(List<Integer> list) {
            ListIterator<Integer> li = list.listIterator();

            while (li.hasNext()) {
                int temp = li.next();
                ListIterator<Integer> subLi = list.listIterator(li.nextIndex()); // Используйте subLi для оставшихся элементов

                while (subLi.hasNext()) {
                    if (temp == subLi.next()) {
                        subLi.remove();
                    }
                }
            }

            System.out.println(list);
        }




}