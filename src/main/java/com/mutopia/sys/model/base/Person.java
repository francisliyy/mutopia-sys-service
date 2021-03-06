/**
 * 
 */
package com.mutopia.sys.model.base;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author ThinkPad
 *
 */
public class Person extends BaseEntity {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "first_name")
    @NotEmpty
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty
    private String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
