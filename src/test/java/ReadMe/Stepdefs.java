package ReadMe;

import ReadMe.ui.UI;
import ReadMe.io.IOStub;
import ReadMe.dao.InMemoryDao;
import ReadMe.domain.Article;
import ReadMe.domain.Blog;
import ReadMe.domain.Book;
import ReadMe.domain.News;
import ReadMe.domain.Video;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.*;

public class Stepdefs {

    UI ui;
    IOStub io;
    InMemoryDao dao = new InMemoryDao();
    String[] inputLinesAdd = new String[2];
    String[] inputLinesList = new String[5];
    String[] inputLinesAll = new String[5];
    String[] inputLinesListType = new String[4];

    String[] inputLinesVideo = new String[10];
    String[] inputLinesBook = new String[10];
    String[] inputLinesNews = new String[10];
    String[] inputLinesArticle = new String[10];
    String[] inputLinesBlog = new String[10];

    String[] inputLinesVideoType = new String[10];
    String[] inputLinesBookType = new String[10];
    String[] inputLinesNewsType = new String[10];
    String[] inputLinesArticleType = new String[10];
    String[] inputLinesBlogType = new String[10];

    String[] inputLinesSingle = new String[10];
    String[] inputLinesSingle2 = new String[10];
    
    String[] inputLinesMark = new String[10];
    String[] inputLinesMarkFail = new String[10];

    //for video: Feature: A new tip can be added if proper properties are given
    @Given("^command \"([^\"]*)\" add new readtip is selected and command \"([^\"]*)\" video is selected$")
    public void command_add_new_readtip_is_selected_and_command_video_is_selected(String arg1, String arg2) throws Throwable {
        inputLinesVideo[0] = "a";
        inputLinesVideo[1] = "1";

    }

    //for video: Feature: A new tip can be added if proper properties are given
    @When("^Title \"([^\"]*)\" and Author \"([^\"]*)\" and Link \"([^\"]*)\" and Description \"([^\"]*)\" and Year published \"([^\"]*)\" are input$")
    public void title_and_Author_and_Link_and_Description_and_Year_published_are_input(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        inputLinesVideo[2] = "title";
        inputLinesVideo[3] = "author";
        inputLinesVideo[4] = "www";
        inputLinesVideo[5] = "desc";
        inputLinesVideo[6] = "2000";
        inputLinesVideo[7] = "q";
    }

    //for video: Feature: A new tip can be added if proper properties are given
    @Then("^a new videotip is added$")
    public void a_new_videotip_is_added() throws Throwable {
        io = new IOStub(inputLinesVideo);
        ui = new UI(io, dao);
        assertTrue(dao.getVideos().size() == 1);
        ui.run();
        assertTrue(dao.getVideos().size() == 2);
    }

    //for book: Feature: A new tip can be added if proper properties are given
    @Given("^command \"([^\"]*)\" add new readtip is selected and command \"([^\"]*)\" book is selected$")
    public void command_add_new_readtip_is_selected_and_command_book_is_selected(String arg1, String arg2) throws Throwable {
        inputLinesBook[0] = "a";
        inputLinesBook[1] = "2";
    }

    //for book: Feature: A new tip can be added if proper properties are given
    @When("^Title \"([^\"]*)\" and Author \"([^\"]*)\" and ISBN \"([^\"]*)\" and Description \"([^\"]*)\" and Year \"([^\"]*)\" are input$")
    public void title_and_Author_and_ISBN_and_Description_and_Year_are_input(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        inputLinesBook[2] = "title";
        inputLinesBook[3] = "author";
        inputLinesBook[4] = "12345";
        inputLinesBook[5] = "desc";
        inputLinesBook[6] = "2000";
        inputLinesBook[7] = "q";
    }

