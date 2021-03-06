package com.nitesh.data.entities;

import javax.persistence.*;
import java.util.*;

//
@Entity
@Table(name="finances_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private Long userId;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Set<Account> accounts = new HashSet<Account>();

    @OneToOne(mappedBy = "user")
    private Credential credential;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    //@Basic
    @Column(name = "BIRTH_DATE", nullable = false)
    private Date birthDate;

    @Column(name="EMAIL_ADDRESS")
    private String emailAddress;

    @ElementCollection
    @CollectionTable(name="USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    @AttributeOverrides({@AttributeOverride(name="addressLine1", column = @Column(name = "USER_ADDRESS_LINE_1")),
            @AttributeOverride(name="addressLine2", column = @Column(name = "USER_ADDRESS_LINE_2"))})
    private List<Address> address = new ArrayList<Address>();

    @Column(name="LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Column(name="LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name="CREATED_DATE",updatable = false)
    private Date createdDate;

    @Column(name="CREATED_BY", updatable = false)
    private String createdBy;

    @Transient
    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
