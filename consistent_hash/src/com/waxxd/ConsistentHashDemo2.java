package com.waxxd;

import com.waxxd.utils.MD5Hash;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * description:
 *          带虚拟节点，使用一致性hash算法
 * @author waxxd
 * @date 2019-05-08 14:28
 **/
public class ConsistentHashDemo2 {

    // 需要加入hash环的服务器ip列表
    private static String[] servers = {
            "192.168.0.0:8888",
            "192.168.0.1:8888",
            "192.168.0.2:8888",
            "192.168.0.3:8888",
            "192.168.0.4:8888" };

    // 用来保存服务器信息，key是hash值，value表示服务器名称
    // 采用TreeMap数据结构，实现方式是红黑树
    private static SortedMap<Long,String> vnNodes = new TreeMap<>();


    private static List<String> realNodes = new LinkedList<>();

    private static final int VN_NODES = 10;

    // 静态代码块将，服务器添加到hash环上面
    static {
        for(int i = 0;i < servers.length;i++){
            realNodes.add(servers[i]);
        }

        for(String server : realNodes){
            for(int i = 0 ;i < VN_NODES;i++){
                String vnNodeName = server + "&&vn" + i;
                long hash = MD5Hash.getHash(MD5Hash.md5(vnNodeName), 0);
                vnNodes.put(hash,vnNodeName);
                System.out.println("虚拟节点[" + vnNodeName + "]被添加, hash值为" + hash);
            }
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
        SortedMap<Long, String> tailMap = vnNodes.tailMap(hash);
        Long key = tailMap.firstKey();
        String vnNodeName = tailMap.get(key);

        return vnNodeName.substring(0,vnNodeName.indexOf("&&"));
    }

    public static void main(String[] args) {

        String[] nodes = {"127.0.0.1:8888","127.0.0.2:9999","127.0.0.3:8888","122.134.156.66:82","122.134.156.66:88"};
        for(int i = 0;i < nodes.length;i++){
            System.out.println("[" + nodes[i] + "]的hash值为" +
                    MD5Hash.getHash(MD5Hash.md5(nodes[i]),0) + ", 被路由到结点" + getServer(nodes[i]));
        }

    }

}










































