package com.sfs.experimentaltesting.domin.phoneBill;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description:
 * Create DateTime: 2020/4/1 13:10
 *
 * 

 */
@Data
@Accessors(chain = true)
public class PhoneOrderWaitPushNew {


    Long id;

    /**
     * 分类名称
     */
    private String classifyName;



    /**
     * 上游用户id
     */
    private Long upstreamUserId;

    /**
     * 商户id
     */
    private Long shopUserId;
    /**
     * 上游订单号
     */
    private String upstreamOrderNo;

    /**
     * 平台订单号
     */
    private String platformOrderNo;

    /**
     * 商户订单号
     */
    private String shopOrderNo;





}
