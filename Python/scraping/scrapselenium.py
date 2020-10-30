from selenium.webdriver import Chrome
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options


class Time:
    def __init__(self,nome, pg,jogos,vitorias,empates,derrotas,gc,gp):
        self.nome=nome
        self.pg=pg
        self.jogos=jogos
        self.vitorias=vitorias
        self.empates=empates
        self.derrotas=derrotas
        self.gc=gc
        self.gp=gp
    def __str__(self):
        return "Time:{0} Jogos:{1} PG:{2} Vitórias:{3} Empates:{4} Derrotas:{5} GC:{6} GP{7}".format(self.nome,self.jogos,self.pg,
                                                                                                     self.vitorias,self.empates,self.derrotas,
                                                                                                     self.gc,self.gp)

nome_times=[]
chrome_options=Options()
chrome_options.add_argument('--headless')
#chrome_options.add_argument('--no-sandbox')
#chrome_options.add_argument('--disable-dev-shm-usage')

driver=Chrome(options=chrome_options,executable_path="./chromedriver")

URL='https://www.uol.com.br/esporte/futebol/campeonatos/brasileirao/'

driver.get(URL)

wait=WebDriverWait(driver,10)
elements=driver.find_elements(By.CSS_SELECTOR,'table.data-table.name a.team-link.ng-scope')
for element in elements:
    nome_times.append(element.text)

scores=driver.find_elements(By.CSS_SELECTOR,'tbody.score tr.ng-scope')
i=0
times=[]
for score in scores:
    pontos_ganhos=int(score.find_element(By.CSS_SELECTOR,'td.pg.ng-binding.ng-scope').text)
    jogos=int(score.find_element(By.CSS_SELECTOR,'td.pg.ng-binding.ng-scope').text)
    vitorias=int(score.find_element(By.CSS_SELECTOR,'td.v.ng-binding.ng-scope').text)
    empates=int(score.find_element(By.CSS_SELECTOR,'td.e.ng-binding.ng-scope').text)
    derrotas=int(score.find_element(By.CSS_SELECTOR,'td.d.ng-binding.ng-scope').text)
    golscontra=int(score.find_element(By.CSS_SELECTOR,'td.gc.ng-binding.ng-scope').text)
    golspro=int(score.find_element(By.CSS_SELECTOR,'td.gp.ng-binding.ng-scope').text)
    times.append(Time(nome_times[i],pontos_ganhos,jogos,vitorias,empates,derrotas,golscontra,golspro))
    i=i+1
for time in times:
    print(time)