    //for book: Feature: A new tip can be added if proper properties are given
    @Then("^a new booktip is added$")
    public void a_new_booktip_is_added() throws Throwable {
        io = new IOStub(inputLinesBook);
        InMemoryDao daoBook = new InMemoryDao();
        ui = new UI(io, daoBook);
        ui.run();
        assertTrue(daoBook.listByType("book").contains(new Book("author", "title", "12345", "desc", 2000)));

    }

    //news: Feature: A new tip can be added if proper properties are given
    @Given("^command \"([^\"]*)\" add new readtip is selected and command \"([^\"]*)\" newstip is selected$")
    public void command_add_new_readtip_is_selected_and_command_newstip_is_selected(String arg1, String arg2) throws Throwable {
        inputLinesNews[0] = "a";
        inputLinesNews[1] = "3";
    }

    //news: Feature: A new tip can be added if proper properties are given
    @When("^Title \"([^\"]*)\" and Author \"([^\"]*)\" and link \"([^\"]*)\" and Description \"([^\"]*)\" and Publisher \"([^\"]*)\" and Year published \"([^\"]*)\" are input$")
    public void title_and_Author_and_link_and_Description_and_Publisher_and_Year_published_are_input(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
        inputLinesNews[2] = "title";
        inputLinesNews[3] = "author";
        inputLinesNews[4] = "www";
        inputLinesNews[5] = "desc";
        inputLinesNews[6] = "publisher";
        inputLinesNews[7] = "2000";
        inputLinesNews[8] = "q";
    }

    //news: Feature: A new tip can be added if proper properties are given
    @Then("^a new newstip is added$")
    public void a_new_newstip_is_added() throws Throwable {
        io = new IOStub(inputLinesNews);
        ui = new UI(io, dao);
        ui.run();
        assertTrue(dao.listByType("news").contains(new News("author", "title", "www", "desc", "publisher", 2000)));
    }

    //article: Feature: A new tip can be added if proper properties are given
    @Given("^command \"([^\"]*)\" add new readtip is selected and command \"([^\"]*)\" article is selected$")
    public void command_add_new_readtip_is_selected_and_command_article_is_selected(String arg1, String arg2) throws Throwable {
        inputLinesArticle[0] = "a";
        inputLinesArticle[1] = "4";
    }

    //article: Feature: A new tip can be added if proper properties are given
    @When("^Title \"([^\"]*)\" and Author \"([^\"]*)\" and Link \"([^\"]*)\" and Description \"([^\"]*)\" and Publisher \"([^\"]*)\" and Year \"([^\"]*)\" are input$")
    public void title_and_Author_and_Link_and_Description_and_Publisher_and_Year_are_input(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
        inputLinesArticle[2] = "title";
        inputLinesArticle[3] = "author";
        inputLinesArticle[4] = "www";
        inputLinesArticle[5] = "desc";
        inputLinesArticle[6] = "pub";
        inputLinesArticle[7] = "2000";
        inputLinesArticle[8] = "q";
    }

    //article: Feature: A new tip can be added if proper properties are given
    @Then("^a new articletip is added$")
    public void a_new_articletip_is_added() throws Throwable {
        io = new IOStub(inputLinesArticle);
        ui = new UI(io, dao);
        ui.run();
        assertTrue(dao.listByType("article").contains(new Article("author", "title", "www", "desc", "pub", 2000)));

    }

    //blog: Feature: A new tip can be added if proper properties are given
    @Given("^command \"([^\"]*)\" add new readtip is selected and command \"([^\"]*)\" blog is selected$")
    public void command_add_new_readtip_is_selected_and_command_blog_is_selected(String arg1, String arg2) throws Throwable {
        inputLinesBlog[0] = "a";
        inputLinesBlog[1] = "5";
    }

