import java.util.ArrayList;
import java.util.List;

/**
 * @author danghf
 * @data 2023/11/12 23:27
 * 基于链表实现的HashMap
 * 使用链地址法解决哈希冲突
 */
public class LinkedHashMap<K,V> {
    private static class PairNode<K,V> extends Pair<K,V>{
        public PairNode(K key, V val) {
            super(key, val);
            this.next = null;
        }
        public PairNode<K,V> next;
    }
    private List<PairNode<K,V>> buckets;

    public LinkedHashMap() {
        this.buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(null);
        }
    }
    /* hash函数 */
    private int hashFun(K key) {
        return key.hashCode() % buckets.size();
    }
    /* 查询 */
    public V get(K key) {
        int index = hashFun(key);
        PairNode<K,V> pairNode = buckets.get(index);
        while (pairNode != null && !pairNode.key.equals(key)) {
            pairNode = pairNode.next;
        }
        return pairNode == null ? null : pairNode.val;
    }
    /* 添加 */
    public void add(K key, V value) {
        PairNode<K,V> pairNode = new PairNode<>(key, value);
        int index = hashFun(key);
        PairNode<K,V> node = buckets.get(index);
        if (node == null) {
            buckets.set(index, pairNode);
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = pairNode;
        }
    }
    /* 删除 */
    public void remove(K key) {
        int index = hashFun(key);
        PairNode<K,V> node = buckets.get(index);
        if (node == null) {
            return;
        }
        if (node.key.equals(key)) {
            buckets.set(index, node.next);
        } else {
            while (node.next != null && !node.next.key.equals(key)) {
                node = node.next;
            }
            if (node.next != null) {
                node.next = node.next.next;
            }
        }
    }
    /* 获取所有键值对 */
    public List<Pair<K,V>> getAll() {
        List<Pair<K,V>> collect = new ArrayList<>();
        for (PairNode<K,V> pairNode : buckets) {
            while (pairNode != null) {
                collect.add(pairNode);
                pairNode = pairNode.next;
            }
        }
        return collect;
    }
    /* 获取所有键 */
    public List<K> keySet() {
        List<K> keySet = new ArrayList<>();
        for (PairNode<K,V> pairNode : buckets) {
            while (pairNode != null) {
                keySet.add(pairNode.key);
                pairNode = pairNode.next;
            }
        }
        return keySet;
    }
    /* 获取所有值 */
    public List<V> valueSet() {
        List<V> valueSet = new ArrayList<>();
        for (PairNode<K,V> pairNode : buckets) {
            while (pairNode != null) {
                valueSet.add(pairNode.val);
                pairNode = pairNode.next;
            }
        }
        return valueSet;
    }
}
