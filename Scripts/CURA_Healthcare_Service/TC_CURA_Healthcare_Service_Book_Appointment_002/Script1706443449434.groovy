import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'com.qa.login_booking.customFunctions.login'()

WebUI.selectOptionByValue(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/select_Tokyo CURA Healthcare Center        _5b4107'), 
    'Seoul CURA Healthcare Center', true)

CustomKeywords.'com.qa.login_booking.customFunctions.verifyDropDownOptionExists'(findTestObject('CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/select_Tokyo CURA Healthcare Center        _5b4107'), 
    'Hongkong CURA Healthcare Center')

WebUI.click(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/input_hospital_readmission'))

WebUI.verifyElementChecked(findTestObject('CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/input_hospital_readmission'), 
    0)

WebUI.verifyElementClickable(findTestObject('CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/input_programs'))

WebUI.click(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/input_programs'))

WebUI.click(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/span_glyphicon glyphicon-calendar'))

WebUI.click(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/td_31'))

WebUI.setText(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/textarea_comment'), 
    'Fever and Dry Cough')

WebUI.click(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/button_Book Appointment'))

WebUI.verifyCheckpoint(findCheckpoint('Checkpoints/Checkpoint_CURA_Test_Data/CURA_AppointmentConfirmation_Facility_Testdata_checkpoint'), 
    false)

WebUI.verifyElementPresent(findTestObject('Object Repository/CURA_Healthcare_Book Appointment_OR/Page_CURA Healthcare Service/h2_Appointment Confirmation'), 
    0)

WebUI.closeBrowser()