    //blog: Feature: A new tip can be added if proper properties are given
    @When("^Title \"([^\"]*)\" and Author \"([^\"]*)\" and Link \"([^\"]*)\" and Description \"([^\"]*)\" and Year \"([^\"]*)\" are input$")
    public void title_and_Author_and_Link_and_Description_and_Year_are_input(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        inputLinesBlog[2] = "title";
        inputLinesBlog[3] = "author";
        inputLinesBlog[4] = "www";
        inputLinesBlog[5] = "desc";
        inputLinesBlog[6] = "2000";
        inputLinesBlog[7] = "q";
    }

    //blog: Feature: A new tip can be added if proper properties are given
    @Then("^a new blogtip is added$")
    public void a_new_blogtip_is_added() throws Throwable {
        io = new IOStub(inputLinesBlog);
        ui = new UI(io, dao);
        ui.run();
        assertTrue(dao.listByType("blog").contains(new Blog("author", "title", "www", "desc", 2000)));
    }

    // Feature changes here ----readtip_list_all.feature-------------------------------------------------------------------------------------------------------------------------------
    //Feature: all readtiplist is printed in correct form
    @Given("^command \"([^\"]*)\" list tips is given$")
    public void command_list_tips_is_given(String arg1) throws Throwable {
        inputLinesAll[0] = "l";
        inputLinesVideoType[0] = "l";
        inputLinesBookType[0] = "l";
        inputLinesNewsType[0] = "l";
        inputLinesArticleType[0] = "l";
        inputLinesBlogType[0] = "l";

    }

    @When("^type command \"([^\"]*)\" all is input$")
    public void type_command_all_is_input(String arg1) throws Throwable {
        inputLinesAll[1] = "1";
        inputLinesAll[2] = "q";

    }

    @Then("^all readtips are printed in a table$")
    public void all_readtips_are_printed_in_a_table() throws Throwable {

        IOStub ios = new IOStub(inputLinesAll);
        InMemoryDao dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();

        assertTrue(ios.getOutputString().contains("hackerdashery"));
        assertTrue(ios.getOutputString().contains("hackerdashery1"));
        assertTrue(ios.getOutputString().contains("hackerdashery2"));
        assertTrue(ios.getOutputString().contains("hackerdashery3"));
        assertTrue(ios.getOutputString().contains("hackerdashery4"));
        assertTrue(ios.getOutputString().contains("P vs. NP and the Co"));
        assertTrue(ios.getOutputString().contains("book"));
        assertTrue(ios.getOutputString().contains("video"));
        assertTrue(ios.getOutputString().contains("blog"));
        assertTrue(ios.getOutputString().contains("news"));
        assertTrue(ios.getOutputString().contains("article"));

    }

    @Then("^table don't contain year'$")
    public void table_don_t_contain_year() throws Throwable {
        IOStub ios = new IOStub(inputLinesAll);
        InMemoryDao dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();
        assertTrue(!ios.getOutputString().contains("2014"));
    }

    // Feature: readtiplists by type are printed in correct form  ---_______________------------------------uses same given as list all
    // video
    @When("^type command \"([^\"]*)\" video is input$")
    public void type_command_video_is_input(String arg1) throws Throwable {
        inputLinesVideoType[1] = "2";
        inputLinesVideoType[2] = "q";

    }

    //video
    @Then("^videotips are printed in a table$")
    public void videotips_are_printed_in_a_table() throws Throwable {
        IOStub ios = new IOStub(inputLinesVideoType);
        dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();

        assertTrue(ios.getOutputString().contains("hackerdashery"));
        assertTrue(ios.getOutputString().contains("P vs. NP and the Co"));
        assertTrue(ios.getOutputString().contains("Video"));
    }

    //video
    @Then("^videotable does not contain year$")
    public void videotable_does_not_contain_year() throws Throwable {
        IOStub ios = new IOStub(inputLinesVideoType);
        InMemoryDao dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();
        assertTrue(!ios.getOutputString().contains("2014"));
    }

    //book
    @When("^type command \"([^\"]*)\" book is input$")
    public void type_command_book_is_input(String arg1) throws Throwable {
        inputLinesBookType[1] = "3";
        inputLinesBookType[2] = "q";

    }

