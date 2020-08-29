package stepDefs;


import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookApiStepDef {
    private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
    private static final String USERNAME = "TOOLSQA-Test";
    private static final String PASSWORD = "Test@@123";
    private static final String BASE_URL = "https://bookstore.toolsqa.com";

    private static String token;
    private static Response response;
    private static String jsonString;
    private static String bookId;


    @Given("I am an authorized user")
    public void iAmAnAuthorizedUser() {

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/GenerateToken");

        String jsonString = response.asString();
        token = JsonPath.from(jsonString).get("token");
        System.out.println(token + " is the token");
    }

    @Given("A list of books are available")
    public void listOfBooksAreAvailable() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/BookStore/v1/Books");

        jsonString = response.asString();
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);

        bookId = books.get(0).get("isbn");
    }

    @When("^I Search the ISBN \"([^\"]*)\" in the list$")
    public void i_Search_the_ISBN_in_the_list(String param) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
       response = request.queryParam("ISBN", param).get("/BookStore/v1/Book");
    }


    @Then("^Status Code is \"([^\"]*)\"$")
    public void bookIsAdded(String statusCode) {
        Assert.assertEquals(Integer.parseInt(statusCode), response.getStatusCode());
    }
    @Then("^Title of book is \"([^\"]*)\"$")
    public void title_of_book_is(String bookTitle) {

        jsonString = response.asString();
        String title = JsonPath.from(jsonString).get("title");
        Assert.assertEquals(bookTitle, title);
    }
}