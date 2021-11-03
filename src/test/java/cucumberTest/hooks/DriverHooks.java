//package cucumberTest.hooks;
//
////import io.cucumber.java.After;
////import io.cucumber.java.Before;
////import driver.Driver;
//
//public class DriverHooks {
//    //
////    @Before
////    public void setUpDriver() {
////       DriverManager.getDriver();
////    }
////
////    @After
////    public void quitDriver() {
////        DriverManager.quitDriver();
////    }
////  Driver driver;
////
////    @Before
////    public void setUp() {
////        String browserName = getParameter("browser");
////        driver = new Driver(browserName);
////    }
////
////    @After
////    public void tearDown() {
////        driver.quit();
////    }
////
////    private String getParameter(String name) {
////        String value = System.getProperty(name);
////        if (value == null)
////            throw new RuntimeException(name + " is not a parameter!");
////
////        if (value.isEmpty())
////            throw new RuntimeException(name + " is empty!");
////
////        return value;
////    }
//}