package com.naveen.learn.springdemo.common;
// Lets say this class is from some third-party
// We cannot make this class as @Component as this class is owned by Thrid-party
// Now we have to make this bean available to Spring
//This can be achieved using @Bean above the method
// Check SportConfig for implementation


public class SwimCoach implements  Coach{

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters strait for WarmUp!!!";
    }
}
