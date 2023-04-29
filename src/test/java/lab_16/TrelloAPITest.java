package lab_16;


import lab_14.AllureListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Listeners({AllureListener.class})
public class TrelloAPITest {


    Properties properties = new Properties();
    String trelloKey;
    String trelloToken;
    @BeforeTest
            void initProperty() throws IOException {
        properties.load(new FileReader(new File("src\\main\\resources\\aplication.properties")));
         trelloKey = properties.getProperty("trello.key");
         trelloToken = properties.getProperty("trello.token");
    }


    @Test
    void crudRestAssureTest() {


        String AT_lab15 = UUID.randomUUID().toString().substring(2,10);

        String boardId=given()
                .contentType("application/json")
                .accept("application/json")
                .log().all().when().post("https://api.trello.com/1/boards/?name="+AT_lab15+"&key="+trelloKey+"&token="+trelloToken+"")
                .then().assertThat().statusCode(200).and().assertThat()
                .body("name", equalTo(AT_lab15))
                .extract().jsonPath().getString("id");




        String Mylist = UUID.randomUUID().toString().substring(2,10);
        String ListId=given()
                .contentType("application/json")
                .accept("application/json")
                .log().all().when()
                .post("https://api.trello.com/1/lists?name="+Mylist+"&idBoard="+boardId+"&key="+trelloKey+"&token="+trelloToken+"")
                .then().assertThat().statusCode(200).and().assertThat()
                .body("name", equalTo(Mylist))
                .extract().jsonPath().getString("id");


        String AddCard = UUID.randomUUID().toString().substring(2,10);
        String IdCard=given()
                .contentType("application/json")
                .accept("application/json")
                .log().all().when()
                .post("https://api.trello.com/1/cards?name="+AddCard+"&idList="+ListId+"&key="+trelloKey+"&token="+trelloToken+"")
                .then().assertThat().statusCode(200).and().assertThat()
                .body("name", equalTo(AddCard))
                .extract().jsonPath().getString("id");


        String CheckList = UUID.randomUUID().toString().substring(2,10);
                String CheckListId=given()
                .contentType("application/json")
                .accept("application/json")
                .log().all().when()
                .post("https://api.trello.com/1/checklists?name="+CheckList+"&idCard="+IdCard+"&key="+trelloKey+"&token="+trelloToken+"")
                .then().assertThat().statusCode(200).and().assertThat()
                .body("name", equalTo(CheckList))
                .extract().jsonPath().getString("id");



        given()
                .contentType("application/json")
                .accept("application/json")
                .log().all().when()
                .delete("https://api.trello.com/1/checklists/"+CheckListId+"?key="+trelloKey+"&token="+trelloToken+"")
                .then().assertThat().statusCode(200).and().assertThat()
                .body("value", equalTo(null));


    }



    @Test
    void crudAppClientTest() throws IOException, URISyntaxException, InterruptedException {


        String AT_lab15 = UUID.randomUUID().toString().substring(2,10);

        HttpRequest createBoardRequest= HttpRequest.newBuilder()
                .header("accept","application/json")
                .uri(new URL("https://api.trello.com/1/boards/" +
                        "?name="+AT_lab15+"&key="+trelloKey+"&token="+trelloToken+"").toURI())
                .POST(HttpRequest.BodyPublishers.ofString("",StandardCharsets.UTF_8)).build();

        HttpResponse createBoardResponse = HttpClient.newBuilder().build().send(createBoardRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(createBoardResponse.statusCode(), 200);

//        String boardId=given()
//                .contentType("application/json")
//                .accept("application/json")
//                .log().all().when().post("https://api.trello.com/1/boards/?name="+AT_lab15+"&key="+trelloKey+"&token="+trelloToken+"")
//                .then().assertThat().statusCode(200).and().assertThat()
//                .body("name", equalTo(AT_lab15))
//                .extract().jsonPath().getString("id");
//
//
//
//
//        String Mylist = UUID.randomUUID().toString().substring(2,10);
//        String ListId=given()
//                .contentType("application/json")
//                .accept("application/json")
//                .log().all().when()
//                .post("https://api.trello.com/1/lists?name="+Mylist+"&idBoard="+boardId+"&key="+trelloKey+"&token="+trelloToken+"")
//                .then().assertThat().statusCode(200).and().assertThat()
//                .body("name", equalTo(Mylist))
//                .extract().jsonPath().getString("id");
//
//
//        String AddCard = UUID.randomUUID().toString().substring(2,10);
//        String IdCard=given()
//                .contentType("application/json")
//                .accept("application/json")
//                .log().all().when()
//                .post("https://api.trello.com/1/cards?name="+AddCard+"&idList="+ListId+"&key="+trelloKey+"&token="+trelloToken+"")
//                .then().assertThat().statusCode(200).and().assertThat()
//                .body("name", equalTo(AddCard))
//                .extract().jsonPath().getString("id");
//
//
//        String CheckList = UUID.randomUUID().toString().substring(2,10);
//        String CheckListId=given()
//                .contentType("application/json")
//                .accept("application/json")
//                .log().all().when()
//                .post("https://api.trello.com/1/checklists?name="+CheckList+"&idCard="+IdCard+"&key="+trelloKey+"&token="+trelloToken+"")
//                .then().assertThat().statusCode(200).and().assertThat()
//                .body("name", equalTo(CheckList))
//                .extract().jsonPath().getString("id");
//
//
//
//        given()
//                .contentType("application/json")
//                .accept("application/json")
//                .log().all().when()
//                .delete("https://api.trello.com/1/checklists/"+CheckListId+"?key="+trelloKey+"&token="+trelloToken+"")
//                .then().assertThat().statusCode(200).and().assertThat()
//                .body("value", equalTo(null));
//
//
   }


}







