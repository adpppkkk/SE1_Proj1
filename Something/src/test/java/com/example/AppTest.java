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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest 
{   

    @Rule
    public TestRule watcher =
    new TestWatcher() {
    protected void starting(Description description) {
        System.out.println("Starting test: " + description.getMethodName());
        }
    };


    App app;
    
    @Before
    public void initialize() {
    app = new App();
    }



    @Test
    public void GroupNumbertest(){
        int case1 = app.ReturnGroupNumber(1,2);
        int case2 = app.ReturnGroupNumber(3,2);
        int case3 = app.ReturnGroupNumber(2,1);
        int case4 = app.ReturnGroupNumber(3,3);
        assertEquals (1, case1);
        assertEquals (2, case2);
        assertEquals (3, case3);
        assertEquals (2, case4);

    }


    @Test
    public void GroupNumbertestcase1(){
        String[] case1 = app.ReturnGroupMember(1,2);
        String[] answer = {"1","2"};
        for (int i = 0; i<2; i++){
            assertEquals(answer[i],case1[i]);
        }
    }


    @Test
    public void GroupNumbertestcase2(){
        String[] case1 = app.ReturnGroupMember(2,2);
        String[] answer = {"3","4"};
        for (int i = 0; i<2; i++){
            assertEquals(answer[i],case1[i]);
        }
    }



    @Test
    public void GroupNumbertestcase3(){
        String[] case1 = app.ReturnGroupMember(3,1);
        String[] answer = {"4"};
            assertEquals(answer[0],case1[0]);
    }


    //test first person in group 1, A's happiness
    @Test
    public void Happinesstest1(){
        int case1 = app.PersonalHappiness(0,2,3);
        assertEquals (3, case1);
    }


    @Test
    public void Happinesstest2(){
        int case1 = app.PersonalHappiness(2,2,3);
        assertEquals (1, case1);
    }

    @Test
    public void Happinesstest3(){
        int case1 = app.PersonalHappiness(3,2,3);
        assertEquals (1, case1);
    }



    @Test
    public void Happinesstest4(){
        int case1 = app.PersonalHappiness(2,1,3);
        assertEquals (0, case1);
    }

    
    @Test
    public void TeamHappinesstest1(){
        int case1 = app.TeamHappiness(0,2,3);
        assertEquals (6, case1);
    }

    @Test
    public void TeamHappinesstest2(){
        int case1 = app.TeamHappiness(2,2,3);
        assertEquals (2, case1);
    }

    @Test
    public void RandomNumTest1(){
        double case1 = app.getRandom(2,6);
        assertTrue (case1>=2);
        assertTrue (case1<=6);
        assertEquals (0, case1 % 1, 0.001);
    }

    

}