package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AMDEmployee extends BaseClass{
	
	@FindBy(linkText="PIM")
    public WebElement pimlink;

    @FindBy(linkText="Add Employee")
    public WebElement addEmployee;

    @FindBy(id="firstName")
    public WebElement firstname;

    @FindBy(id="middleName")
    public WebElement middlename;

    @FindBy(id="lastName")
    public WebElement lastname;

    @FindBy(id="employeeId")
    public WebElement empId;

    @FindBy(id="btnSave")
    public WebElement save;
    
    @FindBy(xpath="//*[@id=\"profile-pic\"]/h1")
    public WebElement verifyName;
    
    @FindBy(linkText="Employee List")
    public WebElement EmployeeList;

    @FindBy(id="searchBtn")
    public WebElement searchbtn;

    

    @FindBy(xpath="//fieldset/p/input[@value='Edit']")
    public WebElement edit;

    @FindBy(id="personal_optGender_1")
    public WebElement gender;

    @FindBy(id="personal_cmbNation")
    public WebElement nationality;

    @FindBy(id="personal_txtLicExpDate")
    public WebElement licenseExpiryDate;

    @FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")
    public WebElement monthDropD;

    @FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")
    public WebElement yearDropD;

    @FindBy(xpath="//table[@id='resultTable']/tbody/tr")
    public List<WebElement> Table;

    @FindBy(xpath="//input[@id='btnSave']")
    public WebElement saveEdit;
    
    @FindBy(id="btnDelete")  
    public WebElement delete;
    
    @FindBy(id="dialogDeleteBtn")
    public WebElement okBtn;
    
    
    public AMDEmployee() {
        PageFactory.initElements(driver, this);
    }

}

