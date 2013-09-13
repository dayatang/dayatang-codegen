/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domainclass;

import java.util.Date;
import javax.persistence.Embeddable;

/**
 * 员工教育情况
 * @author yyang
 */
@Embeddable
public class EmployeeEducation {
    
    //学校
    private String school;
    
    //开始日期
    private Date fromDate;
    
    //结束日期
    private Date toDate;
    
}
