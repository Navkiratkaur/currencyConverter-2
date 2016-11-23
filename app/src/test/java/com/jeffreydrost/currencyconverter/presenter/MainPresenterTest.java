package com.jeffreydrost.currencyconverter.presenter;

import com.jeffreydrost.currencyconverter.BuildConfig;
import com.jeffreydrost.currencyconverter.view.MainView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainPresenterTest {

    @Mock
    MainView view;

    @InjectMocks
    MainPresenter presenter;

    @Before
    public void setUpMockito() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDownMockito() {
        Mockito.validateMockitoUsage();
    }

    @Test
    public void testIsDollarInputInvalid() {
        when(view.getDollars()).thenReturn("");
        assertTrue(presenter.isDollarInputInvalid());
    }

    @Test
    public void testIsDollarInputValid() {
        when(view.getDollars()).thenReturn("10");
        assertFalse(presenter.isDollarInputInvalid());
    }
}
