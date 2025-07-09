package com.makers.makersbnb;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class LandingPageTests {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    public void usersAreWelcomedToTheApp() {
        page.navigate("http://localhost:8080");
        Locator pageBody = page.locator("h3");
        assertThat(pageBody).containsText("spaces are waiting to be discovered");
    }

    @Test
    public void usersGivenContactEmail() {
        page.navigate("http://localhost:8080/contact");
        Locator pageBody = page.locator("body");
        assertThat(pageBody).containsText("contact@makersbnb.co.uk");
    }

    @Test
    public void usersGivenStaffList() {
        page.navigate("http://localhost:8080/team");
        Locator pageBody = page.locator("body");
        assertThat(pageBody).containsText("Toby, Katerina, Sandy");
    }

}

