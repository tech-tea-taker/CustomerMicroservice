package com.bankservice.CustomerMicroservice.model;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "login")
public class CustomerModel {

    @Id
    @Column(name="id")
    private String id;
    @Column(name="fullname")
    private String name;
    @Column(name="gender")
    private String gender;
    @Column(name="father_name")
    private String father;
    @Column(name="mother_name")
    private String mother;
    @Column(name="date_of_birth")
    private String dob; 
    @Column(name="nominee")
    private String nominee;
    @Column(name="address")
    private String address;
    @Column(name="pin")
    private String pin;
    @Column(name="phone_no")
    private String phone_no;
    @Column(name="email")
    private String email;
    @Column(name="pan_card")
    private String pancard;
    @Column(name="pan_photo")
    private String pan_photo;
    @Column(name="addhar_card")
    private String addharcard;
    @Column(name="addhar_photo")
    private String addhar_photo;
    @Column(name="password")
    private  String password;
    @Column(name="submit_date")
    private String submit_date;
    @Column(name="approve")
    private int approve;
    @Column(name="email_sent")
    private int email_sent;
    


    
	public int getEmail_sent() {
		return email_sent;
	}

	public void setEmail_sent(int email_sent) {
		this.email_sent = email_sent;
	}

	public int getApprove() {
		return approve;
	}

	public void setApprove(int approve) {
		this.approve = approve;
	}

	public String getSubmit_date() {
		return submit_date;
	}

	public void setSubmit_date(String submit_date) {
		this.submit_date = submit_date;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPan_photo() {
		return pan_photo;
	}

	public void setPan_photo(String pan_photo) {
		this.pan_photo = pan_photo;
	}

	public String getAddhar_photo() {
		return addhar_photo;
	}

	public void setAddhar_photo(String addhar_photo) {
		this.addhar_photo = addhar_photo;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public String getNominee() {
        return nominee;
    }

    public String getAddress() {
        return address;
    }

    public String getPIN() {
        return pin;
    }

    public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddharcard() {
        return addharcard;
    }

    public String getPancard() {
        return pancard;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPIN(String pin) {
        this.pin = pin;
    }

    public void setAddharcard(String addharcard) {
        this.addharcard = addharcard;
    }

    public void setPancard(String pancard) {
        this.pancard = pancard;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

  

  

	
 

	public CustomerModel(String id, String name, String gender, String father, String mother, String dob,
			String nominee, String address, String pin, String phone_no, String email, String pancard, String pan_photo,
			String addharcard, String addhar_photo, String password, String submit_date, int approve, int email_sent) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.father = father;
		this.mother = mother;
		this.dob = dob;
		this.nominee = nominee;
		this.address = address;
		this.pin = pin;
		this.phone_no = phone_no;
		this.email = email;
		this.pancard = pancard;
		this.pan_photo = pan_photo;
		this.addharcard = addharcard;
		this.addhar_photo = addhar_photo;
		this.password = password;
		this.submit_date = submit_date;
		this.approve = approve;
		this.email_sent = email_sent;
	}

	public CustomerModel() {
    }

	
    
    
}
