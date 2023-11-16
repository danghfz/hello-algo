/**
 * @author danghf
 * @data 2023/11/16 20:27
 */
public class Test {
    public static void main(String[] args) {
        char[] vertices = {'a', 'b', 'c', 'd', 'e'};
        /*
         *   a ------ b
         *   | \     /
         *   |  \  /
         *   | / \
         *   c -- d -- e
         */
        int[][] matrix = {
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 3},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4}
        };
        GraphAdjMat graphAdjMat = new GraphAdjMat(vertices, matrix);
        System.out.println("=================测试基于邻接矩阵的图======================");
        System.out.println(graphAdjMat);
        /*
         *   a ------ b
         *   | \     /
         *   |  \  /
         *   | / \
         *   c -- d -- e
         */
        char[][] chars = {
                new char[]{'a','b'},
                new char[]{'a','c'},
                new char[]{'a','d'},
                new char[]{'b','c'},
                new char[]{'c','d'},
                new char[]{'d','e'}
        };
        GraphAdjList graphAdjList = new GraphAdjList(chars);
        System.out.println("=================测试基于邻接表的图======================");
        System.out.println(graphAdjList);
        System.out.println("=================广度优先遍历=================");
        System.out.println(graphAdjList.graphBfs());
        System.out.println("=================深度优先遍历=================");
        System.out.println(graphAdjList.graphDfs());
    }
}
