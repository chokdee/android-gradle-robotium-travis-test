package pl.mg6.agrtt;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

public class TestActivityTests extends ActivityInstrumentationTestCase2<TestActivity> {

    public void testCanEnterTextAndPressButton() {
        solo.enterText(0, "my login");
        solo.enterText(1, "my password");
        solo.clickOnText("New Button");
    }

    private Solo solo;

    public TestActivityTests() {
        super(TestActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }
}
