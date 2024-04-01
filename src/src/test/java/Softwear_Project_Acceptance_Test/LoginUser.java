package Softwear_Project_Acceptance_Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Application;
import org.example.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginUser {
    private User user; // Creating an instance of the User class
    private Application application; // Creating an instance of the Application class
    private String username;
    private String password;

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
         user = new User();
    }

    @Given("a list of users <User>")
    public void a_list_of_users_user() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The user enters a valid username sameh and password {int} are checked")
    public void the_user_enters_a_valid_username_and_password(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        this.username = username;
        this.password = password;
        user.setUsername(username);
        user.setPassword(password);
    }

    @Then("the user is found and logged in")
    public void the_user_is_found_and_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        String expectedAnswer = String.valueOf(true);
        String actualAnswer = String.valueOf(application.checkUser(username, password));
        assertTrue(expectedAnswer.equals(actualAnswer));
    }

    @Then("the user should be logged in successfully and show The User is  found   Successful Login")
    public void the_user_should_be_logged_in_successfully_and_show_the_user_is_not_found_successful_login() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("The User is  found" +
                "Successful Login"); // Displaying the success message
    }

    @When("The user enters a valid username sameh and incorrect password {string} in WorngPassword are checked")
    public void the_user_enters_a_valid_username_sameh_and_incorrect_password_in_worng_password_are_checked(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        user.setUsername(username);

        // Convert password to a boolean value
        boolean isPasswordValid = password != null && !password.isEmpty();

        // Negate the boolean value to create an incorrect password scenario
        boolean incorrectPassword = !isPasswordValid;

        // Convert the boolean value back to string
        String incorrectPasswordString = String.valueOf(incorrectPassword);

        user.setPassword(incorrectPasswordString);
    }

    @Then("the user is notfound and logged in")
    public void the_user_is_notfound_and_logged_in() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        String expectedAnswer = String.valueOf(false);
        String actualAnswer = String.valueOf(application.checkUser(username, password));
        assertFalse(expectedAnswer.equals(actualAnswer));
    }

    @Then("The user should see an error message indicating incorrect password in The User is not found   incorrect password")
    public void the_user_should_see_an_error_message_indicating_incorrect_password_in_the_user_is_not_found_incorrect_password() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("The User is not found" +
                "incorrect password"); // Displaying the not success message
    }

    @When("The user enters a nonexistent username nonexistent User Name and password {string} in {int} are checked")
    public void the_user_enters_a_nonexistent_username_nonexistent_user_name_and_password_in_are_checked(String string, Integer int1) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
       user.setPassword(password);

        // Convert password to a boolean value
        boolean isusernameValid = username != null && !username.isEmpty();

        // Negate the boolean value to create an incorrect password scenario
        boolean incorrectusername = !isusernameValid;

        // Convert the boolean value back to string
        String incorrectusernameString = String.valueOf(incorrectusername);

        user.setPassword(incorrectusernameString);
    }

    @Then("The user should see an error message indicating invalid username in The User is not found   invalid username")
    public void the_user_should_see_an_error_message_indicating_invalid_username_in_the_user_is_not_found_invalid_username() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("The User is not found" +
                "invalid username"); // Displaying the not success message
    }



    @When("the user enters a valid username sameh and leaves the password field blank in  are checked")
    public void the_user_enters_a_valid_username_sameh_and_leaves_the_password_field_blank_in_are_checked() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        user.setUsername(username);
        user.setPassword(null);
    }

//    @Then("clicks the login button")
//    public void clicks_the_login_button() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

    @Then("the user should see an error message indicating the password is required in The User is not found   password is required")
    public void the_user_should_see_an_error_message_indicating_the_password_is_required_in_the_user_is_not_found_password_is_required() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("The User is not found " +
                "password is required"); // Displaying the not success message
    }

    @When("the user leaves the username field blank in   and enters a valid password {int} are checked")
    public void the_user_leaves_the_username_field_blank_in_and_enters_a_valid_password_are_checked(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        user.setUsername(null);
        user.setPassword(password);
    }

    @Then("the user should see an error message indicating the username is required in The User is not found   username is required")
    public void the_user_should_see_an_error_message_indicating_the_username_is_required_in_the_user_is_not_found_username_is_required() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("The User is not found " +
                "username is required"); // Displaying the not success message
    }
}
