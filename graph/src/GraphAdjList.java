import java.util.*;

/**
 * @author danghf
 * @data 2023/11/16 20:42
 * 基于邻接表的图
 */
public class GraphAdjList {
    /** key 顶点。 value 邻接顶点*/
    Map<Character, List<Character>> adjList;

    public GraphAdjList(char[][] edges) {
        this.adjList = new HashMap<>();
        // 添加顶点和边
        for (char[] edge : edges) {
            addVertex(edge[0]);
            addVertex(edge[1]);
            addEdge(edge[0], edge[1]);
        }
    }
    /** 获取顶点数量 */
    public int size(){
        return adjList.size();
    }
    /** 添加顶点 */
    public void addVertex(Character vertex){
        if (!adjList.containsKey(vertex)){
            adjList.put(vertex, new ArrayList<>());
        }
    }
    /** 删除顶点 */
    public void removeVertex(Character vertex){
        // 删除所有出现的 vertex
        if (!adjList.containsKey(vertex)){
            return;
        }
        adjList.remove(vertex);
        for (List<Character> list : adjList.values()){
            list.remove(vertex);
        }
    }
    /** 添加边 */
    public void addEdge(Character c1, Character c2){
        // 分别在两个顶点的邻接表中添加对方
        if (!adjList.containsKey(c1) || !adjList.containsKey(c2)){
            throw new IllegalArgumentException(c1 + " or " + c2 + " is not a vertex");
        }
        // 考虑重复边的情况
        if (adjList.get(c1).contains(c2) || adjList.get(c2).contains(c1)){
            return;
        }
        adjList.get(c1).add(c2);
        adjList.get(c2).add(c1);
    }
    /** 删除边 */
    public void removeEdge(Character c1, Character c2){
        if (!adjList.containsKey(c1) || !adjList.containsKey(c2)){
            throw new IllegalArgumentException(c1 + " or " + c2 + " is not a vertex");
        }
        adjList.get(c1).remove(c2);
        adjList.get(c2).remove(c1);
    }

    /**
     * a -> b -> c
     * b -> c
     * c -> d
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, List<Character>> entry : adjList.entrySet()) {
            builder.append(entry.getKey());
            for (Character c : entry.getValue()) {
                builder.append(" -> ").append(c);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * 广度优先搜索
     */
    public List<Character> graphBfs(){
        // 起始顶点
        Character start = 'a';
        // 用于存储遍历结果
        ArrayList<Character> res = new ArrayList<>();
        // 用户记录已经访问过的顶点
        Set<Character> visited = new HashSet<>();
        visited.add(start);
        Queue<Character> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            // 出队
            Character poll = queue.poll();
            // 记录已经访问的节点
            res.add(poll);
            // 获取该节点的邻接节点
            List<Character> list = adjList.get(poll);
            for (Character c : list) {
                // 只添加未访问过的节点
                if (!visited.contains(c)){
                    visited.add(c);
                    queue.offer(c);
                }
            }
        }
        return res;
    }

    /**
     * 深度优先搜索
     */
    public List<Character> graphDfs(){
        // 起始顶点
        Character start = 'a';
        ArrayList<Character> res = new ArrayList<>();
        // 用户记录已经访问过的顶点
        Set<Character> visited = new HashSet<>();
        dfs(start, visited, res);
        return res;
    }

    /**
     * dfs 辅助函数
     */
    private void dfs(Character start, Set<Character> visited, ArrayList<Character> res) {
        // 记录该节点
        res.add(start);
        // 标记
        visited.add(start);
        // 获取所有邻接节点
        for (Character c : adjList.get(start)) {
            if (visited.contains(c)){
                continue;
            }
            // 递归访问邻接节点
            dfs(c, visited, res);
        }
    }
}
