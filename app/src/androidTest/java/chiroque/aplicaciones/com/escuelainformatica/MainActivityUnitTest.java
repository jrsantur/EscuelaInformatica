package chiroque.aplicaciones.com.escuelainformatica;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;

/**
 * Created by OP on 23/06/2016.
 */
public class MainActivityUnitTest extends ActivityUnitTestCase<MainActivity> {

    private MainActivity activity;

    public MainActivityUnitTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

    }

    @SmallTest
    public void testaclickactivobotonMatem(){
        activity=new MainActivity();
        Button btnmate=(Button)activity.findViewById(R.id.btnOpenMatematicas);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
