package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.*;
import org.junit.Test;
import org.junit.Rule;

import org.junit.runner.Description;

import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    App app;
    
    @Before
    public void initialize() {
    app = new App();
    }



    @Test
    public void Team1_positiontest(){
        for (int i = 0; i<3; i++){

            assertTrue(app.Students[i] == "Mike" || app.Students[i] == "Ben" || app.Students[i] == "Sam");

        }
    }

    @Test
    public void Team2_positiontest(){
        for (int i = 3; i<6; i++){

            assertTrue(app.Students[i] == "George" || app.Students[i] == "James" || app.Students[i] == "Tanner");

        }
    }


    @Test
    public void Team3_positiontest(){
        for (int i = 6; i<9; i++){

            assertTrue(app.Students[i] == "Reeves" || app.Students[i] == "Homer" || app.Students[i] == "John");

        }
    }

    @Test
    public void Team4_positiontest(){
        for (int i = 9; i<12; i++){

            assertTrue(app.Students[i] == "Simon" || app.Students[i] == "Adam" || app.Students[i] == "Smith");

        }
    }

    @Test
    public void Team5_positiontest(){
        for (int i = 12; i<14; i++){

            assertTrue(app.Students[i] == "Jacob" || app.Students[i] == "Josh" );

        }
    }

}
