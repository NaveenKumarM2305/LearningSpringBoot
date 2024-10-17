package com.naveen.mvc.model;


import com.naveen.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "required")
    @Size(min = 1, message = "required")
    private String lastName;

    @Min(value = 0,message = "Mininum number of passes should be 0")
    @Max(value=10,message="Maximum number o of passes allowed is 10")
    private Integer passes;

    @NotNull(message = "required")
@Pattern(regexp = "560\\d{3}", message = "Enter only banglore pincode")
   private String pincode;

    @CourseCode(value = "RVCE",message = "Should start with RVCE")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(@Pattern(regexp = "560\\d{3}", message = "Enter only banglore pincode") String pincode) {
        this.pincode = pincode;
    }

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "required") @Size(message = "required") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "required") @Size(message = "required") String lastName) {
        this.lastName = lastName;
    }


    public Integer getPasses() {
        return passes;
    }

    public void setPasses(@Min(value = 0, message = "Mininum number of passes should be 0") @Max(value = 10, message = "Maximum number o of passes allowed is 10") Integer passes) {
        this.passes = passes;
    }
}