    //book
    @Then("^booktips are printed in a table$")
    public void booktips_are_printed_in_a_table() throws Throwable {
        IOStub ios = new IOStub(inputLinesBookType);
        dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();

        assertTrue(ios.getOutputString().contains("hackerdashery1"));
        //assertTrue(ios.getOutputString().contains("P vs. NP and the Co"));
        assertTrue(ios.getOutputString().contains("Book"));

    }

    @Then("^booktable does not contain year$")
    public void booktable_does_not_contain_year() throws Throwable {
        IOStub ios = new IOStub(inputLinesBookType);
        InMemoryDao dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();
        assertTrue(!ios.getOutputString().contains("2014"));
    }

    //news
    @When("^type command \"([^\"]*)\" news  is input$")
    public void type_command_news_is_input(String arg1) throws Throwable {
        inputLinesNewsType[1] = "4";
        inputLinesNewsType[2] = "q";
    }

    //news
    @Then("^newstips are printed in a table$")
    public void newstips_are_printed_in_a_table() throws Throwable {

        IOStub ios = new IOStub(inputLinesNewsType);
        dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();

        assertTrue(ios.getOutputString().contains("hackerdashery2"));
        assertTrue(ios.getOutputString().contains("P vs. NP and the Co"));
        assertTrue(ios.getOutputString().contains("News"));

    }

    @Then("^newstable does not contain year$")
    public void newstable_does_not_contain_year() throws Throwable {
        IOStub ios = new IOStub(inputLinesNewsType);
        InMemoryDao dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();
        assertTrue(!ios.getOutputString().contains("2014"));
    }

    //article
    @When("^type command \"([^\"]*)\" article is input$")
    public void type_command_article_is_input(String arg1) throws Throwable {
        inputLinesArticleType[1] = "5";
        inputLinesArticleType[2] = "q";
    }

    //article
    @Then("^articletips are printed in a table$")
    public void articletips_are_printed_in_a_table() throws Throwable {
        IOStub ios = new IOStub(inputLinesArticleType);
        dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();

        assertTrue(ios.getOutputString().contains("hackerdashery3"));
        assertTrue(ios.getOutputString().contains("P vs. NP and the Co"));
        assertTrue(ios.getOutputString().contains("Article"));
    }

    @Then("^articletable does not contain year$")
    public void articletable_does_not_contain_year() throws Throwable {
        IOStub ios = new IOStub(inputLinesArticleType);
        dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();
        assertTrue(!ios.getOutputString().contains("2014"));
    }

    //blogs
    @When("^type command \"([^\"]*)\" blog is input$")
    public void type_command_blogs_is_input(String arg1) throws Throwable {
        inputLinesBlogType[1] = "6";
        inputLinesBlogType[2] = "q";
    }

    //blogs
    @Then("^blogtips are printed in a table$")
    public void blogtips_are_printed_in_a_table() throws Throwable {
        IOStub ios = new IOStub(inputLinesBlogType);
        dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();

        assertTrue(ios.getOutputString().contains("hackerdashery4"));
        assertTrue(ios.getOutputString().contains("P vs. NP and the Co"));
        assertTrue(ios.getOutputString().contains("Blog"));
    }

    @Then("^blogtable does not contain year$")
    public void blogtable_does_not_contain_year() throws Throwable {
        IOStub ios = new IOStub(inputLinesBlogType);
        dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();
        assertTrue(!ios.getOutputString().contains("2014"));
    }

    @Then("^error message :\"([^\"]*)\" is printed$")
    public void error_message_is_printed(String arg1) throws Throwable {
        IOStub ios = new IOStub(inputLinesAll);
        InMemoryDao daoEmpty = new InMemoryDao(true);
        ui = new UI(ios, daoEmpty);
        ui.run();

        assertTrue(ios.getOutputString().contains("No reading tips found."));
    }

