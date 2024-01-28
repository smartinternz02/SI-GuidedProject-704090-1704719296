package com.qa.login_booking
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.common.WebUiCommonHelper

import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select


import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class customFunctions {

	@Keyword
	def login(){
		WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')
		WebUI.maximizeWindow()
		WebUI.click(findTestObject('Object Repository/CURA_Healthcare_Login_OR/Page_CURA Healthcare Service/a_Make Appointment'))
		WebUI.setText(findTestObject('Object Repository/CURA_Healthcare_Login_OR/Page_CURA Healthcare Service/input_username'),'John Doe')
		WebUI.setEncryptedText(findTestObject('Object Repository/CURA_Healthcare_Login_OR/Page_CURA Healthcare Service/input_password'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')

		WebUI.click(findTestObject('Object Repository/CURA_Healthcare_Login_OR/Page_CURA Healthcare Service/button_Login'))

		WebUI.verifyElementPresent(findTestObject('CURA_Healthcare_Login_OR/Page_CURA Healthcare Service/h2_Make Appointment'), 0)
	}

	@Keyword
	def booking() {
		WebUI.selectOptionByValue(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/select_Tokyo CURA Healthcare Center        _5b4107'),
				'Seoul CURA Healthcare Center', true)

		WebUI.click(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/input_hospital_readmission'))
		WebUI.click(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/input_programs'))

		WebUI.click(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/span_glyphicon glyphicon-calendar'))

		WebUI.click(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/td_31'))

		WebUI.setText(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/textarea_comment'),
				'Fever and Dry Cough')

		WebUI.click(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/button_Book Appointment'))
	}

	@Keyword
	def verifyDropDownOptionExists(TestObject dropdownObject, String expectedOption) {
		boolean optionExists = false

		WebElement dropdownElement = WebUiCommonHelper.findWebElement(dropdownObject, 20)

		Select dropdown = new Select(dropdownElement)

		for (WebElement optionElement : dropdown.getOptions()) {
			if (optionElement.getText().equals(expectedOption)) {
				System.out.println("The expected option exists in the dropdown.")
				optionExists = true
			} else {
				System.out.println("The expected option does not exist in the dropdown.")
			}
		}

		return optionExists
	}
}