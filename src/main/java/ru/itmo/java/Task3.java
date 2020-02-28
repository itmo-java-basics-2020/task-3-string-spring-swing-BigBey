package ru.itmo.java;

import java.util.HashMap;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        try {
            int[] result = new int[inputArray.length];
            if (inputArray.length == 0)
                return new int[]{};
            else {
                for (int i = 1; i < inputArray.length; i++) {
                    result[i] = inputArray[i - 1];
                }
                result[0] = inputArray[inputArray.length - 1];
            }
            return result;
        }catch (NullPointerException e) {
            return new int[]{};
        }
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if( inputArray == null || inputArray.length == 0)
            return 0;
        else if ( inputArray.length == 1)
            return inputArray[0];
        else{
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < inputArray.length; i++)
                for(int j = 0; j < inputArray.length; j++)
                    if(inputArray[i]*inputArray[j] > max && i != j)
                        max = inputArray[i]*inputArray[j];
            return max;
        }

    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if(input == null || input.equals(""))
            return 0;
        else {
            String lowerCase = input.toLowerCase();
            int countAB = 0;
            for (int i = 0; i < lowerCase.length(); i++) {
                if (lowerCase.charAt(i) == 'a' || lowerCase.charAt(i) == 'b')
                    countAB++;
            }
            return (int) ((double) countAB / lowerCase.length() * 100);
        }
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        boolean result = false;
        if(input == null)
            return false;
        else if (input.equals(""))
            return true;
        else
            for(int i = 0; i < input.length()/2; i++){
                if(input.charAt(i) == input.charAt(input.length()-1-i))
                    result = true;
                else
                    result = false;
            }
        return result;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        String result = "";
        if(input == null || input.length() == 0)
            return "";
        else {
            char currentSymbol = input.charAt(0);
            int count = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == currentSymbol)
                    count++;
                else {
                    result += currentSymbol + "" + count;
                    currentSymbol = input.charAt(i);
                    count = 1;
                }
            }
            result += currentSymbol + "" + count;
        }
        return result;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        try {
            HashMap<Character, Character> first = new HashMap<>();
            HashMap<Character, Character> second = new HashMap<>();
            if (one.length() != two.length() || one.equals("") || two.equals(""))
                return false;
            else {
                for (int i = 0; i < one.length(); i++) {
                    first.put(one.charAt(i), one.charAt(i));
                    second.put(two.charAt(i), two.charAt(i));
                }
                return first.equals(second);
            }
        }catch (NullPointerException e){
            return false;
        }
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        try {
            if(s.equals(""))
                return false;
            else {
                HashMap<Character, Character> symbols = new HashMap<>();
                for (int i = 0; i < s.length(); i++)
                    symbols.put(s.charAt(i), s.charAt(i));
                return s.length() == symbols.size();
            }
        }catch (NullPointerException e){
            return false;
        }
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        try{
            if(m.length == 0)
                return new int[][]{};
            else {
                int[][] result = new int[m.length][m.length];
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m.length; j++)
                        result[i][j] = m[j][i];
                }
                return result;
            }
        }catch (NullPointerException e){
            return new int[][]{{},{}};
        }catch (IndexOutOfBoundsException e){
            return m;
        }
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        try{
            String result = "";
            if(inputStrings.length == 0){
                return result;
            }else {
                Character localSeparator;
                if (separator == null) {
                    localSeparator = ' ';
                } else {
                    localSeparator = separator;
                }
                for (int i = 0; i < inputStrings.length - 1; i++)
                    result += inputStrings[i] + localSeparator;
                result += inputStrings[inputStrings.length - 1];
                return result;
            }
        }catch (NullPointerException e){
            return "";
        }
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        try {
            if(inputStrings.length == 0)
                return 0;
            else{
                int count = 0;
                for(int i = 0; i < inputStrings.length; i++) {
                    if (inputStrings[i].startsWith(prefix))
                        count++;
                }
                return count;
            }
        }catch (NullPointerException e){
            return 0;
        }
    }
}
