package com.tmb.SeleniumConcepts;


import org.testng.annotations.Test;
import java.lang.reflect.Method;
//Practicing reflections class

public class flection {

    @Test
    public void sampleTest() {
        System.out.println("This is a sample test.");
    }

    public static void main(String[] args) throws Exception {
        // Get the Class object for the class containing the test method
        Class clazz = flection.class;
       
     

        // Get all methods declared in the class
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            // Check if the method is annotated with @Test
            if (method.isAnnotationPresent(Test.class)) {
                System.out.println("Found TestNG test method: " + method.getName());

                // Invoke the method (if needed)
              //  flection instance = new flection();
                //method.invoke(instance);
            }
        }
    }
}
