package com.madonasyombua.bottomnavigationbarsample

import androidx.activity.compose.setContent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.madonasyombua.bottomnavigationbarsample.ui.theme.BottomNavigationBarSampleTheme
import org.junit.Before
import org.junit.Rule

class MainActivityTest {
    @get:Rule
    val composeRuleTest = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp(){
        initCompose()
    }



    fun initCompose(){
        composeRuleTest.activity.setContent{
            BottomNavigationBarSampleTheme {
                AppScreen()
            }
        }
    }
}