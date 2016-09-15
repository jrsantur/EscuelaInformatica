package chiroque.aplicaciones.com.escuelainformatica;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by OP on 23/06/2016.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testButtonMatem(){
        Button btnmate=(Button)getActivity().findViewById(R.id.btnOpenMatematicas);
        assertNotNull(btnmate);
    }
    @SmallTest
    public void testTextoGeneralDeAplicacion(){
        TextView textv=(TextView)getActivity().findViewById(R.id.txtgeneralEscuelaInformatica);
        assertNotNull(textv);
        assertEquals("No son iguales","Cursos tomados en cuenta:",textv.getText().toString());
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
