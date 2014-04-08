package pl.mg6.agrtt;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.EditText;

import com.robotium.solo.Solo;

public class TestActivityTests extends ActivityInstrumentationTestCase2<TestActivity> {

    public void testCanEnterTextAndPressButton() {
        solo.enterText(0, "my login");
        solo.enterText(1, "my password");
        solo.clickOnText("New Button");
    }

    public void testCanFindViewsEnterTextAndPressButton() {
        solo.enterText((EditText) solo.getView(R.id.editText1), "my login");
        solo.enterText((EditText) solo.getView(R.id.editText2), "my password");
        try {
            solo.clickOnView(solo.getView(R.id.button));
        } catch (junit.framework.AssertionFailedError e) {
            getActivity().dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_HOME));
            solo.clickOnView(solo.getView(R.id.button));
        }
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
