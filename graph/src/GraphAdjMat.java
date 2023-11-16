import java.util.ArrayList;
import java.util.List;

/**
 * @author danghf
 * @data 2023/11/16 20:08
 * 基于邻接矩阵的图
 */
public class GraphAdjMat {
    /** 顶点列表 */
    private final List<Character> vertices;
    /** 邻接矩阵 */
    private final List<List<Integer>> matrix;
    /** 构造方法 */
    public GraphAdjMat(char[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.matrix = new ArrayList<>();
        // 添加顶点
        for (char val : vertices) {
            addVertex(val);
        }
        // 添加边
        // 请注意，edges 元素代表顶点索引，即对应 vertices 元素索引
        for (int[] e : edges) {
            addEdge(e[0], e[1]);
        }
    }
    /** 获取顶点数量 */
    public int size() {
        return vertices.size();
    }
    /** 添加顶点 */
    public void addVertex(char val) {
        int n = size();
        // 向顶点列表中添加新顶点的值
        vertices.add(val);
        // 在邻接矩阵中添加一行
        List<Integer> newRow = new ArrayList<>(n);
        for (int j = 0; j < n; j++) {
            newRow.add(0);
        }
        matrix.add(newRow);
        // 在邻接矩阵中添加一列
        // 遍历每一行，添加一个 0 元素
        for (List<Integer> row : matrix) {
            row.add(0);
        }
    }
    /** 删除顶点 */
    public void remove(int index){
        if (index > size()){
            throw new IndexOutOfBoundsException();
        }
        // 删除一行
        matrix.remove(index);
        // 每一列删除一个元素
        for (List<Integer> row : matrix) {
            row.remove(index);
        }
        // 删除顶点列表中的元素
        vertices.remove(index);
    }
    /** 添加边 */
    public void addEdge(int i, int j){
        if(i < 0 || j < 0 || i >= size() || j >= size()){
            throw new IndexOutOfBoundsException();
        }
        if (i == j){
            throw new IllegalArgumentException("i == j");
        }
        // 让 M[i,j] 和 M[j,i] = 1
        matrix.get(i).set(j, 1);
        matrix.get(j).set(i, 1);
    }
    /** 删除边 */
    public void removeEdge(int i, int j){
        if(i < 0 || j < 0 || i >= size() || j >= size()){
            throw new IndexOutOfBoundsException();
        }
        matrix.get(i).set(j, 1);
        matrix.get(j).set(i, 1);
    }
    /**
     *    a b c d e
     *  a 0 1 0 0 1
     *  b * * * * *
     *  c * * * * *
     *  d * * * * *
     *  e * * * * *
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int size = vertices.size();
        builder.append("  ");
        for (Character vertex : vertices) {
            builder.append(vertex).append(" ");
        }
        builder.append("\n");
        for (int i = 0; i < size; i++) {
            builder.append(vertices.get(i)).append(" ");
            for (int j = 0; j < size; j++) {
                builder.append(matrix.get(i).get(j)).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
