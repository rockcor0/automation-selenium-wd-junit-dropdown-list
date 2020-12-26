package com.rockcor.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RegisterTest.class, LoginTest.class, FligthsTest.class })
public class AllTests {

}
