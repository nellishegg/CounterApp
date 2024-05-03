package com.work.counterapp


import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    /**
    TestCase:
    //1
    0)check InitialState
    1)click IncrementButton
    2)check IncrementState

    //2
    (repeat 9)
    3)click IncrementButton
    4)check IncrementState

    //3
    5)click IncrementButton
    4)check ResetState

    //4
    6)click resetButton
    7)check InitialState

     **/

    @Test
    fun testCase() = with(CounterPage()) {
        //0
        checkInitialState()

        //1
        clickIncrementButton()
        checkIncrementState()
        activityScenarioRule.scenario.recreate()
        checkIncrementState()

        //2
        repeat(9) {
            clickIncrementButton()
            checkIncrementState()
            activityScenarioRule.scenario.recreate()
            checkIncrementState()
        }
        //3
        clickIncrementButton()
        checkResetState()
        activityScenarioRule.scenario.recreate()
        checkResetState()

        //4
        clickResetButton()
        checkInitialState()
        activityScenarioRule.scenario.recreate()
        checkInitialState()
    }
}