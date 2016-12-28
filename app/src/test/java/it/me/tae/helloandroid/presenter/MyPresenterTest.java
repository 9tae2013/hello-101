package it.me.tae.helloandroid.presenter;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class MyPresenterTest {
    @Mock
    MyPresenter.View view;

    private MyPresenter presenter;

    private String input;
    private String expect;

    public MyPresenterTest(String input, String expect) {
        this.input = input;
        this.expect = expect;
    }

    @Parameterized.Parameters
    public static Collection inputTexts() {
        return Arrays.asList(new Object[][] {
                { "2 + 3", "5" },
                { "3 * 2", "6" },
                { "3.4 * 2", "6.8" },
                { "2.22 / 2", "1.11" },
                { "2 - 3", "- 1" }
        });
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        presenter = new MyPresenter();
        presenter.attachView(view);
    }

    @Test
    public void test_calculate() {
        // given
        when(view.getInputTextToCalculate()).thenReturn(input);

        // when
        presenter.calculate();

        // then
        verify(view).onCalculateSuccess(expect);
    }
}
