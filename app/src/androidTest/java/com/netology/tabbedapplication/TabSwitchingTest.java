package com.netology.tabbedapplication;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TabSwitchingTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void tabSwitchingTest() {
        // Нажимаем на TAB 2
        ViewInteraction tab2 = onView(
                allOf(withText("TAB 2"), isDisplayed()));
        tab2.perform(click());

        // Проверяем, что текст сменился на Page: 2
        ViewInteraction text2 = onView(
                allOf(withText("Page: 2"), isDisplayed()));
        text2.check(matches(isDisplayed()));

        // Нажимаем на TAB 1
        ViewInteraction tab1 = onView(
                allOf(withText("TAB 1"), isDisplayed()));
        tab1.perform(click());

        // Проверяем, что текст сменился на Page: 1
        ViewInteraction text1 = onView(
                allOf(withText("Page: 1"), isDisplayed()));
        text1.check(matches(isDisplayed()));
    }
}