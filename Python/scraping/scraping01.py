# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

from selenium.webdriver import Chrome
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.chrome.options import Options

chrome_options=Options()
chrome_options.add_argument('--headless')
#chrome_options.add_argument('--no-sandbox')
#chrome_options.add_argument('--disable-dev-shm-usage')

browser=Chrome(options=chrome_options,executable_path="./chromedriver")

URL='https://www.futebolinterior.com.br/futebol/Brasileiro/Serie-A/2020/classificacao'

browser.get(URL)

wait=WebDriverWait(browser,10)

element=browser.find_element_by_id('tbody_classificacao')

linhas=element.find_elements_by_css_selector("tr.linha-class")

for linha in linhas:
    coluna_posicao=linha.find_element_by_class_name('coluna-posicao')
    print(coluna_posicao.text)








# See PyCharm help at https://www.jetbrains.com/help/pycharm/
