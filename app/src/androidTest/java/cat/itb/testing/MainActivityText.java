package cat.itb.testing;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityText {
    private final String USER_TO_BE_TYPED = "david", PASS_TO_BE_TYPED = "1234";
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void viewsAreDisplayedCorrectly() {
        onView(withId(R.id.textViewTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.theButton)).check(matches(isDisplayed()));
    }

    @Test
    public void textsAreCorrect() {
        onView(withId(R.id.textViewTitle)).check(matches(withText(R.string.main_activity_title)));
        onView(withId(R.id.theButton)).check(matches(withText(R.string.next)));
    }

/*    @Test
    public void buttonTextChangeOnClick() {
        onView(withId(R.id.theButton)).perform(click()).check(matches(withText(R.string.back)));
    }*/

    @Test
    public void loginFormBehaviour() {
        onView(withId(R.id.editTextUsername)).perform(typeText(USER_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText(PASS_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.theButton)).perform(click()).check(matches(withText(R.string.logged)));
    }

    @Test
    public void goesToSecondActivity() {
        onView(withId(R.id.theButton)).perform(click());
        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()));
    }

    @Test
    public void goesToSecondActivityAndBack() {
        goesToSecondActivity();
        onView(withId(R.id.buttonBackSecondActivity)).perform(click());
        onView(withId(R.id.MainActivity)).check(matches(isDisplayed()));

        goesToSecondActivity();
        pressBack();
        onView(withId(R.id.MainActivity)).check(matches(isDisplayed()));
    }

    @Test
    public void checkAllFunctionality() {
        onView(withId(R.id.editTextUsername)).perform(typeText(USER_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText(PASS_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.theButton)).perform(click());

        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewWelcomeBack)).check(matches(withText("Welcome back " + USER_TO_BE_TYPED)));
        onView(withId(R.id.buttonBackSecondActivity)).perform(click());
        onView(withId(R.id.MainActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextUsername)).check(matches(withText("")));
        onView(withId(R.id.editTextPassword)).check(matches(withText("")));

    }
}
