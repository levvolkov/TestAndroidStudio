package com.netology.mqa_lesson_2_1.ui.login;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.netology.mqa_lesson_2_1.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void loginActivityTest() {
        ViewInteraction appCompatEditText = onView(withId(R.id.username)); // Ищем какой-то визуальный компонет с id username и обращаемся к нему потому, что он уникален.
        appCompatEditText.check(matches(isDisplayed())); // Проверяем на видимость,(check-проверяет, matches-ищет, isDisplayed-проверяет что элемент видим).
        appCompatEditText.perform(replaceText("test@mail.ru"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(withId(R.id.password));
        appCompatEditText2.check(matches(isDisplayed()));
        appCompatEditText2.perform(replaceText("12345qa"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.login));
        materialButton.check(matches(isDisplayed()));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.result));
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("Welcome !test@mail.ru")));
    }
}

// Автоматически сгенерированный тест Espresso
//@Test
//public void loginActivityTest() {
//    ViewInteraction appCompatEditText = onView(
//            allOf(withId(R.id.username),
//                    childAtPosition(
//                            allOf(withId(R.id.container),
//                                    childAtPosition(
//                                            withId(android.R.id.content),
//                                            0)),
//                            0),
//                    isDisplayed()));
//    appCompatEditText.perform(replaceText("test@mail.ru"), closeSoftKeyboard());
//
//    ViewInteraction appCompatEditText2 = onView(
//            allOf(withId(R.id.password),
//                    childAtPosition(
//                            allOf(withId(R.id.container),
//                                    childAtPosition(
//                                            withId(android.R.id.content),
//                                            0)),
//                            1),
//                    isDisplayed()));
//    appCompatEditText2.perform(replaceText("12345qa"), closeSoftKeyboard());
//
//    ViewInteraction materialButton = onView(
//            allOf(withId(R.id.login), withText("Sign in or register"),
//                    childAtPosition(
//                            allOf(withId(R.id.container),
//                                    childAtPosition(
//                                            withId(android.R.id.content),
//                                            0)),
//                            2),
//                    isDisplayed()));
//    materialButton.perform(click());
//
//    ViewInteraction textView = onView(
//            allOf(withId(R.id.result), withText("Welcome !test@mail.ru"),
//                    withParent(allOf(withId(R.id.container),
//                            withParent(withId(android.R.id.content)))),
//                    isDisplayed()));
//    textView.check(matches(withText("Welcome !test@mail.ru")));
//}
//
//private static Matcher<View> childAtPosition(
//        final Matcher<View> parentMatcher, final int position) {
//
//    return new TypeSafeMatcher<View>() {
//        @Override
//        public void describeTo(Description description) {
//            description.appendText("Child at position " + position + " in parent ");
//            parentMatcher.describeTo(description);
//        }
//
//        @Override
//        public boolean matchesSafely(View view) {
//            ViewParent parent = view.getParent();
//            return parent instanceof ViewGroup && parentMatcher.matches(parent)
//                    && view.equals(((ViewGroup) parent).getChildAt(position));
//        }
//    };
//}
//}