    @When("^command \"([^\"]*)\" is chosen$")
    public void command_is_chosen(String arg1) throws Throwable {
        inputLinesSingle[0] = "l";
        inputLinesSingle[1] = "1";
        inputLinesSingle[2] = "s";
        inputLinesSingle2[0] = "l";
        inputLinesSingle2[1] = "1";
        inputLinesSingle2[2] = "s";
    }

    @When("^index \"([^\"]*)\" is chosen$")
    public void index_is_chosen(String arg1) throws Throwable {
        inputLinesSingle[3] = "1";
        inputLinesSingle[4] = "q";

    }

    @Then("^the right tip shown$")
    public void the_right_tip_shown() throws Throwable {
        Video testVideo = new Video("hackerdashery", "P vs. NP and the Computational Complexity Zoo",
                "https://www.youtube.com/watch?v=YX40hbAHx3s&frags=pl%2Cwn", "P js NP erot", 2014);
        IOStub ios = new IOStub(inputLinesSingle);
        dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();

        assertTrue(ios.getOutputString().contains(testVideo.toString()));

    }

    @When("^wrong index \"([^\"]*)\" is chosen$")
    public void wrong_index_is_chosen(String arg1) throws Throwable {
        inputLinesSingle2[3] = "100";
        inputLinesSingle2[4] = "q";
    }

    @Then("^\"([^\"]*)\" is printed$")
    public void is_printed(String arg1) throws Throwable {
        IOStub ios = new IOStub(inputLinesSingle2);
        dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();

        assertTrue(ios.getOutputString().contains("Bad index"));
    }
    
//  --------------------------- Mark as read ------------------------------------------------
    
    @Given("^all tips are shown by typing commands \"([^\"]*)\", \"([^\"]*)\"$")
    public void all_tips_are_shown_by_typing_commands(String list, String type) throws Throwable {
        inputLinesMark[0] = list;
        inputLinesMarkFail[0] = list;
        
        inputLinesMark[1] = type;
        inputLinesMarkFail[1] = type;
    }

    @When("^command \"([^\"]*)\" is input$")
    public void command_is_input(String singleAction) throws Throwable {
        inputLinesMark[2] = singleAction;
        inputLinesMarkFail[2] = singleAction;
    }

    @When("^index \"([^\"]*)\" for tip to be marked is input$")
    public void index_for_tip_to_be_marked_is_input(String index) throws Throwable {
        inputLinesMark[3] = index;
        inputLinesMarkFail[3] = index;
    }

    @Then("^the tip listed at index \"([^\"]*)\" has been marked as read$")
    public void the_tip_listed_at_index_has_been_marked_as_read(String index) throws Throwable {
        inputLinesMark[4] = "s";
        inputLinesMark[5] = index;
        inputLinesMark[6] = "q";
        
        IOStub ios = new IOStub(inputLinesMark);
        dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();
        
        assertTrue(ios.getOutputString().contains("Checked: true"));
    }

    @Then("^the input is rejected and application responds \"([^\"]*)\"$")
    public void the_input_is_rejected_and_application_responds(String error) throws Throwable {
        inputLinesMarkFail[4] = "q";
        
        IOStub ios = new IOStub(inputLinesMarkFail);
        dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();
        
        assertTrue(ios.getOutputString().contains(error));
    }
    
    @Then("^the tip listed at index \"([^\"]*)\" shows when it was marked$")
    public void the_tip_listed_at_index_shows_when_it_was_marked(String index) throws Throwable {
        inputLinesMark[4] = "s";
        inputLinesMark[5] = index;
        inputLinesMark[6] = "q";
        
        IOStub ios = new IOStub(inputLinesMark);
        dao = new InMemoryDao();
        ui = new UI(ios, dao);
        ui.run();
        
        String dateToday = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        assertTrue(ios.getOutputString().contains("Date checked: "+ dateToday));
    }

}
