package com.boor.javautils.bean;

import lombok.Data;

/**
 * 哈夫曼 实体
 *
 * @author 周林
 * @version 1.0
 * @date 2021/1/5 11:08
 */
@Data
public class HuffmanNodeBean {
    /** 顶节点 */
    private int topNode;
    /** 右节点 */
    private int rightNode;
    /** 左节点 */
    private int leftNode;
    /** 权值 */
    private int weight;
}
