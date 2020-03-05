
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
public class HappyTeamsTest 
{   

    @Rule
    public TestRule watcher =
    new TestWatcher() {
    protected void starting(Description description) {
        System.out.println("Starting test: " + description.getMethodName());
        }
    };


    HappyTeams app;
    
    @Before
    public void initialize() {
    app = new HappyTeams();
    }


    // TEST CASES ASSERT THAT DELETE SELF FROM PREFERENCE WORKS
    // @Test
    // public void AbnormalPreferenceFixTest1(){
    //     String[] answer = {"0","0","0"};
    //     app.RemoveSelf(app.E,3);
    //     for (int i=0; i<3; i++){
    //         assertEquals(answer[i], app.E[i]);
    //     }
    // }

    // @Test
    // public void AbnormalPreferenceFixTest2(){
    //     String[] answer = {"0","3","4"};
    //     app.RemoveSelf(app.A,3);
    //     for (int i=0; i<3; i++){
    //         assertEquals(answer[i], app.A[i]);
    //     }
    // }

    // @Test
    // public void AbnormalPreferenceFixTest3(){
    //     String[] answer = {"0","0","4"};
    //     app.RemoveSelf(app.B,3);
    //     for (int i=0; i<3; i++){
    //         assertEquals(answer[i], app.B[i]);
    //     }
    // }

    // @Test
    // public void AbnormalPreferenceFixTest4(){
    //     String[] answer = {"0","2","0"};
    //     app.RemoveSelf(app.C,3);
    //     for (int i=0; i<3; i++){
    //         assertEquals(answer[i], app.C[i]);
    //     }
    // }


    // @Test
    // public void AbnormalPreferenceFixTest5(){
    //     String[] answer = {"0","2","3"};
    //     app.RemoveSelf(app.D,3);
    //     for (int i=0; i<3; i++){
    //         assertEquals(answer[i], app.D[i]);
    //     }
    // }

    // @Test
    // public void AbnormalPreferenceFixTest6(){
    //     String[] answer = {"0","2","1"};
    //     app.RemoveSelf(app.F,3);
    //     for (int i=0; i<3; i++){
    //         assertEquals(answer[i], app.F[i]);
    //     }
    // }


    // @Test
    // public void AbnormalPreferenceFixTest2(){
    //     String[] answer = {"5","0","0"};
    //     app.RemoveDuplicate(app.E,3);
    //     for (int i=0; i<3; i++){
    //         assertEquals(answer[i], app.F[i]);
    //     }
    // }


//     @Test
//     public void GroupAmounttest1(){
//         assertEquals(3, app.AmountofGroups(2));
//     }

//     @Test
//     public void GroupAmounttest2(){
//         assertEquals(2, app.AmountofGroups(3));
//     }

//     @Test
//     public void GroupNumbertest(){
//         int case1 = app.ReturnGroupNumber(1,2);
//         int case2 = app.ReturnGroupNumber(3,2);
//         int case3 = app.ReturnGroupNumber(2,1);
//         int case4 = app.ReturnGroupNumber(3,3);
//         assertEquals (1, case1);
//         assertEquals (2, case2);
//         assertEquals (3, case3);
//         assertEquals (2, case4);

//     }


//     @Test
//     public void GroupNumbertestcase1(){
//         String[] case1 = app.ReturnGroupMember(1,2);
//         String[] answer = {"1","2"};
//         for (int i = 0; i<2; i++){
//             assertEquals(answer[i],case1[i]);
//         }
//     }


//     @Test
//     public void GroupNumbertestcase2(){
//         String[] case1 = app.ReturnGroupMember(2,2);
//         String[] answer = {"3","4"};
//         for (int i = 0; i<2; i++){
//             assertEquals(answer[i],case1[i]);
//         }
//     }



//     @Test
//     public void GroupNumbertestcase3(){
//         String[] case1 = app.ReturnGroupMember(3,1);
//         String[] answer = {"4"};
//             assertEquals(answer[0],case1[0]);
//     }

//     @Test
//     public void GroupNumbertestcase4(){
//         String[] case1 = app.ReturnGroupMember(5,2);
//         String[] answer = {"5","6"};
//         for (int i = 0; i<2; i++){
//             assertEquals(answer[i],case1[i]);
//         }
//     }


//     //test first person in group 1, A's happiness
//     @Test
//     public void Happinesstest1(){
//         int case1 = app.PersonalHappiness(0,2,3);
//         assertEquals (3, case1);
//     }


//     @Test
//     public void Happinesstest2(){
//         int case1 = app.PersonalHappiness(2,2,3);
//         assertEquals (1, case1);
//     }

//     @Test
//     public void Happinesstest3(){
//         int case1 = app.PersonalHappiness(3,2,3);
//         assertEquals (1, case1);
//     }



//     @Test
//     public void Happinesstest4(){
//         int case1 = app.PersonalHappiness(2,1,3);
//         assertEquals (0, case1);
//     }

//     // test personal happiness with not choice
//     @Test
//     public void Happinesstest5(){
//         int case1 = app.PersonalHappiness(5,2,3);
//         assertEquals (3, case1);
//     }

//     // test on "Bug" that put self into preference list
//     @Test
//     public void Happinesstest6(){
//         int case1 = app.PersonalHappiness(4,2,3);
//         assertEquals (1, case1);
//     }


//     // if input is empty
//     @Test
//     public void Happinesstest7(){
//         int case1 = app.PersonalHappiness(1,2,3);
//         assertEquals (1, case1);
//     }


    
//     @Test
//     public void TeamHappinesstest1(){
//         int case1 = app.TeamHappiness(0,2,3);
//         assertEquals (4, case1);
//     }

//     @Test
//     public void TeamHappinesstest2(){
//         int case1 = app.TeamHappiness(2,2,3);
//         assertEquals (2, case1);
//     }

//     @Test
//     public void TeamHappinesstest3(){
//         int case1 = app.TeamHappiness(4,2,3);
//         assertEquals (4, case1);
//     }


//     @Test
//     public void OverallHappinesstest(){
//         int case1 = app.OverallHappiness(2,3);
//         assertEquals (10, case1);
//     }


//     @Test
//     public void RandomNumTest1(){
//         double case1 = app.getRandom(2,6);
//         assertTrue (case1>=2);
//         assertTrue (case1<=6);
//         assertEquals (0, case1 % 1, 0.001);
//     }



//     @Test
//     public void SwapLogicTest(){
//         double case1 = app.OverallHappiness(2,3);
//         app.Swap(2,3);
//         double case2 = app.OverallHappiness(2,3);
//         assertTrue (case2 >= case1);
//     }
    

// }













    