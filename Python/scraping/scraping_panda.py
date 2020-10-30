# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

from selenium.webdriver import Chrome
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.chrome.options import Options
from bs4 import BeautifulSoup
import pandas as pd
from tabulate import tabulate

chrome_options=Options()
chrome_options.add_argument('--headless')
#chrome_options.add_argument('--no-sandbox')
#chrome_options.add_argument('--disable-dev-shm-usage')

browser=Chrome(options=chrome_options,executable_path="./chromedriver")

URL='https://www.futebolinterior.com.br/futebol/Brasileiro/Serie-A/2020/classificacao'

browser.get(URL)

wait=WebDriverWait(browser,10)

soup=BeautifulSoup(browser.page_source,'lxml')
tabela_header=soup.find(class_='linha-class-topo')
tabela=soup.find(id='tbody_classificacao')
html="<table><thead>"+str(tabela_header)+"</thead>"+str(tabela)+"</table>"
list_data_frame=pd.read_html(html,header=0)#Lê todas as tabeleas html existentes no código, retornando uma lista
frame=pd.DataFrame(list_data_frame[0])#Transforma o elemento da lista é um data frame
frame.drop(index=20)
browser.quit()

#resultado = pd.DataFrame(data_frame)

cabecalho=['Posição','Clube','Pontos Ganhos','Jogos','Vitórias','Empates','Derrotas','Gols-Pró','Gols Sofridos','Saldo de Gols','Aproveitamento']

print(tabulate(frame,headers=cabecalho,tablefmt='github'))







# See PyCharm help at https://www.jetbrains.com/help/pycharm/
