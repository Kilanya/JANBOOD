package com.syntax.stepDefinitions;


import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.pages.AMDEmployee;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AMDEmployeeSteps extends BaseClass{
	
	public AMDEmployee addEmp;
    public LoginPage login;

    String empFullName;

    String ID;

    @When("^I logged into OrangeHRM$")
    public void i_logged_into_OrangeHRM() {
        login = new LoginPage();
        CommonMethods.enterValue(login.username, BaseClass.prop.getProperty("username"));
        CommonMethods.enterValue(login.password, BaseClass.prop.getProperty("password"));
        CommonMethods.click(login.btnLogin);

    }

    @And("^I clicked on PIM$")
    public void i_clicked_on_PIM() {
        addEmp = new AMDEmployee();
        addEmp = new AMDEmployee();
        CommonMethods.click(addEmp.pimlink);

    }

    @When("^I navigated to the Add Employee Page$")
    public void i_navigated_to_the_Add_Employee_Page() {

        CommonMethods.click(addEmp.addEmployee);
    }

    @When("^I provide the first name \"([^\"]*)\" , middle name \"([^\"]*)\" and last name \"([^\"]*)\" of the employee$")
    public void i_provide_the_first_name_middle_name_and_last_name_of_the_employee(String fName, String mName,
            String lName) throws InterruptedException {

        empFullName = fName + " " + mName + " " + lName;
        CommonMethods.enterValue(addEmp.firstname, fName);
        CommonMethods.enterValue(addEmp.middlename, mName);
        CommonMethods.enterValue(addEmp.lastname, lName);
        Thread.sleep(3000);
        CommonMethods.click(addEmp.save);

    }

    @Then("^I successfully added an employee$")
    public void i_successfully_added_an_employee() {

        String name = addEmp.verifyName.getText();

        System.out.println(name);
        Assert.assertEquals(empFullName, name);
    }

    @When("^I navigated to the Employee List Page$")
    public void i_navigated_to_the_Employee_List_Page() throws InterruptedException {

        CommonMethods.click(addEmp.EmployeeList);

    }

    @When("^I search for an added employee \"([^\"]*)\"$")
    public void i_search_for_an_added_employee(String name) throws InterruptedException {

        List<WebElement> rows = addEmp.Table;

        for (int i = 1; i <= rows.size(); i++) {
            String rowdata = rows.get(i).getText();
            if (rowdata.contains(name)) {
                List<WebElement> cells = rows.get(i).findElements(By.tagName("a"));
                for (WebElement cell : cells) {
                    cell.getText();
                    if (cell.getText().contains(name)) {

                    }
                    cell.click();
                    Thread.sleep(6000);
                    break;

                }
            }
        }
    }

    @Then("^I navigated to the employee profile$")
    public void i_navigated_to_the_employee_profile() {

        CommonMethods.click(addEmp.edit);
    }

    @Then("^I can edit Employee information$")
    public void i_can_edit_Employee_information() {

        CommonMethods.click(addEmp.gender);
        CommonMethods.DropDown(addEmp.nationality, "Afghan");
        CommonMethods.click(addEmp.saveEdit);
    }

    @When("^I search for an added employee \"([^\"]*)\" to delete$")
    public void i_search_for_an_added_employee_to_delete(String name) throws Throwable {

        List<WebElement> rows = addEmp.Table;

        for (int i = 1; i <= rows.size(); i++) {
            String rowdata = rows.get(i).getText();
            if (rowdata.contains(name)) {
                List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    cell.getText();
                    if (cell.getText().contains(name)) {
                    	
                    }
                    cell.click();
                    CommonMethods.click(addEmp.delete);
                    CommonMethods.click(addEmp.okBtn);
                    Thread.sleep(2000);
                    break;
                    
                }
            }
        }
    }

    @Then("^I should be able to delete that employee$")
    public void i_should_be_able_to_delete_that_employee() throws InterruptedException {
    	
        Thread.sleep(3000);

        
    }

}