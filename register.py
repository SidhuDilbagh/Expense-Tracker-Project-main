from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

driver = webdriver.Chrome(executable_path=r"C:\Users\dilba\Downloads\chromedriver-win64\chromedriver-win64\chromedriver.exe")

try:
    driver.get("http://localhost:3000/register")

    name_input = driver.find_element("name", "name")
    email_input = driver.find_element("name", "email")
    password_input = driver.find_element("name", "password")
    register_button = driver.find_element("css selector", "button.submit")

    name_input.send_keys("Test User")
    email_input.send_keys("test@example.com")
    password_input.send_keys("testpassword")

    register_button.click()

    time.sleep(2)

    assert "Login" in driver.page_source

finally:
    driver.quit()
