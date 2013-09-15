/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domainclass;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;

/**
 * 员工
 * 
 * @author yyang
 */
@Entity
@DiscriminatorValue("Employee")
public class Employee extends Party {

	private static final long serialVersionUID = -7339118476080239701L;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 身份证号码
	 */
	private String idNumber;

	/**
	 * 已失效
	 */
	private Boolean disabled = false;

	/**
	 * 出生日期
	 */
	private Date birthday;

	/**
	 * 教育情况
	 */
	@ElementCollection
	@CollectionTable(name = "person_educations", joinColumns = @JoinColumn(name = "person_id"))
	private List<EmployeeEducation> educations = new ArrayList<EmployeeEducation>();

	/**
	 * 电子邮箱
	 */
	@ElementCollection
	@CollectionTable(name = "person_emails", joinColumns = @JoinColumn(name = "person_id"))
	private Set<String> emails = new HashSet<String>();

	/**
	 * 即时通信
	 */
	@ElementCollection
	@CollectionTable(name = "person_ims", joinColumns = @JoinColumn(name = "person_id"))
	@MapKeyColumn(name = "im_type")
	@MapKeyEnumerated(EnumType.STRING)
	@Column(name = "im_address")
	private Map<ImType, String> ims = new HashMap<ImType, String>();

	@Override
	public int hashCode() {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public boolean equals(Object other) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public String toString() {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}
}
