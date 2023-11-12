import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author danghf
 * @data 2023/11/12 20:31
 * 基于数组实现的HashMap
 * 使用开放寻址法解决哈希冲突
 */
public class ArrayHashMap<K, V> {
    private List<Pair<K, V>> buckets;
    public ArrayHashMap() {
        this.buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(null);
        }
    }
    /* 哈希函数 */
    private int hashFun(K key) {
        return key.hashCode() % buckets.size();
    }
    /* 查询 */
    public V get(K key) {
        int index = hashFun(key);
        // 通过key找到对应的Pair, index++ 解决哈希冲突
        while (index < buckets.size() && !buckets.get(index).key.equals(key)) {
            index++;
        }
        return buckets.get(index) == null ? null : buckets.get(index).val;
    }
    /* 添加 */
    public void add(K key, V value){
        Pair<K, V> pair = new Pair<>(key, value);
        int index = hashFun(key);
        while (index < buckets.size() && buckets.get(index) != null) {
            index++;
        }
        buckets.set(index, pair);
    }
    /* 删除 */
    public void remove(K key) {
        int index = hashFun(key);
        while (index < buckets.size() && !buckets.get(index).key.equals(key)) {
            index++;
        }
        buckets.set(index, null);
    }
    /* 获取所有键值对 */
    public List<Pair<K, V>> getAll() {
        List<Pair<K, V>> collect =
                buckets.stream()
                        .filter(pair -> pair != null)
                        .collect(Collectors.toList());
        return collect;
    }
    /* 获取所有键 */
    public List<K> keySet() {
        List<K> keySet = new ArrayList<>();
        for (Pair<K,V> pair : buckets) {
            if (pair != null){
                keySet.add(pair.key);
            }
        }
        return keySet;
    }

    /* 获取所有值 */
    public List<V> valueSet() {
        List<V> valueSet = new ArrayList<>();
        for (Pair<K,V> pair : buckets) {
            if (pair != null){
                valueSet.add(pair.val);
            }
        }
        return valueSet;
    }
}
