package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.test.MoreAsserts.assertNotEmpty;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;


/**
 * Test fetching jokes
 */
@RunWith(AndroidJUnit4.class)
public class FetchJokesTest implements EndpointsAsyncTask.JokesTaskResponse {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void async_task_non_empty() {
        // According to Espresso documentation test should wait for AsyncTask to finish
        // but turns out that espresso does wait but only if there is a view interaction
        // https://stackoverflow.com/questions/42277000/espresso-does-not-wait-for-asynctask-to-finish
        // so do this dummy click just to make sure Espresso waits for AsyncTask
        onView(withId(R.id.content_fragment)).perform(click());

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.setJokesTaskResponse(this);
        endpointsAsyncTask.execute(activityTestRule.getActivity());
    }

    @Override
    public void onFinish(String jokeResult) {
        // get asynctask result and check it non-empty

        assertNotNull(jokeResult);
        assertTrue(!jokeResult.isEmpty());
    }
}
