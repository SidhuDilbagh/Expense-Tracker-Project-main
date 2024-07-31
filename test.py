from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

webdriver_path = r"C:\Users\dilba\Downloads\chromedriver-win64\chromedriver-win64\chromedriver.exe"
driver = webdriver.Chrome(executable_path=r"C:\Users\dilba\Downloads\chromedriver-win64\chromedriver-win64\chromedriver.exe")



def register(testName,testMail,testPassword):
    driver.get("http://localhost:3000/register")

    name_input = driver.find_element("name", "name")
    email_input = driver.find_element("name", "email")
    password_input = driver.find_element("name", "password")
    register_button = driver.find_element("css selector", "button.submit")

    name_input.send_keys(testName)
    email_input.send_keys(testMail)
    password_input.send_keys(testPassword)

    register_button.click()

    time.sleep(2)

    assert "Login" in driver.page_source


def login():
    login_page_url = 'http://localhost:3000/Login'
    test_email = 'test@example.com'
    test_password = 'testpassword'

    driver = webdriver.Chrome(executable_path=webdriver_path)

    driver.get(login_page_url)

    def perform_login(email, password):
        email_input = driver.find_element_by_name('email')
        email_input.send_keys(email)

        password_input = driver.find_element_by_name('password')
        password_input.send_keys(password)

        login_button = driver.find_element_by_class_name('submit')
        login_button.click()

    perform_login(test_email, test_password)

    time.sleep(2)

    if 'Dashboard' in driver.current_url:
        print('Login Successful!')
    else:
        print('Login Failed.')

    driver.quit()

register()
login()