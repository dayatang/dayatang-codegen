/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domainclass;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.dayatang.domain.AbstractEntity;
import com.dayatang.utils.DateUtils;

/**
 * 当事人
 * @author yyang
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CATEGORY", discriminatorType = DiscriminatorType.STRING)
public abstract class Party extends AbstractEntity {

	private static final long serialVersionUID = -6083088250263550905L;

	// 编码
	private String sn;

	// 名称
	private String name;

	// 创建日期
	private Date createDate = new Date();

	// 终结日期
	private Date terminateDate = DateUtils.MAX_DATE;
}
