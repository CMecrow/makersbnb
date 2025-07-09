package com.makers.makersbnb;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TermsAndConditionsTest {
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
    public void showTermsAndConditions() {
        page.navigate("http://localhost:8080/termsandconditions");
        Locator h1 = page.locator("h1");
        assertThat(h1).containsText("Coming soon! In the meantime, please behave yourselves.");
    }
}
