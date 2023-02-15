package com.leonds.datastructure.sparse;

/**
 * 稀疏数组
 * <p>
 * 适用场景：当一个数组中大部分元素为0，或者为同一个值的数组时，可以使用稀疏数组来存放该数组
 * 稀疏数组一般为3列多行的二维数组，第一行存放原始二维数组的信息，多少行，多少列，有效值的个数，其它行存放每个值的信息
 * <p>
 * 二维数组转稀疏数组过程：
 * - 遍历二维数组，获取有效数据的个数
 * - 根据有效数据的个数创建稀疏数组
 * - 稀疏数组的第一行赋值为源数组的基本信息：行数、列数、有效数据个数
 * - 稀疏数组的剩余行赋值为有效数据的基本信息：所在行、所在列、值
 * <p>
 * 稀疏数组转二维数组过程：
 * - 根据稀疏数组第一行信息创建二维数组
 * - 遍历剩余行数据给二维数组赋值
 *
 * @author Leon
 */
public class SparseArray {
    public static void main(String[] args) {
        // 初始化二维数组
        int[][] sourceArray = new int[10][10];
        sourceArray[1][3] = 5;
        sourceArray[2][5] = 2;
        sourceArray[4][7] = 8;

        // 遍历二维数组，获取有效数据个数，即不为0的数据个数
        int validCount = 0;
        for (int[] items : sourceArray) {
            for (int item : items) {
                if (item != 0) {
                    validCount++;
                }
            }
        }

        printArray("原始二维数组", sourceArray);

        // 创建稀疏数组, 因为稀疏数组第一行要存储源数组的基本信息，所以稀疏数组的行数等于有效数据个数+1, 列固定为3列
        int[][] sparseArray = new int[validCount + 1][3];
        sparseArray[0][0] = 10;
        sparseArray[0][1] = 10;
        sparseArray[0][2] = validCount;

        // 给稀疏数组剩余行赋值
        int row = 0;
        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = 0; j < sourceArray[i].length; j++) {
                if (sourceArray[i][j] != 0) {
                    row++;
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = sourceArray[i][j];
                }
            }
        }

        printArray("稀疏数组", sparseArray);

        // 稀疏数组转换给原始数组
        int[][] sourceArrayNew = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            sourceArrayNew[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        printArray("原始二维数组", sourceArrayNew);
    }

    static void printArray(String title, int[][] arr) {
        System.out.println(title);
        for (int[] items : arr) {
            for (int item : items) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        System.out.println();
    }
}
