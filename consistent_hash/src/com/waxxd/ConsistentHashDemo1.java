package com.waxxd;

import com.waxxd.utils.MD5Hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * description:
 *          不带虚拟节点，使用一致性hash算法
 * @author waxxd
 * @date 2019-05-08 14:28
 **/
public class ConsistentHashDemo1 {

    // 需要加入hash环的服务器ip列表
    private static String[] servers = {
            "192.168.0.0:8888",
            "192.168.0.1:8888",
            "192.168.0.2:8888",
            "192.168.0.3:8888",
            "192.168.0.4:8888" };

    // 用来保存服务器信息，key是hash值，value表示服务器名称
    // 采用TreeMap数据结构，实现方式是红黑树
    private static SortedMap<Long,String> sortedMap = new TreeMap<>();

    // 静态代码块将，服务器添加到hash环上面
    static {
        for(int i = 0;i < servers.length; i++){
            long hash = MD5Hash.getHash(MD5Hash.md5(servers[i]), 0);
            System.out.println("服务器" + i + "加入map中，其中hash值为：" + hash);
            sortedMap.put(hash,servers[i]);
        }
    }



    /**
     * 将node节点映射到hash环上面，顺时针离它的hash值最小的服务器ip上面
     * @param node
     * @return
     * @author waxxd
     **/
    private static String getServer(String node){
        long hash = MD5Hash.getHash(MD5Hash.md5(node),0);
        SortedMap<Long, String> tailMap = sortedMap.tailMap(hash);
        Long key = tailMap.firstKey();
        return tailMap.get(key);
    }

    public static void main(String[] args) {

        String[] nodes = {"127.0.0.1:8888","127.0.0.2:9999","127.0.0.3:8888","122.134.156.66:82","122.134.156.66:88"};
        for(int i = 0;i < nodes.length;i++){
            System.out.println("[" + nodes[i] + "]的hash值为" +
                    MD5Hash.getHash(MD5Hash.md5(nodes[i]),0) + ", 被路由到结点" + getServer(nodes[i]));
        }

    }

}










































