/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain;

import javax.persistence.Embeddable;

/**
 * 地址
 * @author yyang
 */
@Embeddable
public class Address {
    
    //国家
    private String nation;
    
    //省份
    private String province;
    
    //城市
    private String city;
    
    //街道
    private String street;
}
